package com.dao;

import com.bean.Course;
import com.exception.CoursesException;

public interface CourseDAO {
	public String addNewCourse(Course course)throws CoursesException;
}
