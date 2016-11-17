package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.repository.MembersDao;
import com.bit2016.jblog.vo.MembersVo;

@Service
public class MembersService {

	@Autowired
	private MembersDao membersDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	

	public void join(MembersVo vo) {
		Long no = membersDao.insert(vo);
		blogDao.createBlog(no);
		categoryDao.createCategory(no);
	}

	public boolean idExists(String id) {
		return (membersDao.get(id) != null);
	}

	public MembersVo login(String id, String password) {
		MembersVo membersVo = null;
		membersVo = membersDao.get(id, password);
		return membersVo;
	}

	
}
