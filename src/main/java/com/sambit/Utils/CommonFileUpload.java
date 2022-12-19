package com.sambit.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CommonFileUpload {
    public static final Logger logger = LoggerFactory.getLogger(CommonFileUpload.class);
    public static final String windowsRootFolder = "C://RegistrationData//";
    public static final String linuxRootFolder = "/opt/RegistrationData/";
    private static final String uploadedFolderInWindows="C://RegistrationData//Documents//";
    private static final String uploadedFolderInLinux="/opt/RegistrationData/Documents/";
    public static String operatingSystem = System.getProperty("os.name").toLowerCase().trim();

    private static final ResourceBundle fileResourceBundle = ResourceBundle.getBundle("file.configuration");


//    Color
    public static final String ansiGreen = "\u001b[32;1m";
    public static final String ansiRed = "\u001b[31;1m";
    public static final String ansiReset = "\u001B[0m";



//    Create Root Directory and Folder Method
    public static String createFolder(String folderName){
        String filePath = "";
        String result= null;
//        System.out.println("Logger" + logger.toString() +  "Name: " +  logger.getName());
//        System.out.println("Operating System--------------> " + ansiGreen + operatingSystem + ansiReset);
//        System.out.println("System Properties--------------> " + ansiGreen + System.getProperties() + ansiReset);
//        operatingSystem.indexOf("windows") >= 0 Instead of  operatingSystem.contains("windows")----------can Used but Not Appropriate
        if (operatingSystem.contains("windows")){
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + " Windows" + ansiReset);
            filePath = windowsRootFolder + folderName;
        }
        else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")){
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + "Linux" + ansiReset);
            filePath = linuxRootFolder + folderName;
        }

        //Checking Root Directory is Present or Not
        File file = new File("C://RegistrationData");
        if (!file.exists()){
            logger.info("Root Directory Not Present, Do You Want to Create Root Directory(" + ansiGreen + "Y" + ansiReset + "/" + ansiRed + "N" +ansiReset + ")?!");
            Scanner scanner = new Scanner(System.in);
            char response = scanner.next().charAt(0);
            if (Character.toUpperCase(response) == 'Y'){
                logger.info("Root Directory is Creating....");
                boolean checkCreated = file.mkdir();
                if (checkCreated){
                    logger.info(ansiGreen + "Root Directory Created Successfully." + ansiReset);
                    File file1 = new File(filePath);
                    if (!file1.exists()){
                        logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                        boolean checkCreated1 = file1.mkdir();
                        if (checkCreated1){
                            logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                            result = "Success";
                        }
                        else {
                            logger.info(folderName + ansiReset + " Already Present in Root Directory!" + ansiReset);
                        }
                    }
                }
            }
            else{
                logger.info(ansiRed + "Reverting Back!!" + ansiReset);
                result = "Failed";
            }
        }
        else{
            logger.info("Root Directory Present");
            File file1 = new File(filePath);
            if (!file1.exists()){
                logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                boolean checkCreated2 = file1.mkdir();
                if (checkCreated2){
                    logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                    result = "Success";
                }
                else {
                    logger.info(folderName + ansiReset + " Already Present in Root Directory!" + ansiReset);
                }
            }
        }
        return result;
    }


