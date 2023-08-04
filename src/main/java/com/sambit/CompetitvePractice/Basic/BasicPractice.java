package com.sambit.CompetitvePractice.Basic;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class BasicPractice {

    public static void main(String[] args) throws JsonProcessingException {
        Map<String, Object> requestData = new LinkedHashMap<>();
        requestData.put("DEPARTEMENTID", "7567687");
        requestData.put("SERVICEID", "7987879");
        requestData.put("SUBSERVICEID", "5675");
        requestData.put("REQUESTID", "567567");
        requestData.put("REQTIMESTAMP", "21-12-2020");
        requestData.put("OOUSERCODE", "567567");

        System.out.println("Request Data : " + requestData);
        System.out.println("Request Data 1: " + new ObjectMapper().writeValueAsString(requestData));//Check Difference In Both
    }
}
