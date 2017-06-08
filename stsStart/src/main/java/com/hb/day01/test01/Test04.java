package com.hb.day01.test01;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Test04 {

	@RequestMapping("/ex04")
	public String myPage(Model model){
		model.addAttribute("msg", "�𵨷� ����");
		return "ex02";
	}
	
	@RequestMapping("/ex05")
	public String myPage02(){
		return "ex01";
	}
	
	@RequestMapping("/ex06")
	public void myPage03(){}
	
	@RequestMapping("/ex07")
	public String myPage04(Model model, HttpServletRequest req){
		System.out.println(req.getParameter("msg"));
		model.addAttribute("msg", req.getParameter("msg"));
		return "ex07";
	}
	
	@RequestMapping("/ex08")
	public String myPage05(@RequestParam("msg") String msg2){
		System.out.println(msg2);
		return "ex08";
	}
	
	
	@RequestMapping("/path/{a}")
	public String myPage06(@PathVariable String a){
		System.out.println("a:"+a);
		return "ex01";
	}
	
	@RequestMapping("/ex09")
	public String myPage09(){
		return "ex02";
	}
	
	
	@RequestMapping(value="/ex10",method=RequestMethod.POST)
	public String myPage10(String id, String pw, Model model, HttpServletRequest req){
		System.out.println("id:"+id+", pw:"+pw);
		model.addAttribute("id", req.getParameter("id"));
		model.addAttribute("pw", req.getParameter("pw"));
		return "ex03";
	}
}


/*@RequestMapping(value="/ex10",method=RequestMethod.POST)
	public String myPage10(String id, String pw){
		System.out.println("id:"+id+", pw:"+pw);
		return "ex03";
	}*/













