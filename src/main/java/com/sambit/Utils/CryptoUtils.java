package com.sambit.Utils;

import com.sambit.CustomException.CryptoException;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class CryptoUtils {
	private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";//"AES";
    private static final String salt = "SaLt@INTllectSeCrET#*!!!!";
 
    public static void encrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }
 
    public static void decrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
 
    private static void doCrypto(int cipherMode, String key, File inputFile,
            File outputFile) throws CryptoException {
        try {
        	byte[] iv = { 0, 1, 0, 9, 8, 0, 0, 2, 0, 3, 0, 5, 0, 7, 0, 3 };
        	
        	SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        	KeySpec keySpec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
        	SecretKey secretKey = factory.generateSecret(keySpec);
        	
            //Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        	SecretKey secret = new SecretKeySpec(secretKey.getEncoded(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secret, new IvParameterSpec(iv));
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
            
            if (cipherMode == 1) {
        		System.out.println("File Encrypted Successfully:"+outputFile);
        	} else {
        		System.out.println("File Decrpyted Successfully:"+outputFile);
        	}
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException |InvalidAlgorithmParameterException | InvalidKeySpecException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        } 
    }
}
