package com.sambit.Controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/11/2022 - 11:18 PM
 */
@Controller
public class ZipFileController {

	@GetMapping("/indexData")
	public String indexData() {
		System.out.println("Inside indexData");
		return "indexData";
	}


//	Download Zip File Using Web Button Click
	@GetMapping(value = "/downloadZipFile")
	public void downloadZipFile(HttpServletResponse httpServletResponse) throws IOException {
		String filePath = "C:\\Users\\sambit.pradhan\\Desktop\\Data\\Desktop.zip";

		httpServletResponse.setContentType("application/zip");
		httpServletResponse.setHeader("Content-Disposition", "attachment; filename=Desktop.zip");

//		Download File Using Http Servlet Response
		File file = new File(filePath);
		FileInputStream fileInputStream = new FileInputStream(file);
		OutputStream outputStream = httpServletResponse.getOutputStream();
		byte[] buffer = new byte[1024];
		int bytesRead = -1;
		while ((bytesRead = fileInputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		fileInputStream.close();
		outputStream.close();
		httpServletResponse.flushBuffer();
	}


	@GetMapping(value = "/downloadZipFileUsingZipFile")
	public void downloadZipFileWithoutWeb(){
		try {
			String filePath = "C:\\Users\\sambit.pradhan\\Desktop\\Data\\Desktop.zip";
			String downloadPath = "C:\\Users\\sambit.pradhan\\Desktop\\";

			FileInputStream fileInputStream = new FileInputStream(filePath);
			FileOutputStream fileOutputStream = new FileOutputStream(downloadPath + "Download.zip");
			int len;
			byte[] buffer = new byte[1024];
			while ((len = fileInputStream.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, len);
			}
			fileInputStream.close();
			fileOutputStream.close();
			System.out.println("Done");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping(value = "/downloadZipFileContent")
	public void downloadZipFileContent() throws IOException {
		String filePath = "C:\\Users\\sambit.pradhan\\Desktop\\Data\\Desktop.zip";
		String downloadPath = "C:\\Users\\sambit.pradhan\\Desktop\\Data\\";
		try {
			ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(filePath));
			ZipEntry zipEntry = zipInputStream.getNextEntry();
			while (zipEntry != null) {
				String fileName = zipEntry.getName();
				File newFile = new File(downloadPath + fileName);
				System.out.println("Unzipping to " + newFile.getAbsolutePath());
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fileOutputStream = new FileOutputStream(newFile);
				int len;
				byte[] buffer = new byte[1024];
				while ((len = zipInputStream.read(buffer)) > 0) {
					fileOutputStream.write(buffer, 0, len);
				}
				fileOutputStream.close();
				zipInputStream.closeEntry();
				zipEntry = zipInputStream.getNextEntry();
			}
			zipInputStream.closeEntry();
			zipInputStream.close();
			System.out.println("Done");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping(value = "/printZipFileContentInformation")
	public void printZipFileContentInformation() throws IOException {
		String filePath = "C:\\Users\\sambit.pradhan\\Desktop\\Data\\Desktop.zip";
		try {
			ZipFile zipFile = new ZipFile(filePath);
			zipFile.stream().forEach(zipEntry -> {
				System.out.println("File Name : " + zipEntry.getName());
				System.out.println("File Size : " + zipEntry.getSize());
				System.out.println("File Compressed Size : " + zipEntry.getCompressedSize());
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	@GetMapping(value = "/readExcelFileFromZipFile")
	public void readExcelFileFromZipFile() {
		String filePath = "C:\\Users\\sambit.pradhan\\Desktop\\Data\\Desktop.zip";
		try {
			ZipFile zipFile = new ZipFile(filePath);
			zipFile.stream().forEach(zipEntry -> {
				System.out.println("File Name : " + zipEntry.getName());
				System.out.println("File Size : " + zipEntry.getSize());
				System.out.println("File Compressed Size : " + zipEntry.getCompressedSize());
				try {
					InputStream inputStream = zipFile.getInputStream(zipEntry);
					Workbook workbook = WorkbookFactory.create(inputStream);
					Sheet sheet = workbook.getSheetAt(0);
					for (Row row : sheet) {
						System.out.println("Row Number : " + row.getRowNum());
						for (int i = 0; i < row.getLastCellNum(); i++) {
							System.out.println("Cell Value : " + row.getCell(i));
						}
					}
				} catch (IOException | InvalidFormatException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@GetMapping(value = "/readExcelFileFromZipFileUsingApachePOI")
	public void readExcelFileFromZipFileUsingApachePOI() {
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sambit.pradhan\\Desktop\\Desktop.zip");
			ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
			ZipEntry zipEntry = zipInputStream.getNextEntry();
			while (zipEntry != null) {
				System.out.println(zipEntry.getName());
				XSSFWorkbook workbook = new XSSFWorkbook(zipInputStream);
				Sheet sheet = workbook.getSheetAt(0);

				int lastRowNum = sheet.getLastRowNum();
				int lastCellNum = sheet.getRow(0).getLastCellNum();
				for (int i = 0; i <= lastRowNum; i++) {
					for (int j = 0; j < lastCellNum; j++) {
						Row row = sheet.getRow(i);
						System.out.print(row.getCell(j) + " ");
					}
					System.out.println();
				}
				System.out.println("===================================");
				zipEntry = zipInputStream.getNextEntry();
				System.out.println("Zip Entry: " + zipEntry);
			}
			zipInputStream.closeEntry();
			zipInputStream.close();
			fileInputStream.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


}
