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
public class RegisteredCourseImpl implements RegisteredCourseInterface {

	@Override
	public List<Student> viewEnrolledStudents(CourseCatalog courseCatalogue, Professor professor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> viewEnrolledStudents(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAvailability(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRegisteredCourse(RegisteredCourse registeredCourse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dropRegisteredCourse(RegisteredCourse registeredCourse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RegisteredCourse findRegisteredCourse(SemesterRegistration semesterRegistration, String courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisteredCourse> findRegisteredCourses(SemesterRegistration semesterRegistration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean markGrade(String courseID, CourseCatalog courseCatalogue, String rollNo, Grade grade) {
		// TODO Auto-generated method stub
		return false;
	}

}
