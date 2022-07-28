/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.bean.Student;

/**
 * @author vanshika.yadav
 *
 */
public interface RegisteredCourseInterface {
	 public List<Student> viewEnrolledStudents(CourseCatalog courseCatalogue, Professor professor);


	  public List<Student> viewEnrolledStudents(Course course);


	  boolean checkAvailability(Course course);


	  public boolean addRegisteredCourse(RegisteredCourse registeredCourse);


	  public boolean dropRegisteredCourse(RegisteredCourse registeredCourse);

	  public RegisteredCourse findRegisteredCourse(
	      SemesterRegistration semesterRegistration, String courseID);


	  public List<RegisteredCourse> findRegisteredCourses(SemesterRegistration semesterRegistration);


	  public boolean markGrade(String courseID, CourseCatalog courseCatalogue, String rollNo, Grade grade);
}
