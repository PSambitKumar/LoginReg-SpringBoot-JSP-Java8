package com.sambit.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project : TMS Backend
 * @Author: Sambit Kumar Pradhan
 * @Date: 14-Mar-2024 : 2:50 PM
 */

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class CustomHTMLException extends RuntimeException{
    public CustomHTMLException(String message) {
        super(message);
    }
}
