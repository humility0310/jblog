package com.bit2016.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void createCategory( Long no ) {
		sqlSession.insert( "category.createcategory" , no );
	}
	
	public List<CategoryVo> categoryList(String id){
		return sqlSession.selectList("category.categorylist", id);
	}

}
