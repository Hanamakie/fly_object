package com.neuedu.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.model.domain.TabArea;
import com.neuedu.model.domain.TabUser;

public interface UserDao {
	TabUser findUser(Connection conn,TabUser user);
	TabUser findUser(Connection conn,String email);
	void regist(Connection conn,TabUser user) throws SQLException;
	List<TabArea> getarea(Connection conn);
	void updateinfo(Connection conn,TabUser user);
	

}
