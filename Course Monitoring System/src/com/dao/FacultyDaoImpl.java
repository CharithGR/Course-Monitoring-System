package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Course;
import com.bean.Faculty;
import com.exception.CoursesException;
import com.exception.FacultyException;
import com.utility.DBUtil;

public class FacultyDaoImpl implements FacultyDAO {

	@Override
	public String addnewFaculty(Faculty facutly) throws FacultyException {
		
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into faculty  (facultyName ,facultyAddress,mobile ,email ,username ,password) values(?,?,?,?,?,?)");
//			ps.setInt(1, facutly.getFacultyid());
			ps.setString(1, facutly.getFacultyname());
			ps.setString(2, facutly.getFacultyaddress());
			ps.setString(3, facutly.getMobile());
			ps.setString(4, facutly.getEmail());
			ps.setString(5, facutly.getUsername());
			ps.setString(6, facutly.getPassword());
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				return "New faculty added successfully";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		
		
		return null;
	}

	@Override
	public List<Faculty> getAllFacultyDetails() throws FacultyException {
		List<Faculty> li=new ArrayList<>();
		
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from faculty");
			ResultSet rs= ps.executeQuery();
			boolean flag=false;
			while(rs.next()) {
				Faculty faculty=new Faculty();
				
				faculty.setFacultyid(rs.getInt("facultyid"));
				faculty.setFacultyname(rs.getString("facultyName"));
				faculty.setFacultyaddress(rs.getString("facultyAddress"));
				faculty.setMobile(rs.getString("mobile"));
				faculty.setEmail(rs.getString("email"));
				faculty.setUsername(rs.getString("username"));
				faculty.setPassword(rs.getString("password"));
				
				
				flag=true;
				li.add(faculty);				
			}
			if(flag)return li;
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		
		
		return null;
	}

	@Override
	public Faculty facultyLogin(String email,String password) throws FacultyException {
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from faculty where email=? and password=? ");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			boolean flag=false;
			Faculty faculty=new Faculty();
			if(rs.next()) {
				
				
				faculty.setFacultyid(rs.getInt("facultyid"));
				faculty.setFacultyname(rs.getString("facultyName"));
				faculty.setFacultyaddress(rs.getString("facultyAddress"));
				faculty.setMobile(rs.getString("mobile"));
				faculty.setEmail(rs.getString("email"));
				faculty.setUsername(rs.getString("username"));
				faculty.setPassword(rs.getString("password"));
				
				
				flag=true;
			}
			if(flag)return faculty;
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		return null;
	}

	@Override
	public String removeFaculty(int id) throws FacultyException {
	
try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("delete from faculty where facultyid=?");
			ps.setInt(1, id);			
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				return "Faculty data deleted successfully";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return null;
	}
 
}
