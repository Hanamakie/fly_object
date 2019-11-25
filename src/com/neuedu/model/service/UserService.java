package com.neuedu.model.service;

import java.util.List;

import com.neuedu.model.domain.TabArea;
import com.neuedu.model.domain.TabUser;

public interface UserService {
	TabUser findUser(TabUser user);
	TabUser findUser(String email);
	void regist(TabUser user);
	List<TabArea> getarea();
	void updateinfo(TabUser user);

}
