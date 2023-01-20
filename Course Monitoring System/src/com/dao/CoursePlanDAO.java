package com.dao;

import java.util.List;

import com.bean.CoursePlan;
import com.bean.CoursePlanDetails;
import com.exception.CoursePlanException;

public interface CoursePlanDAO {	
		public String addNewCoursePlan(CoursePlan coursePlan)throws CoursePlanException;
		public String removeCoursePlan(int id)throws CoursePlanException;
		public String updateStatus(int id,String status)throws CoursePlanException;
		public List<CoursePlanDetails> getAllCoursePlanDeatils()throws CoursePlanException;
		public List<CoursePlanDetails> getAllCoursePlanDeatilsOfAFaculty(int facultyid)throws CoursePlanException;
}


