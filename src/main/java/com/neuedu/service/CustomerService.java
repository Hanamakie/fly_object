package com.neuedu.service;

import com.neuedu.domain.Customer;

public interface CustomerService {
	Customer getCustomer(Customer customer);
	
	/**********************************************************************
	*
	* @fileName     IndexController.java
	* @author		KstarMing
	* @date		 	2019-11-23
	* @version      V1.0.0
	* @description  添加邮箱、邮箱/用户名验证
	**********************************************************************/
	void addcustomer(Customer customer);
	String testemail(String email);
	String testusername(String username);
}
