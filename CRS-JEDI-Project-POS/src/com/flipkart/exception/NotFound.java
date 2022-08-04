/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Group6
 *
 */
public class NotFound extends Exception{
	private String message;
	
	public NotFound(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}