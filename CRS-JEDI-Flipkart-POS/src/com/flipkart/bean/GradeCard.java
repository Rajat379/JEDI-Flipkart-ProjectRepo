/**
 * 
 */
package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vanshika.yadav
 *
 */
public class GradeCard {
	
	  /** The sgpa. */
	  private double sgpa;

	  /** The course codes. */
	  private List<String> courseCodes = new ArrayList<String>();

	  /** The grades. */
	  private List<Integer> grades = new ArrayList<Integer>();

	  /** The course I ds. */
	  private List<Integer> courseIDs = new ArrayList<Integer>();

	/**
	 * @return the sgpa
	 */
	public double getSgpa() {
		return sgpa;
	}

	/**
	 * @param sgpa the sgpa to set
	 */
	public void setSgpa(double sgpa) {
		this.sgpa = sgpa;
	}

	/**
	 * @return the courseCodes
	 */
	public List<String> getCourseCodes() {
		return courseCodes;
	}

	/**
	 * @param courseCodes the courseCodes to set
	 */
	public void setCourseCodes(List<String> courseCodes) {
		this.courseCodes = courseCodes;
	}

	/**
	 * @return the grades
	 */
	public List<Integer> getGrades() {
		return grades;
	}

	/**
	 * @param grades the grades to set
	 */
	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}

	/**
	 * @return the courseIDs
	 */
	public List<Integer> getCourseIDs() {
		return courseIDs;
	}

	/**
	 * @param courseIDs the courseIDs to set
	 */
	public void setCourseIDs(List<Integer> courseIDs) {
		this.courseIDs = courseIDs;
	}
	  
	  

}
