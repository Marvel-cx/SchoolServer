package com.example.test;

import java.sql.Date;

import com.example.dao.handleDao;
import com.example.daoImpl.handleDaoImpl;
import com.example.vo.CustomerVo;

public class SaveTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		handleDao dao=new handleDaoImpl();
		CustomerVo vo=new CustomerVo();
		vo.setCusno(1010);
		vo.setAddress("shanghai");
		vo.setAge(19);
		vo.setBirthday(Date.valueOf("1990-10-10"));
		vo.setCusName("rose");
		vo.setSal(9000);
		int i=dao.saveCustomer(vo);
		System.out.println(i);
	}

}
