package com.sambit.Utils;

import java.util.Base64;
import java.util.ResourceBundle;

/**
 * @Project : BSKY Communication Service
 * @Author : Sambit Kumar Pradhan
 * @Created On : 29/06/2023 - 12:00 PM
 */
public class StringUtils {
    public static final ResourceBundle bskyResourceBundle = ResourceBundle.getBundle("application");

    public static String host = new String(Base64.getDecoder().decode(bskyResourceBundle.getString("spring.mail.host")));//Not Added Yet
    public static String port = bskyResourceBundle.getString("spring.mail.port");//Not Added Yet
    public static String auth = bskyResourceBundle.getString("spring.mail.properties.mail.smtp.auth");//Not Added Yet
    public static String starttls = bskyResourceBundle.getString("spring.mail.properties.mail.smtp.starttls.enable");//Not Added Yet
    public static String username = new String(Base64.getDecoder().decode(bskyResourceBundle.getString("spring.mail.username")));//Not Added Yet
    public static String password = new String(Base64.getDecoder().decode(bskyResourceBundle.getString("spring.mail.password")));//Not Added Yet
}
