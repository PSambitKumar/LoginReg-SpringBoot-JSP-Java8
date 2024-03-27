package com.sambit.Utils;

import com.sambit.CustomException.CustomException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Project : TMS Backend
 * @Author: Sambit Kumar Pradhan
 * @Date: 15-Nov-2023 : 3:47 PM
 */

@PropertySource(value = "classpath:application.properties")
public class FileUtils {

    private FileUtils() {}

    private static final String OPERATING_SYSTEM = System.getProperty("os.name").toLowerCase().trim();
    private static final ResourceBundle BSKY_APP_RESOURCES_BUNDLE = ResourceBundle.getBundle("application");
    public static final String WINDOWS_ROOT_FOLDER = BSKY_APP_RESOURCES_BUNDLE.getString("file.upload.directory.windows");
    public static final String LINUX_ROOT_FOLDER = BSKY_APP_RESOURCES_BUNDLE.getString("file.upload.directory.linux");

    /**
     * This method is used to get Root Path
     * Output = Root Path
     */
    public static String getRootDirectoryName() {
        if (OPERATING_SYSTEM.contains("windows"))
            return WINDOWS_ROOT_FOLDER;
        else
            return LINUX_ROOT_FOLDER;
    }

    /**
     * This method is used to Save File to Server
     * Output = Full File Path
     */
    public static String saveFileToServer(String year, String hospitalCode, String folderName,
                                          String newFileName, MultipartFile file) throws IOException {
        String filePathString = "";

        String path = String.format("%s/%s/%s", year, hospitalCode, folderName);
        File fileData = new File(getRootDirectoryName() + path);
        fileData.getParentFile().mkdirs();

        if (file.isEmpty())
            filePathString = "FileEmpty";
        else {
            String folderPath = folderExistsOrNot(path);
            byte[] bytes = file.getBytes();
            Path filePath = Paths.get( String.format("%s/%s", folderPath.trim(), newFileName.trim()));
            Files.write(filePath, bytes);
            filePathString = folderPath + newFileName;
        }
        return filePathString;
    }

    /**
     * This method is used to Check Folder existence if not present then creates a new folder
     * Output = File Path
     */
    public static String folderExistsOrNot(String path) {
        String rootDirectoryName = getRootDirectoryName();
        String filePath = rootDirectoryName + path;

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

    public static boolean fileExistsOrNot(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static String getFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex != -1)
            return filename.substring(lastDotIndex);
        return "";
    }

    /**
     * This method is used to get the prefix from File Name.
     * Eg: File Name Like = "INV_666666_66612023111620231116103845670.jpg",
     * Output = "INV"
     */
    public static String getPrefixFromFileName(String fileName) {
        return fileName.split("_")[0];
    }

    /**
     * This method is used to get File Type Name Using File Name.
     * Eg: File Name Like = "INV_666666_66612023111620231116103845670.jpg",
     * Output = "Investigation"
     */
    public static String getFileTypeUsingFileName(String fileName) {
        String prefix = getPrefixFromFileName(fileName);

        if (prefix.equalsIgnoreCase(StringUtils.INVESTIGATION_DOC_PREFIX_NAME))
            return "Investigation";
        else if (prefix.equalsIgnoreCase(StringUtils.REFERRAL_DOC_PREFIX_NAME))
            return "Referral";
        else
            return "Invalid Document Prefix";
    }

    /**
     * This method is used to get Folder Name Using File Name.
     * Eg: File Name Like = "INV_666666_66612023111620231116103845670.jpg",
     * Output = "InvestigationDoc"
     */
    public static String getFolderNameUsingFileName(String fileName) {
        String prefix = getPrefixFromFileName(fileName);

        if (prefix.equalsIgnoreCase(StringUtils.INVESTIGATION_DOC_PREFIX_NAME))
            return StringUtils.INVESTIGATION_DOC_FOLDER_NAME;
        else if (prefix.equalsIgnoreCase(StringUtils.REFERRAL_DOC_PREFIX_NAME))
            return StringUtils.REFERRAL_DOC_FOLDER_NAME;
        else
            return "Invalid Document Prefix";
    }

    /**
     * This method is used to Download File.
     * Output = "File in Bytes Array of BLOB
     */
    public static void downloadFile(String fileName, String year, String hospitalCode, String folderName, HttpServletResponse response) throws Exception {
        String path = String.format("%s%s/%s/%s/%s", getRootDirectoryName(), year, hospitalCode, folderName.trim(), fileName);
        File file = new File(path);

        if (!file.exists()) {
            String errorMessage = "Sorry. The file you are looking for does not exist";
            response.getOutputStream().write(errorMessage.getBytes(StandardCharsets.UTF_8));
            return;
        }

        String mimeType = Files.probeContentType(file.toPath());
        if (mimeType == null)
            mimeType = "application/octet-stream";

        response.setContentType(mimeType);
        response.setContentLength((int) file.length());

        String encodedFilename = UriUtils.encode(file.getName(), StandardCharsets.UTF_8.toString());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + encodedFilename + "\"");

