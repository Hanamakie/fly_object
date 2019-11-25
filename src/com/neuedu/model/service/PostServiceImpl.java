package com.neuedu.model.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.model.dao.PostDao;
import com.neuedu.model.dao.PostDaoImpl;
import com.neuedu.model.domain.TabFlyKiss;
import com.neuedu.model.domain.TabPost;
import com.neuedu.model.domain.TabSpecialColumn;
import com.neuedu.model.domain.TabUser;
import com.neuedu.model.domain.pagedomain;
import com.neuedu.util.DBUtil;

public class PostServiceImpl implements PostService{
	private PostDao postDao = new PostDaoImpl();

	@Override
	public int getPostCount(TabUser user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		int n = postDao.getPostCount(conn, user);
		return n;
	}

	@Override
	public int getCollPostCount(TabUser user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		int n = postDao.getCollPostCount(conn, user);
		return n;
	}

	@Override
	public List<TabPost> getpost(TabUser user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		List<TabPost> list = postDao.getpost(conn, user);
		return list;
	}

	@Override
	public List<TabPost> getcollpost(TabUser user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		List<TabPost> list = postDao.getcollpost(conn, user);
		return list;
	}

	@Override
	public List<TabSpecialColumn> getSpecialColumn() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		List<TabSpecialColumn> list = postDao.getSpecialColumn(conn);
		return list;
	}

	@Override
	public List<TabFlyKiss> getFlyKiss() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		List<TabFlyKiss> list = postDao.getFlyKiss(conn);
		return list;
	}

	@Override
	public void addPost(TabPost post) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		postDao.addPost(conn, post);
		
	}

	@Override
	public List<TabPost> getpostlist(String selectcondition,pagedomain pagedomain) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		List<TabPost> list = postDao.getpostlist(conn,selectcondition,pagedomain);
		return list;
	}

	@Override
	public TabPost detailpost(int id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		TabPost post = postDao.detailpost(conn,id);
		return post;
	}

}
