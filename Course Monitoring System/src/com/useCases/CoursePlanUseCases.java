package com.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.CoursePlan;
import com.bean.CoursePlanDetails;
import com.dao.CoursePlanDAO;
import com.dao.CoursePlanDAOImpl;
import com.exception.CoursePlanException;

public class CoursePlanUseCases {

	private static Scanner sc=new Scanner(System.in);

	public static final String RESET = "\033[0m";
	public static final String RED = "\033[0;31m";
	public static final String GREEN = "\033[0;32m";

	public static void main(String[] args) {
		addNewCoursePlan();
//		updateStatus();
//		getallCoursePlanDetails();
	}

	public static void addNewCoursePlan() {
		CoursePlan coursePlan=new CoursePlan();
		CoursePlanDAO dao=new CoursePlanDAOImpl();



		System.out.println("Enter Batch id");
		while (!sc.hasNextInt()) 
		{        
			sc.next(); 
			System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		coursePlan.setBatchId(sc.nextInt());


		System.out.println("Enter day Number( Monday-1, Tuesday-2...)");
		while (!sc.hasNextInt()) 
		{        
			sc.next(); 
			System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		coursePlan.setDaynumber(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter Topic");
		coursePlan.setTopic(sc.nextLine());

		System.out.println("Enter Status - Pending/Completed");
		String temp=null;
		while(sc.hasNextLine()) {
			temp=sc.nextLine();
			if(temp.equalsIgnoreCase("Pending") || temp.equalsIgnoreCase("Completed"))break;
			else System.out.println("Please enter Pending or Completed only");
		}

		coursePlan.setStatus(temp);

		String res=null;

		try {
			res= dao.addNewCoursePlan(coursePlan);
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res==null)System.out.println(RED+"Course Plan not added"+RESET);
		else	System.out.println(GREEN+res+RESET);



	}
	public static void removeCoursePlanByid() {
		CoursePlanDAO dao=new CoursePlanDAOImpl();		


		System.out.println("Enter plan id");
		while (!sc.hasNextInt()) 
		{        
			sc.next(); 
			System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		int id=(sc.nextInt());


		String res=null;
		try {
			res=dao.removeCoursePlan(id);
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(res==null)System.out.println(RED+"Course Plan not added"+RESET);
		else	System.out.println(GREEN+res+RESET);

	}
	public static void updateStatus() {
		CoursePlanDAO dao=new CoursePlanDAOImpl();		


		System.out.println("Enter plan id");
		while (!sc.hasNextInt()) 
		{        
			sc.next(); 
			System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		int id=(sc.nextInt());
		sc.nextLine();
		String status=null;
		try {
			status=(dao.getStatus(id));
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temp=null;
		
		if(status.equalsIgnoreCase("pending")) {
			temp="Completed";
		}else if(status.equalsIgnoreCase("completed")) {
			temp="Pending";
		}
		
		
		
		
//		System.out.println("Enter Status - Pending/Completed");
//		String temp=null;
//		while(sc.hasNextLine()) {
//			temp=sc.nextLine();
//			if(temp.equalsIgnoreCase("Pending") || temp.equalsIgnoreCase("Completed"))break;
//			else System.out.println("Please enter Pending or Completed only");
//		}
		
		String res=null;
		try {
			res=dao.updateStatus(id, temp);
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(res==null)System.out.println(RED+"Course Plan status not updated"+RESET);
		else	System.out.println(GREEN+res+RESET);

	}
	public static void  getallCoursePlanDetails() {
		CoursePlanDAO dao=new CoursePlanDAOImpl();
		List<CoursePlanDetails>li=new ArrayList<>();
		
		try {
			li=dao.getAllCoursePlanDeatils();
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(li==null)System.out.println(RED+"No Course Plan at the moment please"+RESET);
		else	{
			System.out.println(GREEN+"+--------+---------+-------------+-----------+--------------------+----------------+\r\n"
					+ "| PlanID | BatchID | facultyName | DayNumber |       Topic        |     Status     |\r\n"
					+ "+--------+---------+-------------+-----------+--------------------+----------------+"+RESET);
			li.forEach(x->{
				
				String day=null;
				switch(x.getDaynumber()) {
			      case 1:
			        day="Monday";
			        break;
			      case 2:
			    	  day="Tuesday";
			        break;
			      case 3:
			    	  day="Wednesday";
			        break;
			      case 4:
			    	  day="Thursday";
			        break;
			      case 5:
			    	  day= "Friday";			        
			        break;
			      case 6:
			    	  day="Saturday";
			        break;
			      case 7:
			    	  day="Sunday";
			        break;       
			      default:
			    	  day="Invalid day number";
			        break;                      
			    } 
				
				
				 System.out.println(String.format("%9s %8s %13s %12s %20s %16s",
						 x.getPlanId(),x.getBatchId(),x.getFacultyname(),
						 x.getDaynumber()+"("+day+")",x.getTopic(),x.getStatus()
						 ));
		});
		}
	}
	
	public static void getAllCoursePlanOfParticularFaculty(int facultyid) {
		CoursePlanDAO dao=new CoursePlanDAOImpl();
		List<CoursePlanDetails>li=new ArrayList<>();
		
		try {
			li=dao.getAllCoursePlanDeatilsOfAFaculty(facultyid);
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(li==null)System.out.println(RED+"No Course Plan at the moment please"+RESET);
		else	{
			System.out.println(GREEN+"+--------+---------+-------------+-----------+--------------------+----------------+\r\n"
					+ "| PlanID | BatchID | facultyName | DayNumber |       Topic        |     Status     |\r\n"
					+ "+--------+---------+-------------+-----------+--------------------+----------------+"+RESET);
			li.forEach(x->{
				
				String day=null;
				switch(x.getDaynumber()) {
			      case 1:
			        day="Monday";
			        break;
			      case 2:
			    	  day="Tuesday";
			        break;
			      case 3:
			    	  day="Wednesday";
			        break;
			      case 4:
			    	  day="Thursday";
			        break;
			      case 5:
			    	  day= "Friday";			        
			        break;
			      case 6:
			    	  day="Saturday";
			        break;
			      case 7:
			    	  day="Sunday";
			        break;       
			      default:
			    	  day="Invalid day number";
			        break;                      
			    } 
				
				 System.out.println(String.format("%9s %8s %13s %12s %20s %16s",
						 x.getPlanId(),x.getBatchId(),x.getFacultyname(),
						 x.getDaynumber()+"("+day+")",x.getTopic(),x.getStatus()
						 ));
		});
		}
	}
}
