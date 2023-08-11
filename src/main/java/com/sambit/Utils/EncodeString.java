package com.sambit.Utils;

import java.util.Base64;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 12/01/2023 - 5:11 PM
 */
public class EncodeString {

    public static String encodeString(String str) {
        String encodedString = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            encodedString += (int) c;
        }
        return encodedString;
    }

    public static String decodeString(String str) {
        StringBuilder decodedString = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            String s = str.substring(i, i + 2);
            int n = Integer.parseInt(s);
            decodedString.append((char) n);
        }
        return decodedString.toString();
    }

    public static String base64Encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String base64Decode(String str) {
        byte[] bytes = Base64.getDecoder().decode(str);
        return new String(bytes);
    }
    
    public static void main(String[] args) {
        String data =  base64Encode("The fact of the matter is that although you may have numerous valid facts or descriptions related to your paragraph’s core idea, you may lose a reader’s attention if your paragraphs are too long. What’s more, if all of your paragraphs are long, you may lose opportunities to draw your reader in. Journalists, for example, know that their readers respond better to short paragraphs. News readers generally lose interest with long descriptions and even one-sentence paragraphs are considered both acceptable and impactful.");
        System.out.println("Encoded String : " + data);
    }
}
