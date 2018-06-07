package com.zxerjones.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxerjones.dao.CategoryDAO;
import com.zxerjones.dao.ProductDAO;
import com.zxerjones.entity.Category;
import com.zxerjones.entity.CategoryVO;
import com.zxerjones.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDAO categoryDAO ;
	
	@Autowired
	private ProductDAO productDAO ;
	@Override
	public List<Category> queryAll() {
		// TODO Auto-generated method stub
		List<Category> type1 = categoryDAO.selectByType(1, 0) ;
		for (Category type2 : type1) {
			List<Category> list = categoryDAO.selectByType(2, type2.getId()) ;
			type2.setCategorys(list);
			for (Category category : list) {
				List<Category> type3 = categoryDAO.selectByType(3, category.getId()) ; 
				category.setCategorys(type3);
			}
		}
		return type1 ;
	}
	@Override
	public List<CategoryVO> queryCategoryVO(List<Category> list) {
		// TODO Auto-generated method stub
		List<CategoryVO> list1 = new ArrayList<CategoryVO>() ;
		for (Category category : list) {
			if( category.getType() == 1 ){
				CategoryVO categoryVO = new  CategoryVO() ;
				categoryVO.setName(category.getName());
				categoryVO.setCategorys(categoryDAO.queryLevelTwoByLevelOne(category.getId()));
				categoryVO.setProducts(productDAO.queryByLevelOne(category.getId()));
				list1.add(categoryVO) ;
			}
		}
		return list1;
	}

}
