package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;

	public void createBlog(Long no) {
		sqlSession.insert("blog.createblog", no);
	}

	public BlogVo getBlogInfo(String id) {
		return sqlSession.selectOne("blog.viewblog", id);
	}
	
	public void updateBlog(BlogVo vo){
		sqlSession.update("blog.updateblog",vo);
	}

}
