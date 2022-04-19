package com.sambit.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CommonFileUpload {
    public static final Logger logger = LoggerFactory.getLogger(CommonFileUpload.class);
    public static final String windowsRootFolder = "C://RegistrationData//";
    public static final String linuxRootFolder = "/opt/RegistrationData/";
    public static String operatingSystem = System.getProperty("os.name").toLowerCase().trim();


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
}
