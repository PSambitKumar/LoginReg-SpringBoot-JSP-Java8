package com.sambit.CompetitvePractice.Basic;

import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Arrays;
import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 21/04/2023 - 12:42 PM
 */
public class TestJava {

    public static void main(String[] args) throws JSONException {
        List<String> datas = Arrays.asList("1524","707","1140","706","699","905","840","720","866","865","826","823","820","816","901","891","881","911","886","910", "12312", "2934");
        System.out.println(datas.size());

//        Print 10 data batchwise as stringBuffer
        int count = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (String data : datas) {
            stringBuffer.append(data).append(",");
            count++;
            if (count == 10) {
                System.out.println(stringBuffer);
                stringBuffer = new StringBuffer();
                count = 0;
            }
        }
        System.out.println(stringBuffer);


        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("SELECT ");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("Sambit");
        jsonArray.put("Kumar");
        jsonArray.put("Pradhan");

        for (int i = 0; i < jsonArray.length(); i++) {
            System.out.println(jsonArray.get(i));
            stringBuilder1.append(jsonArray.get(i)).append(",");
        }

        System.out.println(stringBuilder1);
    }
}
