package com.hb.action;

import com.hb.model.SimpleDao;
import com.opensymphony.xwork2.ActionSupport;

public class InsetOne extends ActionSupport{
	private String name,nalja;
	private int cnt;
	
	//add.jsp������ ��(name,nalja,cnt)���� �����ؾ��ϴϱ� setter�ʿ�
	public void setName(String name) {
		this.name = name;
	}

	public void setNalja(String nalja) {
		this.nalja = nalja;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String execute() throws Exception {
		SimpleDao dao = new SimpleDao();
		int result = dao.insertOne(name,nalja,cnt);
		System.out.println("1�̸� ����:"+result);
		if(result>0)//����
			return this.SUCCESS;
		else	//�Է½��н� input��, error=error error!=input 
			return this.INPUT;
	}
}
