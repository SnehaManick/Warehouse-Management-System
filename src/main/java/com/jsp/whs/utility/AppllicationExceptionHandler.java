package com.jsp.whs.utility;

 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.whs.exception.SuperAdminAlreadyExistException;

@RestControllerAdvice
public class AppllicationExceptionHandler {

	 @ExceptionHandler
	public ResponseEntity<ErrorStructure<Map<String, String>>> handleMethodArugumentNotValid(MethodArgumentNotValidException ex){
		 List<ObjectError> errors =ex.getAllErrors();
		 Map<String , String> allError= new HashMap<String, String>();
		 errors.forEach( error ->{
			 FieldError fieldError = (FieldError)error;
			 String field= fieldError.getField();
			 String message =fieldError.getDefaultMessage();
			 allError.put(field, message);
					 
		 });
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				 .body(new ErrorStructure< Map<String , String>>().setStatus(HttpStatus.BAD_REQUEST.value())
						 .setMesssage("invalid input")
						 .setRoutcase(allError));
				 
	}
	  
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<ErrorStructure<String>> errorResponse  ( HttpStatus status , String message , String routcase){
		 return  ResponseEntity.status(status).body(new ErrorStructure()
				 .setMesssage(message)
				 .setStatus(status.value())
				 .setRoutcase(routcase)
				);
	 }
	 @ExceptionHandler
	 public ResponseEntity<ErrorStructure<String>> handleSuperAdminAlreadyExist(SuperAdminAlreadyExistException ex){
		 return errorResponse(HttpStatus.FORBIDDEN,  ex.getMessage(),  "the admin must be only one");
	 }
}
