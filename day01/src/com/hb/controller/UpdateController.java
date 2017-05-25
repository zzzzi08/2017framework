package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.engine.FrontImp;

public class UpdateController implements FrontImp{

	@Override
	public String execute(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return "update.do";
	}

}
