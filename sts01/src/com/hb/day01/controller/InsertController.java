package com.hb.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.day01.model.SimpleDao;
import com.hb.day01.model.SimpleVo;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		if(req.getMethod().equals("POST")){	//post = �������� ����
			req.setCharacterEncoding("UTF-8");
			SimpleDao dao = new SimpleDao();
			SimpleVo bean = new SimpleVo( 		//�Ķ���� ���� �����ϱ����� bean��ü ����
					Integer.parseInt(req.getParameter("sabun")),req.getParameter("name"), null, Integer.parseInt(req.getParameter("pay")));	
			
			if(dao.insertOne(bean)>0){
				mav.setViewName("redirect:list.do");
			}else{
				mav.setViewName("add");
			}
		}else{	//�߸��� �����̹Ƿ� ��� ����
			mav.setViewName("add");
		}
		return mav;
	}

}
