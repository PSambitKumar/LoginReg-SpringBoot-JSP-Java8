package com.sambit.CustomException;

import com.sambit.Bean.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
	public final ResponseEntity<Object> handelAllException(Exception ex ){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResponse=new ErrorResponse("server error", details);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=CustomException.class)
	public final ResponseEntity<Object> handelCustomException(CustomException ex ){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResponse=new ErrorResponse("Failed", details);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value=CustomHTMLException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	public final ResponseEntity<Object> handelCustomHTMLException(CustomHTMLException ex ){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResponse=new ErrorResponse("HTML Injection Detected!", details);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
