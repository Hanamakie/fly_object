package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.domain.Customer;
import com.neuedu.domain.Kiss;
import com.neuedu.domain.Release;
import com.neuedu.domain.Special;
import com.neuedu.service.gyl.ArticleAddService;

@Controller
public class ArticleAddController {
	@Autowired
	ArticleAddService articleaddservice;
	
	/**********************************************************************
	*
	* @fileName     ArticleAddController.java
	* @author		GaoYunLong
	* @date		 	2019-12-1
	* @version      V1.0.0
	* @description  文章添加控制器
	**********************************************************************/
	@RequestMapping(value="add")
	public ModelAndView add(HttpSession session){
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("customer2") != null) {
			List<Special> special_column = articleaddservice.getspecial();
			List<Kiss> kiss = articleaddservice.getkiss();
			session.setAttribute("special_column",special_column);
			session.setAttribute("kiss", kiss);
			mv.setViewName("jie/add");
		}else {
			mv.setViewName("user/login");
		}
		return mv;
	}
	
	/**********************************************************************
	*
	* @fileName     ArticleAddController.java
	* @author		GaoYunLong
	* @date		 	2019-12-1
	* @version      V1.0.0
	* @description  文章添加控制器 
	**********************************************************************/
	@RequestMapping(value="publishAnArticle")
	public ModelAndView publishAnArticle(HttpServletRequest request,HttpSession session,Release release,Customer customer) {
		ModelAndView mv = new ModelAndView();
//		获取用户id
		Customer id = (Customer) session.getAttribute("customer2");
		release.setUser_id(id.getId());
//		获取文章分类 
		String special_column = request.getParameter("special_column");
		release.setSpecial_column_id(Integer.valueOf(special_column));
//		获取标题
		release.setTitle(request.getParameter("title"));
//		获取文章内容
		release.setContent(request.getParameter("content"));
//		获取飞吻数
		String kiss = request.getParameter("experience"); 
		release.setFly_kiss_id(Integer.valueOf(kiss));
		articleaddservice.publishAnArticle(release);
		mv.setViewName("jie/add");
		return mv;
	}
}
