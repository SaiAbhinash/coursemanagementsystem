package com.cms.dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
private static Connection con=null;
	
	public static Connection getConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			if(con==null) {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course?useSSL=false","root","");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}

}
