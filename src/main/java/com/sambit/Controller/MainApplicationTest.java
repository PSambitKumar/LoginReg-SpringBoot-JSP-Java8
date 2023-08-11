package com.sambit.Controller;

import com.sambit.Utils.Mail;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 26/04/2023 - 10:18 AM
 */
public class MainApplicationTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Mail.sendEmailGmailTLS("changesoumya@gmail.com");
        }
    }
}
