package com.hb.day03.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day03.support.MyController;

public class AddForm implements MyController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("title", "�Է�");
		req.setAttribute("nxtURI", "insert.do");
		return "form";
	}

}
