/**
 * 
 */
package com.flipkart.constant;

import com.flipkart.bean.Course;

/**
 * @author Group6
 *
 */
public class PairCourseChar {
	private Course first;
	private Character second;
	
	public Course getFirst() {
		return first;
	}
	public void setFirst(Course first) {
		this.first = first;
	}
	public Character getSecond() {
		return second;
	}
	public void setSecond(Character second) {
		this.second = second;
	}
	
	public PairCourseChar(Course x,Character y) {
		this.first=x;
		this.second=y;
	}
}
