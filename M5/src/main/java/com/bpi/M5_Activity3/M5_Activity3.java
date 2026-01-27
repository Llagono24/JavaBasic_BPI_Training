package com.bpi.M5_Activity3;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class M5_Activity3 {
	
	// Database credentials
    private static final String URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "GSTJLlagano";
    private static final String PASSWORD = "bpi_postgres";
    
    static Student student = null;
    static Course course = null;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Connection conn = null;
		
		Scanner input = new Scanner(System.in);
		
		try {
			conn = connectDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		char choice;
		
		do{
			displayMenu();
			
			choice = askInput(input).charAt(0);
			
			if(choice == '1') {
				addStudent(input, conn);
			}else if(choice == '2') {
				addCourse(input, conn);
			}else if(choice == '3') {
				showStudents(conn);
			}else if(choice == '4') {
				showCourses(conn);
			}else if(choice == '0') {
				System.out.println("Thank you for using the system.");
			}else {
				System.out.println("Invalid input!");
			}
			
			
		}while(choice != '0');
		
		input.close();

	}
	
	
	public static void displayMenu() {
		
		System.out.println("==== STUDENT COURSE MANAGEMENT ====");
		System.out.println("1. Add Student");
		System.out.println("2. Add Course");
		System.out.println("3. Show Students");
		System.out.println("4. Show Courses");
		System.out.println("0. Exit");
	}
	
	public static String askInput(Scanner input) {
		
		System.out.print("Enter choice: ");
		String choice = input.nextLine();
		
		return choice;
		
	}
	
	public static void addStudent(Scanner input, Connection conn) {
		System.out.print("Enter name: ");
		String name = input.nextLine();
		System.out.print("Enter age: ");
		Integer age = Integer.valueOf(input.nextLine());
		System.out.print("Enter email: ");
		String email = input.nextLine();
		

		String sql = "INSERT INTO STUDENTS(name, age, email) VALUES (?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, email);
			ps.executeUpdate();

			student = new Student();
			student.setName(name);
			student.setAge(age);
			student.setEmail(email);
			
			conn.close();
			ps.close();
			System.out.println("Successfully added a student\n");
			
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	
	public static void addCourse(Scanner input, Connection conn) {
		
		String sql = "SELECT ID, NAME, AGE, EMAIL FROM STUDENTS";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("ID  | Name  | Age | Email");
			System.out.println("--------------------------");
			while(rs.next()) {
				
				System.out.println(rs.getString("id") + " | " + rs.getString("name") + " | "+ rs.getInt("age") + " | " + rs.getString("email"));
			}    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.print("Enter Student ID: ");
		Integer studId = Integer.valueOf(input.nextLine());
		System.out.print("Enter course name: ");
		String courseName = input.nextLine();
		System.out.print("Enter grade: ");
		Integer grade = Integer.valueOf(input.nextLine());
		

		String sql1 = "INSERT INTO COURSES(student_id, course_name, grade) VALUES (?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, studId);
			ps.setString(2, courseName);
			ps.setInt(3, grade);
			ps.executeUpdate();

			course = new Course();
			course.setStudentId(studId);
			course.setName(courseName);
			course.setGrade(grade);
			
			conn.close();
			ps.close();
			System.out.println("Successfully added a course\n");
			
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	
	
	public static void showStudents(Connection conn) {
		
		String sql = "SELECT ID, NAME, AGE, EMAIL FROM STUDENTS";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("\nID  | Name  | Age | Email");
			System.out.println("--------------------------");
			while(rs.next()) {
				
				System.out.println(rs.getString("id") + " | " + rs.getString("name") + " | "+ rs.getInt("age") + " | " + rs.getString("email"));
			}  
			
			System.out.println("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void showCourses(Connection conn) {
		
		String sql = "SELECT S.ID, C.COURSE_NAME, C.GRADE, S.Name FROM STUDENTS S INNER JOIN COURSES C on S.ID = C.Student_id";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("\nID  | Course Name  | Grade | Student Name");
			System.out.println("--------------------------");
			while(rs.next()) {
				
				System.out.println(rs.getString("id") + " | " + rs.getString("course_name") + " | "+ rs.getInt("grade") + " | " + rs.getString("name"));
			}    
			
			System.out.println("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
    public static Connection connectDB() throws SQLException {
        Connection conn = null;
        try {

        	conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            throw e;
        }
        return conn;
    }

}
