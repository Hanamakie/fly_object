package com.neuedu.domain;

public class Kiss {
	private int id; // 飞吻数编号
	private String kiss_num; // 飞吻数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKiss_num() {
		return kiss_num;
	}
	public void setKiss_num(String kiss_num) {
		this.kiss_num = kiss_num;
	}
	@Override
	public String toString() {
		return "Kiss [id=" + id + ", kiss_num=" + kiss_num + "]";
	}
	
}
