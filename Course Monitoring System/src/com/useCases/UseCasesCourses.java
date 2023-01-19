package com.useCases;

import java.util.Scanner;

import com.bean.Course;
import com.dao.CourseDAO;
import com.dao.CourseDAOImpl;
import com.exception.CoursesException;

public class UseCasesCourses {

	 public static final String RESET = "\033[0m";
	 public static final String RED = "\033[0;31m";
	 public static final String GREEN = "\033[0;32m";
	 
	public static void main(String[] args) {
		addNewCourse();
		

	}
	
	public static void addNewCourse() {
	Scanner sc=new Scanner(System.in);
		
		CourseDAO dao=new CourseDAOImpl();
		Course course =new Course();
		
		
		System.out.println("Enter Course id");
		while (!sc.hasNextInt()) 
		{        
		    sc.next(); 
		    System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		int id=sc.nextInt();
		sc.nextLine();
		
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
		
		
		course.setCoursid(id);
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
}
