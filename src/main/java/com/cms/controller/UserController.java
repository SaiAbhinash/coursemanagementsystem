package com.cms.controller;


import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.cms.model.Course;
import com.cms.model.User;
import com.cms.service.CourseService;
import com.cms.service.UserService;


public class UserController {
static Logger logger = Logger.getLogger(UserController.class.getName());
	
	public void main() {
		UserService service=new UserService();
		Scanner s = new Scanner(System.in);
		int ch;
		
		boolean istrue=true;
		
		do {
			
			logger.info("==================================WELCOME=================================");
			logger.info("-----------------------------COURSE MANAGEMENT SYSTEM------------------------------");
			logger.info("1.VIEW ALL COURSES");
			logger.info("2.ENROLL COURSE");
			logger.info("3.UNENROLL COURSE");
			logger.info("4.ENROLLED COURSES");
			logger.info("0.Exit");
			logger.info("Enter choice");
			ch = s.nextInt();
			
			
			switch (ch) {
			case 0:
				istrue=false;
				break;
			case 1:
				
			
				List<Course> list =new CourseService().getAll();
				logger.info("Course id     " + "Course name     "+  "Course description    "+ "Course duration    "+ "Course trainer   ");
				for(Course co:list) {
					logger.info(co.getCourseid() + "       " + co.getCoursename() + "         " + co.getCoursedescription() + "        "+ co.getCourseduration() + "       " + co.getCoursetrainer() +  "  ");
				}
				break;
			case 2:
				logger.info("-----------------------Enrolling Courses---------------------------");
				s.nextLine();
				logger.info("Enter Course id : ");
				int cid = s.nextInt();
				int k = service.insert(cid);
				if(k==1) {
					logger.info("Course Enrolled Successfully");
				}else {
					logger.info("Try Again");
				}
				break;
				
			case 3:
				logger.info("------------------------------Unenrolling Course-------------------------");
				logger.info("Enter Course id to Uneroll : ");
				cid = s.nextInt();
				k=service.delete(cid);
				if(k==1) {
					logger.info(" Course Unenrolled Successfully");
				}else {
					logger.info(" Course Not Unenrolled");
				}
				break;
			case 4:
				List<User> list1 =service.getAll();
				logger.info("Course id     " + "Course name     "+  "Course details    "+ "Course duration    "+ "Course trainer   ");
				for(User co:list1) {
					logger.info(co.getCourseid() + "       " + co.getCoursename() + "         " + co.getCoursedetails() + "        "+ co.getCourseduration() + "       " + co.getCoursetrainer() +  "  ");
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
