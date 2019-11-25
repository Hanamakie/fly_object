package com.neuedu.domain;

import java.io.IOException;

public class Customer {
	/**********************************************************************
	*
	* @fileName     Customer.java
	* @author		ChangEnYing
	* @date		 	2019-11-25
	* @version      V1.0.0
	 * @throws IOException 
	* @description  客户类
	**********************************************************************/
	//id
	private int id;
	//用户名
	private String username;
	//密码
	private String password;
	//昵称
	private String nick_name;
	//邮箱
	private String email;
	//状态
	private int status;
	//会员等级
	private String vip_level;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getVip_level() {
		return vip_level;
	}
	public void setVip_level(String vip_level) {
		this.vip_level = vip_level;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", nick_name=" + nick_name
				+ ", email=" + email + ", status=" + status + ", vip_level=" + vip_level + "]";
	}
	
	
	
	
}
