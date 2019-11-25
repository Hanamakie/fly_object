package com.neuedu.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.neuedu.dao.CustomerMapper;
import com.neuedu.domain.Customer;

public class test {
	@Test
	public void test(){
		InputStream is;
		try {
			is = Resources.getResourceAsStream("SqlMapConfig.xml");
			SqlSessionFactory f = new SqlSessionFactoryBuilder().build(is);
			SqlSession sqlsession = f.openSession();
			CustomerMapper empmapper =sqlsession.getMapper(CustomerMapper.class);
			
			Customer customer = new Customer();
			customer.setUsername("admin");
			customer.setPassword("admin");
			Customer emp = empmapper.getCustomer(customer);
			System.out.println(emp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
