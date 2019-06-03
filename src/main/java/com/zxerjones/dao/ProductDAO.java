package com.zxerjones.dao;

import java.util.List;

import com.zxerjones.entity.Product;

public interface ProductDAO {
	public List<Product> queryByLevelOne( int id ) ;

	public List<Product> queryByLevelTwo( int id  , int start , int prePage );

	public List<Product> queryByLevelThree(int id  , int start , int prePage );
	
	public int getPagesByLevelTwo( int id ) ;
	
	public int getPagesByLevelThree( int id ) ;
	
	public Product getProductById( int id ) ;
	
	public List<Product> getProductByName(String name, int start, int page);
	
	public int getPagesByName(String name);
	
	
	
}
