/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.SemesterRegistration;

/**
 * @author vanshika.yadav
 *
 */
public interface SemesterRegistrationInterface {
	
	 public List<Grade> viewGrades(SemesterRegistration semesterRegistration);


	  public List<RegisteredCourse> viewGradesAndCourses(SemesterRegistration semesterRegistration);


	  public List<SemesterRegistration> viewSemesterRegistrations(int student);

	  boolean addSemesterRegistration(SemesterRegistration semesterRegistration);

}
