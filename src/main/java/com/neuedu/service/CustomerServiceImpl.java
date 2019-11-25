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
	@Override
	public Customer getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer);
		Customer customer2=new Customer();
		customer2=customerMapper.getCustomer(customer);
		return customer2;
	}

	

	
	
	
	
}
