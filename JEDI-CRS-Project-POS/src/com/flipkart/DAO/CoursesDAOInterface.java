/**
 * 
 */
package com.flipkart.DAO;

import java.util.ArrayList;

import com.flipkart.bean.Course;

/**
 * @author Group6
 *
 */
public interface CoursesDAOInterface {
	
	public ArrayList<Course> getAllCourses();
	public boolean hasCourse(int courseId);
}
