package com.main;

import java.util.Scanner;

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
		System.out.println("\n1.Get All faculty details");
		System.out.println("2.Add faculty");
		System.out.println("3.Remove faculty");
		System.out.println("4.Log Out");
		while(true) {

			while (!sc.hasNextInt()) 
			{        
				sc.next(); 
				System.out.println( RED+"Please enter a valid number "+RESET); 
			}
			int choice = sc.nextInt();

			boolean flag=true;
			switch(choice){
			case 1:FacultyUseCases.getAllFacultyDetails();;
			break;
			case 2:FacultyUseCases.addFaculty();
			break;
			case 3:FacultyUseCases.removeFaculty();
			break;			
			case 4:logout();
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

	}
	public static void batch() {

	}
	public static void coursePlan() {

	}


	public static void logout() {
		Main.main(null);
	}


}
