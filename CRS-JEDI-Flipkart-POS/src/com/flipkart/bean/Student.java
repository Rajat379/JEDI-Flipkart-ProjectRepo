/**
 * 
 */
package com.flipkart.bean;

/**
 * @author vanshika.yadav
 *
 */
public class Student {
	/** The department. */
	private String department;
	private boolean isApproved;

	/** The roll no. */
	private String rollNo;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	  
}