        try (OutputStream outputStream = response.getOutputStream()) {
            Files.copy(file.toPath(), outputStream);
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * This method is used to get File Type
     *
     * @Auther : Sambit Kumar Pradhan
     * @param fileName
     * @return String
     * @Date : 20-Mar-2024 : 12:47 PM
     */
    public static String getFileType(String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("jpeg") || suffix.equalsIgnoreCase("png"))
            return "Image";
        else if (suffix.equalsIgnoreCase("pdf"))
            return "PDF";
        else if (suffix.equalsIgnoreCase("doc") || suffix.equalsIgnoreCase("docx"))
            return "Word";
        else if (suffix.equalsIgnoreCase("xls") || suffix.equalsIgnoreCase("xlsx"))
            return "Excel";
        else if (suffix.equalsIgnoreCase("ppt") || suffix.equalsIgnoreCase("pptx"))
            return "PowerPoint";
        else if (suffix.equalsIgnoreCase("txt"))
            return "Text";
        else if (suffix.equalsIgnoreCase("zip") || suffix.equalsIgnoreCase("rar"))
            return "Zip";
        else if (suffix.equalsIgnoreCase("mp3") || suffix.equalsIgnoreCase("wav") || suffix.equalsIgnoreCase("wma"))
            return "Audio";
        else if (suffix.equalsIgnoreCase("mp4") || suffix.equalsIgnoreCase("avi") || suffix.equalsIgnoreCase("flv"))
            return "Video";
        else if (suffix.equalsIgnoreCase("csv"))
            return "CSV";
        else if (suffix.equalsIgnoreCase("json"))
            return "JSON";
        else if (suffix.equalsIgnoreCase("xml"))
            return "XML";
        else if (suffix.equalsIgnoreCase("html") || suffix.equalsIgnoreCase("htm"))
            return "HTML";
        else if (suffix.equalsIgnoreCase("log"))
            return "Log";
        else
            return "Other";
    }

    /**
     * This method is used to get File Type
     *
     * @Auther : Sambit Kumar Pradhan
     * @param fileName
     * @return String
     * @Date : 20-Mar-2024 : 12:47 PM
     */

    private static final Map<String, String> FILE_TYPE_MAP = new HashMap<>();

    static {
        FILE_TYPE_MAP.put("jpg", "Image");
        FILE_TYPE_MAP.put("jpeg", "Image");
        FILE_TYPE_MAP.put("png", "Image");
        FILE_TYPE_MAP.put("pdf", "PDF");
        FILE_TYPE_MAP.put("doc", "Word");
        FILE_TYPE_MAP.put("docx", "Word");
        FILE_TYPE_MAP.put("xls", "Excel");
        FILE_TYPE_MAP.put("xlsx", "Excel");
        FILE_TYPE_MAP.put("ppt", "PowerPoint");
        FILE_TYPE_MAP.put("pptx", "PowerPoint");
        FILE_TYPE_MAP.put("txt", "Text");
        FILE_TYPE_MAP.put("zip", "Zip");
        FILE_TYPE_MAP.put("rar", "Zip");
        FILE_TYPE_MAP.put("7z", "Zip");
        FILE_TYPE_MAP.put("tar", "Zip");
        FILE_TYPE_MAP.put("gz", "Zip");
        FILE_TYPE_MAP.put("mp3", "Audio");
        FILE_TYPE_MAP.put("wav", "Audio");
        FILE_TYPE_MAP.put("wma", "Audio");
        FILE_TYPE_MAP.put("mp4", "Video");
        FILE_TYPE_MAP.put("avi", "Video");
        FILE_TYPE_MAP.put("flv", "Video");
        FILE_TYPE_MAP.put("csv", "CSV");
        FILE_TYPE_MAP.put("json", "JSON");
        FILE_TYPE_MAP.put("xml", "XML");
        FILE_TYPE_MAP.put("html", "HTML");
        FILE_TYPE_MAP.put("htm", "HTML");
        FILE_TYPE_MAP.put("log", "Log");
    }

    public static String getFileType1(String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        return FILE_TYPE_MAP.getOrDefault(suffix, "Other");
    }
}
