package com.neuedu.domain;

import java.util.Date;
import java.util.List;

public class Release {
	private int id; // 文章标识
	private String title; // 文章标题
	private String content; // 文章内容
	private int user_id; // 发表人
	private List<Customer> customer;//用户信息
	private List<Kiss> kiss;//飞吻数
	private List<Level> level;//会员等级
	private List<Special> special;//文章分类
	private Date create_time; // 创建时间
	private int view_count; // 访问次数
	private int special_column_id; // 文章分类
	private int fly_kiss_id; // 飞吻数
	private int sort_order; // 排序
	private int sticky; // 指定级别
	
	public List<Level> getLevel() {
		return level;
	}
	public void setLevel(List<Level> level) {
		this.level = level;
	}
	public List<Special> getSpecial() {
		return special;
	}
	public void setSpecial(List<Special> special) {
		this.special = special;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	public List<Kiss> getKiss() {
		return kiss;
	}
	public void setKiss(List<Kiss> kiss) {
		this.kiss = kiss;
	}
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public int getSpecial_column_id() {
		return special_column_id;
	}
	public void setSpecial_column_id(int special_column_id) {
		this.special_column_id = special_column_id;
	}
	public int getFly_kiss_id() {
		return fly_kiss_id;
	}
	public void setFly_kiss_id(int fly_kiss_id) {
		this.fly_kiss_id = fly_kiss_id;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public int getSticky() {
		return sticky;
	}
	public void setSticky(int sticky) {
		this.sticky = sticky;
	}
	@Override
	public String toString() {
		return "Release [id=" + id + ", title=" + title + ", content=" + content + ", user_id=" + user_id
				+ ", create_time=" + create_time + ", view_count=" + view_count + ", special_column_id="
				+ special_column_id + ", fly_kiss_id=" + fly_kiss_id + ", sort_order=" + sort_order + ", sticky="
				+ sticky + "]";
	}
}