//    Check For Folder Is Exists or Not
    public static String fileExistsOrNot(String folderName){
        String filePath = "";
        String result= null;
        System.out.println("Logger" + logger.toString() +  "Name: " +  logger.getName());
        System.out.println("Operating System--------------> " + ansiGreen + operatingSystem + ansiReset);
        System.out.println("System Properties--------------> " + ansiGreen + System.getProperties() + ansiReset);
//        operatingSystem.indexOf("windows") >= 0 Instead of  operatingSystem.contains("windows")----------can Used but Not Appropriate
        if (operatingSystem.contains("windows")){
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + " Windows" + ansiReset);
            filePath = windowsRootFolder + folderName;
        }
        else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")){
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + "Linux" + ansiReset);
            filePath = linuxRootFolder + folderName;
        }

        //Checking Root Directory is Present or Not
        File file = new File("C://RegistrationData");
        if (!file.exists()){
            logger.info("Root Directory Not Present, Do You Want to Create Root Directory(" + ansiGreen + "Y" + ansiReset + "/" + ansiRed + "N" +ansiReset + ")?!");
            Scanner scanner = new Scanner(System.in);
            char response = scanner.next().charAt(0);
            if (Character.toUpperCase(response) == 'Y'){
                logger.info("Root Directory is Creating....");
                boolean checkCreated = file.mkdir();
                if (checkCreated){
                    logger.info(ansiGreen + "Root Directory Created Successfully." + ansiReset);
                    File file1 = new File(filePath);
                    if (!file1.exists()){
                        logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                        boolean checkCreated1 = file1.mkdir();
                        if (checkCreated1){
                            logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                            result = "Success";
                            return filePath + "//";
                        }
                        else {
                            logger.info(folderName + ansiReset + " Already Present in Root Directory!" + ansiReset);
                            return filePath + "//";
                        }
                    }
                }
            }
            else{
                logger.info(ansiRed + "Reverting Back!!" + ansiReset);
                result = "Failed";
            }
        }
        else{
            logger.info("Root Directory Present");
            File file1 = new File(filePath);
            if (!file1.exists()){
                logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                boolean checkCreated2 = file1.mkdir();
                if (checkCreated2){
                    logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                    result = "Success";
                    return filePath + "//";
                }
                else {
                    logger.info(folderName + ansiReset + " Already Present in Root Directory!" + ansiReset);
                    return filePath + "//";
                }
            }
        }
        return filePath;
    }

