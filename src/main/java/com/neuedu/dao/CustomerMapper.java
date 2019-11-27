package com.neuedu.dao;

import com.neuedu.domain.Customer;

public interface CustomerMapper {
	//登陆查询
	Customer getCustomer(Customer customer);
	
	/*注册功能：添加用户*/
	void addcustomer(Customer customer);
	
	/*验证邮箱*/
	Customer testemail(String email);
	
	/*验证用户名*/
	Customer testusername(String username);
}
