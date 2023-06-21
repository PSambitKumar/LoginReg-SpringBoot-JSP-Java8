package com.sambit.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Clob;
import java.util.List;
import java.util.Map;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 21/06/2023 - 12:57 PM
 */
public class CommonUtils {
    public static String convertClobToString(Clob data) {
        try {
            return (data != null ? data.getSubString(1, (int) data.length()) : null);
        } catch (Exception e) {
            return null;
        }
    }

    public static Map<String, Object> convertStringToMap(String data) {
        try {
            return new ObjectMapper().readValue(data, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static List<Map<String, Object>> convertStringToListMap(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(data, new TypeReference<List<Map<String, Object>>>() {});
        } catch (Exception e) {
            return null;
        }
    }
}