package com.hb.day03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hb.day03.model.dao.GuestDao;

/*
	 ����ƮǮ
	 
	 ��� : 	/list		get(�ּ�ǥ���ٿ� ���°�)
	 �� : 	/guest/{1}	get
	 �Է���: 	/guest		get
	 �Է� :		/guest		post(�ּ�ǥ���ٿ� ������ �ʴ°�)
	 ���� : 	/guest/{1}	put
	 ���� : 	/guest/{1}	delete
	 
 */
@Controller
public class SelectContoller {
	@Autowired
	private GuestDao guestDao;
	
	@RequestMapping("/list")
	public ModelAndView selectAll(ModelAndView mav){
		try{
			mav.addObject("alist", guestDao.selectAll());
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		mav.setViewName("list");
		
		return mav;
	}
	
	@RequestMapping(value="/guest/{idx}",method=RequestMethod.GET)
	public String selectOne(@PathVariable int idx,Model model){
		try {
			model.addAttribute("bean", guestDao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "detail";
	}

}
