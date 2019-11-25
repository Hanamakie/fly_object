package com.neuedu.model.dao;

import java.sql.Connection;
import java.util.List;

import com.neuedu.model.domain.TabFlyKiss;
import com.neuedu.model.domain.TabPost;
import com.neuedu.model.domain.TabSpecialColumn;
import com.neuedu.model.domain.TabUser;
import com.neuedu.model.domain.pagedomain;

public interface PostDao {
	int getPostCount(Connection conn,TabUser user);
	int getCollPostCount(Connection conn,TabUser user);
	List<TabPost> getpost(Connection conn,TabUser user);
	List<TabPost> getcollpost(Connection conn,TabUser user);
	List<TabSpecialColumn> getSpecialColumn(Connection conn);
	List<TabFlyKiss> getFlyKiss(Connection conn);
	void addPost(Connection conn,TabPost post);
	List<TabPost> getpostlist(Connection conn,String selectcondition,pagedomain pagedomain);
	TabPost detailpost(Connection conn,int id);

}
