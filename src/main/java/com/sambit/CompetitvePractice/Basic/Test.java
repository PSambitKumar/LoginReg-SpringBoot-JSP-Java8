package com.sambit.CompetitvePractice.Basic;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 21/06/2023 - 11:51 AM
 */
public class Test {

//        @Override
//    public List<Map<String, Object>> getReportDataList(String request) throws Exception {
//        logger.info("Inside getReportDataList of APIServiceImpl");
//        List<Map<String, Object>> reportMapList = new ArrayList<>();
//        try {
//            JSONObject requestObject = new JSONObject(request);
//
//            if (!requestObject.has("apiId") && !requestObject.has("year") && !requestObject.has("month")) {
//                throw new Exception("Invalid Request/Parameter");
//            }
//
//            if (requestObject.getInt("apiId") == 1 || requestObject.getInt("apiId") == 2 || requestObject.getInt("apiId") == 3 || requestObject.getInt("apiId") == 4 || requestObject.getInt("apiId") == 5 || requestObject.getInt("apiId") == 9) {
//                reportMapList = apiServiceLogRepository.getReportList(
//                                Long.parseLong(requestObject.getString("apiId")),
//                                Integer.parseInt(requestObject.getString("year")),
//                                Integer.parseInt(requestObject.getString("month")))
//                        .stream()
//                        .map(report -> {
//                            Map<String, Object> reportMap = new LinkedHashMap<>();
//
//                            reportMap.put("apiId", ((Object[]) report)[0] != null ? ((Object[]) report)[0] : "NA");
//                            reportMap.put("apiName", ((Object[]) report)[1] != null ? ((Object[]) report)[1] : "NA");
//                            reportMap.put("apiStartTime", ((Object[]) report)[2] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[2]) : "NA");
//                            reportMap.put("apiEndTime", ((Object[]) report)[3] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[3]) : "NA");
//                            reportMap.put("dataDelivered", ((Object[]) report)[4] != null ? ((Object[]) report)[4] : "NA");
//                            reportMap.put("createdOn", ((Object[]) report)[5] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[5]) : "NA");
//                            reportMap.put("createdBy", ((Object[]) report)[6] != null ? ((Object[]) report)[6] : "NA");
//                            reportMap.put("id", ((Object[]) report)[7]);
//
//                            return reportMap;
//                        })
//                        .collect(Collectors.toList());
//            } else if(requestObject.getInt("apiId") == 6) {
//                reportMapList = healthDepartmentServiceReportRepository.getReportList(
//                                Long.parseLong(requestObject.getString("apiId")),
//                                Integer.parseInt(requestObject.getString("year")),
//                                Integer.parseInt(requestObject.getString("month")))
//                        .stream()
//                        .map(report -> {
//                            Map<String, Object> reportMap = new LinkedHashMap<>();
//
//                            reportMap.put("id", ((Object[]) report)[0] != null ? ((Object[]) report)[0] : "NA");
//                            reportMap.put("apiId", ((Object[]) report)[1] != null ? ((Object[]) report)[1] : "NA");
//                            reportMap.put("serviceName", ((Object[]) report)[2] != null ? ((Object[]) report)[2] : "NA");
//                            reportMap.put("apiStartTime", ((Object[]) report)[3] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[3]) : "NA");
//                            reportMap.put("apiEndTime", ((Object[]) report)[4] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[4]) : "NA");
//                            reportMap.put("recordsFetched", ((Object[]) report)[5] != null ? ((Object[]) report)[5] : "NA");
//                            reportMap.put("recordsInserted", ((Object[]) report)[6] != null ? ((Object[]) report)[6] : "NA");
//                            reportMap.put("recordsUpdated", ((Object[]) report)[7] != null ? ((Object[]) report)[7] : "NA");
//                            reportMap.put("recordsFailed", ((Object[]) report)[8] != null ? ((Object[]) report)[8] : "NA");
//                            reportMap.put("createdOn", ((Object[]) report)[9] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[9]) : "NA");
//                            reportMap.put("createdBy", ((Object[]) report)[10] != null ? ((Object[]) report)[10] : "NA");
//                            reportMap.put("serviceId", ((Object[]) report)[2].toString().toLowerCase().replace(" ", "").contains("basicdetails")
//                                    ? 1
//                                    : ((Object[]) report)[2].toString().toLowerCase().replace(" ", "").contains("memberdetails")
//                                    ? 2
//                                    : 0
//                            );
//
//                            return reportMap;
//                        })
//                        .collect(Collectors.toList());
//            } else if (requestObject.getInt("apiId") == 7) {
//                reportMapList = moSarkarLogRepository.getReportList(
//                                Long.parseLong(requestObject.getString("apiId")),
//                                Integer.parseInt(requestObject.getString("year")),
//                                Integer.parseInt(requestObject.getString("month")))
//                        .stream()
//                        .map(report -> {
//                            Map<String, Object> reportMap = new LinkedHashMap<>();
//
//                            reportMap.put("apiId", ((Object[]) report)[0] != null ? ((Object[]) report)[0] : "NA");
//                            reportMap.put("apiName", ((Object[]) report)[1] != null ? ((Object[]) report)[1] : "NA");
//                            reportMap.put("apiStartTime", ((Object[]) report)[2] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[2]) : "NA");
//                            reportMap.put("apiEndTime", ((Object[]) report)[3] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[3]) : "NA");
//                            reportMap.put("dataDelivered", ((Object[]) report)[4] != null ? ((Object[]) report)[4] : "NA");
//                            reportMap.put("successDataSize", ((Object[]) report)[5] != null ? ((Object[]) report)[5] : "NA");
//                            reportMap.put("failedDataSize", ((Object[]) report)[6] != null ? ((Object[]) report)[6] : "NA");
//                            reportMap.put("createdOn", ((Object[]) report)[7] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[7]) : "NA");
//                            reportMap.put("createdBy", ((Object[]) report)[8] != null ? ((Object[]) report)[8] : "NA");
//                            reportMap.put("id", ((Object[]) report)[9]);
//
//                            return reportMap;
//                        })
//                        .collect(Collectors.toList());
//            } else if(requestObject.getInt("apiId") == 8) {
//                reportMapList = edsDataLogRepository.getReportList(
//                                Long.parseLong(requestObject.getString("apiId")),
//                                Integer.parseInt(requestObject.getString("year")),
//                                Integer.parseInt(requestObject.getString("month")))
//                        .stream()
//                        .map(report -> {
//                            Map<String, Object> reportMap = new LinkedHashMap<>();
//
//                            reportMap.put("id", ((Object[]) report)[0] != null ? ((Object[]) report)[0] : "NA");
//                            reportMap.put("apiId", ((Object[]) report)[1] != null ? ((Object[]) report)[1] : "NA");
//                            reportMap.put("apiStartTime", ((Object[]) report)[2] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[2]) : "NA");
//                            reportMap.put("apiEndTime", ((Object[]) report)[3] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[3]) : "NA");
//                            reportMap.put("recordFetched", ((Object[]) report)[4] != null ? ((Object[]) report)[4] : "NA");
//                            reportMap.put("recordInserted", ((Object[]) report)[5] != null ? ((Object[]) report)[5] : "NA");
//                            reportMap.put("recordUpdated", ((Object[]) report)[6] != null ? ((Object[]) report)[6] : "NA");
//                            reportMap.put("recordFailed", ((Object[]) report)[7] != null ? ((Object[]) report)[7] : "NA");
//                            reportMap.put("createdOn", ((Object[]) report)[8] != null ? DateFormat.formatDateToTime((Date) ((Object[]) report)[8]) : "NA");
//                            reportMap.put("createdBy", ((Object[]) report)[9] != null ? ((Object[]) report)[9] : "NA");
//
//                            return reportMap;
//                        })
//                        .collect(Collectors.toList());
//            }else
//                throw new Exception("Invalid API ID!");
//        } catch (Exception e) {
//            logger.error("Exception Occurred in getReportDataList of APIServiceImpl" + e.getMessage());
//            throw new Exception(e.getMessage());
//        }
//        return reportMapList;
//    }

//    @Override
//    public List<Map<String, Object>> getReportDataList(String request) throws Exception {
//        logger.info("Inside getReportDataList of APIServiceImpl");
//        List<Map<String, Object>> reportMapList = new ArrayList<>();
//        try {
//            JSONObject requestObject = new JSONObject(request);
//
//            if (!requestObject.has("apiId") && !requestObject.has("year") && !requestObject.has("month")) {
//                throw new Exception("Invalid Request/Parameter");
//            }
//
//            int apiId = requestObject.getInt("apiId");
//            int year = Integer.parseInt(requestObject.getString("year"));
//            int month = Integer.parseInt(requestObject.getString("month"));
//
//            switch (apiId) {
//                case 1:
//                case 2:
//                case 3:
//                case 4:
//                case 5:
//                case 9:
//                    reportMapList = apiServiceLogRepository.getReportList((long) apiId, year, month)
//                            .stream()
//                            .map(report -> {
//                                Map<String, Object> reportMap = new LinkedHashMap<>();
//                                Object[] reportArray = (Object[]) report;
//
//                                reportMap.put("apiId", reportArray[0] != null ? reportArray[0] : "NA");
//                                reportMap.put("apiName", reportArray[1] != null ? reportArray[1] : "NA");
//                                reportMap.put("apiStartTime", reportArray[2] != null ? DateFormat.formatDateToTime((Date) reportArray[2]) : "NA");
//                                reportMap.put("apiEndTime", reportArray[3] != null ? DateFormat.formatDateToTime((Date) reportArray[3]) : "NA");
//                                reportMap.put("dataDelivered", reportArray[4] != null ? reportArray[4] : "NA");
//                                reportMap.put("createdOn", reportArray[5] != null ? DateFormat.formatDateToTime((Date) reportArray[5]) : "NA");
//                                reportMap.put("createdBy", reportArray[6] != null ? reportArray[6] : "NA");
//                                reportMap.put("id", reportArray[7]);
//
//                                return reportMap;
//                            })
//                            .collect(Collectors.toList());
//                    break;
//                case 6:
//                    reportMapList = healthDepartmentServiceReportRepository.getReportList((long) apiId, year, month)
//                            .stream()
//                            .map(report -> {
//                                Map<String, Object> reportMap = new LinkedHashMap<>();
//                                Object[] reportArray = (Object[]) report;
//
//                                reportMap.put("id", reportArray[0] != null ? reportArray[0] : "NA");
//                                reportMap.put("apiId", reportArray[1] != null ? reportArray[1] : "NA");
//                                reportMap.put("serviceName", reportArray[2] != null ? reportArray[2] : "NA");
//                                reportMap.put("apiStartTime", reportArray[3] != null ? DateFormat.formatDateToTime((Date) reportArray[3]) : "NA");
//                                reportMap.put("apiEndTime", reportArray[4] != null ? DateFormat.formatDateToTime((Date) reportArray[4]) : "NA");
//                                reportMap.put("recordsFetched", reportArray[5] != null ? reportArray[5] : "NA");
//                                reportMap.put("recordsInserted", reportArray[6] != null ? reportArray[6] : "NA");
//                                reportMap.put("recordsUpdated", reportArray[7] != null ? reportArray[7] : "NA");
//                                reportMap.put("recordsFailed", reportArray[8] != null ? reportArray[8] : "NA");
//                                reportMap.put("createdOn", reportArray[9] != null ? DateFormat.formatDateToTime((Date) reportArray[9]) : "NA");
//                                reportMap.put("createdBy", reportArray[10] != null ? reportArray[10] : "NA");
//                                reportMap.put("serviceId", reportArray[2].toString().toLowerCase().replace(" ", "").contains("basicdetails")
//                                        ? 1
//                                        : reportArray[2].toString().toLowerCase().replace(" ", "").contains("memberdetails")
//                                        ? 2
//                                        : 0
//                                );
//
//                                return reportMap;
//                            })
//                            .collect(Collectors.toList());
//                    break;
//                case 7:
//                    reportMapList = moSarkarLogRepository.getReportList((long) apiId, year, month)
//                            .stream()
//                            .map(report -> {
//                                Map<String, Object> reportMap = new LinkedHashMap<>();
//                                Object[] reportArray = (Object[]) report;
//
//                                reportMap.put("apiId", reportArray[0] != null ? reportArray[0] : "NA");
//                                reportMap.put("apiName", reportArray[1] != null ? reportArray[1] : "NA");
//                                reportMap.put("apiStartTime", reportArray[2] != null ? DateFormat.formatDateToTime((Date) reportArray[2]) : "NA");
//                                reportMap.put("apiEndTime", reportArray[3] != null ? DateFormat.formatDateToTime((Date) reportArray[3]) : "NA");
//                                reportMap.put("dataDelivered", reportArray[4] != null ? reportArray[4] : "NA");
//                                reportMap.put("successDataSize", reportArray[5] != null ? reportArray[5] : "NA");
//                                reportMap.put("failedDataSize", reportArray[6] != null ? reportArray[6] : "NA");
//                                reportMap.put("createdOn", reportArray[7] != null ? DateFormat.formatDateToTime((Date) reportArray[7]) : "NA");
//                                reportMap.put("createdBy", reportArray[8] != null ? reportArray[8] : "NA");
//                                reportMap.put("id", reportArray[9]);
//
//                                return reportMap;
//                            })
//                            .collect(Collectors.toList());
//                    break;
//                case 8:
//                    reportMapList = edsDataLogRepository.getReportList((long) apiId, year, month)
//                            .stream()
//                            .map(report -> {
//                                Map<String, Object> reportMap = new LinkedHashMap<>();
//                                Object[] reportArray = (Object[]) report;
//
//                                reportMap.put("id", reportArray[0] != null ? reportArray[0] : "NA");
//                                reportMap.put("apiId", reportArray[1] != null ? reportArray[1] : "NA");
//                                reportMap.put("apiStartTime", reportArray[2] != null ? DateFormat.formatDateToTime((Date) reportArray[2]) : "NA");
//                                reportMap.put("apiEndTime", reportArray[3] != null ? DateFormat.formatDateToTime((Date) reportArray[3]) : "NA");
//                                reportMap.put("recordFetched", reportArray[4] != null ? reportArray[4] : "NA");
//                                reportMap.put("recordInserted", reportArray[5] != null ? reportArray[5] : "NA");
//                                reportMap.put("recordUpdated", reportArray[6] != null ? reportArray[6] : "NA");
//                                reportMap.put("recordFailed", reportArray[7] != null ? reportArray[7] : "NA");
//                                reportMap.put("createdOn", reportArray[8] != null ? DateFormat.formatDateToTime((Date) reportArray[8]) : "NA");
//                                reportMap.put("createdBy", reportArray[9] != null ? reportArray[9] : "NA");
//
//                                return reportMap;
//                            })
//                            .collect(Collectors.toList());
//                    break;
//                default:
//                    throw new Exception("Invalid API ID!");
//            }
//        } catch (Exception e) {
//            logger.error("Exception Occurred in getReportDataList of APIServiceImpl" + e.getMessage());
//            throw new Exception(e.getMessage());
//        }
//        return reportMapList;
//    }

//    public List<Map<String, Object>> getReportDataList(String request) throws Exception {
//        logger.info("Inside getReportDataList of APIServiceImpl");
//        try {
//            JSONObject requestObject = new JSONObject(request);
//            int apiId = requestObject.getInt("apiId");
//            int year = Integer.parseInt(requestObject.getString("year"));
//            int month = Integer.parseInt(requestObject.getString("month"));
//
//            List<Map<String, Object>> reportMapList;
//            switch (apiId) {
//                case 1:
//                case 2:
//                case 3:
//                case 4:
//                case 5:
//                case 9:
//                    reportMapList = apiServiceLogRepository.getReportList((long) apiId, year, month)
//                            .stream()
//                            .map(this::createReportMap)
//                            .collect(Collectors.toList());
//                    break;
//                case 6:
//                    reportMapList = healthDepartmentServiceReportRepository.getReportList((long) apiId, year, month)
//                            .stream()
//                            .map(this::createHealthDepartmentReportMap)
//                            .collect(Collectors.toList());
//                    break;
//                case 7:
//                    reportMapList = moSarkarLogRepository.getReportList((long) apiId, year, month)
//                            .stream()
//                            .map(this::createMoSarkarReportMap)
//                            .collect(Collectors.toList());
//                    break;
//                case 8:
//                    reportMapList = edsDataLogRepository.getReportList((long) apiId, year, month)
//                            .stream()
//                            .map(this::createEDSDataLogReportMap)
//                            .collect(Collectors.toList());
//                    break;
//                default:
//                    throw new Exception("Invalid API ID!");
//            }
//
//            return reportMapList;
//        } catch (Exception e) {
//            logger.error("Exception Occurred in getReportDataList of APIServiceImpl" + e.getMessage());
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    private Map<String, Object> createReportMap(Object report) {
//        Object[] reportArray = (Object[]) report;
//        Map<String, Object> reportMap = new LinkedHashMap<>();
//
//        reportMap.put("apiId", reportArray[0] != null ? reportArray[0] : "NA");
//        reportMap.put("apiName", reportArray[1] != null ? reportArray[1] : "NA");
//        reportMap.put("apiStartTime", reportArray[2] != null ? DateFormat.formatDateToTime((Date) reportArray[2]) : "NA");
//        reportMap.put("apiEndTime", reportArray[3] != null ? DateFormat.formatDateToTime((Date) reportArray[3]) : "NA");
//        reportMap.put("dataDelivered", reportArray[4] != null ? reportArray[4] : "NA");
//        reportMap.put("createdOn", reportArray[5] != null ? DateFormat.formatDateToTime((Date) reportArray[5]) : "NA");
//        reportMap.put("createdBy", reportArray[6] != null ? reportArray[6] : "NA");
//        reportMap.put("id", reportArray[7]);
//
//        return reportMap;
//    }
//
//    private Map<String, Object> createHealthDepartmentReportMap(Object report) {
//        Object[] reportArray = (Object[]) report;
//        Map<String, Object> reportMap = new LinkedHashMap<>();
//
//        reportMap.put("id", reportArray[0] != null ? reportArray[0] : "NA");
//        reportMap.put("apiId", reportArray[1] != null ? reportArray[1] : "NA");
//        reportMap.put("serviceName", reportArray[2] != null ? reportArray[2] : "NA");
//        reportMap.put("apiStartTime", reportArray[3] != null ? DateFormat.formatDateToTime((Date) reportArray[3]) : "NA");
//        reportMap.put("apiEndTime", reportArray[4] != null ? DateFormat.formatDateToTime((Date) reportArray[4]) : "NA");
//        reportMap.put("recordsFetched", reportArray[5] != null ? reportArray[5] : "NA");
//        reportMap.put("recordsInserted", reportArray[6] != null ? reportArray[6] : "NA");
//        reportMap.put("recordsUpdated", reportArray[7] != null ? reportArray[7] : "NA");
//        reportMap.put("recordsFailed", reportArray[8] != null ? reportArray[8] : "NA");
//        reportMap.put("createdOn", reportArray[9] != null ? DateFormat.formatDateToTime((Date) reportArray[9]) : "NA");
//        reportMap.put("createdBy", reportArray[10] != null ? reportArray[10] : "NA");
//        reportMap.put("serviceId", reportArray[2].toString().toLowerCase().replace(" ", "").contains("basicdetails")
//                ? 1
//                : reportArray[2].toString().toLowerCase().replace(" ", "").contains("memberdetails")
//                ? 2
//                : 0);
//
//        return reportMap;
//    }
//
//    private Map<String, Object> createMoSarkarReportMap(Object report) {
//        Object[] reportArray = (Object[]) report;
//        Map<String, Object> reportMap = new LinkedHashMap<>();
//
//        reportMap.put("apiId", reportArray[0] != null ? reportArray[0] : "NA");
//        reportMap.put("apiName", reportArray[1] != null ? reportArray[1] : "NA");
//        reportMap.put("apiStartTime", reportArray[2] != null ? DateFormat.formatDateToTime((Date) reportArray[2]) : "NA");
//        reportMap.put("apiEndTime", reportArray[3] != null ? DateFormat.formatDateToTime((Date) reportArray[3]) : "NA");
//        reportMap.put("dataDelivered", reportArray[4] != null ? reportArray[4] : "NA");
//        reportMap.put("successDataSize", reportArray[5] != null ? reportArray[5] : "NA");
//        reportMap.put("failedDataSize", reportArray[6] != null ? reportArray[6] : "NA");
//        reportMap.put("createdOn", reportArray[7] != null ? DateFormat.formatDateToTime((Date) reportArray[7]) : "NA");
//        reportMap.put("createdBy", reportArray[8] != null ? reportArray[8] : "NA");
//        reportMap.put("id", reportArray[9]);
//
//        return reportMap;
//    }
//
//    private Map<String, Object> createEDSDataLogReportMap(Object report) {
//        Object[] reportArray = (Object[]) report;
//        Map<String, Object> reportMap = new LinkedHashMap<>();
//
//        reportMap.put("id", reportArray[0] != null ? reportArray[0] : "NA");
//        reportMap.put("apiId", reportArray[1] != null ? reportArray[1] : "NA");
//        reportMap.put("apiStartTime", reportArray[2] != null ? DateFormat.formatDateToTime((Date) reportArray[2]) : "NA");
//        reportMap.put("apiEndTime", reportArray[3] != null ? DateFormat.formatDateToTime((Date) reportArray[3]) : "NA");
//        reportMap.put("recordFetched", reportArray[4] != null ? reportArray[4] : "NA");
//        reportMap.put("recordInserted", reportArray[5] != null ? reportArray[5] : "NA");
//        reportMap.put("recordFailed", reportArray[6] != null ? reportArray[6] : "NA");
//        reportMap.put("createdOn", reportArray[7] != null ? DateFormat.formatDateToTime((Date) reportArray[7]) : "NA");
//        reportMap.put("createdBy", reportArray[8] != null ? reportArray[8] : "NA");
//
//        return reportMap;
//    }


    public static void main(String[] args) {
        JSONArray reports = new JSONArray();
        JSONArray header = new JSONArray();

        try {
            Test generator = new Test();
            generator.generatePDF(reports, header);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void generatePDF(JSONArray reports, JSONArray header) throws JSONException {
        try {
            Document myDoc = new Document(PageSize.A4);
            OutputStream outputStream = Files.newOutputStream(Paths.get("C:/BSKY/WhatsAppDoc/BSKY Summary Report.pdf"));
            PdfWriter.getInstance(myDoc, outputStream);

            myDoc.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
            Font dateFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.BLACK);
            Font regularFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

            /*BaseFont baseFont = BaseFont.createFont("C:/segoe-ui/Segoe UI.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font titleFont = new Font(baseFont, 18, Font.BOLD, BaseColor.BLACK);
            Paragraph p = new Paragraph("BSKY Summary Report", titleFont);
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);*/

            Paragraph title = new Paragraph("BSKY Summary Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(title);

            Paragraph date = new Paragraph("Document Generated On: " + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()), dateFont);
            date.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(date);

            myDoc.add(new Paragraph(" "));

            for (int i = 0; i < reports.length(); i++) {
                JSONObject report = reports.getJSONObject(i);

                JSONArray reportHeader = (JSONArray) report.get("header");
                JSONArray reportData = (JSONArray) report.get("report");
                String heading = (String) report.get("heading");

                Paragraph reportHeading = new Paragraph(heading, headerFont);
                reportHeading.setAlignment(Element.ALIGN_CENTER);
                myDoc.add(reportHeading);
                myDoc.add(new Paragraph(" "));

                PdfPTable table = new PdfPTable(reportHeader.length());
                table.setWidthPercentage(100);
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                for (int j = 0; j < reportHeader.length(); j++) {
                    PdfPCell cell = new PdfPCell(new Phrase(reportHeader.getString(j), headerFont));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                }

                for (int k = 0; k < reportData.length(); k++) {
                    JSONObject rowData = reportData.getJSONObject(k);
                    Iterator<String> keys = rowData.keys();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        PdfPCell cell = new PdfPCell(new Phrase(rowData.getString(key), regularFont));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    }
                }

                myDoc.add(table);
                myDoc.add(new Paragraph(" "));
            }

            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating PDF: " + e.getMessage());
        }
    }

    public void generatePDF1(JSONArray reports, JSONArray header) throws JSONException {
        header = new JSONArray();
        header.put("SL#");
        header.put("Beneficiary Dist");
        header.put("Total Family treated Till Now");
        header.put("Total Beneficiary treated Till Now");
        header.put("Total Package Discharged Till Now");
        header.put("Amount of Discharge Till Now");

        JSONObject report1 = new JSONObject();
        report1.put("SL#", 1);
        report1.put("Beneficiary Dist", "Cuttack");
        report1.put("Total Family treated Till Now", 23123);
        report1.put("Total Beneficiary treated Till Now", 45345);
        report1.put("Total Package Discharged Till Now", 6786786);
        report1.put("Amount of Discharge Till Now", 78978);
        reports.put(report1);

        JSONObject report2 = new JSONObject();
        report2.put("SL#", 2);
        report2.put("Beneficiary Dist", "Khurdha");
        report2.put("Total Family treated Till Now", 12334);
        report2.put("Total Beneficiary treated Till Now", 6756756);
        report2.put("Total Package Discharged Till Now", 89789);
        report2.put("Amount of Discharge Till Now", 45646);
        reports.put(report2);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("header", header);
        map.put("report", reports);
        map.put("id", 1);
        map.put("heading", "BSKY – Transaction Summary From Starting to 31-April-2024 For All Scheme");

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);

//        Report 2 Data
        JSONArray reports1 = new JSONArray();
        JSONArray header1 = new JSONArray();
        header1.put("SL#");
        header1.put("Beneficiary Dist");
        header1.put("Total Family treated Till Now");
        header1.put("Total Beneficiary treated Till Now");
        header1.put("Total Package Discharged Till Now");
        header1.put("Amount of Discharge Till Now");
        header1.put("Total No of Claim Submitted");
        header1.put("Amount of Claim Submitted");

        JSONObject report3 = new JSONObject();
        report3.put("SL#", 1);
        report3.put("Beneficiary Dist", "Cuttack");
        report3.put("Total Family treated Till Now", 23123);
        report3.put("Total Beneficiary treated Till Now", 45345);
        report3.put("Total Package Discharged Till Now", 6786786);
        report3.put("Amount of Discharge Till Now", 78978);
        report3.put("Total No of Claim Submitted", 78978);
        report3.put("Amount of Claim Submitted", 78978);
        reports1.put(report3);

        JSONObject report4 = new JSONObject();
        report4.put("SL#", 2);
        report4.put("Beneficiary Dist", "Khurdha");
        report4.put("Total Family treated Till Now", 12334);
        report4.put("Total Beneficiary treated Till Now", 6756756);
        report4.put("Total Package Discharged Till Now", 89789);
        report4.put("Amount of Discharge Till Now", 45646);
        report4.put("Total No of Claim Submitted", 45646);
        report4.put("Amount of Claim Submitted", 45646);
        reports1.put(report4);

        Map<String, Object> map1 = new LinkedHashMap<>();
        map1.put("header", header1);
        map1.put("report", reports1);
        map1.put("id", 2);
        map1.put("heading", "BSKY – Monthly Summary From  01-April-2024 to 31-April-2024 For All Scheme");
        list.add(map1);

//        Report 3 Data
        JSONArray header2 = new JSONArray();
        header2.put("SL#");
        header2.put("Speciality Name");
        header2.put("Total Discharge");
        header2.put("Discharge Amount");

        JSONArray reports2 = new JSONArray();

        JSONObject report5 = new JSONObject();
        report5.put("SL#", 1);
        report5.put("Speciality Name", "BM");
        report5.put("Total Discharge", 123123);
        report5.put("Discharge Amount", 23432);
        reports2.put(report5);

        JSONObject report6 = new JSONObject();
        report6.put("SL#", 2);
        report6.put("Speciality Name", "SN");
        report6.put("Total Discharge", 4525);
        report6.put("Discharge Amount", 523);
        reports2.put(report6);

        JSONObject report7 = new JSONObject();
        report7.put("SL#", 3);
        report7.put("Speciality Name", "FG");
        report7.put("Total Discharge", 45523);
        report7.put("Discharge Amount", 3455);
        reports2.put(report7);

        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("header", header2);
        map2.put("report", reports2);
        map2.put("id", 4);
        map2.put("heading", "Top 10 Speciality used from 01-April-2024 to 31-April-2024 – For All Scheme");
        list.add(map2);

//Report 4 Data
        JSONArray header3 = new JSONArray();
        header3.put("SL#");
        header3.put("Hospital State");
        header3.put("Hospital District");
        header3.put("Total No of Discharge");
        header3.put("Discharge Amount");

        // Create the reports array
        JSONArray reports3 = new JSONArray();

        // Generate random data for 20 reports
        for (int i = 0; i < 20; i++) {
            JSONObject report = new JSONObject();
            report.put("SL#", i + 1); // Incrementing SL# starting from 1

            // Generating random Hospital State and District
            String[] states = {"Odisha", "Andhra Pradesh", "Tamil Nadu", "Karnataka"};
            String[] districts = {"Cuttack", "Khordha", "Puri", "Bhubaneswar"};
            Random random = new Random();
            String hospitalState = states[random.nextInt(states.length)];
            String hospitalDistrict = districts[random.nextInt(districts.length)];

            // Generating random Total No of Discharge and Discharge Amount
            int totalDischarge = random.nextInt(100000);
            int dischargeAmount = random.nextInt(10000);

            // Putting data into the JSON object
            report.put("Hospital State", hospitalState);
            report.put("Hospital District", hospitalDistrict);
            report.put("Total No of Discharge", totalDischarge);
            report.put("Discharge Amount", dischargeAmount);

            // Adding the report to the reports JSONArray
            reports3.put(report);
        }

        // Create the JSON object to hold the header and reports
        Map<String, Object> map3 = new LinkedHashMap<>();
        map3.put("header", header3);
        map3.put("report", reports3);
        map3.put("id", 3);
        map3.put("heading", "Top 20 Hospital Having highest Amount of Discharge from 01-April-2024 to 31-April-2024 – For All Scheme");

        list.add(map3);

        try {
            Document myDoc = new Document(PageSize.A4);
            String filePath = "C:\\BSKY\\WhatsAppDoc\\BSKY Summary Report.pdf";
            OutputStream outputStream = new FileOutputStream(filePath);
            PdfWriter.getInstance(myDoc, outputStream);
            myDoc.open();

            Paragraph p = new Paragraph("BSKY Summery Report", FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.BLACK));
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);

