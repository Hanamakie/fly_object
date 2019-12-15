package com.neuedu.service.gyl;

import java.util.List;

import com.neuedu.domain.Customer;
import com.neuedu.domain.Kiss;
import com.neuedu.domain.Release;
import com.neuedu.domain.Special;

public interface ArticleAddService {
//	查询用户基本信息，基于customer表
	Customer user(int id);
//	查询文章分类（文章发布时）
	List<Special> getspecial();
//	查询飞吻数（文章发布时）
	List<Kiss> getkiss();
//	增加文章
	void publishAnArticle(Release release);
//	查询后台“我发的帖子”
	List<Release> postrelease(int id);
//	后台查询用户文章条数
	int getreleasecount(int id);
//	查询后台文章信息
	Release getsumcontext(int id);
//	更新后台用户文章
	void updatecontent(Release release);
//	删除文章（逻辑删）
	void delcontent(int id);
//	home页文章查询
	List<Release> posthomecount(int id);
}
