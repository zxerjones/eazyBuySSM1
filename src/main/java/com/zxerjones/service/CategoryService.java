package com.zxerjones.service;

import java.util.List;

import com.zxerjones.entity.Category;
import com.zxerjones.entity.CategoryVO;



public interface CategoryService {
	public List<Category> queryAll() ;
	public List<CategoryVO> queryCategoryVO( List<Category> list ) ;
}
