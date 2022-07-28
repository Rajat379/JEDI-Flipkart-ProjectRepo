/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.bean.Student;

/**
 * @author rajat.garg
 *
 */

public class StudentImpl implements StudentInterface{

	
	public void viewCourseCatalogue(){
		
		List<CourseCatalog> catalogue = new ArrayList<CourseCatalog>();
		CourseCatalog obj1 = new CourseCatalog();
		obj1.setYear(1);
		obj1.setSem(1);
		obj1.setId(1);
		
		CourseCatalog obj2 = new CourseCatalog();
		obj2.setYear(1);
		obj2.setSem(2);
		obj2.setId(3);
		
		catalogue.add(obj1);
		catalogue.add(obj2);
		
		
		 for(CourseCatalog obj:catalogue)  {
			  System.out.println("Id of the catalogue " + obj.getId()); 
			  System.out.println("Sem of the catalogue " + obj.getSem());
		      System.out.println("Year of the catalogue " + obj.getYear());  
	     }  
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GradeCard viewReportCard(SemesterRegistration semesterRegistration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean payFee(String rollNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkAvailability(Course courseToCheck) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerForCourse(SemesterRegistration semesterRegistration, Course CourseToRegister) {
		// TODO Auto-generated method stub
		
		RegisteredCourseImpl rcInstance = new RegisteredCourseImpl();
		
        RegisteredCourse registeredCourse = new RegisteredCourse();
        registeredCourse.setCourseId(1);
        registeredCourse.setStudentId(1);
        registeredCourse.setSemesterRegistrationId(1);
        registeredCourse.setGradeId(-1);
        
		return true;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getStudentInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentsWaitingApprocal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveStudent(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
