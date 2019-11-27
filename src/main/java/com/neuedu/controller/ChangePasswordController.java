package com.neuedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	* @description  用户修改密码控制器
	**********************************************************************/
	@RequestMapping(value="checkpassword/{password}")
	@ResponseBody
	public String checkpassword(@PathVariable("password") String password) {
		System.out.println("前台获取的密码："+password);
		System.out.println("数据局："+customerservice.changepassword(password));
		String a  = customerservice.changepassword(password).getPassword();
		String msg = "";
		if(a.equals(password)) {
			customerservice.changepassword(password);
			System.out.println("数据局："+customerservice.changepassword(password));
			msg = "check";
		}else {
			msg = "uncheck";
		}
		return msg;
	}

}
