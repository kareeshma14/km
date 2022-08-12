package com.student.StudentForm.exception;

public class NoStudentException extends RuntimeException {
	private String message;

	public NoStudentException(long id) {
		super("" + id);
	}

}
