package com.cms.controller;


import java.util.Scanner;
import java.util.logging.Logger;



public class Main {
	static Logger logger = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {

		logger.info("= = = = = = = = = = = = = = = = = = = = = = WELCOME = = = = = = = = = = = = = = = = = = = = = = = =");
		logger.info("-------------------------------COURSE MANAGEMENT SYSTEM-----------------------------");
		logger.info("1.Press for Admin");
		logger.info("2.Press for user");
	     Scanner s=new Scanner(System.in);
	     int sc= s.nextInt();
	     switch (sc) {
		case 1: {
			new CourseController().main();
			
			break;
		}
		case 2: 
			new UserController().main();
			
			break;
		default:
			logger.info("Unexpected value try again : "  );
		}
	     s.close();
		
	}

}