            Paragraph p1 = new Paragraph("Document Generated On: " + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()), FontFactory.getFont("Segoe UI", 10, Font.NORMAL, BaseColor.BLACK));
            p1.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p1);

            myDoc.add(new Paragraph(" "));

            Font subjectfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Arial")), 12, Font.BOLD);
            Font headingfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Arial")), 10, Font.BOLD);
            Font font = FontFactory.getFont(String.valueOf(FontFactory.getFont("Arial")), 10);

            for (Map<String, Object> mapData : list) {
                JSONArray headerData = (JSONArray) mapData.get("header");
                JSONArray reportData = (JSONArray) mapData.get("report");

                Paragraph p2 = new Paragraph((String) mapData.get("heading"), subjectfont);
                p2.setAlignment(Element.ALIGN_CENTER);
                myDoc.add(p2);
                myDoc.add(new Paragraph(" "));

                PdfPTable table = new PdfPTable(headerData.length());
                table.setWidthPercentage(110);
                table.setSpacingBefore(0);
                table.setSpacingAfter(0);
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                String[] columns = new String[headerData.length()];
                for (int i = 0; i < headerData.length(); i++) {
                    columns[i] = headerData.getString(i);
                }

                for (String column : columns) {
                    PdfPCell cell = new PdfPCell(new Paragraph(column, headingfont));
                    cell.setPaddingLeft(4);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);
                }

                int slNO = 1;

                for (int i = 0; i < reportData.length(); i++) {
                    JSONObject jsonObject = reportData.getJSONObject(i);
                    for (String column : columns) {
                        table.addCell(new Paragraph(jsonObject.getString(column), font));
                    }
                    slNO++;
                }
                myDoc.add(table);
                myDoc.add(new Paragraph(" "));
            }
            myDoc.close();
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void generatePDF3(JSONArray reports, JSONArray header) throws JSONException {
        header = new JSONArray();
        header.put("SL#");
        header.put("Beneficiary Dist");
        header.put("Total Family treated Till Now");
        header.put("Total Beneficiary treated Till Now");
        header.put("Total Package Discharged Till Now");
        header.put("Amount of Discharge Till Now");

        JSONObject report1 = new JSONObject();
        report1.put("SL#", 1);
        report1.put("Beneficiary Dist", "Cuttack");
        report1.put("Total Family treated Till Now", 23123);
        report1.put("Total Beneficiary treated Till Now", 45345);
        report1.put("Total Package Discharged Till Now", 6786786);
        report1.put("Amount of Discharge Till Now", 78978);
        reports.put(report1);

        JSONObject report2 = new JSONObject();
        report2.put("SL#", 2);
        report2.put("Beneficiary Dist", "Khurdha");
        report2.put("Total Family treated Till Now", 12334);
        report2.put("Total Beneficiary treated Till Now", 6756756);
        report2.put("Total Package Discharged Till Now", 89789);
        report2.put("Amount of Discharge Till Now", 45646);
        reports.put(report2);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("header", header);
        map.put("report", reports);
        map.put("id", 1);
        map.put("heading", "BSKY – Transaction Summary From Starting to 31-April-2024 For All Scheme");

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);

