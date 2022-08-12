package com.student.StudentForm.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionResponse {
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd:hh:mm:ss")
	private LocalDateTime timeStamp;
	private String message;

	public ExceptionResponse(HttpStatus status) {
		this.status = status;
	}

	public ExceptionResponse() {
		this.timeStamp = LocalDateTime.now();
	}

	public ExceptionResponse(HttpStatus status, LocalDateTime timeStamp, String message) {
		this.status = status;
		this.timeStamp = timeStamp;
		this.message = message;
	}

	public ExceptionResponse(HttpStatus notFound, String message2) {
		this.status = notFound;
		this.timeStamp = LocalDateTime.now();
		this.message = message2;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
