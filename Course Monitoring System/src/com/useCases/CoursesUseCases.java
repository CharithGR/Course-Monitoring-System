package com.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.Course;
import com.dao.CourseDAO;
import com.dao.CourseDAOImpl;
import com.exception.CoursesException;

public class CoursesUseCases {

	 public static final String RESET = "\033[0m";
	 public static final String RED = "\033[0;31m";
	 public static final String GREEN = "\033[0;32m";
	 
	public static void main(String[] args) {
		addNewCourse();	
//		getAllCourseDetails();
//		updateCourseFeesUsindId();
//		deleteCourseByID();

	}
	
	public static void addNewCourse() {
		Scanner sc=new Scanner(System.in);
		
		CourseDAO dao=new CourseDAOImpl();
		Course course =new Course();
		
		
//		System.out.println("Enter Course id");
//		while (!sc.hasNextInt()) 
//		{        
//		    sc.next(); 
//		    System.out.print( RED+"Please enter a valid number "+RESET); 
//		}
//		int id=sc.nextInt();
//		sc.nextLine();
		
		System.out.println("Enter Course Name");
		String name=sc.nextLine();
		
		System.out.println("Enter Course Fees");
		while (!sc.hasNextInt()) 
		{        
		    sc.next(); 
		    System.out.print(RED+"Please enter valid fees amount "+RESET); 
		}
		int fees=sc.nextInt();
		sc.nextLine();
		
		
		System.out.println("Enter Course Description");
		String description=sc.nextLine();
		
		
		course.setFee(fees);
		course.setCourseName(name);
		course.setCourseDescription(description);
		
		String res=null;
		
		try {
			res=dao.addNewCourse(course);
		} catch (CoursesException e) {
			
			e.printStackTrace();
		}
		
		if(res.equals("New Course added successfully"))
			System.out.println(GREEN+""+res+RESET);
		else
			System.out.println(RED+""+res+RESET);
		
		
		
		sc.close();
	}
	
	public static void getAllCourseDetails() {
		
		CourseDAO dao=new CourseDAOImpl();
		
		List<Course> li=new ArrayList<>();
		
		try {
			li=dao.getAllCourseDeatils();
		} catch (CoursesException e) {
			e.printStackTrace();
		}
		
		if(li==null) {
			System.out.println("No courses at this moment");
		}else {
			
			System.out.println(GREEN+"+----------+-------------------+----------+----------------------+\r\n"
					+ "|CourseID  |     CourseName    |   Fees   |   CourseDescription  |\r\n"
					+ "+----------+-------------------+----------+----------------------+"+RESET);
			li.forEach(x->{
				System.out.println(String.format("%11s %19s %10s %22s",String.valueOf(x.getCoursid()),
						x.getCourseName(),
						String.valueOf(x.getFee()),
						x.getCourseDescription()));
				
				
				return;
				});
		}
		
	
	}
	
	public static void updateCourseFeesUsindId() {
		Scanner sc=new Scanner(System.in);
		
		CourseDAO dao=new CourseDAOImpl();
		
		System.out.println("Enter course id");
		while (!sc.hasNextInt()) 
		{        
		    sc.next(); 
		    System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		int id=sc.nextInt();
		System.out.println("Enter new fees amount");
		while (!sc.hasNextInt()) 
		{        
		    sc.next(); 
		    System.out.print(RED+"Please enter valid fees amount "+RESET); 
		}
		int fees=sc.nextInt();
		
		
		String res=null;
		try {
			res=dao.updateCourseFees(id, fees);
		} catch (CoursesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res==null) {
			System.out.println(RED+"Fees not updated"+RESET);
		}else {
			System.out.println(GREEN+res+RESET);
		}
		
		sc.close();
	}
	public static void deleteCourseByID() {
		Scanner sc=new Scanner(System.in);
		
		CourseDAO dao=new CourseDAOImpl();
		
		System.out.println("Enter course id");
		while (!sc.hasNextInt()) 
		{        
		    sc.next(); 
		    System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		int id=sc.nextInt();
		
		String res=null;
		try {
			res=dao.deleteCourse(id);
		} catch (CoursesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res==null) {
			System.out.println(RED+"Course not deleted"+RESET);
		}else {
			System.out.println(GREEN+res+RESET);
		}
		sc.close();
	}
}
