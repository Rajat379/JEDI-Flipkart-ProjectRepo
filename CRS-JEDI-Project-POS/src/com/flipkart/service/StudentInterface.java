package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Grades;
import com.flipkart.bean.Student;
/**
 * @author Group6
 *
 */
public interface StudentInterface {
	public void showCourses();
    
    public ArrayList<Grades> viewGrades(int studentId);

    public void makePayment(Student student, String method);

    public boolean addPrimaryCourse(int studentId,int courseId);

    public boolean removePrimaryCourse(int studentId,int courseId);
    
    public boolean addSecondaryCourse(int studentId,int courseId);

    public boolean removeSecondaryCourse(int studentId,int courseId);

    public void viewPrimaryRegisteredCourses(int studentId);
    
    public void viewSecondaryRegisteredCourses(int studentId);
    
    public Student getStudentById(int id);

    public boolean addStudent();

	public void viewPayments(Student student);
    
        
}
