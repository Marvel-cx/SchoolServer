package com.example.test;

import java.util.List;

import com.example.dao.handleDao;
import com.example.daoImpl.handleDaoImpl;
import com.example.vo.TempData;

public class temp_test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		handleDao dao=new handleDaoImpl();
		List<TempData> list=dao.selectData();
		if(list != null){
			for(TempData vo:list){
				System.out.println(vo.getTemp_id()+" "+vo.getD1_2());
			}
		}else{
			System.out.println("nodata");
		}
	}

}
