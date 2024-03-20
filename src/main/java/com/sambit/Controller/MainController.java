package com.sambit.Controller;

import com.sambit.CompetitvePractice.Algorithms.Sorting;
import com.sambit.CustomException.CustomException;
import com.sambit.Repository.DistrictRepository;
import com.sambit.Repository.StateRepository;
import com.sambit.Utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 27/09/2022 - 5:51 PM
 */

@Controller
public class MainController {

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@ResponseBody
	@GetMapping(value = "/sortIntegerArray")
	public int[] printSortArray(){
		int[] unSortArray = {5, 4, 3, 2, 1, 0, 9, 8, 7, 6};
		int n = unSortArray.length;
		return Sorting.sort(unSortArray, n);
	}

	@ResponseBody
	@GetMapping(value = "/getDistrictList")
	public ResponseEntity<?> getDistrictList() {
		System.out.println("Inside getDistrictList Method of MainController.");
		List<Map<String, String>> districtMapList = new ArrayList<>();
		List<String> districtList = new ArrayList<>();
		try {
			List<String> stateCodeList = Arrays.asList("35","28","18","10","21","07","30");
			List<Object[]> stateList = stateRepository.getDistrictByStateCode(stateCodeList);
			stateList.forEach(state -> {
				Map<String, String> districtMap = new LinkedHashMap<>();
				districtMap.put("stateCode", state[0].toString());
				districtMap.put("stateName", state[1].toString());
				districtMap.put("districtCode", state[2].toString());
				districtMap.put("districtName", state[3].toString());
				districtMapList.add(districtMap);
			});
			System.out.println(districtMapList);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().body(districtList);
	}

	@GetMapping(value = "/google")
	public ResponseEntity<?> odishaOne() {
		URI uri = null;
		String path = "https://www.google.com";
		try {
			uri = new URI(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(uri).build();
	}

	public List<Map<String, Object>> getServerLogList() {
		List<Map<String, Object>> fileDetails = new ArrayList<>();
		String directoryPath = "C:\\BSKY\\LOG";

		Path directory = Paths.get(directoryPath);

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
			for (Path filePath : stream) {
				Map<String, Object> fileMap = new LinkedHashMap<>();

				BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);

				fileMap.put("fileName", filePath.getFileName().toString());
				fileMap.put("createdDate", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
						.format(new Date(attributes.creationTime().toMillis()))
				);
				fileMap.put("lastModifiedTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
						.format(new Date(attributes.lastModifiedTime().toMillis()))
				);
				fileMap.put("lastAccessedTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
						.format(new Date(attributes.lastAccessTime().toMillis()))
				);
				fileMap.put("fileSize", Files.size(filePath) / 1024 + " KB");
				fileMap.put("isDirectory", attributes.isDirectory());
				fileMap.put("isRegularFile", attributes.isRegularFile());
				fileMap.put("isSymbolicLink", attributes.isSymbolicLink());
				fileMap.put("isOther", attributes.isOther());
				fileMap.put("fileKey", attributes.fileKey());
				fileMap.put("fileOwner", Files.getOwner(filePath));
				fileMap.put("fileType", Files.probeContentType(filePath));
				fileMap.put("actualFileType", FileUtils.getFileType(filePath.getFileName().toString()));
				if (filePath.getFileName().toString().endsWith(".log")) {
					fileMap.put("fileContent", Files.readString(filePath, StandardCharsets.UTF_8));
					fileMap.put("fileLines", Files.readAllLines(filePath, StandardCharsets.UTF_8));
				}

				fileDetails.add(fileMap);
			}
			return fileDetails;
		} catch (DirectoryIteratorException | IOException e) {
			throw new CustomException(e.getMessage());
		}
	}
}
