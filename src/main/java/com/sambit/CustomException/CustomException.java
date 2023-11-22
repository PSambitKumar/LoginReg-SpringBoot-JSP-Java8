package com.sambit.CustomException;

/**
 * @Project : TMS Backend
 * @Author: Sambit Kumar Pradhan
 * @Date: 28-Sep-2023 : 9:48 AM
 */

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
