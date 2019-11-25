package com.neuedu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.model.domain.TabArea;
import com.neuedu.model.domain.TabUser;
import com.neuedu.util.DBUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public TabUser findUser(Connection conn,TabUser user) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tab_user,tab_user_grade where tab_user.grade_id = tab_user_grade.id and email = ? and password = ?";
		TabUser user2 = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				user2 = new TabUser();
				user2.setId(rs.getInt("id"));
				user2.setEmail(rs.getString("email"));
				user2.setPassword(rs.getString("password"));
				user2.setNickname(rs.getString("nickname"));
				user2.setGrade(rs.getString("grade"));
				TabArea area = new TabArea();
				area.setId(rs.getInt("area_id"));
				user2.setArea(area);
				user2.setSex_id(rs.getInt("sex_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user2;
	}

	@Override
	public TabUser findUser(Connection conn, String email) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tab_user where email = ?";
		TabUser user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new TabUser();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void regist(Connection conn,TabUser user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "insert into tab_user (email,password,nickname,grade_id) values (?,?,?,0)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getNickname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally {
			DBUtil.close(null, pstmt, null);
		}
		
		
	}

	@Override
	public List<TabArea> getarea(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tab_area";
		List<TabArea> list = new ArrayList<TabArea>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				TabArea area = new TabArea();
				area.setId(rs.getInt("id"));
				area.setArea(rs.getString("area"));
				list.add(area);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateinfo(Connection conn,TabUser user) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "update tab_user set email = ?,"
				+ "nickname = ?,"
				+ "sex_id = ?,"
				+ "area_id = ?,"
				+ "sign = ? "
				+ "where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getNickname());
			pstmt.setInt(3,user.getSex_id());
			pstmt.setInt(4, user.getArea().getId());
			pstmt.setString(5, user.getSign());
			pstmt.setInt(6, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
