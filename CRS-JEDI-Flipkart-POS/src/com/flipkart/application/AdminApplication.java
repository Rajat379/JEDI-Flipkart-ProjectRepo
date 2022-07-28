/**
 * 
 */
package com.flipkart.application;
import java.util.Scanner;

/**
 * @author vanshika.yadav
 *
 */
public class AdminApplication {
          
		  /** Show admin menu. */
		  public static void showAdminMenu() {

		    System.out.println("-----------Admin Menu-----------");

		    System.out.println("Press 1 - Add course");

		    System.out.println("Press 2 - Remove course");

		    System.out.println("Press 3 - Add Professor");

		    System.out.println("Press 4 - List Courses");
		    
		    System.out.println("Press 5 - Get Student list waiting for approval");
		    
		    System.out.println("Press 6 - Logout");

		    System.out.println("---------------------------------");
		  }
		  
		  
		  public static void adminMenuHandler() {
			        Scanner sc = new Scanner(System.in);
			        System.out.print("Enter admin username: ");
			        String username = sc.next();
			        System.out.print("Enter admin password: ");
			        String password = sc.next();
			        AdminApplication.showAdminMenu();
		  }
			        			        
}
