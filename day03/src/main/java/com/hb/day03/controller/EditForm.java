package com.hb.day03.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day03.model.SimpleDao;
import com.hb.day03.support.MyController;

public class EditForm implements MyController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("title", "����");
		req.setAttribute("nxtURI", "update.do");
		String idx=req.getParameter("idx");
		SimpleDao dao = new SimpleDao();
		try {
			req.setAttribute("bean", dao.selectOne(Integer.parseInt(idx)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "form";
	}

}
