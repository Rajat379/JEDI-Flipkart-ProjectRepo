/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Group6
 *
 */
public class CourseAssignedException extends Exception{
	private String message;
	
	public CourseAssignedException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
