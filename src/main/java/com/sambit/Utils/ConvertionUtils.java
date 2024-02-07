package com.sambit.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 07-Feb-2024 : 3:46 PM
 */

public class ConvertionUtils {
    public Map<String, Object> convertJsonToMap(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
    }

    public static String convertMapToJson(Map<String, Object> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static String convertListMapToJson(List<Map<String, Object>> list) {
        try {
            return new ObjectMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static String convertListMapToJson1(List<Map<String, Object>> list) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Map<String, Object> map : list) {
                JSONObject jsonObject = new JSONObject(map);
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertListMapToJson2(List<Map<String, Object>> list) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Map<String, Object> map : list) {
                JSONObject jsonObject = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertListMapToJson3(List<Map<String, Object>> list) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Map<String, Object> map : list) {
                JSONObject jsonObject = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertListMapToJson4(List<Map<String, Object>> list) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Map<String, Object> map : list) {
                JSONObject jsonObject = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertListMapToJson5(List<Map<String, Object>> list) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Map<String, Object> map : list) {
                JSONObject jsonObject = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertListMapToJson6(List<Map<String, Object>> list) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Map<String, Object> map : list) {
                JSONObject jsonObject = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertListMapToJson7(List<Map<String, Object>> list) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Map<String, Object> map : list) {
                JSONObject jsonObject = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Map<String, Object>> convertJsonArrayToListMap(String json) {
        try {
            return new ObjectMapper().readValue(json, new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static List<Map<String, Object>> convertJsonArrayToListMap1(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            List<Map<String, Object>> list = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("id", jsonObject.get("id"));
                map.put("name", jsonObject.get("name"));
                list.add(map);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONArray convertListMapToJsonArray(List<Map<String, Object>> list) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Map<String, Object> map : list) {
                JSONObject jsonObject = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
                jsonArray.put(jsonObject);
            }
            return jsonArray;
        } catch (Exception e) {
            return null;
        }
    }
}
