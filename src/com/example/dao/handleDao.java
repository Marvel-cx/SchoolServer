package com.example.dao;

import java.util.List;

import com.example.vo.AlarmInfo;
import com.example.vo.CustomerVo;
import com.example.vo.PageVo;
import com.example.vo.TempData;

public interface handleDao {
	
	public int saveCustomer(CustomerVo vo) throws Exception;
	
	public int DeleteCustomer(Integer cusno) throws Exception;
	
	public int updataCustomer(CustomerVo vo) throws Exception;
	
	public CustomerVo selectByCusNo(int cusno) throws Exception;
	//
	public List<AlarmInfo> selectAll() throws Exception;
	//
	public int saveAlrmInfo(String recordNo,String result) throws Exception;
	//
	public List<AlarmInfo> selectByTime(String date) throws Exception;
	//
	public List<TempData> selectData() throws Exception;
	public int selectTotal() throws Exception;
	
	public List<CustomerVo> FenYeSelect(PageVo vo) throws Exception;
}
