package com.zxerjones.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxerjones.dao.ProductDAO;
import com.zxerjones.entity.Product;
import com.zxerjones.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	
	private int prePage = 4 ;
	@Autowired
	private ProductDAO productDAO ;

	@Override
	public List<Product> queryByLevelOne(int id) {
			// TODO Auto-generated method stub
			return productDAO.queryByLevelOne(id);
	}
	@Override
	public List<Product> getProductByLevel(int level , int id , int page) {
		// TODO Auto-generated method stub
		int start = ( page - 1 ) * prePage ; 
		if( level == 2 ){
			return productDAO.queryByLevelTwo( id  , start , prePage ) ;
		}
		if( level == 3 ){
			return productDAO.queryByLevelThree( id  , start , prePage ) ;
		}
		return null;
	}
	@Override
	public int getPages(int level, int id) {
		// TODO Auto-generated method stub
		int counts = 0 ;
		if( level == 2 ){
			counts = productDAO.getPagesByLevelTwo(id) ;
 
		}
		if( level == 3 ){
			counts = productDAO.getPagesByLevelThree(id) ;
		}
		int pages = 0 ;
		if( counts % prePage == 0 ){
			pages = counts % prePage ;
		}else{
			pages = counts / prePage + 1 ;
		}
		return pages;
	}
	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		
		return productDAO.getProductById( id ) ;
	}

	



	

}
