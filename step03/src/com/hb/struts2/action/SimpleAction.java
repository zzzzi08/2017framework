package com.hb.struts2.action;

import java.sql.SQLException;
import java.util.List;

import com.hb.struts2.model.SimpleDao;
import com.hb.struts2.model.SimpleVo;

public class SimpleAction{
	private List<SimpleVo> list;
	
	public List<SimpleVo> getList() {
		return list;
	}
	public void setList(List<SimpleVo> list) {
		this.list = list;
	}
	
	public String execute(){
		return "errors";
	}
	
	public String list(){
		SimpleDao dao = new SimpleDao();
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String add(){
		return "success";
	}
	
	public String detail(){
		return "success";
	}
	
	public String edit(){
		return "success";
	}
	public String insert(){
		return "success";
	}
}
