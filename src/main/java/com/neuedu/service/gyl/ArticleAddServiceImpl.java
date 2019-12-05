package com.neuedu.service.gyl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.gyl.ArticleAddMapper;
import com.neuedu.domain.Kiss;
import com.neuedu.domain.Release;
import com.neuedu.domain.Special;
@Service
public class ArticleAddServiceImpl implements ArticleAddService{
	@Autowired 
	ArticleAddMapper articleAddMapper;
	public List<Special> getspecial() {
		// TODO Auto-generated method stub
		return articleAddMapper.getspecial();
	}
	public List<Kiss> getkiss() {
		// TODO Auto-generated method stub
		return articleAddMapper.getkiss();
	}
	public void publishAnArticle(Release release) {
		// TODO Auto-generated method stub
		articleAddMapper.publishAnArticle(release);
	}

}
