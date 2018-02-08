package com.example.test;

import java.util.List;

import com.example.dao.handleDao;
import com.example.daoImpl.handleDaoImpl;
import com.example.vo.CustomerVo;
import com.example.vo.PageVo;

public class FenYeSelect {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		handleDao dao=new handleDaoImpl();
		PageVo vo=new PageVo();
		vo.setPageNow(3);
		vo.setTotal(dao.selectTotal());
		List<CustomerVo> list=dao.FenYeSelect(vo);
		if(list!=null){
			for(CustomerVo vo1:list){
				System.out.println(vo1.getCusno()+":"+vo1.getCusName()+":"+vo1.getAddress());
			}
		}
		System.out.println("��ǰҳ��:"+vo.getPageNow()+"�ܼ�¼��:"+vo.getTotal()+"��ҳ��"+vo.getPageTotal());
	}
}