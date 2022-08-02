/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Group6
 *
 */
public class ProfessorException extends Exception{

	private String message;
	
	public ProfessorException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
