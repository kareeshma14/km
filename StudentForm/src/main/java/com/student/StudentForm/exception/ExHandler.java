package com.student.StudentForm.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class ExHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(NoStudentException.class)
	public ResponseEntity<Object> handleNoTutorialException(HttpServletRequest response, NoStudentException ex) {
		String message = "Student not found for the id: " + ex.getMessage();
		return buildResponseEntity(new ExceptionResponse(HttpStatus.NOT_FOUND, message));
	}

	private ResponseEntity<Object> buildResponseEntity(ExceptionResponse exceptionResponse) {
		return new ResponseEntity<Object>(exceptionResponse, exceptionResponse.getStatus());
	}
}
