package com.hb.day02me.support;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day02me.controller.AddController;
import com.hb.day02me.controller.InsertController;
import com.hb.day02me.controller.ListController;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		HandlerMapping.setMap("/day02me/list.do", "com.hb.day02me.controller.ListController");
		HandlerMapping.setMap("/day02me/add.do", "com.hb.day02me.controller.AddController");
		HandlerMapping.setMap("/day02me/insert.do", "com.hb.day02me.controller.InsertController");
	}
	


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// /list.do		<get>		-> /page/list.jsp			->list
		// /detail.do	<get>		-> /page/detail.jsp			->detail
		// /add.do		<get>		-> /page/form.jsp			->form
		// /insert.do	<post>		-> redirect: list.do		->redirect: list.do
		// /edit.do		<get>		-> /page/form.jsp 재사용	->form
		// /update.do	<post>		-> redirect: detail.do		->redirect: detail.do
		// /del.do		<post>		-> redirect: detail.do		->redirect: detail.do
		
		
		//controller
		String uri = request.getRequestURI();
		MyController controller = HandlerMapping.mapping(uri);
		String pname = controller.execute(request, response);
		
		
		//view
		String url=null;
		if(pname.startsWith("redirect:")){		//redirect로 시작하면 들어온 문자열 바로 반환하고 아닌것들은 
												// request.getRequestDispatcher(url).forward(request, response); 여기감
			url=pname.replace("redirect:", "");
			response.sendRedirect(url);
			return;
		}
		
		String prifix = "/page/";
		String sufix = ".jsp";
		url= prifix+pname+sufix;
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
