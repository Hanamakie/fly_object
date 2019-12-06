package com.neuedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.CustomerMapper;
import com.neuedu.domain.Customer;
@Service
public  class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerMapper customerMapper;
	//登陆，通过账号和密码或者邮箱和密码查询用户

	public Customer getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.getCustomer(customer);
	}

	/*添加邮箱*/
	public void addcustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.addcustomer(customer);
	}
	/*用户名验证*/
	public String testemail(String email) {
		// TODO Auto-generated method stub
		Customer customer = customerMapper.testemail(email);
		String s = "";
		if(customer == null) {
			s = "OK";
		}else {
			s = "NO";
		}
		return s;
	}
	/*用户上传头像*/
	public String testusername(String username) {
		// TODO Auto-generated method stub
		Customer customer = customerMapper.testusername(username);
		String s1 = "";
		if(customer == null) {
			s1 = "OK";
		}else {
			s1 = "NO";
		}
		return s1;
	}

	public Customer checkpassword(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.checkpassword(customer);
	}

	public void changepass(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.changepass(customer);
	}

	public void uploadAvatar(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.uploadAvatar(customer);
	}

}
