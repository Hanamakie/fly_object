package com.neuedu.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.domain.Customer;
import com.neuedu.service.CustomerService;

@Controller
public class IndexController {
	@Autowired
	CustomerService customerservice;
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
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		ChangEnYing
	* @date		 	2019-11-23
	* @version      V1.0.0
	* @description  登陆页面控制器
	**********************************************************************/
	@RequestMapping(value="login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		ChangEnYing
	* @date		 	2019-11-23
	* @version      V1.0.0
	 * @throws IOException 
	* @description  登陆页面控制器
	**********************************************************************/
	@RequestMapping(value="loginin")
	@ResponseBody
	public String loginin(Customer customer,HttpSession session){
		System.out.println(customer);
		Customer customer2 = new Customer();
		customer2 = customerservice.getCustomer(customer);
		System.out.println(customer2);
		ModelAndView mv = new ModelAndView();
		String s="";
		if(customer != null){
			s="success";
			session.setAttribute("customer", customer2);
		}else{
			s="error";
		}
		return s;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		ChangEnYing
	* @date		 	2019-11-23
	* @version      V1.0.0
	* @description  注册控制器
	**********************************************************************/
	@RequestMapping(value="reg")
	public ModelAndView reg(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/reg");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		ChangEnYing
	* @date		 	2019-11-25
	* @version      V1.0.0
	 * @throws IOException 
	* @description  用户界面主页控制器
	**********************************************************************/
	@RequestMapping(value="userindex")
	public ModelAndView userindex(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/index");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		ChangEnYing
	* @date		 	2019-11-25
	* @version      V1.0.0
	 * @throws IOException 
	* @description  我的主页控制器
	**********************************************************************/
	@RequestMapping(value="home")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/home");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		ChangEnYing
	* @date		 	2019-11-25
	* @version      V1.0.0
	 * @throws IOException 
	* @description  基本设置控制器
	**********************************************************************/
	@RequestMapping(value="set")
	public ModelAndView set(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/set");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		ChangEnYing
	* @date		 	2019-11-25
	* @version      V1.0.0
	 * @throws IOException 
	* @description  我的消息控制器
	**********************************************************************/
	@RequestMapping(value="message")
	public ModelAndView message(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/message");
		return mv;
	}
}