/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

/**
 * @author vanshika.yadav
 *
 */
public class ProfessorApplication {
	
	  public static void showProfessorMenu() {
		  
		  

		    System.out.println("-----------Professor Menu-----------");

		    System.out.println("Press 1 - List the enrolled students");

		    System.out.println("Press 2 - Mark student's grade");

		    System.out.println("Press 3 - List of courses to teach");

		    System.out.println("Press 4 - Register for course to teach");

		    System.out.println("Press 5 - change Password");
		    
		    System.out.println("Press 6 - Logout");

		    System.out.println("--------------------------------------");
	 }
	  
	  public static void professorMenuHandler() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter admin username: ");
	        String username = sc.next();
	        System.out.print("Enter admin password: ");
	        String password = sc.next();
	        ProfessorApplication.showProfessorMenu();
	  }

}
