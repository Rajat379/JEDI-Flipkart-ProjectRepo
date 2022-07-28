/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author vanshika.yadav
 *
 */
public class CourseImpl implements CourseInterface{

	@Override
	public Boolean indicateProfessor(Course course, Professor professor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkAvailability(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findCourses(CourseCatalog courseCatalogue) {
		List<Course> course = new ArrayList<Course>();
		Course obj1 = new Course();
		obj1.setCourseCatalogueId(courseCatalogue.getId());
		obj1.setCourseCode("1");
		obj1.setDepartment("CSE");
		obj1.setDescriptions("Computer Enginerring");
		obj1.setId(1);
		obj1.setPreRequisites("High School");
		obj1.setProfessorId(1);
		
		course.add(obj1);
		return course;
	}

	@Override
	public Course findCourse(CourseCatalog courseCatalogue, String courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCourse(CourseCatalog courseCatalogue, String courseID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> viewEnrolledStudents(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

}
