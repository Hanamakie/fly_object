package com.neuedu.domain;

public class Special {
	private int id ; //文章分类编号
	private String special_column; //文章分类
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecial_column() {
		return special_column;
	}
	public void setSpecial_column(String special_column) {
		this.special_column = special_column;
	}
	@Override
	public String toString() {
		return "Special [id=" + id + ", special_column=" + special_column + "]";
	}
}
