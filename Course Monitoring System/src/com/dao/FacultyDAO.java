package com.dao;

import java.util.List;

import com.bean.Faculty;
import com.exception.FacultyException;

public interface FacultyDAO {
	public String addnewFaculty(Faculty facutly) throws FacultyException;
	public List<Faculty> getAllFacultyDetails() throws FacultyException;
	public Faculty facultyLogin(String email,String password)throws FacultyException;
	public String removeFaculty(int id)throws FacultyException;
	public String updatePassword(String email,String password)throws FacultyException;;
	
}
