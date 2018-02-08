package com.example.test;
import com.example.dao.handleDao;
import com.example.daoImpl.handleDaoImpl;
import com.example.vo.CustomerVo;

public class UpdateTest {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		handleDao dao=new handleDaoImpl();
		CustomerVo vo=dao.selectByCusNo(1003);
		
		vo.setSal(11000);
		
		int i=dao.updataCustomer(vo);
		System.out.println(i);
	}

}
