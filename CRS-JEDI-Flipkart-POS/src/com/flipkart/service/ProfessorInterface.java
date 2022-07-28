package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;

public interface ProfessorInterface {
	
	public boolean addGrade(RegisteredCourse registeredCourse, Grade grade);
	
	
	public List<Student> getEnrolledStudents(CourseCatalog courseCatalog);
	
	public boolean login(String username, String password);


	public void logout();
}
