package com.cms.service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cms.dao.UserDao;
import com.cms.model.Course;
import com.cms.model.User;


public class UserService {
UserDao cs = new UserDao(); 

CourseService cd = new CourseService();
	
	List<User> users;
	 public List<User> getAll(){
			List<User> list=null;
			list=cs.getAllRecords();
			Collections.sort(list,new Comparator<User>() {

				public int compare(User o1, User o2) {
				
					return o1.getCourseid()-o2.getCourseid();
				}
			});
			return list;
			
		}
	 public int insert(int u) {
		 Course course = cd.getCourse(u);
		 User user = new User(course.getCourseid(),course.getCoursename(),course.getCoursedescription(),course.getCourseduration(),course.getCoursetrainer());
			return cs.insertRecord(user);

			
		}
		
		public int delete(int id) {
			return cs.deleteRecord(id);
		
		}
		
		public User getUser(int id) {
			return cs.getUserById(id);
			
		}
	

}
