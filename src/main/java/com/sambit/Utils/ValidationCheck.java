package com.sambit.Utils;

public class ValidationCheck {
    public static final String alphaRegx = "^[a-zA-Z]*$";
    public static final String numericRegx = "^[0-9]*$";
    public static final String alphaNumericRegx = "^[a-zA-Z0-9]*$";
public static final String emailRegx = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    public static final String mobileRegx = "^[0-9]{10}$";
    public static final String passwordRegx = "^[a-zA-Z0-9!@#$%^&*]{8,}$";
    public static final String dateRegx = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$";
    public static final String timeRegx = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
    public static final String dateTimeRegx = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
    public static final String alphaNumericSpaceRegx = "^[a-zA-Z0-9 ]*$";
    public static final String alphaSpaceRegx = "^[a-zA-Z ]*$";
    public static final String numericSpaceRegx = "^[0-9 ]*$";
    public static final String alphaNumericSpecialRegx = "^[a-zA-Z0-9!@#$%^&*]*$";
    public static final String alphaSpecialRegx = "^[a-zA-Z!@#$%^&*]*$";
    public static final String numericSpecialRegx = "^[0-9!@#$%^&*]*$";
    public static final String alphaNumericSpaceSpecialRegx = "^[a-zA-Z0-9 !@#$%^&*]*$";
    public static final String alphaSpaceSpecialRegx = "^[a-zA-Z !@#$%^&*]*$";
    public static final String numericSpaceSpecialRegx = "^[0-9 !@#$%^&*]*$";
}
