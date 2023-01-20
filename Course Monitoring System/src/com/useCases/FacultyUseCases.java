package com.useCases;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.Faculty;
import com.dao.FacultyDAO;
import com.dao.FacultyDaoImpl;
import com.exception.FacultyException;

public class FacultyUseCases {
 
	private static Scanner sc=new Scanner(System.in);

	
	
	 public static final String RESET = "\033[0m";
	 public static final String RED = "\033[0;31m";
	 public static final String GREEN = "\033[0;32m";
	 
	public static void main(String[] args) {
		
		addFaculty();
//		getAllFacultyDetails();
	}

	
	public static void addFaculty() {
		Faculty faculty =new Faculty();
		FacultyDAO dao=new FacultyDaoImpl();
		
//		System.out.println("Enter Faculty id");
//		while (!sc.hasNextInt()) 
//		{        
//		    sc.next(); 
//		    System.out.print( RED+"Please enter a valid number "+RESET); 
//		}
//		faculty.setFacultyid(sc.nextInt());
//		sc.nextLine();
		
		System.out.println("Enter Faculty Name");
		faculty.setFacultyname(sc.nextLine());
		
		System.out.println("Enter Faculty Address");
		faculty.setFacultyaddress(sc.nextLine());
		
		System.out.println("Enter Faculty mobile");
		faculty.setMobile(sc.nextLine());
		
		System.out.println("Enter Faculty email");
		faculty.setEmail(sc.nextLine());
		
		System.out.println("Enter Faculty username");
		faculty.setUsername(sc.nextLine());
		
		System.out.println("Enter Faculty password");
		faculty.setPassword(sc.nextLine());
		
		
		
		String res=null;
		try {
			res=dao.addnewFaculty(faculty);
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res==null) {
			System.out.println(RED+"Faculty data not added"+RESET);
		}else {
			System.out.println(GREEN+res+RESET);
		}
		
	}
	
	public static void getAllFacultyDetails() {

		List<Faculty> li=new ArrayList<>();
		
		FacultyDAO dao=new FacultyDaoImpl();
		
		try {
			li=dao.getAllFacultyDetails();
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(li==null) {
			
		}else {
			System.out.println(GREEN+"+-----------+----------------+----------------+-----------------+----------------------+------------------+-----------------+\r\n"
					+ "| FacultyID |   FacultyName  | FacultyAddress |      Mobile     |         Email        |      Username    |     Password    |\r\n"
					+ "+-----------+----------------+----------------+-----------------+----------------------+------------------+-----------------+"+RESET);
			li.forEach(x->{
				System.out.println(String.format("%12s %14s %18s %17s %22s %18s %17s",
						x.getFacultyid(),x.getFacultyname(),x.getFacultyaddress(),
						x.getMobile(),x.getEmail(),x.getUsername(),x.getPassword()
						));
				});
		}
	}
	public static Faculty facultyLogin() {
		Faculty faculty =new Faculty();
		FacultyDAO dao=new FacultyDaoImpl();
		
		System.out.println("Enter Faculty email");
		String email =sc.nextLine();
		
	
		
		System.out.println("Enter Faculty password");
		String password=sc.nextLine();
		
		
		try {
			faculty=dao.facultyLogin(email, password);
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		return faculty;
	}
	
	public static void removeFaculty() {
		FacultyDAO dao=new FacultyDaoImpl();
		System.out.println("Enter faculty id to delete");
		
		while (!sc.hasNextInt()) 
			{        
			    sc.next(); 
			    System.out.print( RED+"Please enter a valid number "+RESET); 
			}
			int id=sc.nextInt();
		
		String res=null;
		
		try {
			res=dao.removeFaculty(id);
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res==null) {
			System.out.println(RED+"Faculty data not deleted"+RESET);
		}else {
			System.out.println(GREEN+res+RESET);
		}
		
	}
	
	public static void updatepassword(String email,String password) {
		FacultyDAO dao=new FacultyDaoImpl();
		
		String res=null;
		
		try {
			res=dao.updatePassword(email, password);
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res==null) {
			System.out.println(RED+"Your Password was not updated"+RESET);
		}else {
			System.out.println(GREEN+res+RESET);
		}
	}
}
