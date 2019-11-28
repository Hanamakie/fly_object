package com.neuedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	* @description  用户修改密码控制器
	**********************************************************************/
	@RequestMapping(value="checkpassword/{password}/{email}")
	public String checkpassword(@PathVariable("password") String password,@PathVariable("email") String email) {
		
		return "";
	}
}
