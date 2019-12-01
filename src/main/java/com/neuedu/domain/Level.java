package com.neuedu.domain;

public class Level {
	private int id;
	private String level_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	@Override
	public String toString() {
		return "Level [id=" + id + ", level_name=" + level_name + "]";
	}
}
