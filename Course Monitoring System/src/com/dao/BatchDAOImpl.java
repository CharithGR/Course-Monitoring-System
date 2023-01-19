package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Batch;
import com.bean.BatchDetails;
import com.exception.BatchException;
import com.utility.DBUtil;

public class BatchDAOImpl implements BatchDAO {

	@Override
	public String addNewBatch(Batch batch) throws BatchException {
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into batch(courseid ,facultyid,numberOfStudents,batchStartDate ,duration)"
					+ " values(?,?,?,?,?)");
//			ps.setInt(1, batch.getBatchId());
			ps.setInt(1, batch.getCourseId());
			ps.setInt(2, batch.getFacultyId());
			ps.setInt(3, batch.getNumberofStudents());
			ps.setString(4, batch.getBatchstartDate());
			ps.setInt(5, batch.getDuration());
		
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				return "New Batch added successfully";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		
		
		return null;
	}

	@Override
	public List<BatchDetails> getAllBatchDeatils() throws BatchException {
		try(Connection conn=DBUtil.getConnection()){
			List<BatchDetails> li=new ArrayList<>();
			boolean flag=false;
			PreparedStatement ps=conn.prepareStatement("select b.BatchID, b.CourseID, "
					+ "b.facultyID, f.facultyName,c.courseName,b.NumberOfStudents, "
					+ "b.BatchStartDate, b.Duration from \r\n"
					+ "Batch b inner join faculty f inner join courses c On \r\n"
					+ "b.facultyid=f.facultyid and b.courseid=c.courseid "
					+ "order by b.batchStartDate asc;");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				flag=true;
				BatchDetails batch=new BatchDetails();
				batch.setBatchId(rs.getInt("BatchID"));
				batch.setCourseId(rs.getInt("CourseID"));
				batch.setFacultyId(rs.getInt("facultyID"));
				batch.setFacultyName(rs.getString("facultyName"));
				batch.setCourseName(rs.getString("courseName"));
				batch.setNumberofStudents(rs.getInt("NumberOfStudents"));
				batch.setBatchstartDate(rs.getString("BatchStartDate"));
				batch.setDuration(rs.getInt("Duration"));
				li.add(batch);				
			}
			if(flag)return li;
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		return null;
	}

}
