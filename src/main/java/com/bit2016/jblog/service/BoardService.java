package com.bit2016.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BoardDao;
import com.bit2016.jblog.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	BoardDao boardDao;
	
	public List<BoardVo> viewBoard(Long categoryno){
		return boardDao.viewBoard(categoryno);
	}
	
	public BoardVo viewContent(Long titleNo) {
		return boardDao.viewContent(titleNo);
	}
}
