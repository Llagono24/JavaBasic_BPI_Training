package com.bpi.M5_Activity2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class M5_Activity2 {
	
	// Database credentials
    private static final String URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "GSTJLlagano";
    private static final String PASSWORD = "bpi_postgres";
    
    public static void main(String[] args) {
    
    	Connection conn = null;
    	
        try {

            // Establish the connection
        	conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL database successfully!");

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
            
        }
        
        
        
        try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
        
    }
    
}
    


