package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.exception.CourseLimitReached;
import com.flipkart.exception.CourseNotFound;

import com.flipkart.exception.NotFound;
import com.flipkart.utils.DBConnection;

import com.flipkart.utils.*;

/**
 * @author Group6
 *
 */
public class StudentDAOInterfaceIMPL implements StudentDAOInterface {
	private static Logger logger = Logger.getLogger(StudentDAOInterface.class);
	private static StudentDAOInterfaceIMPL instance = null;
	Connection connection = null;
	PreparedStatement ps = null;
	public static StudentDAOInterfaceIMPL getInstance()
	{
		if(instance == null)
		{
			instance = new StudentDAOInterfaceIMPL();
		}
		return instance;
	}

	/**
	 * @param studentID id of student
	 * @return array list of grades
	 */
	@Override
	public ArrayList<Grades> getGrades(int studentID){
		ArrayList<Grades> grades = new ArrayList<>();

		try{
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SQLQueriesConstant.GET_GRADES_QUERY);

			ps.setInt(1,studentID);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()){
				Grades grade = new Grades();
				grade.setCourseID(resultSet.getInt("courseId"));
				grade.setCourseName(resultSet.getString("courseName"));
				grade.setGrade(resultSet.getString("grade"));
				grade.setStudentId(resultSet.getInt("studentId"));
				grades.add(grade);
			}
		}
		catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}

		return grades;
	}

	/**
	 * @param student student bean
	 * @return boolean: true if student added successfully
	 */
	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		PreparedStatement stmt,stmt2 = null;
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_STUDENT_USER);
			stmt.setInt(1, student.getId());
			stmt.setString(2, student.getEmail());
			stmt.setString(3, student.getPassword());
			stmt.setString(4, student.getName());
			stmt2 = conn.prepareStatement(SQLQueriesConstant.INSERT_STUDENT_STUDENT);
			stmt2.setInt(1,student.getId());
			stmt2.setBoolean(2,false);
			stmt2.setString(3,student.getBranch());
			stmt2.setInt(4,student.getAdmission_year());
			stmt2.setInt(5,student.getSemester());
			int res=stmt.executeUpdate();
			int res2 = stmt2.executeUpdate();
			if(res==1 && res2==1) {
				return true;
			}
			return false;
		}
		catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	/**
	 * @param student student bean
	 * @param method payment method
	 */
	@Override
	public void setPaymentStatus(Student student, String method) {
		System.out.println("\n============================================================");
		System.out.println("\t\tPayments");
		System.out.println("============================================================\n");
		try{
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SQLQueriesConstant.GET_PAYMENT_STATUS);
			ps.setInt(1, student.getId());
			ResultSet resultSet = ps.executeQuery();
			if(!resultSet.next()) {
				throw new NotFound("\nThere are no payments to show\n");
			}
			else {
				int status = resultSet.getInt("status");
				int amount = resultSet.getInt("amount");
				if(status == 1)
				{
					logger.info("\nPayment is already done !\n");
				}
				else
				{
					logger.info("Amount to be paid :" + String.valueOf(amount));
					ps = connection.prepareStatement(SQLQueriesConstant.SET_PAYMENT_STATUS_QUERY);
					ps.setString(1, method);
					ps.setString(2, String.valueOf(LocalDate.now()));
					ps.setInt(3, student.getId());
					ps.executeUpdate();
					logger.info("\nPayment done successfully!\n");
				}
			}
		}
		catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 * @param id id of student
	 * @return Student bean
	 */
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Student student = new Student();
		PreparedStatement stmt = null;
		Connection conn = DBConnection.getConnection();
		try {
			
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_USER_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setEmail(rs.getString("email"));
				student.setRole(rs.getString("role"));
				student.setLoggedin(rs.getBoolean("isLogged"));
				student.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		} catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return student;
	}
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * method to add primary course
	 */
	@Override
	public void addPrimaryCourse(int studentId, int courseId) {
		
		try {
			if(countPrimaryCourses(studentId) >= 4) {
				throw new CourseLimitReached("\nYou can only add 4 primary courses\n");
			}
			CoursesDAOInterface courseDAO = new CoursesDAOInterfaceIMPL();
			if(!courseDAO.hasCourse(courseId)) {
				throw new CourseNotFound("\nInvalid Course ID\n");
			}
			if(alreadyPresent(studentId, courseId)) {
				logger.error("\nYou have already added this course\n");
				return;
			}
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.INSERT_SEMREGISTRATION);
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
			stmt.setInt(1, courseId);
			stmt.setInt(2, studentId);
			stmt.setInt(3, 1);
			stmt.setTimestamp(4,sqlTime);
			int added = stmt.executeUpdate();
			if(added>0) {
				logger.info("\nCourse " + courseId + " added successfully\n");
			}
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * method to add secondary course
	 */
	@Override
	public void addSecondaryCourse(int studentId, int courseId) {
		try {
			if(countSecondaryCourses(studentId) >= 2) {
				throw new CourseLimitReached("\nYou can only add 2 secondary courses\n");
			}
			CoursesDAOInterface courseDAO = new CoursesDAOInterfaceIMPL();
			if(!courseDAO.hasCourse(courseId)) {
				throw new CourseNotFound("\nInvalid Course ID\n");
			}
			if(alreadyPresent(studentId, courseId)) {
				logger.error("\nYou have already added this course\n");
				return;
			}
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.INSERT_SEMREGISTRATION);
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
			stmt.setInt(1, courseId);
			stmt.setInt(2, studentId);
			stmt.setInt(3, 0);
			stmt.setTimestamp(4,sqlTime);
			int added = stmt.executeUpdate();
			if(added>0) {
				logger.info("\nCourse " + courseId + " added successfully\n");
			}
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * method to remove primary course
	 */
	@Override
	public void removePrimaryCourse(int studentId, int courseId) {
		try {
			CoursesDAOInterface courseDAO = new CoursesDAOInterfaceIMPL();
			if(!courseDAO.hasCourse(courseId)) {
				throw new CourseNotFound("\nInvalid Course ID\n");
			}
			if(!alreadyPresent(studentId, courseId)) {
				logger.error("\nYou have not registered for this course\n");
				return;
			}
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_PRIMARY_SM);
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			int dropped = stmt.executeUpdate();
			if(dropped > 0) {
				logger.info("\nCourse " + courseId + " deleted successfully\n");
			}else {
				logger.error("\nYou have added this course as secondary\n");
			}
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * method to remove secondary course
	 */
	@Override 
	public void removeSecondaryCourse(int studentId, int courseId) {
		try {
			CoursesDAOInterface courseDAO = new CoursesDAOInterfaceIMPL();
			if(!courseDAO.hasCourse(courseId)) {
				throw new CourseNotFound("\nInvalid Course ID\n");
			}
			if(!alreadyPresent(studentId, courseId)) {
				logger.error("\nYou have not registered for this course\n");
				return;
			}
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_SECONDARY_SM);
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			int dropped = stmt.executeUpdate();
			if(dropped > 0) {
				logger.info("\nCourse " + courseId + " deleted successfully\n");
			}else {
				logger.error("\nYou have added this course as primary\n");
			}
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 * @param studentId id of student
	 * @return array list of registered primary course
	 */
	@Override
	public ArrayList<Course> getPrimaryRegisteredCourses(int studentId) {
		ArrayList<Course> primaryCourses = new ArrayList<Course>();
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.SELECT_PRIMARY_COURSE);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {			
				PreparedStatement stmt2 = conn.prepareStatement(SQLQueriesConstant.GET_COURSE_BY_ID);
				stmt2.setInt(1, rs.getInt(1));
				ResultSet rs2 = stmt2.executeQuery();
				rs2.next();
				Course course = new Course();
				course.setCourseID(rs2.getInt(1));
				course.setCourseName(rs2.getString(2));
				course.setCredits(rs2.getInt(3));
				primaryCourses.add(course);
			}
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return primaryCourses;
	}
	

	/**
	 * @param studentId id of student
	 * @return array list of secondary registered course
	 */
	@Override
	public ArrayList<Course> getSecondaryRegisteredCourses(int studentId) {
		ArrayList<Course> secondaryCourses = new ArrayList<Course>();
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.SELECT_SECONDARY_COURSE);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				PreparedStatement stmt2 = conn.prepareStatement(SQLQueriesConstant.GET_COURSE_BY_ID);
				stmt2.setInt(1, rs.getInt(1));
				ResultSet rs2 = stmt2.executeQuery();
				rs2.next();
				Course course = new Course();
				course.setCourseID(rs2.getInt(1));
				course.setCourseName(rs2.getString(2));
				course.setCredits(rs2.getInt(3));
				secondaryCourses.add(course);
			}
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return secondaryCourses;
	}

	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean: true if student already registered for course
	 */
	@Override
	public boolean alreadyPresent(int studentId,int courseId) {
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_SM_BY_ID);
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()) {
				return false;
			}
			rs.close();
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return true;
	}

	/**
	 * @param studentId id of student
	 * method to delete from semregistration
	 */
	@Override
	public void deleteFromSemiRegistration(int studentId) {
		// NOT TESTED
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_SM_BY_ID);
			stmt.setInt(1, studentId);
			stmt.executeUpdate();
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 * @param studentId id of student
	 * @return number of primary courses
	 */
	public int countPrimaryCourses(int studentId) {
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_PRIMARY_COURSE_NO);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return 0;
	}

	/**
	 * @param studentId id of student
	 * @return number of secondary courses
	 */
	public int countSecondaryCourses(int studentId) {
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_SECONDARY_COURSE_NO);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return 0;
	}
	/*
	 * @param student : Details of student
	 * */
	public void viewPayments(Student student) {
		try{
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SQLQueriesConstant.GET_PAYMENTS);
			ps.setInt(1, student.getId());
			ResultSet resultSet = ps.executeQuery();
			if(!resultSet.next()) {
				throw new NotFound("\nThere are no payments to show\n");
			}
			else {
				int status = resultSet.getInt("status");
				int amount = resultSet.getInt("amount");
				if(status == 0)
				{
					logger.info("\n----------Payment not done yet----------\n");
					logger.info("Amount to be paid : " + String.valueOf(amount));
				}
				else
				{
					logger.info("-------------------------------------------------PAYMENT DETAILS---------------------------------------------------");
					logger.info("Payment ID\t\tMODE\t\t\tBill Date\t\tPayment Date\t\tAmount");
					logger.info("-------------------------------------------------------------------------------------------------------------------");
					logger.info(String.format("%-9d\t\t%-11s\t\t%s\t\t\t%-9s\t\t%-9s\n", resultSet.getInt("paymentid"),resultSet.getString("mode"), resultSet.getDate("billDate"),resultSet.getDate("paymentDate"),amount ));
				}
				logger.info("\n\n");
			}
		}
		catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}
}

	