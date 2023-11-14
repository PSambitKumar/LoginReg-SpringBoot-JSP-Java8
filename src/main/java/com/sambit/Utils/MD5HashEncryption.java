package com.sambit.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 14-Nov-2023 : 10:25 AM
 */

public class MD5HashEncryption {
    public static void main(String[] args) {
        String input = "Sambit Kumar Pradhan";
        String md5Hash = generateMD5(input);
        System.out.println("Input: " + input);
        System.out.println("MD5 Hash: " + md5Hash);


        String md5HashString = "c4e9867f9f0e736881dad82153eae40d";
        Boolean result = checkMD5Hash(input, md5HashString);
        if (result)
            System.out.println("Matched");
        else
            System.out.println("Not matched");
    }

    private static String generateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] hashBytes = md.digest();

            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte hashByte : hashBytes) {
                hexStringBuilder.append(String.format("%02x", hashByte));
            }

            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean checkMD5Hash(String input, String expectedMD5Hash) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] hashBytes = md.digest();

            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte hashByte : hashBytes) {
                hexStringBuilder.append(String.format("%02x", hashByte));
            }

            return hexStringBuilder.toString().equals(expectedMD5Hash);
        } catch (NoSuchAlgorithmException e) {
            // Handle exception
            e.printStackTrace();
            return false;
        }
    }

}
