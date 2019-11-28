package com.neuedu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.neuedu.domain.Customer;
import com.neuedu.service.CustomerService;

@Controller
public class ChangePasswordController {
	@Autowired
	CustomerService customerservice;
	/**********************************************************************
	*
	* @fileName     ChangePasswordController.java
	* @author		GaoYunLong
	* @date		 	2019-11-27
	* @version      V1.0.0
	* @description  用户修改密码（查询用户密码是否正确）控制器
	**********************************************************************/
	@RequestMapping(value="checkpassword/{password}")
	@ResponseBody
	public String checkpassword(@PathVariable("password") String password,Customer customer) {
		String a  = customerservice.checkpassword(password).getPassword();
		String msg = "";
		if(a.equals(password)) {
			customerservice.checkpassword(password);
			msg = "check";
		}else {
			msg = "uncheck";
		}
		return JSON.toJSONString(msg);
	}
	
	/**********************************************************************
	*
	* @fileName     ChangePasswordController.java
	* @author		GaoYunLong
	* @date		 	2019-11-27
	* @version      V1.0.0
	* @description  用户修改密码(更新用户修改密码)控制器
	**********************************************************************/
	@RequestMapping(value="changepass", method=RequestMethod.POST)
	public ModelAndView changepass(Customer customer,HttpServletRequest request,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String password = request.getParameter("repass");
		customerservice.changepass(password);
//		更新密码,清空session,跳转到登录页面
		session.invalidate();
		mv.setViewName("user/login");
		return mv;
	}
}
