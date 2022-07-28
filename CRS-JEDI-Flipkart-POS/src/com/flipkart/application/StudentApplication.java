/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

/**
 * @author vanshika.yadav
 *
 */
public class StudentApplication {
	
	public static void showStudentMenu() {
	    System.out.println("-----------Welcome to the Student Menu-----------");
	    System.out.println("1. View Course Catalogue");
	    System.out.println("2. Add Course ");
	    System.out.println("3. Drop Course ");
	    System.out.println("4. Pay Fee");
	    System.out.println("5. View Registered Courses");
	    System.out.println("6. View Report Card");
	    System.out.println("7. View Notifications");
	    System.out.println("8. update your password");
	    System.out.println("9. Logout");
	    System.out.println("----------------------------------------------------");
	  }
	
	  public static void professorMenuHandler() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter admin username: ");
	        String username = sc.next();
	        System.out.print("Enter admin password: ");
	        String password = sc.next();
	        StudentApplication.showStudentMenu();
	  }

}
