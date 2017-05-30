package com.hb.action;

import java.util.List;
import java.util.Map;

import com.hb.model.SimpleDao;
import com.opensymphony.xwork2.ActionSupport;

public class SelectAll extends ActionSupport{
	private List<Map<String,Object>> list;
	
	public List<Map<String,Object>> getList(){
		
		return list;
	}

	@Override
	public String execute() throws Exception {
		SimpleDao dao = new SimpleDao();	//dao 객체 생성
//		List<Map<String,Object>> list = dao.selectAll();//dao의 selectAll() 호출하면 list 반환되므로 받음. 근데 언제든 가져다 쓸수있게 필드로 뺌
		list = dao.selectAll();
		
		
		return this.SUCCESS;
	}
}
