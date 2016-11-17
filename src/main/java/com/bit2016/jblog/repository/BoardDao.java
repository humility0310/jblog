package com.bit2016.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;

	public List<BoardVo> viewBoard(Long categoryno) {
		return sqlSession.selectList("board.viewboard", categoryno);
	}

	public BoardVo viewContent(Long titleNo) {
		return sqlSession.selectOne("board.viewcontent", titleNo);
	}

}
