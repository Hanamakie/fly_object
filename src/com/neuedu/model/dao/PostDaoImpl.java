package com.neuedu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuedu.model.domain.TabFlyKiss;
import com.neuedu.model.domain.TabPost;
import com.neuedu.model.domain.TabSpecialColumn;
import com.neuedu.model.domain.TabUser;
import com.neuedu.model.domain.pagedomain;

public class PostDaoImpl implements PostDao{
	@Override
	public int getPostCount(Connection conn,TabUser user) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) n from tab_post where user_id = ?";
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				n = rs.getInt("n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int getCollPostCount(Connection conn, TabUser user) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) n from tab_coll_post where user_id = ?";
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				n = rs.getInt("n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public List<TabPost> getpost(Connection conn, TabUser user) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select m.id id,title,content,n.id id2,nickname,create_time,view_count "
				+ "from tab_post m,tab_user n "
				+ "where m.user_id = n.id and n.id = ?";
		List<TabPost> list = new ArrayList<TabPost>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			rs = pstmt.executeQuery();
			while(rs.next()){
				TabPost post = new TabPost();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				TabUser user2 = new TabUser();
				user2.setId(rs.getInt("id2"));
				user2.setNickname(rs.getString("nickname"));
				post.setUser(user2);
				post.setCreate_time(rs.getDate("create_time"));
				post.setView_count(rs.getInt("view_count"));
				list.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TabPost> getcollpost(Connection conn, TabUser user) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select m.id id,title "
				+ "from tab_post m,tab_coll_post n "
				+ "where m.id = n.post_id and n.user_id = ?";
		List<TabPost> list = new ArrayList<TabPost>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			rs = pstmt.executeQuery();
			while(rs.next()){
				TabPost post = new TabPost();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				list.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TabSpecialColumn> getSpecialColumn(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tab_special_column";
		List<TabSpecialColumn> list = new ArrayList<TabSpecialColumn>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				TabSpecialColumn specialcolumn = new TabSpecialColumn();
				specialcolumn.setId(rs.getInt("id"));
				specialcolumn.setSpecial_column(rs.getString("special_column"));
				list.add(specialcolumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TabFlyKiss> getFlyKiss(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tab_fly_kiss";
		List<TabFlyKiss> list = new ArrayList<TabFlyKiss>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				TabFlyKiss flyKiss = new TabFlyKiss();
				flyKiss.setId(rs.getInt("id"));
				flyKiss.setKiss_num(rs.getInt("kiss_num"));
				list.add(flyKiss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addPost(Connection conn, TabPost post) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "insert into tab_post (title,content,user_id,create_time,view_count,special_column_id,fly_kiss_id) values (?,?,?,now(),?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3, post.getUser().getId());
			/*pstmt.setDate(4, new java.sql.Date(new Date().getTime()));*/
			pstmt.setInt(4, 0);
			pstmt.setInt(5, post.getSpecial_column().getId());
			pstmt.setInt(6, post.getFly_kiss().getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TabPost> getpostlist(Connection conn,String selectcondition,pagedomain pagedomain) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TabPost> list = new ArrayList<TabPost>();
		String ordercondition = "";
		if("newpost".equals(selectcondition)){
			ordercondition = "a.create_time";
		}else if("hotpost".equals(selectcondition)){
			ordercondition = "answer_num";
		}
		String sql = "select a.id,a.title,b.special_column,m.nickname,a.create_time,n.kiss_num,e.grade,a.is_good,count(p.id) answer_num "
				+ "from tab_post a "
				+ "join tab_special_column b "
				+ "on a.special_column_id = b.id "
				+ "join tab_user m "
				+ "on a.user_id = m.id "
				+ "join tab_fly_kiss n "
				+ "on a.fly_kiss_id = n.id "
				+ "join tab_user_grade e "
				+ "on m.grade_id = e.id "
				+ "left join tab_answer p "
				+ "on a.id = p.post_id "
				+ "group by a.id,a.title,b.special_column,m.nickname,a.create_time,n.kiss_num,e.grade,a.is_good "
				+ "order by "+ordercondition+" desc "
				+ "limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pagedomain.getIndex()-1)*pagedomain.getSize());
			pstmt.setInt(2, pagedomain.getSize());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				TabPost post = new TabPost();
				post.setId(rs.getInt("a.id"));
				post.setTitle(rs.getString("a.title"));
				TabSpecialColumn special_column = new TabSpecialColumn();
				special_column.setSpecial_column(rs.getString("b.special_column"));
				post.setSpecial_column(special_column);
				TabUser user = new TabUser();
				user.setNickname(rs.getString("m.nickname"));
				user.setGrade(rs.getString("e.grade"));
				post.setUser(user);
				post.setCre_time(rs.getDate("create_time"));
				TabFlyKiss fly_kiss = new TabFlyKiss();
				fly_kiss.setKiss_num(rs.getInt("n.kiss_num"));
				post.setFly_kiss(fly_kiss);
				post.setIs_good(rs.getInt("is_good"));
				post.setAnswer_num(rs.getInt("answer_num"));
				list.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TabPost detailpost(Connection conn, int id) {
		// TODO Auto-generated method stub
		TabPost post = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.id,a.title,b.special_column,a.content,m.nickname,a.create_time,n.kiss_num,e.grade,a.is_good,a.view_count,count(p.id) answer_num "
				+ "from tab_post a "
				+ "join tab_special_column b "
				+ "on a.special_column_id = b.id "
				+ "join tab_user m "
				+ "on a.user_id = m.id "
				+ "join tab_fly_kiss n "
				+ "on a.fly_kiss_id = n.id "
				+ "join tab_user_grade e "
				+ "on m.grade_id = e.id "
				+ "left join tab_answer p "
				+ "on a.id = p.post_id "
				+ "where a.id = ? "
				+ "group by a.id,a.title,b.special_column,a.content,m.nickname,a.create_time,n.kiss_num,e.grade,a.is_good,a.view_count ";
		String sql2 = "update tab_post set view_count = view_count+1 where id = ?";
		try {
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				post = new TabPost();
				post.setId(rs.getInt("a.id"));
				post.setTitle(rs.getString("a.title"));
				TabSpecialColumn special_column = new TabSpecialColumn();
				special_column.setSpecial_column(rs.getString("b.special_column"));
				post.setSpecial_column(special_column);
				post.setContent(rs.getString("a.content"));
				TabUser user = new TabUser();
				user.setNickname(rs.getString("m.nickname"));
				user.setGrade(rs.getString("e.grade"));
				post.setUser(user);
				post.setCre_time(rs.getDate("create_time"));
				TabFlyKiss fly_kiss = new TabFlyKiss();
				fly_kiss.setKiss_num(rs.getInt("n.kiss_num"));
				post.setFly_kiss(fly_kiss);
				post.setIs_good(rs.getInt("is_good"));
				post.setView_count(rs.getInt("a.view_count"));
				post.setAnswer_num(rs.getInt("answer_num"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		return post;
	}


}
