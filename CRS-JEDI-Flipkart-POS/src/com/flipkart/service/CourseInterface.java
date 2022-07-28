/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author vanshika.yadav
 *
 */
public interface CourseInterface {
	
	  public Boolean indicateProfessor (Course course, Professor professor);

	  public Boolean checkAvailability(Course course);


	  public List<Course> findCourses(CourseCatalog courseCatalogue);


	  public Course findCourse(CourseCatalog courseCatalogue, String courseID);


	  public boolean removeCourse(CourseCatalog courseCatalogue, String courseID);


	  public List<Student> viewEnrolledStudents(Course course);


	  public boolean addCourse(Course course);
}
