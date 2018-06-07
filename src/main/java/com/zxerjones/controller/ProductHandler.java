package com.zxerjones.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zxerjones.entity.Category;
import com.zxerjones.entity.Product;
import com.zxerjones.entity.User;
import com.zxerjones.service.CategoryService;
import com.zxerjones.service.ProductService;

@Controller
public class ProductHandler {
	@Autowired
	private ProductService productService ;
	
	@Autowired
	private CategoryService categoryService ;
	
	@RequestMapping("/productList")
	public ModelAndView productList( @RequestParam("level")int level , @RequestParam("id")int id  , @RequestParam("page")int page  ){
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("productList");
		List<Product> productList = productService.getProductByLevel(level , id , page) ;
		List<Category> categoryList = categoryService.queryAll() ;
		mav.addObject("productList", productList) ;  //细分类页面
		mav.addObject("categoryList", categoryList) ;//主页面
		int pages = productService.getPages(level, id) ;
		mav.addObject("pages", pages) ;
		mav.addObject("page", page) ;
		mav.addObject( "level" , level ) ;
		mav.addObject( "id" , id ) ;
		return mav ;
	}
	
	@RequestMapping("/getProductById")
	public ModelAndView getProductById( @RequestParam("id") int id ){
		ModelAndView mav = new ModelAndView() ;
		Product product = productService.getProductById(id) ;
		mav.addObject( "product" , product ) ;
		mav.setViewName("productDeatil");
		return mav ;
	}
	
	@RequestMapping("/addCar")
	public ModelAndView addCar(@RequestParam("productId")int id  , @RequestParam("quantity") int quantity){
		ModelAndView mav = new ModelAndView() ;
		Product product = productService.getProductById(id) ;
		mav.setViewName("toSettlement");
		mav.addObject("product", product) ;
		mav.addObject("quantity", quantity) ;
		return mav ;
	}
	
	@RequestMapping("/easybuy_queryAll")
	public ModelAndView queryAll(){
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("main");
		List<Category> list = categoryService.queryAll() ;
		mav.addObject("categoryVOList", categoryService.queryCategoryVO(list)) ;
		mav.addObject("list", list) ;
		return mav ;
	}
	
	
}
