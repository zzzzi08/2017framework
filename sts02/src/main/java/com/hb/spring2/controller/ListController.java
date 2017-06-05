package com.hb.spring2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.spring2.model.DaoImpl;
import com.hb.spring2.model.SimpleDao;

public class ListController implements Controller {
	private DaoImpl dao;	//��ü������ dao�� null�̹Ƿ� sts02-servlet.xml ���� ���Թ޾ƾ��� ���Թ������� setter(setdao)�ʿ�
	
	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
//		SimpleDao dao = new SimpleDao();
		mav.addObject("alist", dao.selectAll());
		mav.setViewName("list");
		
		return mav;
	}

}
