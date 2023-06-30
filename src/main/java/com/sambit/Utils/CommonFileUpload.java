package com.sambit.Utils;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.System.out;

public class CommonFileUpload {
    public static final Logger logger = LoggerFactory.getLogger(CommonFileUpload.class);
    public static final String windowsRootFolder = "C://RegistrationData//";
    public static final String linuxRootFolder = "/opt/RegistrationData/";
    private static final String uploadedFolderInWindows = "C://RegistrationData//Documents//";
    private static final String uploadedFolderInLinux = "/opt/RegistrationData/Documents/";
    private static final String home = System.getProperty("user.home");
    public static String operatingSystem = System.getProperty("os.name").toLowerCase().trim();

    private static final ResourceBundle fileResourceBundle = ResourceBundle.getBundle("file.configuration");


    //    Color
    public static final String ansiGreen = "\u001b[32;1m";
    public static final String ansiRed = "\u001b[31;1m";
    public static final String ansiReset = "\u001B[0m";


    //    Create Root Directory and Folder Method
    public static String createFolder(String folderName) {
        String filePath = "";
        String result = null;
        out.println("Logger" + logger.toString() + "Name: " + logger.getName());
        out.println("Operating System--------------> " + ansiGreen + operatingSystem + ansiReset);
        out.println("System Properties--------------> " + ansiGreen + System.getProperties() + ansiReset);
//        operatingSystem.indexOf("windows") >= 0 Instead of  operatingSystem.contains("windows")----------can Used but Not Appropriate
        if (operatingSystem.contains("windows")) {
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + " Windows" + ansiReset);
            filePath = windowsRootFolder + folderName;
        } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")) {
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + "Linux" + ansiReset);
            filePath = linuxRootFolder + folderName;
        }

        //Checking Root Directory is Present or Not
        File file = new File("C://RegistrationData");
        if (!file.exists()) {
            logger.info("Root Directory Not Present, Do You Want to Create Root Directory(" + ansiGreen + "Y" + ansiReset + "/" + ansiRed + "N" + ansiReset + ")?!");
            Scanner scanner = new Scanner(System.in);
            char response = scanner.next().charAt(0);
            if (Character.toUpperCase(response) == 'Y') {
                logger.info("Root Directory is Creating....");
                boolean checkCreated = file.mkdir();
                if (checkCreated) {
                    logger.info(ansiGreen + "Root Directory Created Successfully." + ansiReset);
                    File file1 = new File(filePath);
                    if (!file1.exists()) {
                        logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                        boolean checkCreated1 = file1.mkdir();
                        if (checkCreated1) {
                            logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                            result = "Success";
                        } else {
                            logger.info(folderName + ansiReset + " Already Present in Root Directory!" + ansiReset);
                        }
                    }
                }
            } else {
                logger.info(ansiRed + "Reverting Back!!" + ansiReset);
                result = "Failed";
            }
        } else {
            logger.info("Root Directory Present");
            File file1 = new File(filePath);
            if (!file1.exists()) {
                logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                boolean checkCreated2 = file1.mkdir();
                if (checkCreated2) {
                    logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                    result = "Success";
                } else {
                    logger.info(folderName + ansiReset + " Already Present in Root Directory!" + ansiReset);
                }
            }
        }
        return result;
    }


    //    Check For Folder Is Exists or Not
    public static String fileExistsOrNot(String folderName) {
        String filePath = "";
        String result = null;
        out.println("Logger" + logger.toString() + "Name: " + logger.getName());
        out.println("Operating System--------------> " + ansiGreen + operatingSystem + ansiReset);
        out.println("System Properties--------------> " + ansiGreen + System.getProperties() + ansiReset);
//        operatingSystem.indexOf("windows") >= 0 Instead of  operatingSystem.contains("windows")----------can Used but Not Appropriate
        if (operatingSystem.contains("windows")) {
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + " Windows" + ansiReset);
            filePath = windowsRootFolder + folderName;
        } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")) {
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + "Linux" + ansiReset);
            filePath = linuxRootFolder + folderName;
        }

        //Checking Root Directory is Present or Not
        File file = new File("C://RegistrationData");
        if (!file.exists()) {
            logger.info("Root Directory Not Present, Do You Want to Create Root Directory(" + ansiGreen + "Y" + ansiReset + "/" + ansiRed + "N" + ansiReset + ")?!");
            Scanner scanner = new Scanner(System.in);
            char response = scanner.next().charAt(0);
            if (Character.toUpperCase(response) == 'Y') {
                logger.info("Root Directory is Creating....");
                boolean checkCreated = file.mkdir();
                if (checkCreated) {
                    logger.info(ansiGreen + "Root Directory Created Successfully." + ansiReset);
                    File file1 = new File(filePath);
                    if (!file1.exists()) {
                        logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                        boolean checkCreated1 = file1.mkdir();
                        if (checkCreated1) {
                            logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                            result = "Success";
                            return filePath + "//";
                        } else {
                            logger.info(folderName + ansiReset + " Already Present in Root Directory!" + ansiReset);
                            return filePath + "//";
                        }
                    }
                }
            } else {
                logger.info(ansiRed + "Reverting Back!!" + ansiReset);
                result = "Failed";
            }
        } else {
            logger.info("Root Directory Present");
            File file1 = new File(filePath);
            if (!file1.exists()) {
                logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                boolean checkCreated2 = file1.mkdir();
                if (checkCreated2) {
                    logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                    result = "Success";
                    return filePath + "//";
                } else {
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
        if (file.isEmpty()) {
            out.println("File Mustn't Be Empty!");
            fileFlag = "FileEmpty";
        } else {
            String folderPath = fileExistsOrNot(filePath);
            out.println("Check Data-------------->" + folderPath);
            byte[] bytes = file.getBytes();
            Path path = Paths.get(folderPath + "//" + file.getOriginalFilename());
            Files.write(path, bytes);
            fileFlag = folderPath + "//" + file.getOriginalFilename();
        }
        return fileFlag;
    }

    public static String generateFileNoSuffix(String originalFileName, String fileNames) {
        int lastIndexOfDot = originalFileName.lastIndexOf(".");
        String fileName = fileNames;
        String extension = originalFileName.substring(lastIndexOfDot, originalFileName.length());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String[] numbers = dtf.format(now).split("\\s+");
        String[] number1 = numbers[0].split("/");
        String[] number2 = numbers[1].split(":");
        String generateFileNoSuffix = number1[0] + number1[1] + number1[2] + number2[0] + number2[1] + number2[2];
        fileName = fileName + generateFileNoSuffix + extension;
        return fileName;
    }


    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


    public static String getDocumentPath(String filePath) {
        String docPath = "";
        if (operatingSystem.contains("win")) {
            logger.info("This is Windows");
            docPath = windowsRootFolder + filePath;
            out.println("Document Path : " + docPath);
        } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.indexOf("aix") > 0) {
            logger.info("This is Unix or Linux");
            docPath = linuxRootFolder + filePath;
            out.println("Document Path : " + docPath);
        }
        return docPath;
    }

    //    Download Files
    public static void downloadFile(HttpServletResponse response, String filePath) throws IOException {

        File file = new File(CommonFileUpload.getDocumentPath(filePath));
        if (!file.exists()) {
            String errorMessage = "Sorry. The File You Are Looking For Doesn't Exists!";
            logger.info(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            logger.info("Mimetype is Not Detectable, Will Take Default");
            mimeType = "application/octet-stream";
        }
        logger.info("mimetype : " + mimeType);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));//For Downloading
//        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));//For Opeing in Chrome
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    public static void downloadFileUsingCompletePath(HttpServletResponse response, String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            String errorMessage = "Sorry. The File You Are Looking For Doesn't Exists!";
            logger.info(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            logger.info("Mimetype is Not Detectable, Will Take Default");
            mimeType = "application/octet-stream";
        }
        logger.info("mimetype : " + mimeType);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));//For Downloading
