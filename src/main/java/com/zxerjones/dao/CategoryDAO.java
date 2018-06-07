package com.zxerjones.dao;

import java.util.List;

import com.zxerjones.entity.Category;

public interface CategoryDAO {
	public List<Category> selectByType( int type , int parentId ) ;
	public List<Category> queryLevelTwoByLevelOne(int id);
}
