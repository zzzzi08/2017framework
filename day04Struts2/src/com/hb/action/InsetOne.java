package com.hb.action;

import com.hb.model.SimpleDao;
import com.opensymphony.xwork2.ActionSupport;

public class InsetOne extends ActionSupport{
	private String name,nalja;
	private int cnt;
	
	//add.jsp에서의 값(name,nalja,cnt)들을 주입해야하니까 setter필요
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
		System.out.println("1이면 성공:"+result);
		if(result>0)//성공
			return this.SUCCESS;
		else	//입력실패시 input임, error=error error!=input 
			return this.INPUT;
	}
}
