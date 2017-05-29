package com.hb.day03.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet{

	
	@Override
	public void init() throws ServletException {
		super.init();
		
		HendlerMapping.setMap("/main.do", "com.hb.day03.controller.SelectAll");
		
		/*
		list	list.do		get
		detail	detail.do	get


		insert	update.do	post
		update	update.do	put
		delete	update.do	delete
		*/

		
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		//�ּҿ� �ش��ϴ� controller ����
		String uri = req.getRequestURI();
		MyController controller =HendlerMapping.mapping(uri);
		String path = controller.execute(req, res);
		
		//view�� ����
		if(path.startsWith("redirect:")){
			path=path.replace("redirect:", "");
			res.sendRedirect(path);
			return;
		}
		String prifix="/WEB-INF/page/";
		String sufix=".jsp";
		req.getRequestDispatcher(prifix+path+sufix).forward(req, res);
		
	}
}
