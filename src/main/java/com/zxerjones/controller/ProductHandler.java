package com.zxerjones.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zxerjones.entity.Address;
import com.zxerjones.entity.Category;
import com.zxerjones.entity.Product;
import com.zxerjones.entity.User;
import com.zxerjones.service.AddressService;
import com.zxerjones.service.CategoryService;
import com.zxerjones.service.ProductService;

@Controller
public class ProductHandler {
	@Autowired
	private ProductService productService ;
	
	@Autowired
	private CategoryService categoryService ;
	
	@Autowired
	private AddressService addressService; 

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
	
	@RequestMapping("/goodsList_getProductById")
	public ModelAndView GoodsListGetProductById(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView() ;
		Product product = productService.getProductById(id) ;
		mav.addObject( "product" , product ) ;
		mav.setViewName("productDeatil");
		return mav ;
	}
	
	@RequestMapping("/goodsList_queryGoodsByName")
	public ModelAndView querByName(@RequestParam("keyWord") String name, @RequestParam("page")int page) {
		List<Product> list = productService.getProductByName(name, page);
		ModelAndView mavAndView = new ModelAndView();
		mavAndView.addObject("list", list);
		mavAndView.setViewName("productList");
		return mavAndView ;
	}
	
	@RequestMapping("/cart_addAdress")
	public ModelAndView settlement(@RequestParam("flag2") int flag2, HttpServletRequest httpServletRequest, HttpSession session) {
		ModelAndView mavAndView = new ModelAndView();
		mavAndView.setViewName("settlement3");
		Address address = new Address();
		
		// 如果是新地址
		if (flag2 == 0) {
			String addressString = httpServletRequest.getParameter("newAddress");
			String remarkString = httpServletRequest.getParameter("newRemark");
			int userId = ( (User)session.getAttribute("user")).getId();
			// 添加新地址到数据库
			//获取当前系统时间
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String data = sdf.format(date);
			addressService.addAddress(userId, addressString, data, remarkString);
			address.setAddress(addressString);
		}else { //如果不是新地址
			String addressIdString = httpServletRequest.getParameter("addressId");
			int addressId = Integer.parseInt(addressIdString);
			address = addressService.getAddressById(addressId);
		}
		
		String serialNum = null;
		//生成订单序列号
		try {
			StringBuffer orderNumBuffer = new StringBuffer();
			for (int i = 0; i < 32; i++) {
				orderNumBuffer.append(Integer.toHexString(new Random().nextInt(16)));
			}
			serialNum = orderNumBuffer.toString().toUpperCase();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		// 保存订单编号
		mavAndView.addObject("number",serialNum);
		mavAndView.addObject("counts", "￥" + session.getAttribute("totalPirce"));
		mavAndView.addObject("newAddress", address.getAddress());
		
		return mavAndView;
	}
	
	
}
