package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cms.model.Course;




public class CourseDao {
Connection con=null;
	
	public ArrayList<Course> getAllRecords(){
		ArrayList<Course> list=new ArrayList<Course>();
		Statement stmt=null;
		try{
			con=DBConnection.getConnection();
			 stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from courm");	
			while(rs.next()) {
				list.add(new Course(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));					
			}
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		return list;
		}
		public int insertRecord(Course user){
			int result=0;
			try{
				con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into courm(courseid,coursename,coursedescription,courseduration,coursetrainer) values(?,?,?,?,?)");
				ps.setInt(1,user.getCourseid());
				ps.setString(2,user.getCoursename());
				ps.setString(3, user.getCoursedescription());
				ps.setInt(4,user.getCourseduration());
				ps.setString(5, user.getCoursetrainer());
				result=ps.executeUpdate();
				con.close();
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
				PreparedStatement ps=con.prepareStatement("delete from courm where courseid=?");
				ps.setInt(1,id);
				result=ps.executeUpdate();
				con.close();
			
			}catch(Exception e){
					e.printStackTrace();
				}
			return result;
		}
		
		public int updateRecord(Course user) {
			
			int result=0;
			try{
				con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("update courm set coursename =?,coursedescription=?,courseduration=?,coursetrainer=? where courseid =?");
				ps.setString(1,user.getCoursename());
				ps.setString(2, user.getCoursedescription());
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
		
		public Course getCourseById(int id) {
			con=DBConnection.getConnection();
			Course cour=new Course();
			try {
				PreparedStatement ps=con.prepareStatement("select * from courm where courseid=?");
				ps.setInt(1, id);
				ResultSet rs= ps.executeQuery();
				
				while(rs.next()) {
					int courseid=rs.getInt("courseid") ;
					String coursename=rs.getString("coursename");
					String cousedescription=rs.getString("coursedescription");
					int courseduration=rs.getInt("courseduration");
					String coursetrainer=rs.getString("coursetrainer");
					cour.setCourseid(courseid);
					cour.setCoursename(coursename);
					cour.setCoursedescription(cousedescription);
					cour.setCourseduration(courseduration);
					cour.setCoursetrainer(coursetrainer);
				}
				
						
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return cour;
		}


}
