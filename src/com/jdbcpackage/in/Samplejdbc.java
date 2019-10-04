package com.jdbcpackage.in;

//STEP 1. Import required packages

import java.sql.*;

public class Samplejdbc {
	
	 // JDBC driver name and database URL 
	
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
	   static final String DB_URL = "jdbc:mysql://localhost/stud"; 
	   
	 
	   //  Database credentials 
	   static final String USER = "root"; 
	   static final String PASS = "root";
	//private static Object Finally; 
	    
	  public static void main(String[] args) {
		  Connection conn = null; 
		   Statement stmt = null; 
		   
		   try {
			   
			   //STEP 2: Register JDBC driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP 3: Open a connection 
		      System.out.println("Connecting to database..."); 
		      conn = DriverManager.getConnection(DB_URL,USER,PASS); 
		 
		      //STEP 4: Execute a query 
		      System.out.println("Creating statement..."); 
		     stmt = conn.createStatement(); 
		     String  query1 = "INSERT INTO STUDENT (ID,MARKS,NAME)"+"VALUES('110','76', 'john')"; 
		      int count = stmt.executeUpdate(query1);
		      System.out.println("1st insert done"+count);


		      String sql; 
		      sql = "SELECT * FROM STUDENT"; 
		      ResultSet rs = stmt.executeQuery(sql);
		    		  
		    //STEP 5: Extract data from result set 
		      while(rs.next()){ 
		         //Retrieve by column name 
		         int id  = rs.getInt("ID"); 
		         int marks = rs.getInt("MARKS"); 
		         String name = rs.getString("NAME"); 
		         
		         System.out.print(" id: " + id);
		         System.out.print(" Marks: " + marks); 
		         System.out.print(" name: " + name); 
		         System.out.println();
		          
		       
		   }
		      //STEP 6: Clean-up environment 
		      rs.close(); 
		     stmt.close(); 
		      conn.close();
			   
			   
		} 
		   catch(SQLException e){
			   e.printStackTrace();
		   }
		   catch (Exception e) {
                   e.printStackTrace();		
                   }
		  finally {
			   
			   
		   
			   try {
				   if(stmt!=null) 
			            stmt.close(); 
			}
			   catch(SQLException e) {
				   e.printStackTrace();
			   }
			   try {
				   if(conn!=null) 
			            conn.close(); 
			   }
			   catch (SQLException e2) {
				   
				   e2.printStackTrace();
			
			}
			   
		 System.out.println("\n finally done"); 
		 
		   } 
	  }   
	
}
