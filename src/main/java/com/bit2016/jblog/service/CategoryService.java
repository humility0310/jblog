package com.bit2016.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.vo.BoardVo;
import com.bit2016.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	public List<CategoryVo> getCategoryList(String id){
		return categoryDao.categoryList(id);
	}
	
}
