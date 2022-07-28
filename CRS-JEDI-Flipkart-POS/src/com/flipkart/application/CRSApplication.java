/**
 * 
 */
package com.flipkart.application;
import java.util.Scanner;

/**
 * @author vanshika.yadav
 *
 */
public class CRSApplication {
	
    /** First menu. */
    public static void firstMenu() {
        System.out.println("-----------Welcome to CRS-----------");
        System.out.println("Press 1 - Login.");
        System.out.println("Press 2 - Register as a student.");
        System.out.println("Press 3 - Exit.");
        System.out.println("------------------------------------");
    }
    
    /** Login choices. */
    public static void loginChoices() {
	    System.out.println("-----------LOG IN-----------");
	    System.out.println("Press 1 - Student.");
	    System.out.println("Press 2 - Professor.");
	    System.out.println("Press 3 - Admin.");
	    System.out.println("------------------------------------");
    }
    
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	while (true) {
            firstMenu();
            System.out.println("Your choice: ");
            
	        int response1 = sc.nextInt();
	
	        if (response1 == 1) {
	            loginChoices();
	            System.out.println("Your response: ");
	            int loginResponse = sc.nextInt();
	
	            switch (loginResponse) {
	                case 1:
	                   // Student Interface
	                	StudentApplication.studentMenuHandler();
                        break;
	                case 2:
	                   // Professor Interface
	                	ProfessorApplication.professorMenuHandler();
	                   break;
	                case 3:
	                   // Admin Interface
	                	AdminApplication.adminMenuHandler();
	                   break;
	                default:
	                   System.out.println("Please enter valid input");
	             } 
	          }else if(response1 == 2){
	
	                System.out.println("Enter your name: ");
	                String name = sc.next();
	
	                System.out.println("Enter your email: ");
	                String email = sc.next();
	
	                System.out.println("Enter your username: ");
	                String username = sc.next();
	
	                System.out.println("Enter your password: ");
	                String password = sc.next();
	
	                System.out.println("Enter your Roll number: ");
	                String roll = sc.next();
	
	                System.out.println("Enter your department: ");
	                String dept = sc.next();
	
	            } else if(response1 == 3) {
	                System.out.println("Exiting from the website.");
	                break;
	            } else {
	                System.out.println("Invalid input");
	            }
           
        }
    }
}
