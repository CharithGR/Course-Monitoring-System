package com.main;

import java.util.Scanner;

import com.useCases.BatchUsesCases;
import com.useCases.CoursePlanUseCases;
import com.useCases.CoursesUseCases;
import com.useCases.FacultyUseCases;

public class AdminLoggedIn {

	private static Scanner sc=new Scanner(System.in);


	public static final String RESET = "\033[0m";
	public static final String RED = "\033[0;31m";
	public static final String GREEN = "\033[0;32m";

	public static void adminLoggedIn() {

		System.out.println("\n1.Faculty");
		System.out.println("2.Courses");
		System.out.println("3.Batch");
		System.out.println("4.Course Plan");
		System.out.println("5.Log Out");
		while(true) {

			while (!sc.hasNextInt()) 
			{        
				sc.next(); 
				System.out.println( RED+"Please enter a valid number "+RESET); 
			}
			int choice = sc.nextInt();

			boolean flag=true;
			switch(choice){
			case 1:faculty();
			break;
			case 2:courses();
			break;
			case 3:batch();
			break;
			case 4:coursePlan();
			break;
			case 5:logout();
			break;
			default:flag=false;	
			break;
			}
			if(flag) break;
			else {
				System.out.println( RED+"Please enter a valid choice "+RESET); 
			}			

		}
	}
	public static void faculty() {
		System.out.println("\n1.Get details of all faculty");
		System.out.println("2.Add faculty");
		System.out.println("3.Remove faculty");
		System.out.println("4.Back");
		System.out.println("5.Log Out");
		while(true) {

			while (!sc.hasNextInt()) 
			{        
				sc.next(); 
				System.out.println( RED+"Please enter a valid number "+RESET); 
			}
			int choice = sc.nextInt();

			boolean flag=true;
			switch(choice){
			case 1:FacultyUseCases.getAllFacultyDetails();
			faculty();
			break;
			case 2:FacultyUseCases.addFaculty();
			faculty();
			break;
			case 3:FacultyUseCases.removeFaculty();
			faculty();
			break;	
			case 4:adminLoggedIn();
			break;
			case 5:logout();
			break;
			default:flag=false;	
			break;
			}
			if(flag) break;
			else {
				System.out.println( RED+"Please enter a valid choice "+RESET); 
			}			

		}



	}
	public static void courses() {
		System.out.println("\n1.Get details of all courses ");
		System.out.println("2.Add new course");
		System.out.println("3.Remove course");
		System.out.println("4.Update course fees");
		System.out.println("5.Update course description");
		System.out.println("6.Back");
		System.out.println("7.Log Out");
		while(true) {

			while (!sc.hasNextInt()) 
			{        
				sc.next(); 
				System.out.println( RED+"Please enter a valid number "+RESET); 
			}
			int choice = sc.nextInt();

			boolean flag=true;
			switch(choice){
			case 1:CoursesUseCases.getAllCourseDetails();
			courses();
			break;
			case 2:CoursesUseCases.addNewCourse();
			courses();
			break;
			case 3:CoursesUseCases.deleteCourseByID();
			courses();
			break;	
			case 4:CoursesUseCases.updateCourseFeesUsindId();
			courses();
			break;
			case 5:CoursesUseCases.updateCourseDescriprion();
			courses();
			break;
			case 6:adminLoggedIn();
			break;
			case 7:logout();
			break;
			default:flag=false;	
			break;
			}
			if(flag) break;
			else {
				System.out.println( RED+"Please enter a valid choice "+RESET); 
			}			

		}



	}
	public static void batch() {

		System.out.println("\n1.Get details of all batches");
		System.out.println("2.Add new batch");
		System.out.println("3.Remove course");
		System.out.println("4.Update  batch faculty");
		System.out.println("5.Back");
		System.out.println("6.Log Out");
		while(true) {

			while (!sc.hasNextInt()) 
			{        
				sc.next(); 
				System.out.println( RED+"Please enter a valid number "+RESET); 
			}
			int choice = sc.nextInt();

			boolean flag=true;
			switch(choice){
			case 1:BatchUsesCases.getBatchDeatils();
			batch();
			break;
			case 2:BatchUsesCases.addNewBatch();
			batch();
			break;
			case 3:BatchUsesCases.removebatch();
			batch();
			break;	
			case 4:BatchUsesCases.updateFaculty();
			batch();
			break;			
			case 5:adminLoggedIn();
			break;
			case 6:logout();
			break;
			default:flag=false;	
			break;
			}
			if(flag) break;
			else {
				System.out.println( RED+"Please enter a valid choice "+RESET); 
			}			

		}
	}
	public static void coursePlan() {

		System.out.println("\n1.Get details of all coursePlan");
		System.out.println("2.Get details of all coursePlan of particular faculty");
		System.out.println("3.Add new coursePlan");
		System.out.println("4.Remove coursePlan");
		System.out.println("5.Update  coursePlan status");
		System.out.println("6.Back");
		System.out.println("7.Log Out");
		while(true) {

			while (!sc.hasNextInt()) 
			{        
				sc.next(); 
				System.out.println( RED+"Please enter a valid number "+RESET); 
			}
			int choice = sc.nextInt();

			boolean flag=true;
			switch(choice){
			case 1:CoursePlanUseCases.getallCoursePlanDetails();
			coursePlan();
			break;
			case 2:System.out.println("Enter faculty id");
			while (!sc.hasNextInt()) 
			{        
				sc.next(); 
				System.out.println( RED+"Please enter a valid number "+RESET); 
			} 
			int id=sc.nextInt();
			CoursePlanUseCases.getAllCoursePlanOfParticularFaculty(id);
			coursePlan();
			break;
			case 3:CoursePlanUseCases.addNewCoursePlan();
			coursePlan();
			break;	
			case 4:CoursePlanUseCases.removeCoursePlanByid();
			coursePlan();
			break;		
			case 5:CoursePlanUseCases.updateStatus();
			coursePlan();
			break;
			case 6:adminLoggedIn();
			break;
			case 7:logout();
			break;
			default:flag=false;	
			break;
			}
			if(flag) break;
			else {
				System.out.println( RED+"Please enter a valid choice "+RESET); 
			}			

		}







	}


	public static void logout() {
		System.out.println(GREEN+"Logout Successfull"+RESET);


		Main.main(null);
	}


}
