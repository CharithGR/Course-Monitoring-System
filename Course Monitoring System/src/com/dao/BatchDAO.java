package com.dao;

import java.util.List;

import com.bean.Batch;
import com.bean.BatchDetails;
import com.exception.BatchException;

public interface BatchDAO {
	
	public String addNewBatch(Batch batch)throws BatchException;
	public String removebatch(int id)throws BatchException;
	public List<BatchDetails> getAllBatchDeatils()throws BatchException;
	public List<BatchDetails> getAllBatchDeatilsOfparticularfaculty(int facultyId)throws BatchException;
	public String updateFaculty(int id,int newId)throws BatchException;
}

