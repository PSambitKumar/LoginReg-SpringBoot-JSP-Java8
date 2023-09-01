package com.sambit.CompetitvePractice.Basic;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindStringInFile {
    boolean FindStringInFile(String filePath, String str) throws FileNotFoundException {
        File file = new File(filePath);

        Scanner scanner = new Scanner(file);

        // read the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(str)) {
                scanner.close();
                return true;
            }
        }
        scanner.close();
        return false;
    }

    public static void main(String[] args) {
        FindStringInFile findStringInFile = new FindStringInFile();
        try {
            boolean result = findStringInFile.FindStringInFile("C:\\Users\\sambit\\Desktop\\test.txt", "Sambit");
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}