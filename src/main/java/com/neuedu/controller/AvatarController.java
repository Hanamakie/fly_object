package com.neuedu.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


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
	* @author		GaoYunLong1
	* @date		 	2019-11-25
	* @version      V1.0.0
	* @description  澶村儚涓婁紶鎺у埗鍣�
	**********************************************************************/
	@RequestMapping(value="set/avatar")
//	@InitBinder
	public String avatar(MultipartFile avatar,Customer customer,HttpServletRequest request) {
//		鏃堕棿杞崲锛岄槻姝笂浼犲ご鍍忔椂鍥燿ata杞崲闂1鑰屽寘寮傚父 锛氭牴鎹渶姹傚鍔�
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));,WebDataBinder binder
		System.out.println("鍝堝搱"+avatar);
		String img_name = avatar.getOriginalFilename();
		String imgpath = UUIDUtil.getUUID() + img_name.substring(img_name.indexOf("."));
//		闃叉绯荤粺鏉冮檺鍘熷洜鏃犳硶鐢熸垚鏂囦欢澶癸紝res涓嬪垱寤篴vatar宸插瀛樻斁鐢ㄦ埛澶村儚 ,榛樿澶村儚涓� avatar涓嬬殑default.jpg
		String path = request.getServletContext().getRealPath("/res/avatar/")+imgpath;
		File file = new File(path);
		try {
			avatar.transferTo(file);
			System.out.println(customer.getAvatar());
			customerservice.uploadAvatar(imgpath);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		这是测试
		return "redirect:/set";
	}
}