//        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));//For Opeing in Chrome
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
        out.println("File Downloaded Successfully!");
    }


    //    Upoad Multiple Files
    public static String multipleFileUpload(MultipartFile[] file, String folderPath) {
        String fileFlag = "";
        if (file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                if (file[i].isEmpty()) {
                    fileFlag = "FEP";
                } else {
                    try {
                        String filePath = fileExistsOrNot(folderPath.trim());
                        out.println("FilePath length------------" + filePath.length());
                        if (!filePath.isEmpty()) {
                            // logic to save the corresponding file
                            byte[] bytes = file[i].getBytes();
                            Path path = Paths.get(filePath.trim());
                            Files.write(path, bytes);
                            fileFlag = filePath.trim() + "/" + file[i].getOriginalFilename();
                            out.println("FilePath trim length------------" + filePath.trim().length());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return fileFlag;
    }


    //    Operating Systems
    public static String typeOfOperatingSystem() {
        String filePath = "";
        if (operatingSystem.contains("win")) {
            logger.info("This is Windows");
            filePath = "Windows";
        } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.indexOf("aix") > 0) {
            logger.info("This is Unix or Linux");
            filePath = "Linux";
        }
        return filePath;
    }

    public static void saveFileToServer(MultipartFile file, String folderPath, String customFileName) {
        byte[] bytes;
        try {
            bytes = file.getBytes();
            Path path = Paths.get(folderPath + "/" + customFileName);
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
            out.println("File Upload Full Path : " + docPath);
            File file = new File(docPath + "/" + customFileName);
            if (!file.exists()) {
                out.println("File Not Exist");
                boolean mkdirs = file.getParentFile().mkdirs();
                if (mkdirs) {
                    out.println("Missing Directory Created");
                }
                saveFileToServer(hospitalImageFile, docPath, customFileName);
                if (file.exists()) {
                    out.println("File Saved To Server, Path : " + docPath + "/" + customFileName);
                    isSaved = true;
                }
            } else {
                out.println("File Exist");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return isSaved;
    }

    public static String saveFileDCImage(MultipartFile dcImageFile, String hospitalCode, Long dcUserId, String year) throws Exception {
        String fileName, customFileName, folderName, filePath, docPath, responsePath = null;
        try {
            fileName = StringUtils.cleanPath(Objects.requireNonNull(dcImageFile.getOriginalFilename()));
            String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
            customFileName = "DCIM" + "_" + year + "_" + dcUserId + "." + fileExtension;
            folderName = "DCImage";
            filePath = year + "/" + hospitalCode + "/" + folderName;
            docPath = getDocumentPath(filePath);
            out.println("File Upload Full Path : " + docPath);
            File file = new File(docPath + "/" + customFileName);
            if (!file.exists()) {
                out.println("File Not Exist");
                boolean mkdirs = file.getParentFile().mkdirs();
                if (mkdirs) {
                    out.println("Missing Directory Created");
                }
                saveFileToServer(dcImageFile, docPath, customFileName);
                if (file.exists()) {
                    out.println("File Saved To Server, Path : " + docPath + "/" + customFileName);
                    responsePath = docPath + "/" + customFileName;
                }
            } else {
                out.println("File Exist");
                responsePath = docPath + "/" + customFileName;
                throw new Exception("Selfie Image Already Exist, You Can't Upload Same File Again");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return responsePath;
    }

    public static String getDCImageCompletePath(String dcFileName, String Year, String hospitalCode) {
        String folderName = "DCImage";
        String filePath = Year + "/" + hospitalCode + "/" + folderName;
        String docPath = getDocumentPath(filePath);
        return docPath + "/" + dcFileName;
    }

    public static String getHospitalImageCompletePath(String hospitalFileName, String Year, String hospitalCode) {
        String folderName = "HospitalImage";
        String filePath = Year + "/" + hospitalCode + "/" + folderName;
        String docPath = getDocumentPath(filePath);
        return docPath + "/" + hospitalFileName;
    }

    //    Can Check Using PostMan
    public static void downloadDCUploadedFile(JSONObject jsonObject, HttpServletResponse httpServletResponse) throws Exception {
        String filePath = null;

        if (jsonObject.getString("imageFileName").split("_")[0].equalsIgnoreCase("HOSIMG")) {
            filePath = CommonFileUpload.getHospitalImageCompletePath(
                    jsonObject.getString("imageFileName"),
                    jsonObject.getString("createdDate").substring(jsonObject.getString("createdDate").lastIndexOf("/") + 1),
                    jsonObject.getString("hospitalCode")
            );
        } else if (jsonObject.getString("imageFileName").split("_")[0].equalsIgnoreCase("DCIMG")) {
            filePath = CommonFileUpload.getDCImageCompletePath(
                    jsonObject.getString("imageFileName"),
                    jsonObject.getString("createdDate").substring(jsonObject.getString("createdDate").lastIndexOf("/") + 1),
                    jsonObject.getString("hospitalCode")
            );
        }
        File file = new File(filePath);

        if (!file.exists()) {
            String errorMessage = "Sorry! File You are Looking For Doesn't Exist";
            OutputStream outputStream = httpServletResponse.getOutputStream();
            outputStream.write(errorMessage.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        } else {
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            httpServletResponse.setContentType(mimeType);
            httpServletResponse.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
            httpServletResponse.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, httpServletResponse.getOutputStream());
        }
    }

    public String checkFileExtension(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase("jpeg") || fileExtension.equalsIgnoreCase("png")) {
            return fileExtension;
        } else {
            return null;
        }
    }

    public String checkDocumentExtension(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (fileExtension.equalsIgnoreCase("pdf") || fileExtension.equalsIgnoreCase("doc") || fileExtension.equalsIgnoreCase("docx")) {
            return fileExtension;
        } else {
            return null;
        }
    }

    public static void mergeImageFiles() {
        try {
            String filePath = "C:\\BSKY\\2022\\21122004\\surgery picture\\IntraSurgeryPic\\INTR_213659_202301101712085049381.jpg";
            String filePath1 = "C:\\BSKY\\2022\\21122004\\surgery picture\\PostSurgery\\POSTSX_213659_202301101712085049381.jpg";
            String filePath2 = "C:\\BSKY\\2022\\21122004\\surgery picture\\PreSurgery\\PRETSX_213659_202301101712085049381.jpg";

            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            PDImageXObject pdImage = PDImageXObject.createFromFile(filePath, doc);
            PDImageXObject pdImage1 = PDImageXObject.createFromFile(filePath1, doc);
            PDImageXObject pdImage2 = PDImageXObject.createFromFile(filePath2, doc);
//			SET CENTER IMAGE
            contentStream.drawImage(pdImage, 0, 0, 595, 842);
////			SET LEFT IMAGE
//			contentStream.drawImage(pdImage1, 0, 0, 297, 842);
////			SET RIGHT IMAGE
//			contentStream.drawImage(pdImage2, 297, 0, 297, 842);
            contentStream.close();
            doc.save("C:\\BSKY\\DATA1.pdf");
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mergePDFFiles() {
        String filePath = "C:\\Users\\sambit.pradhan\\Desktop\\1.pdf";
        String filePath1 = "C:\\Users\\sambit.pradhan\\Desktop\\2.pdf";
        try {
            out.println("Start");
            PDDocument doc = new PDDocument();
            PDDocument doc1 = new PDDocument();
            doc = PDDocument.load(new File(filePath));
            doc1 = PDDocument.load(new File(filePath1));
            doc.addPage(doc1.getPage(0));
            doc.save("C:\\Users\\sambit.pradhan\\Desktop\\3.pdf");
            doc.close();
            doc1.close();
            out.println("End");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadAllMergedDocumentFiles() throws IOException {
        List<String> pathList = new ArrayList<>();
        PDDocument mergedPDFDocument = new PDDocument();
        List<PDDocument> pdfDocuments = new ArrayList<>();
        pathList.add("C:\\BSKY\\2022\\21122004\\surgery picture\\IntraSurgeryPic\\INTR_213659_202301101712085049381.jpg");
        pathList.add("C:\\BSKY\\2022\\21122004\\surgery picture\\PostSurgery\\POSTSX_213659_202301101712085049381.jpg");
        pathList.add("C:\\BSKY\\2022\\21122004\\surgery picture\\PreSurgery\\PRETSX_213659_202301101712085049381.jpg");
        pathList.add("C:\\Users\\sambit.pradhan\\Desktop\\1.pdf");

        for (String path : pathList) {
//            String fullFilePath = CommonFileUpload.getFullDocumentPath(fileName, year, hospitalCode, CommonFileUpload.getFolderName(fileName));
            out.println("Full File Path : " + path);

            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            PDImageXObject pdImage = PDImageXObject.createFromFile(path, doc);
            contentStream.drawImage(pdImage, 0, 0, 595, 842);
            contentStream.close();
            pdfDocuments.add(doc);
        }

        for (PDDocument pdfDocument : pdfDocuments) {
            mergedPDFDocument.addPage(pdfDocument.getPage(0));
        }

        String destinationFilePath = "C:\\BSKY\\" + "mergedDocumentFile.pdf";
        mergedPDFDocument.save(destinationFilePath);
    }

    public static String getDocumentPath1(String filePath) {
        String docPath = "";
        if (operatingSystem.contains("win")) {
            docPath = windowsRootFolder.trim() + filePath.trim();
        } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.indexOf("aix") > 0) {
            docPath = linuxRootFolder.trim() + filePath.trim();
        }
        return docPath;
    }

    public static String getFullDocumentPath(String fileName, String year, String hospitalCode, String folderName) {
        return getDocumentPath1(year + "/" + hospitalCode + "/" + folderName.trim() + "/" + fileName);
    }


    public static String getFolderName(String fileName) {
        String newName = fileName.split("_")[0];
//		System.out.println("File Prefix Name : "+newName);
        String folderName;
        if (newName.equals(fileResourceBundle.getString("file.presurgery-pic.prefix"))) {
            folderName = fileResourceBundle.getString("folder.patient.presurg.photo");
        } else if (newName.equals(fileResourceBundle.getString("file.postsurgery-pic.prefix"))) {
            folderName = fileResourceBundle.getString("folder.patient.postsurg.photo");
        } else if (newName.equals(fileResourceBundle.getString("file.DischargeSlip.prefix"))) {
            folderName = fileResourceBundle.getString("folder.DischargeSlip");
        } else if (newName.equals(fileResourceBundle.getString("file.AdditionalDoc.prefix"))) {
            folderName = fileResourceBundle.getString("folder.AdditionalDoc");
        } else if (newName.equals(fileResourceBundle.getString("file.Specimen.prefix"))) {
            folderName = fileResourceBundle.getString("folder.patient.SpecimenRemovalPic.photo");
        } else if (newName.equals(fileResourceBundle.getString("file.Patient.prefix"))) {
            folderName = fileResourceBundle.getString("folder.PatientPic");
        } else if (newName.equals(fileResourceBundle.getString("file.moredocument.prefix"))) {
            folderName = fileResourceBundle.getString("folder.Additionaldoc1");
        } else if (newName.equals(fileResourceBundle.getString("file.needmoredocument.prefix"))) {
            folderName = fileResourceBundle.getString("folder.Additionaldoc2");
        } else if (newName.equals(fileResourceBundle.getString("file.Intrasurgery.prefix"))) {
            folderName = fileResourceBundle.getString("folder.patient.IntraSurgeryPic.photo");
        } else {
            folderName = "AdmissionSlip";
        }
//		System.out.println("Folder Name : "+folderName);
        return folderName;
    }

    public void downloadDocuments(JSONArray jsonArray, HttpServletResponse response) {
        String year = "";
        PDDocument mergedPDFDocument = new PDDocument();
        List<PDDocument> pdfDocuments = new ArrayList<>();
        try {
            for (int i = 0; jsonArray.length() > i; i++) {
                String fileName = jsonArray.getJSONObject(i).getString("f");
                String hospitalCode = jsonArray.getJSONObject(i).getString("h");
                String date = jsonArray.getJSONObject(i).getString("d");
                if (date.length() > 11) {
                    String preAuthDate = new SimpleDateFormat("dd MMM yyyy")
                            .format(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                    year = preAuthDate.substring(6);
                } else {
                    year = date.substring(6);
                }
                String fullFilePath = CommonFileUpload.getFullDocumentPath(fileName, year, hospitalCode, CommonFileUpload.getFolderName(fileName));
                out.println("Full File Path : " + fullFilePath);

                if (fileName.endsWith(".pdf")) {
                    PDDocument doc = PDDocument.load(new File(fullFilePath));
                    pdfDocuments.add(doc);
                } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
                    PDDocument doc = new PDDocument();
                    PDPage page = new PDPage();
                    doc.addPage(page);
                    PDPageContentStream contentStream = new PDPageContentStream(doc, page);
                    PDImageXObject pdImage = PDImageXObject.createFromFile(fullFilePath, doc);
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
                    contentStream.newLineAtOffset(250, 700);
                    contentStream.showText(CommonFileUpload.getFolderName(fileName).substring(CommonFileUpload.getFolderName(fileName).indexOf("/") + 1));
                    contentStream.endText();
                    contentStream.drawImage(pdImage, 120, 150, 350, 450);
                    contentStream.close();
                    pdfDocuments.add(doc);
                }
            }

            for (PDDocument pdfDocument : pdfDocuments) {
                mergedPDFDocument.addPage(pdfDocument.getPage(0));
            }

//			Download This mergedPDFDocument
            OutputStream out = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"mergedDocument.pdf\"");
            mergedPDFDocument.save(out);
            out.flush();
            out.close();


//			String destinationFilePath = CommonFileUpload.getMergeDocumentPath() + "mergedDocumentFile.pdf";
//			System.out.println("Destination File Path : " + destinationFilePath);
//			mergedPDFDocument.save(destinationFilePath);
//
//			File mergedDocumentFilePDF = new File(destinationFilePath);
//
//			OutputStream out = response.getOutputStream();
//			response.setContentType("application/pdf");
//			response.setHeader("Content-Disposition", "attachment; filename=\"" + mergedDocumentFilePDF.getName() + "\"");
//			FileInputStream in = new FileInputStream(mergedDocumentFilePDF);
//			byte[] buffer = new byte[4096];
//			int length;
//			while ((length = in.read(buffer)) > 0) {
//				out.write(buffer, 0, length);
//			}
//			in.close();


//			if (mergedDocumentFilePDF.exists()) {
//				System.out.println("File Exists");
//				CommonFileUpload.downloadPDFFile(mergedDocumentFilePDF, response);
//			} else {
//				System.out.println("File Not Exists");
//			}

            for (PDDocument pdfDocument : pdfDocuments) {
                pdfDocument.close();
            }
            mergedPDFDocument.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public void downloadDocuments(JSONArray jsonArray, HttpServletResponse response) {
//        String year = "";
//        PDDocument mergedPDFDocument = new PDDocument();
//        List<PDDocument> pdfDocuments = new ArrayList<>();
//        try {
//            for (int i = 0; jsonArray.length() > i; i++) {
//                String fileName = jsonArray.getJSONObject(i).getString("f");
//                String hospitalCode = jsonArray.getJSONObject(i).getString("h");
//                String date = jsonArray.getJSONObject(i).getString("d");
//                if (date.length() > 11) {
//                    String preAuthDate = new SimpleDateFormat("dd MMM yyyy")
//                            .format(new SimpleDateFormat("yyyy-MM-dd").parse(date));
//                    year = preAuthDate.substring(6);
//                } else {
//                    year = date.substring(6);
//                }
//                String fullFilePath = CommonFileUpload.getFullDocumentPath(fileName, year, hospitalCode, CommonFileUpload.getFolderName(fileName));
////				System.out.println("Full File Path : " + fullFilePath);
//
//                if (fileName.endsWith(".pdf")) {
//                    PDDocument doc = PDDocument.load(new File(fullFilePath));
//                    pdfDocuments.add(doc);
//                } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
//                    PDDocument doc = new PDDocument();
//                    PDPage page = new PDPage();
//                    doc.addPage(page);
//                    PDPageContentStream contentStream = new PDPageContentStream(doc, page);
//                    PDImageXObject pdImage = PDImageXObject.createFromFile(fullFilePath, doc);
//                    contentStream.beginText();
//                    contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
//                    contentStream.newLineAtOffset(250, 700);
//                    contentStream.showText( CommonFileUpload.getFolderName(fileName).substring(CommonFileUpload.getFolderName(fileName).indexOf("/") + 1));
//                    contentStream.endText();
//                    contentStream.drawImage(pdImage, 120, 150, 350, 450);
//                    contentStream.close();
//                    pdfDocuments.add(doc);
//                }
//            }
//            for (PDDocument pdfDocument : pdfDocuments) {
//                mergedPDFDocument.addPage(pdfDocument.getPage(0));
//            }
//            OutputStream out = response.getOutputStream();
//            response.setContentType("application/pdf");
//            response.setHeader("Content-Disposition", "inline; filename=\"mergedDocument.pdf\"");
//            mergedPDFDocument.save(out);
//            out.flush();
//            out.close();
//
//            for (PDDocument pdfDocument : pdfDocuments) {
//                pdfDocument.close();
//            }
//            mergedPDFDocument.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }


//    public void downloadDocuments1(JSONArray jsonArray, HttpServletResponse response) {
//        String year = "";
//        Document mergedDocument = new Document(PageSize.A4);
//        mergedDocument.open();
//        try {
//            for (int i = 0; jsonArray.length() > i; i++) {
//                String fileName = jsonArray.getJSONObject(i).getString("f");
//                String hospitalCode = jsonArray.getJSONObject(i).getString("h");
//                String date = jsonArray.getJSONObject(i).getString("d");
//                if (date.length() > 11) {
//                    String preAuthDate = new SimpleDateFormat("dd MMM yyyy")
//                            .format(new SimpleDateFormat("yyyy-MM-dd").parse(date));
//                    year = preAuthDate.substring(6);
//                } else {
//                    year = date.substring(6);
//                }
//                String fullFilePath = CommonFileUpload.getFullDocumentPath(fileName, year, hospitalCode, CommonFileUpload.getFolderName(fileName));
//
//                if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
//                    Image image = Image.getInstance(fullFilePath);
//                    image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
//                    image.setAlignment(Image.ALIGN_CENTER);
//                    mergedDocument.add(image);
//                }
//            }
//            response.setContentType("application/pdf");
//            response.setHeader("Content-Disposition", "attachment; filename=\"mergedDocument.pdf\"");
//            PdfWriter.getInstance(mergedDocument, response.getOutputStream());
//            OutputStream out = response.getOutputStream();
//
//        }catch (Exception e) {
//            throw new RuntimeException(e);
//        }


    public void downloadFile(File file) {
        try {
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