//    Upload Single File into Local Folder
    public static String singleFileUplaod(MultipartFile file, String filePath) throws IOException {
        String fileFlag = "";
        if (file.isEmpty()){
        System.out.println("File Mustn't Be Empty!");
        fileFlag = "FileEmpty";
        }
        else {
            String folderPath = fileExistsOrNot(filePath);
            System.out.println("Check Data-------------->" + folderPath);
            byte[] bytes =file.getBytes();
            Path path =Paths.get(folderPath + "//" + file.getOriginalFilename());
            Files.write(path, bytes);
            fileFlag = folderPath + "//" + file.getOriginalFilename();
        }
        return fileFlag;
    }

    public static String generateFileNoSuffix(String originalFileName,String fileNames) {
        int lastIndexOfDot=originalFileName.lastIndexOf(".");
        String fileName=fileNames;
        String extension=originalFileName.substring(lastIndexOfDot,originalFileName.length());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String numbers[] = dtf.format(now).split("\\s+");
        String number1[] = numbers[0].split("/");
        String number2[] = numbers[1].split(":");
        String generateFileNoSuffix =number1[0]+number1[1]+number1[2]+number2[0]+number2[1]+number2[2];
        fileName=fileName+generateFileNoSuffix+extension;
        return fileName;
    }


    public static File convert(MultipartFile file) throws IOException
    {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


    public static String getDocumentPath(String filePath){
        String docPath = "";
        if (operatingSystem.indexOf("win") >= 0) {
            logger.info("This is Windows");
            docPath = windowsRootFolder+filePath;
            System.out.println("Document Path : " + docPath);
        }
        else if (operatingSystem.indexOf("nix") >= 0 || operatingSystem.indexOf("nux") >= 0 || operatingSystem.indexOf("aix") > 0 ) {
            logger.info("This is Unix or Linux");
            docPath = linuxRootFolder+filePath;
            System.out.println("Document Path : " + docPath);
        }
        return docPath;
    }

//    Download Files
    public static void downloadFile(HttpServletResponse response, String filePath) throws IOException {

        File file= new File(CommonFileUpload.getDocumentPath(filePath));
        if(!file.exists()){
            String errorMessage = "Sorry. The File You Are Looking For Doesn't Exists!";
            logger.info(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            logger.info("Mimetype is Not Detectable, Will Take Default");
            mimeType = "application/octet-stream";
        }
        logger.info("mimetype : "+mimeType);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() +"\""));//For Downloading
//        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));//For Opeing in Chrome
        response.setContentLength((int)file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    public static void downloadFileUsingCompletePath(HttpServletResponse response, String filePath) throws IOException {
        File file= new File(filePath);
        if(!file.exists()){
            String errorMessage = "Sorry. The File You Are Looking For Doesn't Exists!";
            logger.info(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            logger.info("Mimetype is Not Detectable, Will Take Default");
            mimeType = "application/octet-stream";
        }
        logger.info("mimetype : "+mimeType);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() +"\""));//For Downloading
//        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));//For Opeing in Chrome
        response.setContentLength((int)file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
        System.out.println("File Downloaded Successfully!");
    }


//    Upoad Multiple Files
    public static String multipleFileUpload(MultipartFile[] file, String folderPath) {
        String fileFlag = "";
        if (file.length > 0 ) {
            for (int i = 0; i < file.length; i++) {
                if (file[i].isEmpty()) {
                    fileFlag = "FEP";
                }else{
                    try {
                        String filePath=fileExistsOrNot(folderPath.trim());
                        System.out.println("FilePath length------------"+filePath.length());
                        if(!filePath.isEmpty()){
                            // logic to save the corresponding file
                            byte[] bytes = file[i].getBytes();
                            Path path = Paths.get(filePath.trim());
                            Files.write(path, bytes);
                            fileFlag = filePath.trim()+"/"+file[i].getOriginalFilename();
                             System.out.println("FilePath trim length------------"+filePath.trim().length());
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return fileFlag;
    }




//    Operating Systems
public static String typeOfOperatingSystem(){
    String filePath = "";
    if (operatingSystem.indexOf("win") >= 0) {
        logger.info("This is Windows");
        filePath = "Windows";
    }
    else if (operatingSystem.indexOf("nix") >= 0 || operatingSystem.indexOf("nux") >= 0 || operatingSystem.indexOf("aix") > 0 ) {
        logger.info("This is Unix or Linux");
        filePath = "Linux";
    }
    return filePath;
}

    public static void saveFileToServer(MultipartFile file, String folderPath, String customFileName){
        byte[] bytes;
        try {
            bytes = file.getBytes();
            Path path =  Paths.get(folderPath + "/" + customFileName);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean saveFileHospitalImage(MultipartFile hospitalImageFile, String hospitalCode, String year) {
        boolean isSaved = false;
        String fileName, customFileName, folderName, filePath, docPath;
        try {
            fileName = StringUtils.cleanPath(Objects.requireNonNull(hospitalImageFile.getOriginalFilename()));
            customFileName = fileResourceBundle.getString("file.hospitalImage.prefix") + "_" + year + "_" + hospitalCode + "_" + fileName;
            folderName = fileResourceBundle.getString("file.path.HospitalImage");
            filePath = year + "/" + hospitalCode + "/" + folderName;
            docPath = getDocumentPath(filePath);
            System.out.println("File Upload Full Path : " + docPath);
            File file = new File(docPath + "/" + customFileName);
            if (!file.exists()) {
                System.out.println("File Not Exist");
                boolean mkdirs = file.getParentFile().mkdirs();
                if (mkdirs) {
                    System.out.println("Missing Directory Created");
                }
                saveFileToServer(hospitalImageFile, docPath, customFileName);
                if (file.exists()) {
                    System.out.println("File Saved To Server, Path : " + docPath + "/" + customFileName);
                    isSaved = true;
                }
            } else {
                System.out.println("File Exist");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return isSaved;
    }
}

