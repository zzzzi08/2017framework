package com.hb.day06am;

import java.sql.SQLException;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.day06am.model.GuestDao;
import com.hb.day06am.model.GuestVo;
import com.hb.day06am.service.ServiceCommand;
import com.hb.day06am.service.ServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private ServiceCommand service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("/guest/list")
	public void listPage(Model model) throws SQLException{
		service.listService(sqlSession, model);
	}
	@RequestMapping(value="/guest/add",method=RequestMethod.GET)
	public void addPage(){
	}
	@RequestMapping(value="/guest/add",method=RequestMethod.POST)
	public String insertPage(@ModelAttribute GuestVo bean) throws SQLException{
		service.addService(sqlSession, bean);
		return "redirect:list";
	}
	
	@RequestMapping("/guest/detail/{idx}")
	public String detailPage(@PathVariable int idx,Model model) throws SQLException{
		service.detailService(sqlSession, model, idx);
		return "guest/detail";
	}
	@RequestMapping(value="/guest/edit/{idx}"
			,method=RequestMethod.GET)
	public String editPage(@PathVariable int idx,Model model) throws SQLException{
		service.detailService(sqlSession, model, idx);
		return "guest/edit";
	}
	
	@RequestMapping(value="/guest/edit/{idx}"
			,method=RequestMethod.POST)
	public String updatePage(@ModelAttribute GuestVo bean
			,@PathVariable int idx) throws SQLException{
		service.editService(sqlSession, bean);
		return "redirect:../detail/"+idx;
	}
	
	@RequestMapping(value="/guest/del/{idx}")
	public String deletePage(@PathVariable int idx) throws SQLException{
		service.deleteService(sqlSession, idx);
		return "redirect:../list";
	}
}

