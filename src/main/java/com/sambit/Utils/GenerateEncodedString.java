package com.sambit.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 29/11/2022 - 3:39 PM
 */
public class GenerateEncodedString {
    public static String generateEncodedString(String filePath){
        try {
            return Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
