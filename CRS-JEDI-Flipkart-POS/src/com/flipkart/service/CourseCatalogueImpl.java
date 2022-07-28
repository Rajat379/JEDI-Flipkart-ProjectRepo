/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalog;

/**
 * @author vanshika.yadav
 *
 */
public class CourseCatalogueImpl implements CourseCatalogueInterface {

	@Override
	public boolean addCourseCatalogue(CourseCatalog courseToBeAdded) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCourseCatalogue(CourseCatalog courseCatalogue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course findCourse(CourseCatalog catalogue, String courseID){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCourses(CourseCatalog catalogue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseCatalog> getCourseCatalogues() {
		List<CourseCatalog> courseCatalog = new ArrayList<CourseCatalog>();
		
		CourseCatalog obj1 = new CourseCatalog();
		obj1.setId(1);
		obj1.setSem(1);
		obj1.setYear(1);
		
		courseCatalog.add(obj1);
		
		return courseCatalog;
	}

}
