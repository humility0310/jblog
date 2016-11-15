package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.MembersVo;

@Repository
public class BlogDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void createBlog( Long no ) {
		sqlSession.insert( "blog.createblog" , no );
	}
}
