package com.neuedu.service.gyl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.gyl.ArticleAddMapper;
import com.neuedu.domain.Customer;
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
	public List<Release> postrelease(int id) {
		// TODO Auto-generated method stub
		return articleAddMapper.postrelease(id);
	}
	public int getreleasecount(int id) {
		// TODO Auto-generated method stub
		return articleAddMapper.getreleasecount(id);
	}
	public Release getsumcontext(int id) {
		// TODO Auto-generated method stub
		return articleAddMapper.getsumcontext(id);
	}
	public void updatecontent(Release release) {
		// TODO Auto-generated method stub
		articleAddMapper.updatecontent(release);
	}
	public void delcontent(int id) {
		// TODO Auto-generated method stub
		articleAddMapper.delcontent(id);
	}
	public List<Release> posthomecount(int id) {
		// TODO Auto-generated method stub
		return articleAddMapper.posthomecount(id);
	}
	public Customer user(int id) {
		// TODO Auto-generated method stub
		return articleAddMapper.user(id);
	}


}