//        Report 2 Data
        JSONArray reports1 = new JSONArray();
        JSONArray header1 = new JSONArray();
        header1.put("SL#");
        header1.put("Beneficiary Dist");
        header1.put("Total Family treated Till Now");
        header1.put("Total Beneficiary treated Till Now");
        header1.put("Total Package Discharged Till Now");
        header1.put("Amount of Discharge Till Now");
        header1.put("Total No of Claim Submitted");
        header1.put("Amount of Claim Submitted");

        JSONObject report3 = new JSONObject();
        report3.put("SL#", 1);
        report3.put("Beneficiary Dist", "Cuttack");
        report3.put("Total Family treated Till Now", 23123);
        report3.put("Total Beneficiary treated Till Now", 45345);
        report3.put("Total Package Discharged Till Now", 6786786);
        report3.put("Amount of Discharge Till Now", 78978);
        report3.put("Total No of Claim Submitted", 78978);
        report3.put("Amount of Claim Submitted", 78978);
        reports1.put(report3);

        JSONObject report4 = new JSONObject();
        report4.put("SL#", 2);
        report4.put("Beneficiary Dist", "Khurdha");
        report4.put("Total Family treated Till Now", 12334);
        report4.put("Total Beneficiary treated Till Now", 6756756);
        report4.put("Total Package Discharged Till Now", 89789);
        report4.put("Amount of Discharge Till Now", 45646);
        report4.put("Total No of Claim Submitted", 45646);
        report4.put("Amount of Claim Submitted", 45646);
        reports1.put(report4);

        Map<String, Object> map1 = new LinkedHashMap<>();
        map1.put("header", header1);
        map1.put("report", reports1);
        map1.put("id", 2);
        map1.put("heading", "BSKY – Monthly Summary From  01-April-2024 to 31-April-2024 For All Scheme");
        list.add(map1);

