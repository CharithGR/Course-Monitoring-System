package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.Course;
import com.exception.CoursesException;
import com.utility.DBUtil;

public class CourseDAOImpl implements CourseDAO {

	@Override
	public String addNewCourse(Course course) throws CoursesException {
		String s="New Course not added";
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into courses values(?,?,?,?)");
			ps.setInt(1, course.getCoursid());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getFee());
			ps.setString(4, course.getCourseDescription());
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				s="New Course added successfully";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CoursesException(e.getMessage());
		}
		return s;
	}

}
