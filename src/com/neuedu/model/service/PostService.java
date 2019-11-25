package com.neuedu.model.service;

import java.util.List;

import com.neuedu.model.domain.TabFlyKiss;
import com.neuedu.model.domain.TabPost;
import com.neuedu.model.domain.TabSpecialColumn;
import com.neuedu.model.domain.TabUser;
import com.neuedu.model.domain.pagedomain;

public interface PostService {
	int getPostCount(TabUser user);
	int getCollPostCount(TabUser user);
	List<TabPost> getpost(TabUser user);
	List<TabPost> getcollpost(TabUser user);
	List<TabSpecialColumn> getSpecialColumn();
	List<TabFlyKiss> getFlyKiss();
	void addPost(TabPost post);
	List<TabPost> getpostlist(String selectcondition,pagedomain pagedomain);
	TabPost detailpost(int id);

}
