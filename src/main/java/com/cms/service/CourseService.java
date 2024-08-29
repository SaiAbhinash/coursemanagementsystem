package com.cms.service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cms.dao.CourseDao;
import com.cms.model.Course;



public class CourseService {
CourseDao cd = new CourseDao();
	 List<Course> courses;
	 public List<Course> getAll(){
			List<Course> list=null;
			list=cd.getAllRecords();
			Collections.sort(list,new Comparator<Course>() {

				public int compare(Course o1, Course o2) {
				
					return o1.getCourseid()-o2.getCourseid();
				}
			});
			return list;
			
		}

			public int insert(Course user) {
				return cd.insertRecord(user);
			
				
			}
			
			public int delete(int id) {
				return cd.deleteRecord(id);
			}
			
			public int edit(Course user) {
				return cd.updateRecord(user);
			
			}
			
			public Course getCourse(int id) {
				 return cd.getCourseById(id);
				
			}

}
