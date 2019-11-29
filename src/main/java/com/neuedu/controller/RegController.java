package com.neuedu.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.domain.Customer;
import com.neuedu.service.CustomerService;

@Controller
public class RegController {
	/**********************************************************************
	*
	* @fileName     RegController.java
	* @author		KstarMing
	* @date		 	2019-11-25
	* @version      V1.0.0
	* @description  注册
	**********************************************************************/
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="reg2")
	public String reg( Customer customer){
		customerService.addcustomer(customer);
		return "user/reg";
	}
	/*@RequestMapping(value="testemail")
	@ResponseBody
	public String testemail(String email) {
		String mail = "";
		
		return ;
		
	}*/
	
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		KstarMing
	* @date		 	2019-11-23
	* @version      V1.0.0
	* @description  验证邮箱格式
	**********************************************************************/
	@RequestMapping(value="testemail")
	@ResponseBody
	public String testemail(String email) {
			
			String s1 = null;
			int j = email.indexOf(".") ;
			int a = email.indexOf("@") ;
				if(a < 1 || j < 1) {
//					s1 ="您输入的邮箱类型不包含@或·，格式错误";
					s1 = "NO@";
				}else if(a != email.lastIndexOf("@") || j != email.lastIndexOf(".")) {
//					s1 ="邮箱地址中含有多个@或·";	
					s1 = "more@";
				}else if(a == email.length()-1 || j == email.length()-1) {
//					s1 ="邮箱地址中@与·位置不正确,格式错误！";
					s1 = "typeerror";
				}
				else if(a+2 > j){
//					s1 = "邮箱地址中@与·位置不正确,格式错误！";
					s1 = "typeerror";
				}else {
					//每个邮箱地址进入后，b的值都是true
					//循环，控制i，i会作为遍历字符串内容的索引
					for(int i=0;i<email.length();i++) {
					  char ch = email.charAt(i);
					  if(ch == 46 ||(ch>47 && ch<58) || (ch>63 && ch<91) || (ch>96 && ch<123)){
							//邮箱地址不包含特殊字符
						  String customer = customerService.testemail(email);
						  if(customer ==  "OK") {
								s1 = email;
							}else if(customer == "NO"){
								s1 = "NO";
							}
						}else {
							//邮箱地址中包含特殊字符
//							s1 ="您输入的邮箱地址包含敏感字符，请重新输入";
							s1 = "error";
							//因为已经找到特殊字符，因此该字符串就没有必要再遍历下去，于是跳出循环
							break;
						}
					}
						
				}
			return s1;
		}
	
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		KstarMing
	* @date		 	2019-11-23
	* @version      V1.0.0
	* @description  验证用户名
	**********************************************************************/
	@RequestMapping(value="testusername")
	@ResponseBody
	public String testusername(String username) {
		String s  = null;
		 String customer = customerService.testusername(username);
		
		  if(customer ==  "OK") {
				s = "OK";
			}else if(customer == "NO"){
				s = "NO";
			}
		  System.out.println(s);
		  return s;
	}
}
