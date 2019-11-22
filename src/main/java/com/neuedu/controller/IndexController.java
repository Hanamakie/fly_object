package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		GaoYunLong
	* @date		 	2019-11-22
	* @version      V1.0.0
	* @description  首页控制器
	**********************************************************************/
	@RequestMapping(value="/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
