package com.school.record.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	     @ExceptionHandler(RuntimeException.class)
	     public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex){
	    	 Map<String, String> response = new HashMap<>();
	    	 response.put("error", "An error occured at runtime");
	    	 response.put("message", ex.getMessage());
	    	 return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	     }
	     
	     @ExceptionHandler(Exception.class)
	     public ResponseEntity<Map<String, String>> handleGenericException(Exception ex){
	    	 Map<String,String> response = new HashMap<>();
	    	 response.put("error", "unexpected error occure");
	    	 response.put("message", ex.getMessage());
	    	 return new ResponseEntity<Map<String,String>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	     
	     @ExceptionHandler(MethodArgumentNotValidException.class)
	     public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
	    	 Map<String, String> errors = new HashMap<>();
	    	 ex.getBindingResult().getFieldErrors().forEach(error ->{
	    		 errors.put(error.getField(), error.getDefaultMessage());
	    	 });
	    	 return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
	     }
	     
	     @ExceptionHandler(ConstraintViolationException.class)
	     public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex){
	    	 Map<String, String> errors = new HashMap<>();
	    	 errors.put("error", "An error occure at runtime");
	    	 for(ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	    		 errors.put(violation.getPropertyPath().toString(),violation.getMessage());
	    	 }
	    	 return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
	     }

}
