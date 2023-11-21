package com.sambit.Utils;

import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

/**
 * @Project : TMS Backend
 * @Author: Sambit Kumar Pradhan
 * @Date: 15-Nov-2023 : 3:47 PM
 */

@PropertySource(value = "classpath:application.properties")
public class FileUtils {
    private FileUtils() {}

    private static final String OPERATING_SYSTEM = System.getProperty("os.name").toLowerCase().trim();
    private static final ResourceBundle BSKYAPP_RESOURCES_BUNDLE = ResourceBundle.getBundle("application");
    public static final String WINDOWS_ROOT_FOLDER = BSKYAPP_RESOURCES_BUNDLE.getString("file.upload.directory.windows");
    public static final String LINUX_ROOT_FOLDER = BSKYAPP_RESOURCES_BUNDLE.getString("file.upload.directory.linux");

    public static String getRootDirectoryName() {
        if (OPERATING_SYSTEM.contains("windows"))
            return WINDOWS_ROOT_FOLDER;
        else
            return LINUX_ROOT_FOLDER;
    }

    public static String getFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex != -1)
            return filename.substring(lastDotIndex);
        return "";
    }

    public static String saveFileToServer(String year, String hospitalCode, String folderName, String newFileName, MultipartFile file) throws IOException {
        String path = String.format("%s/%s/%s", year, hospitalCode, folderName);
        File fileData = new File(getRootDirectoryName() + path);
        fileData.getParentFile().mkdirs();
        return saveFile(file, path, newFileName);
    }

    public static String saveFile(MultipartFile file, String fileName, String newFileName) throws IOException {
        String fileFlag = "";
        if (file.isEmpty()) {
            fileFlag = "FileEmpty";
        } else {
            String folderPath = fileExistsOrNot(fileName);
            byte[] bytes = file.getBytes();
            Path path = Paths.get( String.format("%s/%s", folderPath.trim(), newFileName.trim()));
            Files.write(path, bytes);
            fileFlag = folderPath + newFileName;
        }
        return fileFlag;
    }

    public static String fileExistsOrNot(String folderName) {
        String rootDirectoryName = getRootDirectoryName();
        String filePath = rootDirectoryName + folderName;

        File file = new File(filePath);

        if (!file.exists()) {
            boolean checkCreated = file.mkdirs();
            if (checkCreated)
                return filePath + "/";
            else
                return filePath;
        }
        return filePath + "/";
    }
}
