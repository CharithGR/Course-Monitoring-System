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

	 public static final String RESET = "\033[0m";
	 public static final String RED = "\033[0;31m";
	 public static final String GREEN = "\033[0;32m";
	
	public static void main(String[] args) {
//		addNewBatch();
		getBatchDeatils();
	}

	public static void addNewBatch() {
		Scanner sc=new Scanner(System.in);
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
		 
			
		sc.close();
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
		 
			 li.forEach(x->System.out.println(x));
		 }
		 
		
		
	}
	
}
