package com.flipkart.exception;

/**
 * @author Group6
 *
 */
public class CourseNotFound extends Exception{
	private String message;
	
	public CourseNotFound(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}