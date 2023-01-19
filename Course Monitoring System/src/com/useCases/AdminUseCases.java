package com.useCases;

import java.util.Scanner;

import com.bean.Admin;
import com.dao.AdminDAO;
import com.dao.AdminDAOImpl;
import com.exception.AdminException;

public class AdminUseCases {

	public static void main(String[] args) {
		

	}
	
	@SuppressWarnings("resource")
	public static Admin adminLogin() {
		Scanner sc=new Scanner(System.in);
		Admin admin=new Admin();
		AdminDAO dao=new AdminDAOImpl();
		
		System.out.println("Enter Admin username");
		String email =sc.nextLine();
		
	
		
		System.out.println("Enter Admin password");
		String password=sc.nextLine();
		
		
		
			try {
				admin=dao.adminLogin(email, password);
			} catch (AdminException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
//		sc.close();
		return admin;
	}

}
