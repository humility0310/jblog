package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	BlogDao blogDao;

	public void createBlog(Long no) {
		blogDao.createBlog(no);
	}

	public BlogVo getBlogInfo(String id) {
		return blogDao.getBlogInfo(id);
	}
	
	public void updateBlog(BlogVo vo){
		blogDao.updateBlog(vo);
	}
}
