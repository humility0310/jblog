package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.MembersDao;
import com.bit2016.jblog.vo.MembersVo;

@Service
public class MembersService {

	@Autowired
	private MembersDao membersDao;

	public Long join(MembersVo vo) {
		return membersDao.insert(vo);
	}
	
	public boolean idExists( String id ){
		return ( membersDao.get( id ) != null );
	}

}