//        Report 3 Data
        JSONArray header2 = new JSONArray();
        header2.put("SL#");
        header2.put("Speciality Name");
        header2.put("Total Discharge");
        header2.put("Discharge Amount");

        JSONArray reports2 = new JSONArray();

        JSONObject report5 = new JSONObject();
        report5.put("SL#", 1);
        report5.put("Speciality Name", "BM");
        report5.put("Total Discharge", 123123);
        report5.put("Discharge Amount", 23432);
        reports2.put(report5);

        JSONObject report6 = new JSONObject();
        report6.put("SL#", 2);
        report6.put("Speciality Name", "SN");
        report6.put("Total Discharge", 4525);
        report6.put("Discharge Amount", 523);
        reports2.put(report6);

        JSONObject report7 = new JSONObject();
        report7.put("SL#", 3);
        report7.put("Speciality Name", "FG");
        report7.put("Total Discharge", 45523);
        report7.put("Discharge Amount", 3455);
        reports2.put(report7);

        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("header", header2);
        map2.put("report", reports2);
        map2.put("id", 4);
        map2.put("heading", "Top 10 Speciality used from 01-April-2024 to 31-April-2024 – For All Scheme");
        list.add(map2);

//Report 4 Data
        JSONArray header3 = new JSONArray();
        header3.put("SL#");
        header3.put("Hospital State");
        header3.put("Hospital District");
        header3.put("Total No of Discharge");
        header3.put("Discharge Amount");

        // Create the reports array
        JSONArray reports3 = new JSONArray();

        // Generate random data for 20 reports
        for (int i = 0; i < 20; i++) {
            JSONObject report = new JSONObject();
            report.put("SL#", i + 1); // Incrementing SL# starting from 1

            // Generating random Hospital State and District
            String[] states = {"Odisha", "Andhra Pradesh", "Tamil Nadu", "Karnataka"};
            String[] districts = {"Cuttack", "Khordha", "Puri", "Bhubaneswar"};
            Random random = new Random();
            String hospitalState = states[random.nextInt(states.length)];
            String hospitalDistrict = districts[random.nextInt(districts.length)];

            // Generating random Total No of Discharge and Discharge Amount
            int totalDischarge = random.nextInt(100000);
            int dischargeAmount = random.nextInt(10000);

            // Putting data into the JSON object
            report.put("Hospital State", hospitalState);
            report.put("Hospital District", hospitalDistrict);
            report.put("Total No of Discharge", totalDischarge);
            report.put("Discharge Amount", dischargeAmount);

            // Adding the report to the reports JSONArray
            reports3.put(report);
        }

        // Create the JSON object to hold the header and reports
        Map<String, Object> map3 = new LinkedHashMap<>();
        map3.put("header", header3);
        map3.put("report", reports3);
        map3.put("id", 3);
        map3.put("heading", "Top 20 Hospital Having highest Amount of Discharge from 01-April-2024 to 31-April-2024 – For All Scheme");

        list.add(map3);

        try {
            Document myDoc = new Document(PageSize.A4);
            String filePath = "C:\\BSKY\\WhatsAppDoc\\BSKY Summary Report.pdf";
            OutputStream outputStream = new FileOutputStream(filePath);
            PdfWriter writer = PdfWriter.getInstance(myDoc, outputStream);
            myDoc.open();

            Image backgroundImage = Image.getInstance("E:\\My CSM Project\\BSKY Project\\TMS Web\\TMS Frontend\\src\\assets\\images\\fade-logo.png");
            backgroundImage.scaleToFit(500, 500);
            backgroundImage.setAbsolutePosition((myDoc.getPageSize().getWidth() - backgroundImage.getScaledWidth()) / 2,
                    (myDoc.getPageSize().getHeight() - backgroundImage.getScaledHeight()) / 2);

            PdfTemplate backgroundTemplate = writer.getDirectContent().createTemplate(
                    myDoc.getPageSize().getWidth(), myDoc.getPageSize().getHeight()
            );
            backgroundTemplate.addImage(backgroundImage);

            PdfContentByte canvas = writer.getDirectContentUnder();
            canvas.addTemplate(backgroundTemplate, 0, 0);

            Paragraph p = new Paragraph("BSKY Summery Report", FontFactory.getFont("Segoe UI", 18, Font.BOLD, new BaseColor(0, 102, 0)));
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);

            Paragraph p1 = new Paragraph("Document Generated On: " + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()), FontFactory.getFont("Segoe UI", 10, Font.NORMAL, BaseColor.BLACK));
            p1.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p1);

            myDoc.add(new Paragraph(" "));

            Font subjectfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 12, Font.BOLD);
            Font headingfont = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10, Font.BOLD);
            Font font = FontFactory.getFont(String.valueOf(FontFactory.getFont("Segoe UI")), 10);

            for (Map<String, Object> mapData : list) {
                JSONArray headerData = (JSONArray) mapData.get("header");
                JSONArray reportData = (JSONArray) mapData.get("report");

                PdfPTable table = new PdfPTable(headerData.length());
                table.setWidthPercentage(110);
                table.setSpacingBefore(0);
                table.setSpacingAfter(0);
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell headerCell = new PdfPCell(new Paragraph((String) mapData.get("heading"), subjectfont));
                headerCell.setPadding(5);
                headerCell.setBackgroundColor((Integer) mapData.get("id") == 1
                                ? new BaseColor(198, 235, 198)
                                : ((Integer) mapData.get("id") == 2
                                ? new BaseColor(255, 204, 204)
                                : ((Integer) mapData.get("id") == 3
                                ? new BaseColor(255, 194, 153)
                                : new BaseColor(255, 255, 179))
                        )
                );
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                headerCell.setColspan(headerData.length()); // Merge all columns
                table.addCell(headerCell);

                String[] columns = new String[headerData.length()];
                for (int i = 0; i < headerData.length(); i++) {
                    columns[i] = headerData.getString(i);
                }

                for (String column : columns) {
                    PdfPCell cell = new PdfPCell(new Paragraph(column, headingfont));
                    cell.setPaddingLeft(4);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);
                }

                int slNO = 1;

                for (int i = 0; i < reportData.length(); i++) {
                    JSONObject jsonObject = reportData.getJSONObject(i);
                    for (String column : columns) {
                        table.addCell(new Paragraph(jsonObject.getString(column), font));
                    }
                    slNO++;
                }
                myDoc.add(table);
                myDoc.add(new Paragraph(" "));
            }
            myDoc.close();
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
