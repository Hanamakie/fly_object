package com.neuedu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


import com.neuedu.domain.Customer;
import com.neuedu.domain.Kiss;
import com.neuedu.domain.Release;
import com.neuedu.domain.Special;
import com.neuedu.service.CustomerService;
import com.neuedu.service.gyl.ArticleAddService;

@Controller
@SessionAttributes(value= {"customer2","user","user_addtime"})
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
	public ModelAndView login(HttpSession session){
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
	public String loginin(Customer customer,HttpSession session){
		Customer customer2  = customerservice.getCustomer(customer);
		if(customer != null){
			if(customer.getEmail().equals(customer2.getEmail()) && customer2.getPassword().equals(customer2.getPassword()) ) {
				System.out.println("1"+customer2);
				session.setAttribute("customer2", customer2);
				return "redirect:/index";
			}else {
				return "redirect:/login";
			}
		}else{
			return "redirect:/login";
		}
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
	* @author		GaoYunLong
	* @date		 	2019-11-25
	* @version      V1.0.0
	* @description  用户界面主页控制器
	**********************************************************************/
	@RequestMapping(value="index")
	public ModelAndView userindex(Customer customer,HttpSession session){
		ModelAndView mv = new ModelAndView();
		Customer id = (Customer) session.getAttribute("customer2");
		System.out.println("阿萨德很快就爱上"+id);
		List<Release> release= articleaddservice.postrelease(id.getId());
		int count = articleaddservice.getreleasecount(id.getId());
		for(Release x:release) {
	        Date time = new Date(x.getCreate_time());
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String create_time = sdf.format(time);
			mv.addObject("create_time", create_time);
		}
		Customer user = articleaddservice.user(id.getId());
        Date time =new Date(user.getAdd_time());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String user_addtime = sdf.format(time);
        System.out.println("哈哈哈"+user_addtime);
        session.setAttribute("user_addtime", user_addtime);
        session.setAttribute("user", user);
		mv.addObject("release", release);
		mv.addObject("count", count);
		mv.setViewName("user/index");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		GaoYunLong
	* @date		 	2019-11-25
	* @version      V1.0.0
	* @description  我的主页控制器
	**********************************************************************/
	@RequestMapping(value="home")
	public ModelAndView home(HttpSession session){
		ModelAndView mv = new ModelAndView();
		Customer id = (Customer) session.getAttribute("customer2");
		List<Release> homecount= articleaddservice.posthomecount(id.getId());
		Customer user = articleaddservice.user(id.getId());
		for(Release x:homecount) {
	        Date time =new Date(x.getCreate_time());
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String hometime = sdf.format(time);
	        mv.addObject("hometime", hometime);
		}
        session.setAttribute("user", user);
		mv.addObject("homecount", homecount);
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
	public ModelAndView detail(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView();
		Release sumcontext = articleaddservice.getsumcontext(id);
        Date time = new Date(sumcontext.getCreate_time());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String create_time = sdf.format(time);
        mv.addObject("create_time", create_time);
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
		mv.addObject("kiss", kiss);
		mv.addObject("sumcontext", sumcontext);
		mv.addObject("special_column", special_column);
		mv.setViewName("jie/edit");
		return mv;
	}
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		GaoYunLong
	* @date		 	2019-12-11
	* @version      V1.0.0
	* @description 	后台用户更新编辑帖子控制器
	**********************************************************************/
	@RequestMapping(value="updatenovel/{id}")
	public ModelAndView updatenovel(@PathVariable("id") int id,HttpSession session,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Release release = new Release();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int special_column_id = Integer.parseInt(request.getParameter("special_column")); 
		release.setId(id);
		release.setTitle(title);
		release.setContent(content);
		release.setSpecial_column_id(special_column_id);
		articleaddservice.updatecontent(release);
//		数据回显
		Release sumcontext = articleaddservice.getsumcontext(id);
		List<Special> special_column = articleaddservice.getspecial();
		List<Kiss> kiss = articleaddservice.getkiss();
		mv.addObject("kiss", kiss);
		mv.addObject("sumcontext", sumcontext);
		mv.addObject("special_column", special_column);
		mv.setViewName("jie/edit");
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
	@RequestMapping(value="del/{id}")
	public ModelAndView del(@PathVariable("id") int id,HttpSession session){
		ModelAndView mv = new ModelAndView();
		articleaddservice.delcontent(id);
//		数据回显
		Customer id_id = (Customer) session.getAttribute("customer2");
		List<Release> release= articleaddservice.postrelease(id_id.getId());
		int count = articleaddservice.getreleasecount(id_id.getId());
		mv.addObject("release", release);
		mv.addObject("count", count);
		mv.setViewName("user/index");
		return mv;
	}
}