package com.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.Batch;
import com.bean.BatchDetails;
import com.dao.BatchDAO;
import com.dao.BatchDAOImpl;
import com.exception.BatchException;

public class BatchUsesCases {
	private static Scanner sc=new Scanner(System.in);

	 public static final String RESET = "\033[0m";
	 public static final String RED = "\033[0;31m";
	 public static final String GREEN = "\033[0;32m";
	
	public static void main(String[] args) {
		addNewBatch();
//		getBatchDeatils();
//		removebatch();
//		updateFaculty();
	}

	public static void addNewBatch() {
		BatchDAO dao=new BatchDAOImpl();
		
		Batch batch =new Batch();
		
//		System.out.println("Enter Batch ID");
//		while (!sc.hasNextInt()) 
//		{        
//		    sc.next(); 
//		    System.out.print( RED+"Please enter a valid number "+RESET); 
//		}
//		batch.setBatchId(sc.nextInt());
		
		
		System.out.println("Enter Course ID");
		while (!sc.hasNextInt()) 
		{        
		    sc.next(); 
		    System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		batch.setCourseId(sc.nextInt());
		
		System.out.println("Enter Faculty ID");
		while (!sc.hasNextInt()) 
		{        
		    sc.next(); 
		    System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		batch.setFacultyId(sc.nextInt());
		
		
		
		System.out.println("Enter Number of Students in batch");
		while (!sc.hasNextInt()) 
		{        
		    sc.next(); 
		    System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		batch.setNumberofStudents(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Enter Batch Start Date");
		batch.setBatchstartDate(sc.nextLine());
		
		System.out.println("Enter Duration");
		while (!sc.hasNextInt()) 
		{        
		    sc.next(); 
		    System.out.print( RED+"Please enter a valid number "+RESET); 
		}
		batch.setDuration(sc.nextInt());
		
		String res=null;
		 try {
			res=dao.addNewBatch(batch);
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if(res==null)System.out.println(RED+"Batch not added"+RESET);
		 else	System.out.println(GREEN+res+RESET);
		 
			
	}
	
	
	public static void getBatchDeatils() {
		BatchDAO dao=new BatchDAOImpl();
		List<BatchDetails> li=new ArrayList<>();
		
		try {
			li=dao.getAllBatchDeatils();
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(li==null)System.out.println(RED+"No Batches at the moment"+RESET);
		 else	{
			 
		 System.out.println(GREEN+"\r\n"
		 		+ "+-------+--------+-------------+-----------+----------------+----------------+----------+\r\n"
		 		+ "|BatchID|CourseID| facultyName |Coursename |NumberOfStudents| BatchStartDate | Duration |\r\n"
		 		+ "+-------+--------+-------------+-----------+----------------+----------------+----------+"+RESET);
			 li.forEach(x->{
				 System.out.println(String.format("%8s %8s %13s %10s %16s %17s %10s",
						 x.getBatchId(),x.getCourseId(),x.getFacultyName(),
						 x.getCourseName(),x.getNumberofStudents(),x.getBatchstartDate(),
						 x.getDuration()
						 ));
			 });
		 }
		 
		
		
	}
	
	public static void removebatch() {
		BatchDAO dao=new BatchDAOImpl();
		
		
		
		System.out.println("Enter batch id");
		while (!sc.hasNextInt()) 
			{        
			    sc.next(); 
			    System.out.print( RED+"Please enter a valid number "+RESET); 
			}
			int id=(sc.nextInt());
			
			
		String res=null;
		try {
			res=dao.removebatch(id);
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res==null)System.out.println(RED+"Batch not deleted"+RESET);
		 else	System.out.println(GREEN+res+RESET);
			
	}
	public static void updateFaculty() {
		BatchDAO dao=new BatchDAOImpl();
		
		
		
		System.out.println("Enter batch id");
		while (!sc.hasNextInt()) 
			{        
			    sc.next(); 
			    System.out.print( RED+"Please enter a valid number "+RESET); 
			}
			int bacthid=(sc.nextInt());
			System.out.println("Enter new faculty id");
			while (!sc.hasNextInt()) 
				{        
				    sc.next(); 
				    System.out.print( RED+"Please enter a valid number "+RESET); 
				}
				int facultyid=(sc.nextInt());
			
		String res=null;
		try {
			res=dao.updateFaculty(facultyid, bacthid);
		} catch (BatchException e) {
			e.printStackTrace();
		}
		
		if(res==null)System.out.println(RED+"New Faculty to batch not updated"+RESET);
		 else	System.out.println(GREEN+res+RESET);
	}
	
	public static void getAllBatchDetailsOfparticularfaculty(int facultyid) {
		BatchDAO dao=new BatchDAOImpl();
		List<BatchDetails> li=new ArrayList<>();
		
		try {
			li=dao.getAllBatchDeatilsOfparticularfaculty(facultyid);
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(li==null)System.out.println(RED+"No Batches at the moment"+RESET);
		 else	{
			 
		 System.out.println(GREEN+"\r\n"
		 		+ "+-------+--------+-------------+-----------+----------------+----------------+----------+\r\n"
		 		+ "|BatchID|CourseID| facultyName |Coursename |NumberOfStudents| BatchStartDate | Duration |\r\n"
		 		+ "+-------+--------+-------------+-----------+----------------+----------------+----------+"+RESET);
			 li.forEach(x->{
				 System.out.println(String.format("%8s %8s %13s %10s %16s %17s %10s",
						 x.getBatchId(),x.getCourseId(),x.getFacultyName(),
						 x.getCourseName(),x.getNumberofStudents(),x.getBatchstartDate(),
						 x.getDuration()
						 ));
			 });
		 }
	}
}
