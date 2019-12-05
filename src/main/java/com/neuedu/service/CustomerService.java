package com.neuedu.service;
import com.neuedu.domain.Customer;

public interface CustomerService {
//	登录查询
	Customer getCustomer(Customer customer);
//	头像上传     高云龙
	void uploadAvatar(Customer customer);
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
//	修改密码—————检测用户密码是否正确
	Customer checkpassword(Customer customer);
//	修改密码---更新用户密码
	void changepass(Customer customer);
}
