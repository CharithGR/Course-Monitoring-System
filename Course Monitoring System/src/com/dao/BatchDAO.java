package com.dao;

import java.util.List;

import com.bean.Batch;
import com.bean.BatchDetails;
import com.exception.BatchException;

public interface BatchDAO {
	
	public String addNewBatch(Batch batch)throws BatchException;
	public List<BatchDetails> getAllBatchDeatils()throws BatchException;
}
