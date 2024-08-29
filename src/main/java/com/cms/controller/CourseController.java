package com.cms.controller;


import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.cms.model.Course;
import com.cms.service.CourseService;

public class CourseController {
static Logger logger = Logger.getLogger(CourseController.class.getName());
	
	public void main() {
		CourseService service=new CourseService();
		Scanner s = new Scanner(System.in);
		int ch;
		
		boolean istrue=true;
		
		do {
			
			logger.info("= = = = = = = = = = = = = = = = = = = WELCOME = = = = = = = = = = = = = = = = = = = = = = = =");
			logger.info("-----------------------------COURSE MANAGEMENT SYSTEM------------------------------");
			logger.info("1.INSERT COURSE");
			logger.info("2.UPDATE COURSE");
			logger.info("3.DELETE COURSE");
			logger.info("4.VIEW ALL COURSES");
			logger.info("0.Exit");
			logger.info("Enter choice");
			ch = s.nextInt();
			
			
			switch (ch) {
			case 0:
				istrue=false;
				break;
			case 1:
				
				
				logger.info("----------------------Inserting Course Details-------------------------");
				s.nextLine();
				logger.info("Enter Course id : ");
				int cid = s.nextInt();
				s.nextLine();
				logger.info("Enter Course Name : ");
				String cname  = s.nextLine();
				logger.info("Enter Course description : ");
				String cd = s.nextLine();
				logger.info("Enter Course duration : ");
				int cdu = s.nextInt();
				s.nextLine();
				logger.info("Enter Course trainer : ");
				String ct = s.nextLine();
				
				int k=service.insert(new Course(cid,cname,cd,cdu,ct) );
				if(k==1) {
					logger.info("Added");
				}else {
					logger.info("Not Added");
				}
				
				break;
			case 2:
				logger.info("-----------------------Updating Course Details---------------------------");
				s.nextLine();
				logger.info("Enter Course id : ");
				cid = s.nextInt();
				s.nextLine();
				logger.info("Enter Course Name : ");
				cname  = s.nextLine();
				logger.info("Enter Course description : ");
				cd = s.nextLine();
				logger.info("Enter Course duration : ");
				cdu = s.nextInt();
				s.nextLine();
				logger.info("Enter Course trainer : ");
				ct = s.nextLine();
				k=service.edit(new Course(cid,cname,cd,cdu,ct) );
				if(k==1) {
					logger.info("updated course");
				}else {
					logger.info("Not updated course");
				}
				break;
				
			case 3:
				logger.info("------------------------------Deleting Course Details-------------------------");
				logger.info("Enter Course id to delete details : ");
				cid = s.nextInt();
				k=service.delete(cid);
				if(k==1) {
					logger.info(" Course Deleted");
				}else {
					logger.info(" Course Not Deleted");
				}
				break;
			case 4:
				List<Course> list =service.getAll();
				logger.info("Course id     " + "Course name     "+  "Course description    "+ "Course duration    "+ "Course trainer   ");
				for(Course co:list) {
					logger.info(co.getCourseid() + "       " + co.getCoursename() + "         " + co.getCoursedescription() + "        "+ co.getCourseduration() + "       " + co.getCoursetrainer() +  "  ");
				}
				break;

			default:
				logger.info("Enter a valid choice");
				break;
			}
			
		} while (istrue);
		s.close();
			
		}


}
