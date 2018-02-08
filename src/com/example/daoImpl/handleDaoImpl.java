package com.example.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.handleDao;
import com.example.db.DBConnection;
import com.example.vo.AlarmInfo;
import com.example.vo.CustomerVo;
import com.example.vo.PageVo;
import com.example.vo.TempData;

public class handleDaoImpl implements handleDao{
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet res;
	
	public int saveCustomer(CustomerVo vo) throws Exception {
		String sql="insert into student values(?,?,?,?,?,?)";		
		DBConnection db=new DBConnection();
		conn=db.getConnection();		
		pst=conn.prepareStatement(sql);
		pst.setInt(1,vo.getCusno());
		pst.setString(2,vo.getCusName());
		pst.setInt(3,vo.getAge());
		pst.setDate(4,vo.getBirthday());
		pst.setInt(5,vo.getSal());
		pst.setString(6,vo.getAddress());
		int i=pst.executeUpdate();
		conn.close();
		return i;
	}
	
	public int saveAlrmInfo(String recordNo, String result) throws Exception {
		// TODO Auto-generated method stub		
		String sql="update alarminfo set handleSta='已处理',result='"+result+"' where recordNo='"+recordNo+"'";		
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		
		pst=conn.prepareStatement(sql);
		int i=pst.executeUpdate();
		conn.close();
		return i;		
	}
	//delete
	public int DeleteCustomer(Integer cusno) throws Exception {
		String sql="delete from student where cusno=?";
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1,cusno);
		int i=pst.executeUpdate();
		conn.close();
		return i;
	}	
	//update
	public int updataCustomer(CustomerVo vo) throws Exception {
		String sql="update student set cusName=?,age=?,birthday=?,sal=?,address=?where cusno=?";
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setString(1,vo.getCusName());
		pst.setInt(2,vo.getAge());
		pst.setDate(3,vo.getBirthday());
		pst.setInt(4,vo.getSal());
		pst.setString(5,vo.getAddress());
		pst.setInt(6,vo.getCusno());
		int i=pst.executeUpdate();
		conn.close();
		return i;
	}
	
	//select
	public CustomerVo selectByCusNo(int cusno) throws Exception {
		String sql="select cusno,cusName,age,birthday,sal,address from student where cusno=?";
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1,cusno);
		res=pst.executeQuery();
		CustomerVo cus=null;
		if(res.next()){
			cus=new CustomerVo();
			cus.setCusno(res.getInt(1)); 
			cus.setCusName(res.getString(2));
			cus.setAge(res.getInt(3));
			cus.setBirthday(res.getDate(4));
			cus.setSal(res.getInt(5));
			cus.setAddress(res.getString(6));
			
		}
		conn.close();
		return cus;
	}
	
	//selectAll
	public List<AlarmInfo> selectAll() throws Exception {
		List<AlarmInfo> list=new ArrayList<AlarmInfo>();
		String sql="select a.recordNo,a.alarmTime,a.infraredSta,a.smokeSta,a.occupySta,a.tempSta,a.handleSta,a.result,f.school,f.detailBuilding,f.detailFloor,f.gender,f.siteNum,f.securityNo from alarminfo a,fenbuinfo f where a.device_id=f.deviceID order by a.alarmTime desc limit 0,10;";
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		pst=conn.prepareStatement(sql);
		res=pst.executeQuery();
		while(res.next()){
			AlarmInfo alarmInfo=new AlarmInfo();
			alarmInfo.setRecordNo(res.getString(1));
			alarmInfo.setAlarmTime(res.getString(2));
			alarmInfo.setInfraredSta(res.getString(3));
			alarmInfo.setSmokeSta(res.getString(4));
			alarmInfo.setOccupySta(res.getString(5));
			alarmInfo.setTempSta(res.getString(6));
			alarmInfo.setHandleSta(res.getString(7));
			alarmInfo.setResult(res.getString(8));
			alarmInfo.setSchool(res.getString(9));
			alarmInfo.setDetailBuilding(res.getString(10));
			alarmInfo.setDetailFloor(res.getString(11));
			alarmInfo.setGender(res.getString(12));
			alarmInfo.setSiteNum(res.getString(13));
			alarmInfo.setSecurityNo(res.getString(14));
			list.add(alarmInfo);
		}
		conn.close();
		return list;
	}
	
	//根据时间查询
	public List<AlarmInfo> selectByTime(String date) throws Exception {
		// TODO Auto-generated method stub
		List<AlarmInfo> list=new ArrayList<AlarmInfo>();
		String sql="select a.recordNo,a.alarmTime,a.infraredSta,a.smokeSta,a.occupySta,a.tempSta,a.handleSta,a.result,f.school,f.detailBuilding,f.detailFloor,f.gender,f.siteNum,f.securityNo from alarminfo a,fenbuinfo f where a.device_id=f.deviceID and substring(a.alarmTime,1,10)='"+date+"' order by alarmTime desc;";
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		pst=conn.prepareStatement(sql);
		res=pst.executeQuery();
		if(res.next()){
			res.previous();  
			while(res.next()){
				AlarmInfo alarmInfo=new AlarmInfo();
				alarmInfo.setRecordNo(res.getString(1));
				alarmInfo.setAlarmTime(res.getString(2));
				alarmInfo.setInfraredSta(res.getString(3));
				alarmInfo.setSmokeSta(res.getString(4));
				alarmInfo.setOccupySta(res.getString(5));
				alarmInfo.setTempSta(res.getString(6));
				alarmInfo.setHandleSta(res.getString(7));
				alarmInfo.setResult(res.getString(8));
				alarmInfo.setSchool(res.getString(9));
				alarmInfo.setDetailBuilding(res.getString(10));
				alarmInfo.setDetailFloor(res.getString(11));
				alarmInfo.setGender(res.getString(12));
				alarmInfo.setSiteNum(res.getString(13));
				alarmInfo.setSecurityNo(res.getString(14));
				list.add(alarmInfo);
			}
		}else{
			list=null;
		}		
		conn.close();
		return list;
	}
	
		
	public List<CustomerVo> FenYeSelect(PageVo vo) throws Exception {
		String sql="select cusno,cusName,age,birthday,sal,address from student limit ?,?";
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1,vo.getOffset());
		pst.setInt(2,vo.getPageSize());
		res=pst.executeQuery();
		List<CustomerVo> list=new ArrayList<CustomerVo>();
		while(res.next()){
			CustomerVo cus=new CustomerVo();
			cus.setCusno(res.getInt(1)); 
			cus.setCusName(res.getString(2));
			cus.setAge(res.getInt(3));
			cus.setBirthday(res.getDate(4));
			cus.setSal(res.getInt(5));
			cus.setAddress(res.getString(6));
			list.add(cus);
		}
		conn.close();
		return list;
	}
	
	public int selectTotal() throws Exception {
		String sql="select count(*) as count from student";
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		pst=conn.prepareStatement(sql);
		res=pst.executeQuery();
		int total=0;
		if(res.next()){
			total=res.getInt("count");
		}
		return total;
	}

	public List<TempData> selectData() throws Exception {
		List<TempData> list=new ArrayList<TempData>();
		String sql="select * from school.temp_data order by temp_data_id desc limit 1;";
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		pst=conn.prepareStatement(sql);
		res=pst.executeQuery();
		while(res.next()){
			TempData tempData=new TempData();
			tempData.setTemp_id(res.getString(1));
			tempData.setDevice_id(res.getString(2));
			tempData.setTl(res.getString(3));
			tempData.setTh1(res.getString(4));
			tempData.setVer(res.getString(5));
			tempData.setTvoc(res.getString(6));
			tempData.setDb(res.getString(7));
			
			tempData.setD1_1(res.getString(8));
			tempData.setD1_2(res.getString(9));
			tempData.setD1_3(res.getString(10));
			tempData.setD1_4(res.getString(11));
			tempData.setD1_5(res.getString(12));
			tempData.setD1_6(res.getString(13));
			tempData.setD1_7(res.getString(14));
			tempData.setD1_8(res.getString(15));
			
			tempData.setD2_1(res.getString(16));
			tempData.setD2_2(res.getString(17));
			tempData.setD2_3(res.getString(18));
			tempData.setD2_4(res.getString(19));
			tempData.setD2_5(res.getString(20));
			tempData.setD2_6(res.getString(21));
			tempData.setD2_7(res.getString(22));
			tempData.setD2_8(res.getString(23));
			
			tempData.setD3_1(res.getString(24));
			tempData.setD3_2(res.getString(25));
			tempData.setD3_3(res.getString(26));
			tempData.setD3_4(res.getString(27));
			tempData.setD3_5(res.getString(28));
			tempData.setD3_6(res.getString(29));
			tempData.setD3_7(res.getString(30));
			tempData.setD3_8(res.getString(31));
			
			tempData.setD4_1(res.getString(32));
			tempData.setD4_2(res.getString(33));
			tempData.setD4_3(res.getString(34));
			tempData.setD4_4(res.getString(35));
			tempData.setD4_5(res.getString(36));
			tempData.setD4_6(res.getString(37));
			tempData.setD4_7(res.getString(38));
			tempData.setD4_8(res.getString(39));
			
			tempData.setD5_1(res.getString(40));
			tempData.setD5_2(res.getString(41));
			tempData.setD5_3(res.getString(42));
			tempData.setD5_4(res.getString(43));
			tempData.setD5_5(res.getString(44));
			tempData.setD5_6(res.getString(45));
			tempData.setD5_7(res.getString(46));
			tempData.setD5_8(res.getString(47));
			
			tempData.setD6_1(res.getString(48));
			tempData.setD6_2(res.getString(49));
			tempData.setD6_3(res.getString(50));
			tempData.setD6_4(res.getString(51));
			tempData.setD6_5(res.getString(52));
			tempData.setD6_6(res.getString(53));
			tempData.setD6_7(res.getString(54));
			tempData.setD6_8(res.getString(55));
			
			tempData.setD7_1(res.getString(56));
			tempData.setD7_2(res.getString(57));
			tempData.setD7_3(res.getString(58));
			tempData.setD7_4(res.getString(59));
			tempData.setD7_5(res.getString(60));
			tempData.setD7_6(res.getString(61));
			tempData.setD7_7(res.getString(62));
			tempData.setD7_8(res.getString(63));
			
			tempData.setD8_1(res.getString(64));
			tempData.setD8_2(res.getString(65));
			tempData.setD8_3(res.getString(66));
			tempData.setD8_4(res.getString(67));
			tempData.setD8_5(res.getString(68));
			tempData.setD8_6(res.getString(69));
			tempData.setD8_7(res.getString(70));
			tempData.setD8_8(res.getString(71));
			list.add(tempData);
		}
		conn.close();
		return list;
	}
}
