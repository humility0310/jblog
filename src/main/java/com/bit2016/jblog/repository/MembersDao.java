package com.bit2016.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.exception.MembersDaoException;
import com.bit2016.jblog.vo.MembersVo;

@Repository
public class MembersDao {

	@Autowired
	private SqlSession sqlSession;

	public Long insert(MembersVo vo) {
		sqlSession.insert("members.insert", vo);
		return vo.getNo();
	}

	public MembersVo get(String id) {
		return sqlSession.selectOne("members.getById", id);
	}

	// 인증(로그인)
	public MembersVo get(String id, String password) throws MembersDaoException {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);

		return sqlSession.selectOne("members.getByIdAndPassword", map);
	}
}
