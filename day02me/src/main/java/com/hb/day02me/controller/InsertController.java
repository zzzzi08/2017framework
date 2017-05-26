package com.hb.day02me.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day02me.model.SimpleDao;
import com.hb.day02me.model.SimpleVo;
import com.hb.day02me.support.MyController;

public class InsertController implements MyController{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parma1=request.getParameter("name");
		String parma2=request.getParameter("nalja");
		String parma3=request.getParameter("cnt");
		
		SimpleVo vo = new SimpleVo();
		vo.setName(parma1);
		vo.setNalja(parma2);
		vo.setCnt(Integer.parseInt(parma3));
		SimpleDao dao = new SimpleDao();
		int result=dao.insertOne(vo);

		return "redirect:list.do";
	}

}
