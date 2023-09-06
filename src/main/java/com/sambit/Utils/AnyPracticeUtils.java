package com.sambit.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 06-Sep-2023 : 3:25 PM
 */

public class AnyPracticeUtils {
//    @Override
//    public String decryptAndVerifyData(String rawData) throws Exception {
//        logger.info("Inside decryptDataUsingAES of OdishaOneServiceImpl Class.");
//        try {
//            odishaOneLog = new OdishaOneLog();
//            odishaOneLog.setApiId(11L);
//            odishaOneLog.setApiName("Odisha One");
//            odishaOneLog.setApiHitTime(new Date());
//            odishaOneLog.setCreatedBy(2019L);
//            odishaOneLog.setCreatedOn(new Date());
//            odishaOneLog.setStatusFlag(0);
//
//            Map<String, Object> response = verifyAndSave(AESEncryptionUtils.decrypt(StringUtils.secretKey, rawData));
//            logger.info("Response : " + response);
//            if (response != null) {
//                odishaOneLog.setApi2RequestData(new Gson().toJson(response.get("api2Data")));
//                int status = saveOdishaOneLog();
//                if (status > 0) {
//                    response.put("odishaOneLogId", odishaOneLog.getId());
//                    return Base64.getEncoder().encodeToString(new ObjectMapper().writeValueAsString(response).getBytes());
//                }
//                else
//                    throw new Exception("Error Occurred While Saving Odisha One Log");
//            } else
//                throw new Exception("Error Occurred While Verifying Data");
//        } catch (Exception e) {
//            logger.error("Exception Occurred in decryptDataUsingAES of OdishaOneServiceImpl Class : " + e);
//            OdishaOneErrorLog odishaOneErrorLog = new OdishaOneErrorLog();
//            odishaOneErrorLog.setApiId(11L);
//            odishaOneErrorLog.setApiName("Odisha One");
//            odishaOneErrorLog.setErrorCode(String.valueOf(HttpStatus.OK.value()));
//            odishaOneErrorLog.setErrorMessage(e.getMessage());
//            odishaOneErrorLog.setErrorStackTrace(Arrays.toString(e.getStackTrace()));
//            odishaOneErrorLog.setErrorTime(new Date());
//            odishaOneErrorLog.setCreatedOn(new Date());
//            odishaOneErrorLog.setCreatedBy(2019L);
//            odishaOneErrorLog.setStatusFlag(0);
//            odishaOneErrorLogRepository.save(odishaOneErrorLog);
//            throw e;
//        }
//        finally {
//            if(odishaOneLog.getId() != null) odishaOneLog = null;
//        }
//    }
//
//    public Map<String, Object> verifyAndSave(String decryptedData) throws Exception {
//        logger.info("Inside verifyAndSave Method Of OdishaOneServiceImpl Class");
//        Map<?, ?> decryptMap;
//        Map<String, Object> responseObject = null;
//        try {
//            decryptMap = new ObjectMapper()
//                    .readValue(
//                            decryptedData,
//                            Map.class
//                    );
//            odishaOneLog.setApi1RequestData(new Gson().toJson(decryptMap));
//            logger.info("Decrypted Map : " + decryptMap);
//            logger.info("Checksum Value : " + StringUtils.checkSumKey);
//            logger.info("Department Id : " + StringUtils.departmentId);
//
//            String calculateCheckSum = StringUtils.departmentId + "|" +
//                    "\"" + decryptMap.get("DEPARTEMENTID") + "\"|" +
//                    "\"" + decryptMap.get("SERVICEID") + "\"|" +
//                    "\"" + decryptMap.get("SUBSERVICEID") + "\"|" +
//                    "\"" + decryptMap.get("REQUESTID") + "\"|" +
//                    "\"" + decryptMap.get("REQTIMESTAMP") + "\"|" +
//                    "\"" + decryptMap.get("REQUESTTYPE") + "\"|" +
//                    "\"" + decryptMap.get("OLDREQUESTID") + "\"|" +
//                    "\"" + decryptMap.get("OOUSERTOKEN") + "\"|" +
//                    "\"" + decryptMap.get("OOUSERCODE") + "\"|" +
//                    "\"" + decryptMap.get("OOUSERFULLNAME") + "\"|" +
//                    "\"" + decryptMap.get("OOUSERMOBILENO") + "\"|" +
//                    "\"" + decryptMap.get("OOUSEREMAIL") + "\"|" +
//                    "\"" + decryptMap.get("OOUSERGENDER") + "\"|" +
//                    "\"" + decryptMap.get("SUCCESSURL") + "\"|" +
//                    "\"" + decryptMap.get("CANCELURL") + "\"|" +
//                    "\"" + decryptMap.get("PAYMENTURL") + "\"|" +
//                    "\"" + decryptMap.get("IFMSPAYMENTURL") + "\"|" +
//                    "\"" + decryptMap.get("ADDITIONALPARA1") + "\"|" +
//                    "\"" + decryptMap.get("ADDITIONALPARA2") + "\"|" +
//                    StringUtils.checkSumKey;
//            logger.info("Calculated Check Sum : " + calculateCheckSum);
//
//            String hashString  = AESEncryptionUtils.hashCal("SHA-512", calculateCheckSum);
//            logger.info("Hash String : " + hashString);
//            logger.info("Check Sum : " + decryptMap.get("CHECKSUM"));
//
//            if (hashString.equals(decryptMap.get("CHECKSUM"))) {
//                logger.info("Validated Successfully");
//                odishaOneLog.setApi1ValidationStatus(0);
//
//                Optional<MstOdishaOneService> mstOdishaOneService = mstOdishaOneServiceRepository
//                        .findByOdishaOneServiceId(Long.parseLong((String) decryptMap.get("SERVICEID")));
//
//                String addPara1 =(String) decryptMap.get("ADDITIONALPARA1");
//                odishaOneLog.setMskUserId(addPara1.substring(addPara1.lastIndexOf("-") + 1));
//                if (mstOdishaOneService.isPresent())
//                    odishaOneLog.setServiceId(mstOdishaOneService.get().getId());
//
//                String currentDate = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//
//                Map<String, Object> requestData = new LinkedHashMap<>();
//                requestData.put("DEPARTEMENTID", decryptMap.get("DEPARTEMENTID"));
//                requestData.put("SERVICEID", decryptMap.get("SERVICEID"));
//                requestData.put("SUBSERVICEID", decryptMap.get("SUBSERVICEID"));
//                requestData.put("REQUESTID", decryptMap.get("REQUESTID"));
//                requestData.put("REQTIMESTAMP", currentDate);
//                requestData.put("OOUSERCODE", decryptMap.get("OOUSERCODE"));
//
//                String calculateCheckSumRequest = StringUtils.departmentId + "|" +
//                        "\"" + decryptMap.get("DEPARTEMENTID") + "\"|" +
//                        "\"" + decryptMap.get("SERVICEID") + "\"|" +
//                        "\"" + decryptMap.get("SUBSERVICEID") + "\"|" +
//                        "\"" + decryptMap.get("REQUESTID") + "\"|" +
//                        "\"" + currentDate + "\"|" +
//                        "\"" + decryptMap.get("OOUSERCODE") + "\"|" +
//                        StringUtils.checkSumKey;
//
//                logger.info("Check Sum Generated For Send : " + calculateCheckSumRequest);
//                requestData.put("CHECKSUM", AESEncryptionUtils.hashCal("SHA-512", calculateCheckSumRequest));
//
//                logger.info("Request Data to Send : " + new ObjectMapper().writeValueAsString(requestData));
//
//                String requestEncData = AESEncryptionUtils.encrypt(StringUtils.secretKey, new ObjectMapper().writeValueAsString(requestData));
//                logger.info("Request Enc Data to Send : " + requestEncData);
//
//                URIBuilder uriBuilder = new URIBuilder(StringUtils.odishaOneURL + "/api/v1/tpi/verify-request?");
//                uriBuilder.addParameter("departementId", StringUtils.departmentId);
//                uriBuilder.addParameter("serviceId", (String) decryptMap.get("SERVICEID"));
//                logger.info("URI : " + uriBuilder);
//
//                Map<?, ?> responseMap = sendDataToOdishaOne(requestEncData, uriBuilder);
//
//                if (responseMap != null && responseMap.containsKey("encData")) {
//                    Map<?, ?> decryptMap1 = new ObjectMapper()
//                            .readValue(AESEncryptionUtils
//                                    .decrypt(
//                                            StringUtils.secretKey,
//                                            (String) responseMap.get("encData")
//                                    ), Map.class
//                            );
//                    logger.info("Decrypted Map API 2 : " + decryptMap1);
//
//                    if (!decryptMap1.isEmpty()
//                            && ((String)decryptMap1.get("ORIGINEDFROMOO")).equalsIgnoreCase("NO")
//                            && (Integer.parseInt((String) decryptMap1.get("REQSTATUSCODE"))) == 313){
//                        responseObject = new LinkedHashMap<>();
//                        responseObject.put("status", 200);
//                        responseObject.put("api1Data", decryptMap);
//                        responseObject.put("api2Data", decryptMap1);
//                        responseObject.put("userDetails", ClassHelperUtils.getUserAuthUserBean(userDetailsRepository.findByUserName("70581478004")));
//                        responseObject.put("jwtToken", ClassHelperUtils.generateJwtToken("70581478004"));
//                    } else
//                        throw new Exception(String.valueOf(decryptMap1.get("MSSSAGE")));
//                }
//            } else {
//                odishaOneLog.setApi1ValidationStatus(1);
//                throw new Exception("Checksum Doesn't Matched!.");
//            }
//        } catch (Exception e) {
//            logger.error("Exception Occurred in verifyAndSave Method of OdishaOneServiceImpl Class : " + e);
//            throw new Exception(e.getMessage());
//        }
//        return responseObject;
//    }
//
//    public Map<?, ?> sendDataToOdishaOne(String requestData, URIBuilder uriBuilder) throws Exception {
//        logger.info("Inside sendDataToOdishaOne Method of OdishaOneServiceImpl Class");
//        Map<?, ?> responseMap;
//        HttpURLConnection httpURLConnection = null;
//        try {
//            Map<String, Object> requestMap = new LinkedHashMap<>();
//            requestMap.put("encData", requestData);
//
//            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//            String json = ow.writeValueAsString(requestMap);
//            logger.info("Request Data : " + json);
//
//            httpURLConnection = (HttpURLConnection) new URL(uriBuilder.toString()).openConnection();
//            httpURLConnection.setRequestMethod("POST");
//            httpURLConnection.setRequestProperty("Content-Type", "application/json");
//            httpURLConnection.setRequestProperty("Accept", "application/json");
//            httpURLConnection.setDoOutput(true);
//
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
//            outputStreamWriter.write(json);
//            outputStreamWriter.flush();
//
//            int responseCode = httpURLConnection.getResponseCode();
//            logger.info("Response Code : " + responseCode);
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//            responseMap = new ObjectMapper().readValue(bufferedReader.readLine(), Map.class);
//        } catch (Exception e) {
//            logger.error("Exception Occurred in sendDataToOdishaOne Method of OdishaOneServiceImpl Class : " + e);
//            throw new Exception(e.getMessage());
//        } finally {
//            if (httpURLConnection != null)
//                httpURLConnection.disconnect();
//        }
//        logger.info("Response Map : " + responseMap);
//        return responseMap;
//    }
//
//    public int saveOdishaOneLog() throws Exception {
//        logger.info("Inside saveOdishaOneLog Method of OdishaOneServiceImpl Class");
//        try {
//            logger.info("OdishaOneLog : " + odishaOneLog);
//            return odishaOneLogRepository.save(odishaOneLog).getId() != null ? 1 : 0;
//        } catch (Exception e) {
//            logger.error("Exception Occurred in saveOdishaOneLog Method of OdishaOneServiceImpl Class : " + e);
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    public String backToOdishaOne(Map<String, Object> request) throws Exception {
//        logger.info("Inside backToOdishaOne Method of OdishaOneServiceImpl Class");
//        String requestEncData;
//        try {
//            String currentDate = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//            Map<String, Object> requestData = (Map<String, Object>) request.get("data");
//
//            odishaOneLog = odishaOneLogRepository.findById(Long.valueOf(String.valueOf(requestData.get("odishaOneLogId")))).get();
//            odishaOneLog.setOdishaOneRoute(1);
//            odishaOneLog.setCmsLeaveTime(new Date());
//            odishaOneLogRepository.save(odishaOneLog);
//
//            requestData.remove("odishaOneLogId");
//            requestData.put("REQTIMESTAMP", currentDate);
//            logger.info("Request Data : " + requestData);
//
//            String calculateCheckSumRequest = StringUtils.departmentId + "|" +
//                    "\"" + requestData.get("DEPARTEMENTID") + "\"|" +
//                    "\"" + requestData.get("SERVICEID") + "\"|" +
//                    "\"" + requestData.get("SUBSERVICEID") + "\"|" +
//                    "\"" + requestData.get("REQUESTID") + "\"|" +
//                    "\"" + currentDate + "\"|" +
//                    "\"" + requestData.get("OOUSERTOKEN") + "\"|" +
//                    "\"" + requestData.get("OOUSERCODE") + "\"|" +
//                    StringUtils.checkSumKey;
//
//            logger.info("Check Sum Generated For Send : " + calculateCheckSumRequest);
//            requestData.put("CHECKSUM", AESEncryptionUtils.hashCal("SHA-512", calculateCheckSumRequest));
//
//            logger.info("Request Data to Send : " + new ObjectMapper().writeValueAsString(requestData));
//
//            requestEncData = AESEncryptionUtils.encrypt(StringUtils.secretKey, new ObjectMapper().writeValueAsString(requestData));
//            logger.info("Request Enc Data to Send : " + requestEncData);
//        } catch (Exception e) {
//            logger.error("Exception Occurred in backToOdishaOne Method of OdishaOneServiceImpl Class : " + e);
//            throw new Exception(e.getMessage());
//        }
//        return requestEncData;
//    }
//
//    @Override
//    public String successToOdishaOne(Map<String, Object> request) throws Exception {
//        logger.info("Inside successToOdishaOne Method of OdishaOneServiceImpl Class");
//        String requestEncData;
//        try {
//            logger.info("Request of Success to Odisha One : " + request);
//            String currentDate = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//            Map<String, Object> requestData = (Map<String, Object>) request.get("data");
//
//            odishaOneLog = odishaOneLogRepository.findById(Long.valueOf(String.valueOf(requestData.get("odishaOneLogId")))).get();
//            odishaOneLog.setAckNo((String) requestData.get("APPLICATIONID"));
//            odishaOneLog.setCmsLeaveTime(new Date());
//            odishaOneLog.setOdishaOneRoute(0);
//            odishaOneLogRepository.save(odishaOneLog);
//
//            requestData.remove("odishaOneLogId");
//            requestData.put("REQTIMESTAMP", currentDate);
//            logger.info("Request Data : " + requestData);
//
//            String calculateCheckSumRequest = StringUtils.departmentId + "|" +
//                    "\"" + requestData.get("DEPARTEMENTID") + "\"|" +
//                    "\"" + requestData.get("SERVICEID") + "\"|" +
//                    "\"" + requestData.get("SUBSERVICEID") + "\"|" +
//                    "\"" + requestData.get("REQUESTID") + "\"|" +
//                    "\"" + currentDate + "\"|" +
//                    "\"" + requestData.get("APPLICATIONID") + "\"|" +
//                    "\"" + requestData.get("APPLICATIONSTATUS") + "\"|" +
//                    "\"" + requestData.get("ADDITIONALPARA1") + "\"|" +
//                    "\"" + requestData.get("ADDITIONALPARA2") + "\"|" +
//                    "\"" + requestData.get("OOUSERTOKEN") + "\"|" +
//                    "\"" + requestData.get("OOUSERCODE") + "\"|" +
//                    "\"" + requestData.get("OOSTATUS") + "\"|" +
//                    StringUtils.checkSumKey;
//
//            logger.info("Check Sum Generated For Send : " + calculateCheckSumRequest);
//            requestData.put("CHECKSUM", AESEncryptionUtils.hashCal("SHA-512", calculateCheckSumRequest));
//
//            logger.info("Request Data to Send : " + new ObjectMapper().writeValueAsString(requestData));
//
//            requestEncData = AESEncryptionUtils.encrypt(StringUtils.secretKey, new ObjectMapper().writeValueAsString(requestData));
//            logger.info("Request Enc Data to Send : " + requestEncData);
//        } catch (Exception e) {
//            logger.error("Exception Occurred in successToOdishaOne Method of OdishaOneServiceImpl Class : " + e);
//            throw new Exception(e.getMessage());
//        }
//        return requestEncData;
//    }
//
//    @Override
//    public int deliveryCardToCitizen(String ackNo) throws Exception {
//        try {
//            TxnMskCardApplication mskCardApplication = txnMskCardApplicationRepository.findByCardAckno(ackNo);
//            if (mskCardApplication != null) {
//                mskCardApplication.setCardDeliveryToCitizen(0);
//                mskCardApplication.setCardDeliveryDate(new Date());
//                return txnMskCardApplicationRepository.save(mskCardApplication).getCardDeliveryToCitizen();
//            } else
//                throw new Exception("No Data Found");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    public int saveOdishaOneService(Map<String, Object> request) throws Exception {
//        logger.info("Inside saveOdishaOneService Method of OdishaOneServiceImpl Class");
//        try {
//            if (Integer.parseInt(request.get("type").toString()) == 1) {
//                Optional<MstOdishaOneService> mstOdishaOneService = mstOdishaOneServiceRepository
//                        .findById(Integer.parseInt(request.get("id").toString()));
//
//                if (mstOdishaOneService.isPresent()) {
//                    mstOdishaOneService.get().setOdishaOneServiceId(Long.parseLong(request.get("odishaOneServiceId").toString()));
//                    mstOdishaOneService.get().setServiceName(request.get("serviceName").toString());
//                    mstOdishaOneService.get().setCmsComponentName(request.get("componentName").toString());
//                    mstOdishaOneService.get().setUpdatedBy(Long.parseLong(request.get("userId").toString()));
//                    mstOdishaOneService.get().setUpdatedOn(new Date());
//                    mstOdishaOneService.get().setStatusFlag(Integer.parseInt(request.get("status").toString()));
//                    return mstOdishaOneServiceRepository.save(mstOdishaOneService.get()).getId();
//                } else
//                    throw new Exception("No Data Found");
//
//            } else if (Integer.parseInt(request.get("type").toString()) == 0) {
//                boolean isExist = mstOdishaOneServiceRepository
//                        .existsByOdishaOneServiceId(Long.parseLong(
//                                request.get("odishaOneServiceId").toString()
//                        ));
//                if (isExist)
//                    throw new Exception("Odisha One Service Id Already Exist");
//
//                MstOdishaOneService mstOdishaOneService = new MstOdishaOneService();
//                mstOdishaOneService.setOdishaOneServiceId(Long.parseLong(request.get("odishaOneServiceId").toString()));
//                mstOdishaOneService.setServiceName(request.get("serviceName").toString());
//                mstOdishaOneService.setCmsComponentName(request.get("componentName").toString());
//                mstOdishaOneService.setCreatedBy(Long.parseLong(request.get("userId").toString()));
//                mstOdishaOneService.setCreatedOn(new Date());
//                mstOdishaOneService.setStatusFlag(0);
//
//                return mstOdishaOneServiceRepository.save(mstOdishaOneService).getId();
//            } else
//                throw new Exception("Invalid Type");
//        } catch (Exception e) {
//            logger.error("Exception Occurred in saveOdishaOneService Method of OdishaOneServiceImpl Class : " + e);
//            throw e;
//        }
//    }
//
//    @Override
//    public List<MstOdishaOneService> getOdishaOneServiceList() throws Exception {
//        return mstOdishaOneServiceRepository.findAll();
//    }
//
//    @Override
//    public Map<String, Object> validateService(long serviceId) {
//        logger.info("Inside validateService Method of Odisha One Service Impl");
//        Map<String, Object> response = new LinkedHashMap<>();
//        try {
//            Optional<MstOdishaOneService> mstOdishaOneService = mstOdishaOneServiceRepository.findByOdishaOneServiceId(serviceId);
//            if (mstOdishaOneService.isPresent()) {
//                response.put("status", mstOdishaOneService.get().getStatusFlag());
//                response.put("componentURL", mstOdishaOneService.get().getCmsComponentName());
//            } else {
//                response.put("status", 2);
//                response.put("componentURL", "");
//            }
//            return response;
//        } catch (Exception e) {
//            logger.error("Error in validateService Method of Odisha One Service Impl : " , e);
//            throw e;
//        }
//    }
}
