package com.sambit.Utils;

import java.util.Base64;
import java.util.Random;

/**
 * @Project : BSKY Backend
 * @Author : Sambit Kumar Pradhan
 * @Created On : 20/03/2023 - 3:57 PM
 */
public class SecurityEncrypter {

    public static String encryptMerchantName(String merchantName) {
        if (merchantName != null && !merchantName.isEmpty())
            return makeRandom() + Base64.getEncoder().encodeToString(merchantName.getBytes()) + makeRandom();
        else
            return merchantName;
    }

    public static String decryptMerchantName(String merchantName) {
        if (merchantName != null && !merchantName.isEmpty()) {
            merchantName = merchantName.substring(5, merchantName.length() - 5);
            return new String(Base64.getDecoder().decode(merchantName));
        } else
            return merchantName;
    }

    private static String makeRandom() {
        StringBuilder text = new StringBuilder();
        String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            text.append(possible.charAt(random.nextInt(possible.length())));
        }
        return text.toString();
    }

    public static boolean checkEncryptedMerchantName(String encryptedMerchantName) {
        System.out.println(decryptMerchantName(encryptedMerchantName));
        return decryptMerchantName(encryptedMerchantName).equalsIgnoreCase("BSKY-KSIRL-OELOE-OEURE-KLGUR");
    }
}
