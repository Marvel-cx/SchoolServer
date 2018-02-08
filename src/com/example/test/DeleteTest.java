package com.example.test;

import com.example.dao.handleDao;
import com.example.daoImpl.handleDaoImpl;
public class DeleteTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		handleDao dao=new handleDaoImpl();
		int i=dao.DeleteCustomer(1008);
		System.out.println(i);
	}

}
