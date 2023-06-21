package com.sambit.CompetitvePractice.Basic;

import org.json.JSONObject;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 21/06/2023 - 11:51 AM
 */
public class Test1 {

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
}
