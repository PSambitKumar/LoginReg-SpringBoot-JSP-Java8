package com.sambit.Controller;

import com.sambit.CompetitvePractice.JDBC.MysqlConnection;
import com.sambit.Entity.BlobDataUpload;
import com.sambit.Entity.MultiFileUpload;
import com.sambit.Entity.SingleFileUpload;
import com.sambit.Repository.BlobDataUploadRepository;
import com.sambit.Repository.MultiFileUploadRepository;
import com.sambit.Repository.SingleFileUploadRepository;
import com.sambit.Service.RegService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 07/09/2022 - 11:15 AM
 */

@Controller
public class FileHandlerController {

	@Autowired
	private SingleFileUploadRepository singleFileUploadRepository;
	@Autowired
	private MultiFileUploadRepository multiFileUploadRepository;
	@Autowired
	private BlobDataUploadRepository blobDataUploadRepository;
	@Autowired
	private RegService regService;


	//	Single File Upload
	@GetMapping(value = "/singleFileUpload")
	public String singleFileUpload(Model model) {
		System.out.println("Inside Single File Upload---------->>");
		List<SingleFileUpload> singleFileUploadList = singleFileUploadRepository.findAll();
		model.addAttribute("singleFileUploadList", singleFileUploadList);
		return "singleFileUpload";
	}

