package com.sambit.Controller;

import com.sambit.CompetitvePractice.JDBC.MysqlConnection;
import com.sambit.Entity.SingleFileUpload;
import com.sambit.Repository.SingleFileUploadRepository;
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
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 07/09/2022 - 11:15 AM
 */

@Controller
public class FileHandlerController {

	@Autowired
	private SingleFileUploadRepository singleFileUploadRepository;

	@GetMapping(value = "/singleFileUpload")
	public String singleFileUpload(Model model) {
		System.out.println("Inside Single File Upload---------->>");
		List<SingleFileUpload> singleFileUploadList = singleFileUploadRepository.findAll();
		model.addAttribute("singleFileUploadList", singleFileUploadList);
		return "singleFileUpload";
	}

	@PostMapping(value = "/singleFileUpload")
	public String saveSingleFileUpload(@RequestParam(value = "fullName", required = false)String fullName,
	                                   @RequestParam(value = "document", required = false)MultipartFile document,
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
			}else {
				System.out.println("File Uploaded Failed");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return "redirect:/singleFileUpload";
	}

//	Method 1 To Download Single File
	@GetMapping(value = "/downloadSingleFile/{singleFileUploadId}")
	public void downloadSingleFile(@PathVariable(value = "singleFileUploadId")int singleFileUploadId,
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
	public ResponseEntity<ByteArrayResource> downloadSingleFile1(@PathVariable(value = "singleFileUploadId")int singleFileUploadId) {
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

//	Method 3 To Download Single File
	@GetMapping(value = "/downloadSingleFile2/{singleFileUploadId}")
	public void downloadSingleFile2(@PathVariable(value = "singleFileUploadId")int singleFileUploadId) throws SQLException, IOException {
		System.out.println("Inside Download Single File Method 3---------->>");
		System.out.println("Single File Upload Id : " + singleFileUploadId);

		Connection connection = MysqlConnection.getConnection("spring", "root", "");
		Statement statement =connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM single_file_upload WHERE single_file_upload_id = " + singleFileUploadId);

		while (resultSet.next()) {
			Blob blob = resultSet.getBlob("file");

			System.out.println("Blob : " + blob);

			byte[] bytes = blob.getBytes(1, (int) blob.length());
			System.out.println("Bytes : " + Arrays.toString(bytes));

			InputStream in = blob.getBinaryStream();
			OutputStream out = new FileOutputStream("C:\\Users\\sambit.pradhan\\Downloads\\2.jpg");//This Need To Change For According To Your File Content Type
			byte[] buff = new byte[4096];
			int len;

			while ((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
		}
	}
}
