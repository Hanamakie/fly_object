package com.neuedu.dao;

import java.util.List;

import com.neuedu.domain.Customer;

public interface CustomerMapper {
	//登陆查询
	Customer getCustomer(Customer customer);
	
	//头像上传
	List<Customer> uploadAvatar(String avatar);
	
	/*注册功能：添加用户*/
	void addcustomer(Customer customer);
	
	/*验证邮箱*/
	Customer testemail(String email);
	
	/*验证用户名*/
	Customer testusername(String username);
	
	/*检测用户密码是否正确*/
	
	Customer checkpassword(String password);
	
	/*更新用户密码*/
	
	Customer changepass(String password);
}
