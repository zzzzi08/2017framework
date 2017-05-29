package com.hb.day03.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day03.model.SimpleDao;
import com.hb.day03.model.SimpleVo;
import com.hb.day03.support.MyController;

public class InsertOne implements MyController{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(!"POST".equals(req.getMethod())){
			return "err";
		}
		req.setCharacterEncoding("UTF-8");
		SimpleDao dao = new SimpleDao();
		
		try{
			String name = req.getParameter("name");
			String nalja=req.getParameter("nalja");
			int cnt = Integer.parseInt(req.getParameter("cnt"));
			
			int result = dao.insertOne(name,nalja,cnt);
			if(result>0){
				return "redirect:main.do";
			}else{
				return "form";
			}
		}catch (Exception e){
			return "form";
		}
		
	}

}
