package com.sambit.Utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;

public class PasswordUtils {

    private static final int RANDOM_STRING_LENGTH = 5;

    public static String encryptPassword(String normalPass) {
        if (normalPass != null && !normalPass.isEmpty()) {
            String salt = generateSalt();
            String encryptedPassword = hashPassword(normalPass, salt);
            return salt + encryptedPassword;
        } else {
            return normalPass;
        }
    }

    public static boolean verifyPassword(String inputPassword, String encryptedPassword) {
        if (inputPassword == null || inputPassword.isEmpty() || encryptedPassword == null || encryptedPassword.isEmpty()) {
            return false;
        }

        String salt = encryptedPassword.substring(0, RANDOM_STRING_LENGTH);
        String hashedInputPassword = hashPassword(inputPassword, salt);

        return encryptedPassword.equals(salt + hashedInputPassword);
    }

    private static String hashPassword(String password, String salt) {
        return Base64.encodeBase64String((password + salt).getBytes());
    }

    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        return RandomStringUtils.random(RANDOM_STRING_LENGTH, 0, 0, true, true, null, random);
    }

//    Working On This, Not Working Properly
    public static String decryptPassword(String encryptedPassword) {
        if (encryptedPassword != null && !encryptedPassword.isEmpty()) {
            encryptedPassword = encryptedPassword.substring(5, encryptedPassword.length() - 5);
            return new String(Base64.decodeBase64(encryptedPassword));
        } else {
            return encryptedPassword;
        }
    }

    public static void main(String[] args) {
        String password = "PSambitKumar";
        String encryptedPassword = encryptPassword(password);
        System.out.println("Encrypted password: " + encryptedPassword);
        System.out.println("Is password valid: " + verifyPassword("Sambit", encryptedPassword));
        System.out.println("Is password valid: " + verifyPassword("PSambitKumar", encryptedPassword));
//        System.out.println("Decrypted password: " + decryptPassword(encryptedPassword));//Still Working on This
    }
}
