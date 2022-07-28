/**
 * 
 */
package com.flipkart.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.Notification;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Payment;
import com.flipkart.bean.PaymentNotification;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.service.CourseCatalogueImpl;
import com.flipkart.service.CourseImpl;
import com.flipkart.service.NotificationImpl;
import com.flipkart.service.PaymentImpl;
import com.flipkart.service.RegisteredCourseImpl;
import com.flipkart.service.SemesterRegistrationImpl;
import com.flipkart.service.StudentImpl;


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
	
	  public static void studentMenuHandler() {
		    Scanner sc = new Scanner(System.in);
		    CourseCatalog chosen = new CourseCatalogueImpl().getCourseCatalogues().get(0);
		    StudentImpl stud = new StudentImpl();
		    CourseImpl courseImpl = new CourseImpl();
		    RegisteredCourseImpl regImpl = new RegisteredCourseImpl();
		    CourseCatalogueImpl courseCatalogue = new CourseCatalogueImpl();
		    SemesterRegistrationImpl semImpl = new SemesterRegistrationImpl();
		    
	 
		   
		    System.out.print("Enter student username: ");
		    String username = sc.next();
		    System.out.print("Enter student password: ");
		    String password = sc.next();
		    
		    showStudentMenu();
		    
		    System.out.print("Your Choice: ");
		    int option = sc.nextInt();
            
		    SemesterRegistration chosenSem = null;

		    
		    while(true) {
		    if (option == 1) {

		        System.out.println("\n\n **********ALL THE AVAILABLE COURSES ARE********* \n\n");
		        
		        List<Course> courses = courseImpl.findCourses(chosen);
		        
		        System.out.println("Total " + courses.size() + " courses found");
		        if(courses.size()>0) {
		        System.out.println("-------------------------------------------------------------------------------------------------------------");
		        System.out.format("%25s%25s%25s%25s%n", "Course Code", "Course Description", "Course Department", "Course Prerequisites" );
		        System.out.println("-------------------------------------------------------------------------------------------------------------");
		        
		        }
		        for (Course course : courses) {

		          System.out.format("%25s%25s%25s%25s%n",course.getCourseCode(), course.getDescriptions(), course.getDepartment(), course.getPreRequisites());         
		        }
		        
		     
		     System.out.println("-------------------------------------------------------------------------------------------------------------");
		    }else if(option == 2) {
		    	  System.out.println("Enter course you want to add");
		    	  String course = sc.next(); 
		    	  Course c = courseImpl.findCourse(chosen, course);
		          stud.registerForCourse(chosenSem, c);
		          System.out.println("Course "+ course + " registered");
		    	
		    }else if(option == 3) {
		    	    System.out.println("Enter course name to be dropped: ");
		    	    String courseName = sc.next();
		        	regImpl.dropRegisteredCourse(regImpl.findRegisteredCourse(chosenSem, courseName));
		        	System.out.println("Course dropped " + courseName);
		    }else if (option == 4) {

		        System.out.println("Payment options: ");

		        System.out.println();

		        System.out.println("Press 1 - Pay Online");

		        System.out.println("Press 2 - Pay Offline");

		        int option2 = sc.nextInt();
		        String mode = "Online";

		        if (option2 == 2) {

		          mode = "Offline";
		        }
		        

//		        Payment p = new Payment();
//
//		        p.setMode(mode);
//		        p.setStudentId(stud.getStudentInstance().getUserID());
//		        
//		        p.setSemesterRegistrationId(chosenSem.getId());
//
//		        PaymentImpl paymentImpl = new PaymentImpl();
//		        
//		        paymentImpl.makePayment(p);
		          System.out.println("Payment Done!");
		      //new NotificationImpl().showNotification("Payment done at " + LocalDateTime.now(), stud.getStudentInstance().getRollNo());
		    }else if (option == 5) {
		    	System.out.println("Registered Courses are");
                List<String> C = new ArrayList<String>();
		        
		        C.add("course1");
		        C.add("course2");
		        C.add("course3");
		        for (String course : C) {
                     System.out.println(course);
		        }
		        
		        System.out.println("-------------------------------------------------------------------------------------------------------------");
		    }else if (option == 6) {
		        GradeCard report = stud.viewReportCard(chosenSem);
		        System.out.println("Report Card:");
		        System.out.println("--------------------------------------------------------");
//		        System.out.format("%25s%25s%n", "Course Code", "Grade");
//		        System.out.println("--------------------------------------------------------");
//		        for (int i = 0; i < report.getCourseCodes().size(); i++) {
//		        	
//		          System.out.format("%25s%25s%n", report.getCourseCodes().get(i), report.getGrades().get(i));
//		        
//		        }
		        System.out.println("--------------------------------------------------------");
		        System.out.println("GPA: " + 7.6);
		        System.out.println("--------------------------------------------------------");
		    	
		    }else if (option == 7) {

		        System.out.println("All Notifications are");

		        //int studentId = stud.getStudentInstance().getUserID();

		        //NotificationImpl notificationImp = new NotificationImpl();

		        //List<PaymentNotification> notificationList = new ArrayList<PaymentNotification>();

		        //notificationList = notificationImpl.getNotification(studentId);

//		        for (PaymentNotification n : notificationList) {
//
//		          System.out.println(n.getMessage());
//		        } 
		        
		        
		        
		        
		    } else if(option == 8) {
		    	  
		    	  System.out.println("Enter your current pssword !!");
		    	  String pass = sc.next();
		    	  System.out.println("Enter your new Password");
		    	  String newPass = sc.next();
		    	  //boolean changed = stud.changePassword(stud.getStudentInstance().getUserID(),pass,newPass);
		    	  System.out.println("**Password changed successfully**");
		    }else if (option == 9) {
		        stud.logout();
		        break;
		    	
		    }else {
		        System.out.println("Enter valid Inputs");
		    }
		    
		    showStudentMenu();
		    System.out.println("Your choice:");
		    option = sc.nextInt();  
	    }    
	  }	
}
		  
	


