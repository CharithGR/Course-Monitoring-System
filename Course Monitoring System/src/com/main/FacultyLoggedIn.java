package com.main;

import java.util.Scanner;

import com.bean.Faculty;
import com.useCases.BatchUsesCases;
import com.useCases.CoursePlanUseCases;
import com.useCases.FacultyUseCases;

public class FacultyLoggedIn {
	private static Scanner sc=new Scanner(System.in);

	private static Faculty faculty=null;


	public static final String RESET = "\033[0m";
	public static final String RED = "\033[0;31m";
	public static final String GREEN = "\033[0;32m";
	
	
	public static void facultyloggedIn(Faculty fac) {
		faculty=fac;


		System.out.println("\n1.View all your Batches");
		System.out.println("2.View all your CoursePlan");
		System.out.println("3.Change CoursePlan Status");
		System.out.println("4.Change Password");
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
			case 1:batch();
			break;
			case 2:coursePlan();
			break;
			case 3:coursePlanStatusChange();
			break;
			case 4:sc.nextLine();
				changePassword();
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

	public static void batch() {
		BatchUsesCases.getAllBatchDetailsOfparticularfaculty(faculty.getFacultyid());
		facultyloggedIn(faculty);
	}

	public static void coursePlan() {

		CoursePlanUseCases.getAllCoursePlanOfParticularFaculty(faculty.getFacultyid());		
		facultyloggedIn(faculty);
	}
	public static void coursePlanStatusChange() {
		CoursePlanUseCases.updateStatus();
		facultyloggedIn(faculty);
	}
	
	public static void changePassword() {
		
		System.out.println("Enter current password");
		String currentPassword=sc.nextLine();
//		System.out.println(currentPassword+" "+faculty.getPassword()+" "+faculty.getPassword().equals(currentPassword));
		while(!faculty.getPassword().equals(currentPassword)) {
			System.out.println(RED+"Incorrect password"+RESET);
			System.out.println("Press y to try again or any other key to exit");
				String choice=sc.nextLine();
				if(choice.equalsIgnoreCase("y")) {					
					changePassword();
					return;
					}
				else {
					facultyloggedIn(faculty);
				break;
				}
			
		}
		System.out.println("Enter new password");
		String password=sc.nextLine();
		while(faculty.getPassword().equals(password)) {
			System.out.println(RED+"New Password cannot be same as current password"+RESET);
			System.out.println("Enter new password");
			password=sc.nextLine();
		}
		
		FacultyUseCases.updatepassword(faculty.getEmail(),password );
		facultyloggedIn(faculty);
		
	}
	public static void logout() {
		System.out.println(GREEN+"Logout Successfull"+RESET);


		Main.main(null);
	}
}
