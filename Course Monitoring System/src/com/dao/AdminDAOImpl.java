package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Admin;
import com.exception.AdminException;
import com.utility.DBUtil;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public Admin adminLogin(String username, String password) throws AdminException {
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from admin where username=? and password=? ");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			boolean flag=false;
			Admin admin=new Admin();
			if(rs.next()) {
				
				
				
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				
				
				flag=true;
			}
			if(flag)return admin;
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		return null;
	}

}
