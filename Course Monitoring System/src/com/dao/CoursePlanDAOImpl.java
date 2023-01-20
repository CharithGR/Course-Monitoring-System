package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.CoursePlan;
import com.bean.CoursePlanDetails;
import com.exception.CoursePlanException;
import com.utility.DBUtil;

public class CoursePlanDAOImpl implements CoursePlanDAO {

	@Override
	public String addNewCoursePlan(CoursePlan coursePlan) throws CoursePlanException {
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into coursePlan(batchid, dayNumber, topic,status)"
					+ " values(?,?,?,?)");
		ps.setInt(1, coursePlan.getBatchId());
			ps.setInt(2, coursePlan.getDaynumber());
			ps.setString(3, coursePlan.getTopic());
			ps.setString(4, coursePlan.getStatus());
			int rows=ps.executeUpdate();
			if(rows>0) {
				return "New Course Plan added successfully";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		return null;
	}

	@Override
	public String removeCoursePlan(int id) throws CoursePlanException {
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("delete from coursePlan where planid=?");
					ps.setInt(1, id);
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				return " Course Plan removed successfully";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		return null;
	}

	@Override
	public String updateStatus(int id,String status) throws CoursePlanException {
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement ps=conn.prepareStatement(" update courseplan set status=? where planid=? ");
					
			ps.setString(1, status);
			ps.setInt(2, id);
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				return " Course Plan status updated successfully";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<CoursePlanDetails> getAllCoursePlanDeatils() throws CoursePlanException {
		try(Connection conn=DBUtil.getConnection()){
			List<CoursePlanDetails> li=new ArrayList<>();
			PreparedStatement ps=conn.prepareStatement("select c.planid,c.batchid,f.facultyName,c.dayNumber,c.topic,c.status from \r\n"
					+ "coursePlan c inner join batch b inner join faculty f on\r\n"
					+ "c.batchid=b.batchid and b.facultyid=f.facultyid");
						
			ResultSet rs= ps.executeQuery();
			boolean flag=false;
			while(rs.next()) {
				flag=true;
				CoursePlanDetails cp=new CoursePlanDetails();
				
				cp.setPlanId(rs.getInt("planid"));
				cp.setBatchId(rs.getInt("Batchid"));
				cp.setDaynumber(rs.getInt("dayNumber"));
				cp.setFacultyname(rs.getString("facultyname"));
				cp.setTopic(rs.getString("topic"));
				cp.setStatus(rs.getString("status"));
				li.add(cp);
			}
			if(flag)return li;
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<CoursePlanDetails> getAllCoursePlanDeatilsOfAFaculty(int facultyid) throws CoursePlanException {
		try(Connection conn=DBUtil.getConnection()){
			List<CoursePlanDetails> li=new ArrayList<>();
			PreparedStatement ps=conn.prepareStatement("select c.planid,c.batchid,f.facultyName,c.dayNumber,c.topic,c.status from \r\n"
					+ "coursePlan c inner join batch b inner join faculty f on\r\n"
					+ "c.batchid=b.batchid and b.facultyid=f.facultyid and b.facultyid=?");
					ps.setInt(1, facultyid);	
			ResultSet rs= ps.executeQuery();
			boolean flag=false;
			while(rs.next()) {
				flag=true;
				CoursePlanDetails cp=new CoursePlanDetails();
				
				cp.setPlanId(rs.getInt("planid"));
				cp.setBatchId(rs.getInt("Batchid"));
				cp.setDaynumber(rs.getInt("dayNumber"));
				cp.setFacultyname(rs.getString("facultyname"));
				cp.setTopic(rs.getString("topic"));
				cp.setStatus(rs.getString("status"));
				li.add(cp);
			}
			if(flag)return li;
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		return null;
	}

	

}
