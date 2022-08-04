/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Group6
 *
 */
public class CourseLimitReached  extends Exception{

	String message;
	
	public CourseLimitReached(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
}
