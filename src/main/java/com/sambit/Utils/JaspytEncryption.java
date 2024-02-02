package com.sambit.Utils;

import org.jasypt.util.text.BasicTextEncryptor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 02-Feb-2024 : 12:52 PM
 */

public class JaspytEncryption {

    private static char[] password;

    static {
        try (InputStream in = JaspytEncryption.class.getClassLoader().getResourceAsStream("application.properties");) {
            Properties props = new Properties();
            props.load(in);
            password = props.getProperty("password").toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String text = "This is my private data";
        String encrypt = encrypt(text);
        String decrypt = decrypt(encrypt);
        System.out.println("\noriginal: " + text);
        System.out.println("\nencyrpt:  " + encrypt);
        System.out.println("\ndecyrpt:  " + decrypt);
    }

    private static String encrypt(String text) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray(password);
        String encryptedText = textEncryptor.encrypt(text);

        return encryptedText;
    }

    private static String decrypt(String text) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray(password);
        String decryptedText = textEncryptor.decrypt(text);

        return decryptedText;
    }

    public static char[] getPassword() {
        return password;
    }

}
