package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ForgetController {
	@RequestMapping("forget")
	public ModelAndView findpw() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("user/forget");
		return mv;
	}
}
