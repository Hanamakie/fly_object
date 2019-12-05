package com.neuedu.service.gyl;

import java.util.List;

import com.neuedu.domain.Kiss;
import com.neuedu.domain.Release;
import com.neuedu.domain.Special;

public interface ArticleAddService {
//	查询文章分类（文章发布时）
	List<Special> getspecial();
//	查询飞吻数（文章发布时）
	List<Kiss> getkiss();
//	增加文章
	void publishAnArticle(Release release);
}
