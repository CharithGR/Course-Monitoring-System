package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Course;
import com.exception.CoursesException;
import com.utility.DBUtil;

public class CourseDAOImpl implements CourseDAO {

	@Override
	public String addNewCourse(Course course) throws CoursesException {
		String s="New Course not added";
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into courses(courseName, fees, courseDescription) values(?,?,?)");
//			ps.setInt(1, course.getCoursid());
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getFee());
			ps.setString(3, course.getCourseDescription());
			
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

	@Override
	public List<Course> getAllCourseDeatils() throws CoursesException {
		List<Course> li=new ArrayList<>();
		
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from courses");
			ResultSet rs= ps.executeQuery();
			boolean flag=false;
			while(rs.next()) {
				Course course =new Course();
				
				course.setCoursid(rs.getInt("courseid"));
				course.setCourseName(rs.getString("courseName"));
				course.setFee(rs.getInt("fees"));
				course.setCourseDescription(rs.getString("courseDescription"));
				flag=true;
				li.add(course);				
			}
			if(flag)return li;
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CoursesException(e.getMessage());
		}
		
		
		
		
		return null;
	}

	@Override
	public String updateCourseFees(int id, int fees) throws CoursesException {
		
		
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update courses set fees=? where courseid=?");
				
			ps.setInt(1, fees);
			ps.setInt(2, id);		
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				return "Fees updated successfully";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CoursesException(e.getMessage());
		}
		
		
		return null;
	}

	@Override
	public String deleteCourse(int id) throws CoursesException {
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("delete from courses where courseid=?");
				
			ps.setInt(1, id);		
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				return "Course Deleted successfully";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CoursesException(e.getMessage());
		}
		
		
		return null;
	}

}
