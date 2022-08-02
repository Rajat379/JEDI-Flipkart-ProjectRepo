/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Group6
 *
 */
public class AdminException {
	private String message;
	
	public AdminException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
