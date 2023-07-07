package com.sambit.Utils;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 13/04/2023 - 4:47 PM
 */
public class EnglishToOriya {
    public static String convertEnglishToOriya(String English) {
        String englishToOriya = English.chars()
                .mapToObj(c -> (char) c)
                .map(c -> {
                    if (c == 'a') {
                        return "ଅ";
                    } else if (c == 'A') {
                        return "ଆ";
                    } else if (c == 'b') {
                        return "ବ";
                    } else if (c == 'B') {
                        return "ଭ";
                    } else if (c == 'c') {
                        return "କ";
                    } else if (c == 'C') {
                        return "ଖ";
                    } else if (c == 'd') {
                        return "ଦ";
                    } else if (c == 'D') {
                        return "ଧ";
                    } else if (c == 'e') {
                        return "ଏ";
                    } else if (c == 'E') {
                        return "ଐ";
                    } else if (c == 'f') {
                        return "ଫ";
                    } else if (c == 'F') {
                        return "ଫ";
                    } else if (c == 'g') {
                        return "ଗ";
                    } else if (c == 'G') {
                        return "ଘ";
                    } else if (c == 'h') {
                        return "ହ";
                    } else if (c == 'H') {
                        return "ହ";
                    } else if (c == 'i') {
                        return "ଇ";
                    } else if (c == 'I') {
                        return "ଈ";
                    } else if (c == 'j') {
                        return "ଜ";
                    } else if (c == 'J') {
                        return "ଝ";
                    } else if (c == 'k') {
                        return "କ";
                    } else if (c == 'K') {
                        return "ଖ";
                    } else if (c == 'l') {
                        return "ଲ";
                    } else if (c == 'L') {
                        return "ଳ";
                    } else if (c == 'm') {
                        return "ମ";
                    } else if (c == 'M') {
                        return "ମ";
                    } else if (c == 'n') {
                        return "ନ";
                    } else if (c == 'N') {
                        return "ଣ";
                    } else if (c == 'o') {
                        return "ଓ";
                    } else if (c == 'O') {
                        return "ଔ";
                    } else if (c == 'p') {
                        return "ପ";
                    } else if (c == 'P') {
                        return "ଫ";
                    } else if (c == 'q') {
                        return "କ";
                    } else if (c == 'Q') {
                        return "ଖ";
                    } else if (c == 'r') {
                        return "ର";
                    } else if (c == 'R') {
                        return "ର";
                    } else if (c == 's') {
                        return "ସ";
                    } else if (c == 'S') {
                        return "ଶ";
                    } else if (c == 't') {
                        return "ତ";
                    } else if (c == 'T') {
                        return "ଥ";
                    } else if (c == 'u') {
                        return "ଉ";
                    } else if (c == 'U') {
                        return "ଊ";
                    } else if (c == 'v') {
                        return "ଭ";
                    } else if (c == 'V') {
                        return "ଭ";
                    } else if (c == 'w') {
                        return "ୱ";
                    } else if (c == 'W') {
                        return "ୱ";
                    } else if (c == 'x') {
                        return "କ୍ଷ";
                    } else if (c == 'X') {
                        return "କ୍ଷ";
                    } else if (c == 'y') {
                        return "ୟ";
                    } else if (c == 'Y') {
                        return "ୟ";
                    } else if (c == 'z') {
                        return "ଜ୍ଞ";
                    } else if (c == 'Z') {
                        return "ଜ୍ଞ";
                    } else {
                        return String.valueOf(c);
                    }
                })
                .reduce("", String::concat);
        return englishToOriya;
    }
}
