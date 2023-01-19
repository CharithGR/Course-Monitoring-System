package com.dao;

import java.util.List;

import com.bean.Course;
import com.exception.CoursesException;

public interface CourseDAO {
	public String addNewCourse(Course course)throws CoursesException;
	public List<Course> getAllCourseDeatils()throws CoursesException;
	public String updateCourseFees(int id,int fees)throws CoursesException;
	public String deleteCourse(int id)throws CoursesException;;
}
