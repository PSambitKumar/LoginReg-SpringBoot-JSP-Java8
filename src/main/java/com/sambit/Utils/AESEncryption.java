package com.sambit.Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Project : BSKY Card Backend
 * @Author : Sambit Kumar Pradhan
 * @Created On : 01/08/2023 - 12:28 PM
 */
public class AESEncryption {

    private static final String AES_ALGORITHM = "AES";

    public static String encrypt(String message, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, String secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
