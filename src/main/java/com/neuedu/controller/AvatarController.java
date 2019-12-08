package com.neuedu.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.domain.Customer;
import com.neuedu.service.CustomerService;
import com.neuedu.util.UUIDUtil;

@Controller
public class AvatarController {
	
	@Autowired
	CustomerService customerservice;
	
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		GaoYunLong
	* @date		 	2019-11-25
	* @version      V1.0.0
	* @description  头像上传控制器
	**********************************************************************/
	@RequestMapping(value="set/avatar")
//	@InitBinder
	public ModelAndView avatar(MultipartFile avatar,HttpServletRequest request,HttpSession session) {
//		时间转换，防止上传头像时因data转换问题而包异常 ：根据需求增加
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));,WebDataBinder binder
		Customer customer2 = null;
		customer2 = (Customer) session.getAttribute("customer2");
		ModelAndView mv = new ModelAndView();
		String img_name = avatar.getOriginalFilename();
		String imgpath = UUIDUtil.getUUID() + img_name.substring(img_name.indexOf("."));
		customer2.setAvatar(imgpath);
//		防止系统权限原因无法生成文件夹，res下创建avatar已备存放用户头像 ,默认头像为 avatar下的default.jpg
		String path = request.getServletContext().getRealPath("/res/avatar/")+imgpath;
		File file = new File(path);
		try {
			avatar.transferTo(file);
			customerservice.uploadAvatar(customer2);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("imgpath",imgpath);
		mv.setViewName("user/set");
		return mv;
	}
}
