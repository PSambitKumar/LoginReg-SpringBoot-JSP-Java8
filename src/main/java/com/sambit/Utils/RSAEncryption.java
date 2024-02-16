package com.sambit.Utils;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 16-Feb-2024 : 4:03 PM
 */

public class RSAEncryption {

    private Cipher cipher;

    private KeyPair keypair;

    public RSAEncryption() throws Exception{
        this.cipher = Cipher.getInstance("RSA");
        this.keypair = buildKeyPair();
    }

    private KeyPair buildKeyPair() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        this.keypair = kpg.generateKeyPair();
        return this.keypair;
    }

    public KeyPair getKeyPair() {
        return this.keypair;
    }

    public String encrypt(String plaintext) throws Exception{
        this.cipher.init(Cipher.ENCRYPT_MODE, this.keypair.getPublic());
        byte[] bytes = plaintext.getBytes("UTF-8");
        byte[] encrypted = blockCipher(bytes,Cipher.ENCRYPT_MODE);
        char[] encryptedTranspherable = Hex.encodeHex(encrypted);
        return new String(encryptedTranspherable);
    }

    public String decrypt(String encrypted) throws Exception{
        this.cipher.init(Cipher.DECRYPT_MODE, this.keypair.getPrivate());
        byte[] bts = Hex.decodeHex(encrypted.toCharArray());
        byte[] decrypted = blockCipher(bts,Cipher.DECRYPT_MODE);
        return new String(decrypted,"UTF-8");
    }

    private byte[] blockCipher(byte[] bytes, int mode) throws IllegalBlockSizeException, BadPaddingException {
        byte[] scrambled = new byte[0];

        byte[] toReturn = new byte[0];
        int length = (mode == Cipher.ENCRYPT_MODE)? 100 : 128;

        byte[] buffer = new byte[length];

        for (int i=0; i< bytes.length; i++){

            if ((i > 0) && (i % length == 0)){
                scrambled = cipher.doFinal(buffer);
                toReturn = append(toReturn,scrambled);
                int newlength = length;

                if (i + length > bytes.length) {
                    newlength = bytes.length - i;
                }
                buffer = new byte[newlength];
            }
            buffer[i%length] = bytes[i];
        }

        scrambled = cipher.doFinal(buffer);

        toReturn = append(toReturn,scrambled);

        return toReturn;
    }

    private byte[] append(byte[] prefix, byte[] suffix){
        byte[] toReturn = new byte[prefix.length + suffix.length];
        for (int i=0; i< prefix.length; i++){
            toReturn[i] = prefix[i];
        }
        for (int i=0; i< suffix.length; i++){
            toReturn[i+prefix.length] = suffix[i];
        }
        return toReturn;
    }

    public static void main(String[] args) {
        try {
            RSAEncryption rsaEncryption = new RSAEncryption();
            String encrypted = rsaEncryption.encrypt("Sambit Kumar Pradhan");
            System.out.println(encrypted);
            String decrypted = rsaEncryption.decrypt(encrypted);
            System.out.println(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
