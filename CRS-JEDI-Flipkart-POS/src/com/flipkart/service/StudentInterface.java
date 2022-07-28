package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.bean.Student;

public interface StudentInterface {
	
	  public void logout();

	  GradeCard viewReportCard(SemesterRegistration semesterRegistration);


	  boolean payFee(String rollNo);

	  boolean checkAvailability(Course courseToCheck);

	
	  boolean registerForCourse(SemesterRegistration semesterRegistration, Course CourseToRegister); 

	  boolean login(String username, String password);
	
	  public Student getStudentInstance();
	  
	  public List<Student> getStudentsWaitingApprocal();
	  
	  public boolean approveStudent();

	  boolean approveStudent(String email);
}
