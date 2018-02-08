package com.example.vo;

public class PageVo {
	private int pageNow;//��ǰ��ҳ�루�ֶ�����
	private int total;  //�ܼ�¼��ѯ(��ѯ)
	private int offset; //ƫ���������㣩
	private int pageSize=2;//ÿҳ��ʾ������¼���ֶ�����
	private int pageTotal; //��ҳ��
	public int getPageNow(){
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
		//ҳ�汻��ֵʱ��ҳ���Ѿ����ڣ���ʱ����ƫ����
		this.offset=(this.pageNow-1)*this.pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
		if(this.total%this.pageSize==0){
			this.pageTotal=total/this.pageSize;
		}else{
			this.pageTotal=total/this.pageSize+1;
		}
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	
}
