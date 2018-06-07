package com.zxerjones.service;

import java.util.List;

import com.zxerjones.entity.Product;

public interface ProductService {
	public List<Product> queryByLevelOne(int id);
	public List<Product> getProductByLevel( int level , int id , int page ) ;
	public int getPages( int level , int id ) ;
	public Product getProductById( int id ) ;
}
