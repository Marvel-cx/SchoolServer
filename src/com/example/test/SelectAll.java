package com.example.test;

import java.util.List;

import com.example.dao.handleDao;
import com.example.daoImpl.handleDaoImpl;
import com.example.vo.AlarmInfo;
import com.example.vo.CustomerVo;

public class SelectAll {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		handleDao dao=new handleDaoImpl();
		String date="2017/10/26";
		List<AlarmInfo> list=dao.selectByTime(date);
		if(list!=null){
			for(AlarmInfo vo:list){
				//System.out.println(vo.getCurrentTimeString()+":"+vo.getHandleReusltString()+":"+vo.getHandleStaString());
				System.out.println(vo.getAlarmTime()+vo.getDetailBuilding());
			}	
		}else{
			System.out.println("nodata");
		}
	}

}
