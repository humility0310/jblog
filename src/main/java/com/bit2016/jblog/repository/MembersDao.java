package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.MembersVo;

@Repository
public class MembersDao {

	@Autowired
	private SqlSession sqlSession;

	public Long insert(MembersVo vo) {
		sqlSession.insert("members.insert", vo);
		return vo.getNo();
	}
	
	public MembersVo get( String id ) {
		return sqlSession.selectOne( "members.getById", id );
	}
}
