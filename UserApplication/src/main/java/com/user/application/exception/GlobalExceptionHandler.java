package com.user.application.exception;
import java.net.http.HttpHeaders;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

	@ControllerAdvice //handle exceptions globally
	public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
	{
		
		@ExceptionHandler(ResourceNotFoundException.class) //to handle the specific exceptions and sending the custom responses to the client.
		public ResponseEntity<String> handleResourceNotFoundException
		(ResourceNotFoundException exception, WebRequest request)
		{
			return new ResponseEntity<String>("input field is empty, please look into it", HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(NoSuchElementException.class)
		public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException)
		{
			return new ResponseEntity<String>("No value is present in DB, please change your request", HttpStatus.NOT_FOUND);
		}
		protected ResponseEntity<Object> handleHttpRequestMethodNotSupported
		(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request )
		{
			return new ResponseEntity<Object>("Please change your http method request", HttpStatus.NOT_FOUND);
	    }
	}
