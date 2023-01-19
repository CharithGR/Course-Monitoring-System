package com.dao;

import com.bean.Admin;
import com.exception.AdminException;

public interface AdminDAO {

	public Admin adminLogin(String username, String password)throws AdminException;
	
}
