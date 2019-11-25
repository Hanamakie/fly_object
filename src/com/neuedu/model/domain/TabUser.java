package com.neuedu.model.domain;

public class TabUser {
	private int id;
	private String email;
	private String password;
	private String nickname;
	private String grade;
	private TabArea area;
	private int sex_id;
	private String sign;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public TabArea getArea() {
		return area;
	}
	public void setArea(TabArea area) {
		this.area = area;
	}
	public int getSex_id() {
		return sex_id;
	}
	public void setSex_id(int sex_id) {
		this.sex_id = sex_id;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

}
