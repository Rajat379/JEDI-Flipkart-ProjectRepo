/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;

/**
 * @author rajat.garg
 *
 */
public class ProfessorImpl implements ProfessorInterface{

	@Override
	public boolean addGrade(RegisteredCourse registeredCourse, Grade grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> getEnrolledStudents(CourseCatalog courseCatalog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
