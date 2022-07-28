/**
 * 
 */
package com.flipkart.service;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalog;

/**
 * @author vanshika.yadav
 *
 */
public interface CourseCatalogueInterface {
	

	  boolean addCourseCatalogue(CourseCatalog courseToBeAdded);

      boolean removeCourseCatalogue(CourseCatalog courseCatalogue);


	  Course findCourse(CourseCatalog catalogue, String courseID);


	  List<Course> getCourses(CourseCatalog catalogue);

	  List<CourseCatalog> getCourseCatalogues();

}
