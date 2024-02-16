package com.sambit.Utils;


import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Project : TMS Backend
 * @Author: Sambit Kumar Pradhan
 * @Date: 07-Dec-2023 : 2:25 PM
 */

public class GeneratorUtils {
    private static final String NUMERIC = "0123456789";
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHANUMERIC = ALPHABET + NUMERIC;

    private static final Random random = new Random();
    private static final SecureRandom secureRandom = new SecureRandom();

    private GeneratorUtils() {}

    public static String generateAcknowledgeNumber(String urn) {
        try{
            return "ACK-" + new SimpleDateFormat("ddMMyyyy").format(new Date()) + generateRandomNumber() + "-" + urn;
        } catch (Exception e) {
            return new Exception("Error in generating Acknowledge Number").getMessage();
        }
    }

    public static String generateRandomNumber() {
        return String.valueOf(random.nextInt(900) + 100);
    }

    public static String generateOTP() throws Exception {
        try {
            int number = 100000 + random.nextInt(900000);
            return String.valueOf(number);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static String generateAlphanumericRefNumber(int length) {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(ALPHANUMERIC.charAt(secureRandom.nextInt(ALPHANUMERIC.length())));
        }
        return otp.toString();
    }
}
