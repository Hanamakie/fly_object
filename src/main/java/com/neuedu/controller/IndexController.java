package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.neuedu.domain.Customer;
import com.neuedu.domain.Kiss;
import com.neuedu.domain.Release;
import com.neuedu.domain.Special;
import com.neuedu.service.CustomerService;
import com.neuedu.service.gyl.ArticleAddService;

@Controller
@SessionAttributes("customer2")
public class IndexController {
	@Autowired
	CustomerService customerservice;
	@Autowired
	ArticleAddService articleaddservice;
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
	* @description  登陆页面控制器
	**********************************************************************/
	@RequestMapping(value="loginin")
	@ResponseBody
	public String loginin(Customer customer,HttpSession session){
		Customer customer2 = new Customer();
		customer2 = customerservice.getCustomer(customer);
		String s="";
		if(customer != null){
			s="success";
			session.setAttribute("customer2", customer2);
		}else{
			s="error";
		}
		return JSON.toJSONString(s);
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
	* @description  用户界面主页控制器
	**********************************************************************/
	@RequestMapping(value="index")
	public ModelAndView userindex(Customer customer,HttpSession session){
		ModelAndView mv = new ModelAndView();
		Customer id = (Customer) session.getAttribute("customer2");
		List<Release> release= articleaddservice.postrelease(id.getId());
		int count = articleaddservice.getreleasecount(id.getId());
		mv.addObject("release", release);
		mv.addObject("count", count);
		mv.setViewName("user/index");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		ChangEnYing
	* @date		 	2019-11-25
	* @version      V1.0.0
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
	* @description  我的消息控制器
	**********************************************************************/
	@RequestMapping(value="message")
	public ModelAndView message(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/message");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		GaoYunLong
	* @date		 	2019-12-03
	* @version      V1.0.0
	* @description  用户退出控制器
	**********************************************************************/
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpSession session,HttpServletRequest request,SessionStatus sessionStatus){
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("customer2");//我这里是先取出httpsession中的user属性
		request.getSession().invalidate();//然后是让httpsession失效
		sessionStatus.setComplete();//最后是调用sessionStatus方法
		mv.setViewName("index");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		GaoYunLong
	* @date		 	2019-12-06
	* @version      V1.0.0
	* @description  后台帖子控制器
	**********************************************************************/
	@RequestMapping(value="detail/{id}")
	public ModelAndView detail(@PathVariable("id") int id,Release release){
		ModelAndView mv = new ModelAndView();
		Release sumcontext = articleaddservice.getsumcontext(id);
		System.out.println("文章信息"+JSON.toJSONString(sumcontext));
		mv.addObject("sumcontext", sumcontext);
		mv.setViewName("jie/detail");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		GaoYunLong
	* @date		 	2019-12-07
	* @version      V1.0.0
	* @description 	后台用户编辑帖子控制器
	**********************************************************************/
	@RequestMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id,HttpSession session){
		ModelAndView mv = new ModelAndView();
		Release sumcontext = articleaddservice.getsumcontext(id);
		List<Special> special_column = articleaddservice.getspecial();
		List<Kiss> kiss = articleaddservice.getkiss();
		session.setAttribute("special_column",special_column);
		session.setAttribute("kiss", kiss);
		mv.addObject("sumcontext", sumcontext);
		mv.setViewName("jie/edit");
		return mv;
	}
}