package com.hb.day01.test01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03 {

	@RequestMapping("/ex03.do")
	public String myPage02(HttpServletRequest req){
		req.setAttribute("msg", "�� ���� �Ǿ���?");
		return "ex01";
	}
}
