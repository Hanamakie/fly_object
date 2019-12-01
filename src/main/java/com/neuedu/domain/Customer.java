package com.neuedu.domain;


public class Customer {
	private int id;
	private String username;
	private String password;
	private String nick_name;
	private String email;
	private int status;
	private int vip_level;
	// 头像
	private String avatar;
	private Level level;
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
	public int getVip_level() {
		return vip_level;
	}
	public void setVip_level(int vip_level) {
		this.vip_level = vip_level;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", nick_name=" + nick_name
				+ ", email=" + email + ", status=" + status + ", vip_level=" + vip_level + ", avatar=" + avatar + "]";
	}

}
