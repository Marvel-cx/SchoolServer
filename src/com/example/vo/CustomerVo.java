package com.example.vo;
import java.sql.Date;

public class CustomerVo {
	
	private Integer cusno;
	private String cusName;
	private Integer age;
	private Date birthday;
	private int sal;
	private String address;
	public Integer getCusno() {
		return cusno;
	}
	public void setCusno(Integer cusno) {
		this.cusno = cusno;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
