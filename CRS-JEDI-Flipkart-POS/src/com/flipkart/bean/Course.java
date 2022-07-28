/**
 * 
 */
package com.flipkart.bean;

/**
 * @author vanshika.yadav
 *
 */
public class Course {
	
	/** The course code. */
	  private String courseCode;

	  /** The department. */
	  private String department;

	  /** The descriptions. */
	  private String descriptions;

	  /** The pre requisites. */
	  private String preRequisites;

	  /** The professor id. */
	  private int professorId;

	  /** The Id. */
	  private int Id;

	  /** The course catalogue id. */
	  private int courseCatalogueId; // catalog ID

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the descriptions
	 */
	public String getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the preRequisites
	 */
	public String getPreRequisites() {
		return preRequisites;
	}

	/**
	 * @param preRequisites the preRequisites to set
	 */
	public void setPreRequisites(String preRequisites) {
		this.preRequisites = preRequisites;
	}

	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the courseCatalogueId
	 */
	public int getCourseCatalogueId() {
		return courseCatalogueId;
	}

	/**
	 * @param courseCatalogueId the courseCatalogueId to set
	 */
	public void setCourseCatalogueId(int courseCatalogueId) {
		this.courseCatalogueId = courseCatalogueId;
	}
	  
	  

}
