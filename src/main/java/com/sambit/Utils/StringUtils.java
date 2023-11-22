package com.sambit.Utils;

import java.util.Base64;
import java.util.ResourceBundle;

/**
 * @Project : BSKY Communication Service
 * @Author : Sambit Kumar Pradhan
 * @Created On : 29/06/2023 - 12:00 PM
 */
public class StringUtils {

    private StringUtils() {}

    public static final ResourceBundle bskyResourceBundle = ResourceBundle.getBundle("application");

    public static String host = new String(Base64.getDecoder().decode(bskyResourceBundle.getString("spring.mail.host")));//Not Added Yet
    public static String port = bskyResourceBundle.getString("spring.mail.port");//Not Added Yet
    public static String auth = bskyResourceBundle.getString("spring.mail.properties.mail.smtp.auth");//Not Added Yet
    public static String starttls = bskyResourceBundle.getString("spring.mail.properties.mail.smtp.starttls.enable");//Not Added Yet
    public static String username = new String(Base64.getDecoder().decode(bskyResourceBundle.getString("spring.mail.username")));//Not Added Yet
    public static String password = new String(Base64.getDecoder().decode(bskyResourceBundle.getString("spring.mail.password")));//Not Added Yet


    private static final ResourceBundle FILE_CONFIGURATION = ResourceBundle.getBundle("file.configuration");

    public static final String STATUS_KEY = "status";
    public static final String MESSAGE_KEY = "msg";
    public static final String DATA_KEY = "data";

    //    Prefix Names
    public static final String INVESTIGATION_DOC_PREFIX_NAME = FILE_CONFIGURATION.getString("file.Investigation.prefix");
    public static final String REFERRAL_DOC_PREFIX_NAME = FILE_CONFIGURATION.getString("file.Referral.prefix");

    //    Folder Names
    public static final String INVESTIGATION_DOC_FOLDER_NAME = FILE_CONFIGURATION.getString("folder.Investigation.name");
    public static final String REFERRAL_DOC_FOLDER_NAME = FILE_CONFIGURATION.getString("folder.Referral.name");
}
