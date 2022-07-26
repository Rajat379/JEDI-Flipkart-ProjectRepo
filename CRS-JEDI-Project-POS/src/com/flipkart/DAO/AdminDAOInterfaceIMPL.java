package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.apache.log4j.Logger;

import com.flipkart.application.AdminCRSMenu;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBConnection;
/**
 * @author Group6
 *
 */
public class AdminDAOInterfaceIMPL implements AdminDAOInterface {

	public static Logger logger=Logger.getLogger(AdminDAOInterfaceIMPL.class);
	/**
	 * @param id id of professor
	 * @return Admin bean
	 */
	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		PreparedStatement stmt = null;
		
		try {
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_USER_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setEmail(rs.getString("email"));
				admin.setRole(rs.getString("role"));
				admin.setLoggedin(rs.getBoolean("isLogged"));
				admin.setName(rs.getString("name"));
				admin.setAdminEmail(rs.getString("email"));
				admin.setAdminId(id);
				admin.setAdminName(rs.getString("name"));
			}
		} catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		} catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return admin;
	}
	
	
	
	 
	// Declare the Connection or prepaidstatement variable here 
   	Connection conn = null;
   	PreparedStatement stmt = null;
	/**
	 * method to view report card
	 */
   	@Override
   	public void viewReportCard(Student student) {
		try {
		    conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.GET_GRADES_QUERY);
			stmt.setInt(1,student.getId());
			ResultSet res =stmt.executeQuery();
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %20s ", "Course NAME",  "GRADE"));
			logger.info("-----------------------------------------------------------------------------");
			while(res.next()) {
				logger.info(String.format("%10s %20s ",res.getString("coursename"),res.getString("grade")));
			}
			logger.info("\n\n");
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	/**
	 * method to add professor
	 */
	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		try {
		   	conn = DBConnection.getConnection();
		   	stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_PROFESSOR);
			stmt.setInt(1, professor.getId());
			stmt.setString(2, professor.getEmail());
			stmt.setString(3, professor.getPassword());
			stmt.setString(4, professor.getName());
			int res=stmt.executeUpdate();
			if(res==1) {
				stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_PROFESSOR_PROFESSOR);
				stmt.setInt(1, professor.getId());
				stmt.setString(2, professor.getEmail());
			    stmt.setString(3, professor.getPassword());
				stmt.setString(4, professor.getName());
				res=stmt.executeUpdate();
				logger.info("Professor successfully added.");
				return true;
			}
			logger.info("\nUnable to add Professor\n");
		    return false;
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}
	/**
	 *method to remove professor
	 */
	@Override
	public boolean removeProfessor(Professor professor) {
		// TODO Auto-generated method stub
		try {
		   	conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_USER_BY_ID);
		    stmt.setInt(1, professor.getId());
		    int res=stmt.executeUpdate();
		    if(res==1) {
				logger.info("\nProfessor successfully removed\n");
		    	return true;
		    }
			logger.info("\nUnable to remove Professor\n");
		    return false;
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	/**
	 *method to remove student
	 */
		@Override
	public boolean removeStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_STUDENT_BY_ID);
			stmt.setInt(1, student.getId());
			int res=stmt.executeUpdate();
			
			if(res==1) {
				stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_USER_BY_ID);
				stmt.setInt(1, student.getId());
				res=stmt.executeUpdate();
				logger.info("Student successfully deleted.");
				return true;
			}
			logger.info("\nUnable to remove Student\n");
		    return false;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 * method to add course
	 */
	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		try {
		   	conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_COURSE);
		    stmt.setInt(1, course.getCourseID());
		    stmt.setString(2, course.getCourseName());
		    stmt.setInt(3, course.getCredits());
		    int res=stmt.executeUpdate();
		    if(res==1) {
				logger.info("\nCourse successfully added\n");
		    	return true;
		    }
		    System.out.println("\nUnable to add course\n");
		    return false;
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}
	/**
	 * method to remove course
	 */
	@Override
	public boolean removeCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_COURSE_BY_ID);
		    stmt.setInt(1, course.getCourseID());
		    int res=stmt.executeUpdate();
		    if(res==1) {
				logger.info("\nCourse successfully removed\n");
		    	return true;
		    }
			logger.info("\nUnable to remove course\n");
		    return false;
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}
	/**
	 *method to approve courses of students
	 */
	@Override
	public void approveStudents() {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_SEM_REGISTRATION);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				stmt=conn.prepareStatement(SQLQueriesConstant.ADD_COURSE_STUDENT);
				stmt.setInt(1,rs.getInt("studentid"));
				stmt.setInt(2,rs.getInt("courseid"));
				int x=stmt.executeUpdate();
				if(x!=1) {
					logger.info("\nError in approving\n");
					break;
				}
			}
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_DISTINCT_SEM_REGISTRATION);
			rs=stmt.executeQuery();
			LocalDateTime cur_date=LocalDateTime.now();
			String date="";
			date+=String.valueOf(cur_date.getYear())+"-"+String.valueOf(cur_date.getMonthValue())+"-"+String.valueOf(cur_date.getDayOfMonth());
			while(rs.next()) {
				stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_PAYMENT);
				stmt.setInt(1,cur_date.getNano());
				stmt.setInt(2,rs.getInt("studentid"));
				stmt.setString(3, String.valueOf(LocalDate.now()));
				stmt.executeUpdate();
			}
			stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_SEM_REGISTRATION);
			stmt.executeUpdate();
			System.out.println("\n---All students are approved---\n");
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	/**
	 *method to view unapproved students
	 */
	@Override
	public void viewUnapprovedStudent() {
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.VIEW_UNAPPROVED_STUDENTS);
			ResultSet rs=stmt.executeQuery();
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %20s ", "USER ID",  "USER NAME"));
			logger.info("-----------------------------------------------------------------------------");
			while(rs.next()) {
				logger.info(String.format("%10s %20s ",rs.getInt("user.id"),rs.getString("user.name")));
			}
			logger.info("\n\n");

		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	/**
	 *method to approve registration of students
	 */
	@Override
	public void approveStudentsRequest(int id) {
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.APPROVE_STUDENTS_REQUEST);
			stmt.setBoolean(1,true);
			stmt.setInt(2,id);
			stmt.executeUpdate();
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	/**
	 *method to view all professors
	 */
	@Override
	public void viewProfessors() {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_PROFESSORS);
			ResultSet rs=stmt.executeQuery();
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %20s ", "PROFESSOR ID",  "PROFESSOR NAME"));
			logger.info("-----------------------------------------------------------------------------");

			while(rs.next()) {
				logger.info(String.format("%10s %20s ",rs.getInt("id"),rs.getString("name")));
			}
			logger.info("\n\n");
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	/**
	 *method to view all students
	 */
	@Override
	public void viewStudents() {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_STUDENTS);
			ResultSet rs=stmt.executeQuery();
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %20s ", "STUDENT ID",  "STUDENT NAME"));
			logger.info("-----------------------------------------------------------------------------");
			while(rs.next()) {
				logger.info(String.format("%10s %20s ",rs.getInt("id"),rs.getString("name")));
			}
			logger.info("\n\n");
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	/**
	 *method to view all courses
	 */
	@Override
	public void viewCourses() {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_COURSES);
			ResultSet rs=stmt.executeQuery();
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %20s ", "COURSE ID",  "COURSE NAME"));
			logger.info("-----------------------------------------------------------------------------");
			while(rs.next()) {
				logger.info(String.format("%10s %20s ",rs.getInt("id"),rs.getString("name")));
			}
			logger.info("\n\n");
		}catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	
}
