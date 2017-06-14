package com.hb.day06am;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.day06am.model.GuestDao;
import com.hb.day06am.model.GuestVo;

@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping("/guest/list")
	public void listPage(Model model){
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			model.addAttribute("alist", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/guest/add", method=RequestMethod.GET)
	public void addPage(){}
	
	@RequestMapping(value="/guest/add", method=RequestMethod.POST)
	public String insertPage(@ModelAttribute GuestVo bean){
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	
	@RequestMapping("/guest/detail/{idx}")
	public String detailPage(@PathVariable int idx, Model model){
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			model.addAttribute("bean", dao.selectOne(idx));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "guest/detail";
	}
	
	@RequestMapping(value="/guest/detail/{idx}", method=RequestMethod.GET)
	public String editPage(@PathVariable int idx, Model model){
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			model.addAttribute("bean", dao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "guest/edit";
	}
	
	
	@RequestMapping(value="/guest/edit/{idx}",method=RequestMethod.POST)
	public String updatePage(@PathVariable int idx,@ModelAttribute GuestVo bean){
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:../detail/"+idx;
	}
	
	@RequestMapping("/guest/del/{idx}")
	public String deletePage(@PathVariable int idx){
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			dao.deleteOne(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:../list";
	}
	
	
	
}
