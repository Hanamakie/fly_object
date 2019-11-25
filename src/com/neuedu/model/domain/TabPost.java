package com.neuedu.model.domain;

import java.util.Date;

import com.neuedu.util.DateUtil;

public class TabPost {
	private int id;
	private String title;
	private String content;
	private TabUser user;
	private Date create_time;
	private int view_count;
	private TabSpecialColumn special_column;
	private TabFlyKiss fly_kiss;
	private int answer_num;
	private Date cre_time;
	private int is_good;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public TabUser getUser() {
		return user;
	}
	public void setUser(TabUser user) {
		this.user = user;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public TabSpecialColumn getSpecial_column() {
		return special_column;
	}
	public void setSpecial_column(TabSpecialColumn special_column) {
		this.special_column = special_column;
	}
	public TabFlyKiss getFly_kiss() {
		return fly_kiss;
	}
	public void setFly_kiss(TabFlyKiss fly_kiss) {
		this.fly_kiss = fly_kiss;
	}
	public int getAnswer_num() {
		return answer_num;
	}
	public void setAnswer_num(int answer_num) {
		this.answer_num = answer_num;
	}
	public String getCre_time() {
		return DateUtil.getDateString(cre_time);
	}
	public void setCre_time(Date cre_time) {
		this.cre_time = cre_time;
	}
	public int getIs_good() {
		return is_good;
	}
	public void setIs_good(int is_good) {
		this.is_good = is_good;
	}

}
