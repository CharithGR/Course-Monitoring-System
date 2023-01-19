package com.main;

import java.util.Scanner;

import com.bean.Admin;
import com.useCases.AdminUseCases;

public class Main {
	private static Scanner sc=new Scanner(System.in);
	
	
	public static final String RESET = "\033[0m";
	public static final String RED = "\033[0;31m";
	public static final String GREEN = "\033[0;32m";

	public static void main(String[] args) {
		

		System.out.println("Welcome to Course Monitoring System");
		System.out.println("\n1. Admin Login");
		System.out.println("2. Faculty Login");
		System.out.println("3. Exit");
		while(true) {
			
			while (!sc.hasNextInt()) 
			{        
				sc.next(); 
				System.out.println( RED+"Please enter a valid number "+RESET); 
			}
			int choice = sc.nextInt();
			
			boolean flag=true;
			switch(choice){
			case 1:adminLogin();
			break;
			case 2:facultyLogin();
			break;
			case 3:System.out.println(GREEN+"Thank You for using course monitoring system"+RESET);
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
	public static void adminLogin() {
		
		Admin admin=new Admin();
		
		admin=AdminUseCases.adminLogin();
		
		if(admin==null) {			
			System.out.println(RED+"Incorrect username or password"+RESET);
			System.out.println("Press y to try again or any other key to exit");
				String choice=sc.next();
				if(choice.equalsIgnoreCase("y"))adminLogin();	
			
		}else {
			System.out.println(GREEN+"Login Successful");
			System.out.println("Welcome "+ admin.getUsername()+RESET);
			
		}
		AdminLoggedIn.adminLoggedIn();
		
	}
	public static void facultyLogin() {
		
	}


}
