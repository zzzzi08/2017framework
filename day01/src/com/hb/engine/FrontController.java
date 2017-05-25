package com.hb.engine;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.AddController;
import com.hb.controller.DetailController;
import com.hb.controller.InsertController;
import com.hb.controller.ListController;
import com.hb.model.SimpleDao;

public class FrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doDo(req, resp);
	}
	
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String url="/";
		String url="";
		String path=req.getRequestURI();
		

			try {
				SimpleDao dao = new SimpleDao();
				
				if(path.equals("/day01/list.do")){
					ListController controller=new ListController();
					url=controller.execute(req);
				}else  if(path.equals("/day01/detail.do")){
					DetailController controller = new DetailController();
					url=controller.execute(req);
				}else  if(path.equals("/day01/add.do")){
					AddController controller = new AddController();
					url=controller.execute(req);
				}else if("POST".equals(req.getMethod())&&path.equals("/day01/insert.do")){
					InsertController controller = new InsertController();
					url=controller.execute(req);
				}
				dao.close();
//				url+=".jsp";
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
	
		//view
		
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
