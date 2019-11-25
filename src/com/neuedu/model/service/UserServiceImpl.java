package com.neuedu.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.model.dao.UserDao;
import com.neuedu.model.dao.UserDaoImpl;
import com.neuedu.model.domain.TabArea;
import com.neuedu.model.domain.TabUser;
import com.neuedu.util.DBUtil;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	@Override
	public TabUser findUser(TabUser user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		TabUser user2 = userDao.findUser(conn, user);
		return user2;
	}

	@Override
	public TabUser findUser(String email) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		TabUser user2 = userDao.findUser(conn, email);
		return user2;
	}

	@Override
	public void regist(TabUser user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			userDao.regist(conn, user);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			DBUtil.close(null, null, conn);
		}
	}

	@Override
	public List<TabArea> getarea() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		List<TabArea> list = userDao.getarea(conn);
		return list;
	}

	@Override
	public void updateinfo(TabUser user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		userDao.updateinfo(conn, user);
		
	}

}
