package com.cms.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cms.model.User;

public class UserDao {
	
Connection con=null;
	
	public ArrayList<User> getAllRecords(){
		ArrayList<User> list=new ArrayList<User>();
		Statement stmt=null;
		try{
			con=DBConnection.getConnection();
			 stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from encou");	
			while(rs.next()) {
				list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));					
			}
			
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		return list;
		}
		public int insertRecord(User user){
			int result=0;
			try{
				con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into encou(courseid,coursename,coursedetails,courseduration,coursetrainer) values(?,?,?,?,?)");
				ps.setInt(1,user.getCourseid());
				ps.setString(2,user.getCoursename());
				ps.setString(3, user.getCoursedetails());
				ps.setInt(4,user.getCourseduration());
				ps.setString(5, user.getCoursetrainer());
				result=ps.executeUpdate();
			
				}
				catch(Exception e){
					e.printStackTrace();
				}
			return result;		
		}
		public int deleteRecord(int id){
			int result=0;
			try{
				con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from encou where courseid=?");
				ps.setInt(1,id);
				result=ps.executeUpdate();
			
			
			}catch(Exception e){
					e.printStackTrace();
				}
			return result;
		}
		
		public int updateRecord(User user) {
			
			int result=0;
			try{
				con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("update encou set coursename =?,coursedetails=?,courseduration=?,coursetrainer=? where courseid =?");
				ps.setString(1,user.getCoursename());
				ps.setString(2, user.getCoursedetails());
				ps.setInt(3,user.getCourseduration());
				ps.setString(4, user.getCoursetrainer());
				ps.setInt(5,user.getCourseid());
				result=ps.executeUpdate();
				
				}
				catch(Exception e){
					e.printStackTrace();
				}
			
			return result;
			
		}
		
		public User getUserById(int id) {
			con=DBConnection.getConnection();
			User use=new User();
			try {
				PreparedStatement ps=con.prepareStatement("select * from encou where courseid=?");
				ps.setInt(1, id);
				ResultSet rs= ps.executeQuery("select * from encou");
				
				while(rs.next()) {
					int courseid=rs.getInt("courseid") ;
					String coursename=rs.getString("coursename");
					String coursedetails=rs.getString("coursedetails");
					int courseduration=rs.getInt("courseduration");
					String coursetrainer=rs.getString("coursetrainer");
					use.setCourseid(courseid);
					use.setCoursename(coursename);
					use.setCoursedetails(coursedetails);
					use.setCourseduration(courseduration);
					use.setCoursetrainer(coursetrainer);
				}
						
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return use;
		}

}