	@PostMapping(value = "/singleFileUpload")
	public String saveSingleFileUpload(@RequestParam(value = "fullName", required = false) String fullName,
	                                   @RequestParam(value = "document", required = false) MultipartFile document,
	                                   SingleFileUpload singleFileUpload) {
		System.out.println("Inside Save Single File Upload---------->>");
		System.out.println("Full Name : " + fullName);
		System.out.println("Document : " + document);
		System.out.println("Document Name : " + document.getOriginalFilename());
		System.out.println("Document Size : " + document.getSize());
		try {
			singleFileUpload.setFullName(fullName);
			singleFileUpload.setFile(document.getBytes());
			singleFileUpload.setFileContentType(document.getContentType());
			singleFileUpload.setOriginalFileName(document.getOriginalFilename());
			singleFileUpload = singleFileUploadRepository.save(singleFileUpload);
			if (singleFileUpload.getSingleFileUploadId() > 0) {
				System.out.println("File Uploaded Successfully");
			} else {
				System.out.println("File Uploaded Failed");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return "redirect:/singleFileUpload";
	}

	//	Method 1 To Download Single File
	@GetMapping(value = "/downloadSingleFile/{singleFileUploadId}")
	public void downloadSingleFile(@PathVariable(value = "singleFileUploadId") int singleFileUploadId,
	                               HttpServletResponse httpServletResponse) {
		System.out.println("Inside Download Single File Method 1---------->>");
		System.out.println("Single File Upload Id : " + singleFileUploadId);
		try {
			SingleFileUpload singleFileUpload = singleFileUploadRepository.findById(singleFileUploadId).get();
			byte[] bytes = singleFileUpload.getFile();
			System.out.println("Bytes : " + bytes);

			httpServletResponse.setContentType(singleFileUpload.getFileContentType());
//			httpServletResponse.setHeader("Content-Disposition", "inline;filename=" + singleFileUpload.getOriginalFileName());//For Open in Browser
			httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + singleFileUpload.getOriginalFileName());//For Download
			OutputStream out = httpServletResponse.getOutputStream();
			out.write(bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//	Method 2 To Download Single File
	@GetMapping(value = "/downloadSingleFile1/{singleFileUploadId}")
	public ResponseEntity<ByteArrayResource> downloadSingleFile1(@PathVariable(value = "singleFileUploadId") int singleFileUploadId) {
		System.out.println("Inside Download Single File Method 2---------->>");
		System.out.println("Single File Upload Id : " + singleFileUploadId);
		try {
			SingleFileUpload singleFileUpload = singleFileUploadRepository.findById(singleFileUploadId).get();
			byte[] bytes = singleFileUpload.getFile();
			System.out.println("Bytes : " + bytes);

			ByteArrayResource byteArrayResource = new ByteArrayResource(bytes);

			return ResponseEntity.ok()
				   .contentType(MediaType.parseMediaType(singleFileUpload.getFileContentType()))
				   .header("Content-Disposition", "attachment;filename=" + singleFileUpload.getOriginalFileName())
				   .body(byteArrayResource);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//	Method 3 To Download Single File (Data Present in Database as ByteArray Format(BLOB))
	@GetMapping(value = "/downloadSingleFile2/{singleFileUploadId}")
	public void downloadSingleFile2(@PathVariable(value = "singleFileUploadId") int singleFileUploadId) throws SQLException, IOException {
		System.out.println("Inside Download Single File Method 3---------->>");
		System.out.println("Single File Upload Id : " + singleFileUploadId);

		Connection connection = MysqlConnection.getConnection("spring", "root", "");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM single_file_upload WHERE single_file_upload_id = " + singleFileUploadId);

		while (resultSet.next()) {
			Blob blob = resultSet.getBlob("file");

			System.out.println("Blob : " + blob);

			byte[] bytes = blob.getBytes(1, (int) blob.length());
			System.out.println("Bytes : " + Arrays.toString(bytes));

			InputStream in = blob.getBinaryStream();
			OutputStream out = new FileOutputStream("C:\\Users\\sambit.pradhan\\Downloads\\downloadedData.pdf");//This Need To Change For According To Your File Content Type
			byte[] buff = new byte[4096];
			int len;

			while ((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
		}
	}


	//	Multi File Upload
	@GetMapping(value = "/multiFileUpload")
	public String multiFileUpload(Model model) {
		System.out.println("Inside Multi File Upload---------->>");
		List<MultiFileUpload> multiFileUploadList = multiFileUploadRepository.findAll();
		model.addAttribute("multiFileUploadList", multiFileUploadList);
		return "multiFileUpload";
	}

	@PostMapping(value = "/multiFileUpload")
	public String saveMultiFileUpload(@RequestParam(value = "fullName", required = false) String fullName,
	                                  @RequestParam(value = "document", required = false) MultipartFile[] document) {
		System.out.println("Inside Save Multi File Upload---------->>");
		System.out.println("Full Name : " + fullName);
		System.out.println("Document : " + Arrays.toString(document));
		MultiFileUpload multiFileUpload = null;
		try {
			for (MultipartFile multipartFile : document) {
				multiFileUpload = new MultiFileUpload();
				multiFileUpload.setFullName(fullName);
				multiFileUpload.setFile(multipartFile.getBytes());
				multiFileUpload.setFileContentType(multipartFile.getContentType());
				multiFileUpload.setOriginalFileName(multipartFile.getOriginalFilename());
				multiFileUpload = multiFileUploadRepository.save(multiFileUpload);
			}
			if (multiFileUpload.getMultiFileUploadId() > 0) {
				System.out.println("File Uploaded Successfully");
			} else {
				System.out.println("File Uploaded Failed");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return "redirect:/multiFileUpload";
	}

	@GetMapping(value = "/downloadMultipleFile/{multiFileUploadId}")
	public void downloadMultipleFile(@PathVariable(value = "multiFileUploadId") int multiFileUploadId,
	                                 HttpServletResponse httpServletResponse) {
		System.out.println("Inside Download Multiple File Method---------->>");
		System.out.println("Multi File Upload Id : " + multiFileUploadId);
		try {
			MultiFileUpload multiFileUpload = multiFileUploadRepository.findById(multiFileUploadId).get();
			byte[] bytes = multiFileUpload.getFile();
			System.out.println("Bytes : " + bytes);

			httpServletResponse.setContentType(multiFileUpload.getFileContentType());
//			httpServletResponse.setHeader("Content-Disposition", "inline;filename=" + singleFileUpload.getOriginalFileName());//For Open in Browser
			httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + multiFileUpload.getOriginalFileName());//For Download
			OutputStream out = httpServletResponse.getOutputStream();
			out.write(bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	//	File Read And Write
	@GetMapping(value = "/processTextFileData")
	public String processDataOfFiles() throws IOException {
		System.out.println("Inside Process Data Of Files---------->>");
		String fileName = "C:\\Users\\sambit.pradhan\\Downloads\\sambit.JPG";
		Path path = Paths.get(fileName);
		System.out.println("File Name : " + fileName);
		System.out.println("File Size : " + Files.size(path));
		System.out.println("File Content1 : " + Files.readString(path));
		System.out.println("File Content2 : " + Files.readAllLines(path));
		System.out.println("File Content3 : " + Files.readAllBytes(path));
		System.out.println("Bytes To String : " + new String(Files.readAllBytes(path)));
		System.out.println("Bytes : " + Files.readAllBytes(path));
		byte[] bytes = Files.readAllBytes(path);
		System.out.println("Path : " + path);
		return null;
	}

	//	Process a BLOB Text File From Local File Server and Save Data Into Database Byte Array(BLOB)
	@GetMapping(value = "/processTextFileDataSave")
	public String processDataOfFilesSave() throws IOException {
		String fileName = "C:\\Users\\sambit.pradhan\\Downloads\\2.txt";
		Path path = Paths.get(fileName);
		System.out.println("File Content1 : " + Files.readString(path));
		BlobDataUpload blobDataUpload = new BlobDataUpload();
		byte[] bytes = Files.readAllBytes(path);
		blobDataUpload.setData(bytes);
		blobDataUploadRepository.save(blobDataUpload);
		return null;
	}

	//	Process a Text File From Local Dir. Contains BLOB Data, Covert to Image File and Save to Local Dir.
//	Not Working
	@GetMapping(value = "/processTextFileDataConvertImage")
	public String processDataOfFilesConvertImage() throws IOException {
		String fileName = "C:\\Users\\sambit.pradhan\\Downloads\\data.txt";
		Path path = Paths.get(fileName);
		System.out.println("File Content1 : " + Files.readString(path));
		byte[] bytes = Files.readAllBytes(path);
		System.out.println("Bytes : " + Arrays.toString(bytes));
		String imageFileName = "C:\\Users\\sambit.pradhan\\Downloads\\2.jpg";
		Path imagePath = Paths.get(imageFileName);
		Files.write(imagePath, bytes);
		return null;
	}


	//	Custom Sql Query Call Using Prepared Statement
	@GetMapping(value = "/getClaimId")
	public void getClaimId() {
		System.out.println("Inside process And Download3 Method-------->>");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@ora3.corp.csmpl.com:1521:ora3", "bskyv1", "OdishaBsky$907e#");
			PreparedStatement preparedStatement = con.prepareStatement("SELECT CLAIMID FROM TXNCLAIM_APPLICATION WHERE TRANSACTIONDETAILSID =?");
			preparedStatement.setInt(1, 217225);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int claimId = resultSet.getInt(1);
				System.out.println("Claim Id : " + claimId);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping(value = "/encodedStringConvert")
	public String encodedStringConvert(){
		String uploadPath = "C:/BSKY/2022/21063021/surgery picture/PreSurgery/PRETSX_410944_20221110115413691743Pre Surgery.jpg";
		System.out.println("Uploaded Path : " + uploadPath);

		try {
			byte[] fileContent = Files.readAllBytes(Paths.get(uploadPath));
			System.out.println("File Content : " + Arrays.toString(fileContent));
			String encodedString = Base64.getEncoder().encodeToString(fileContent);
			System.out.println("Encoded String : " + encodedString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping(value = "/generatePDF")
	public void generatePDF(@RequestParam("data") String data, HttpServletResponse httpServletResponse)  {
		try {
			System.out.println("Data : " + data);
			byte[] bytes = Base64.getDecoder().decode(data);
			JSONArray reports = new JSONObject(new String(bytes)).getJSONArray("report");
			String headers = new JSONObject(new String(bytes)).getString("heading");
			regService.generatePDF(reports, headers, httpServletResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "/generatePDF1")
	public void generatePDF1(@RequestParam("data") String data, HttpServletResponse httpServletResponse)  {
		try {
			System.out.println("Data : " + data);
			byte[] bytes = Base64.getDecoder().decode(data);
			regService.generatePDF1(new JSONArray(), new JSONArray(), httpServletResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "/generatePDF2")
	public void generatePDF2(@RequestParam("data") String data, HttpServletResponse httpServletResponse)  {
		try {
			System.out.println("Data : " + data);
			byte[] bytes = Base64.getDecoder().decode(data);
			regService.generatePDF2(new JSONArray(), new JSONArray(), httpServletResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@GetMapping(value = "/openWordDocs")
//	public void openWordDocs(@RequestParam("data") String data, HttpServletResponse httpServletResponse)  {
//		try {
//			Options.WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
//			loadOptions.setPassword("password-if-any");
//
//			Editor editor = new Editor("path/document.docx", loadOptions);
//			EditableDocument defaultWordProcessingDoc = editor.edit();
//
//// Either edit using any WYSIWYG editor or edit programmatically
//			String allEmbeddedInsideString = defaultWordProcessingDoc.getEmbeddedHtml();
//			String allEmbeddedInsideStringEdited = allEmbeddedInsideString.replace("document", "edited document");
//
//// Save the edited document
//			EditableDocument editedDoc = EditableDocument.fromMarkup(allEmbeddedInsideStringEdited, null);
//			WordProcessingSaveOptions saveOptions = new WordProcessingSaveOptions(WordProcessingFormats.Docx);
//			editor.save(editedDoc, "path/edited-document.docx", saveOptions);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@GetMapping(value = "blobFileProcessing")
	public void blobFileProcessing() {
		String rapFilePath = "C:\\Users\\sambit.pradhan\\IdeaProjects\\Registration\\src\\main\\resources\\static\\assets\\BLOB File\\RAP5";
		String ticketFilePath = "C:\\Users\\sambit.pradhan\\IdeaProjects\\Registration\\src\\main\\resources\\static\\assets\\BLOB File\\ticket";
		try {
			File inputFile = new File(rapFilePath);

			FileInputStream inputStream = new FileInputStream(inputFile);
			byte[] fileContent = new byte[(int) inputFile.length()];
			inputStream.read(fileContent);
			String encodedString = Base64.getEncoder().encodeToString(fileContent);
			System.out.println("Encoded String : " + encodedString);
			byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
			FileOutputStream outputStream = new FileOutputStream("C:\\Users\\sambit.pradhan\\Desktop\\convertedFile.pdf");
			outputStream.write(decodedBytes);
			inputStream.close();
			outputStream.close();

			System.out.println("File Content : " + Arrays.toString(fileContent));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}






}

