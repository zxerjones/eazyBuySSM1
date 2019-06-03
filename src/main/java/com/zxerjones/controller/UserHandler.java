package com.zxerjones.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zxerjones.entity.Address;
import com.zxerjones.entity.Category;
import com.zxerjones.entity.CategoryVO;
import com.zxerjones.entity.Product;
import com.zxerjones.entity.User;
import com.zxerjones.service.AddressService;
import com.zxerjones.service.CategoryService;
import com.zxerjones.service.ProductService;
import com.zxerjones.service.UserService;
@Controller
public class UserHandler {
	@Autowired
	private UserService userService ;
	
	@Autowired
	private CategoryService categoryService ;
	
	@Autowired
	private ProductService productService ;
	
	@Autowired
	private AddressService addressService ;
	
	@RequestMapping("/easybuy_register")
	public String register( User user ){
//		System.out.println( userService.register( user ) );
		String loginName = user.getLoginName();
		User user2 = userService.searchUserByLoginName(loginName);
		if (user2 == null) {
			userService.register( user );
			return "login" ;
		} else {
			return "register";
		}
	}
	
	@RequestMapping("/easybuy_login")
	public ModelAndView login( User user , HttpSession session ){
		ModelAndView mav = new ModelAndView() ;
		User user1 = userService.login(user) ;
		if( user1 != null ){
			mav.setViewName("main");
			List<Category> list = categoryService.queryAll() ;
			mav.addObject("categoryVOList", categoryService.queryCategoryVO(list)) ;
			mav.addObject("list", list) ;
			session.setAttribute("user", user1);
		}else{
			mav.setViewName("login");
		}
		return mav ;
	}
	
	@RequestMapping("/isLogin")
	public ModelAndView islogin( HttpSession session , String fileName ,  String name , double price , Integer quantity, String totalPirce ){
		ModelAndView mav = new ModelAndView() ;
		User user = (User) session.getAttribute("user") ;
		totalPirce = totalPirce.substring(1);
		session.setAttribute("totalPirce", totalPirce);
		if( user != null ){
			List<Address> addresses = addressService.getAddress(user.getId()) ;
			Product product = new Product() ;
			product.setFileName(fileName);
			
//			try {
//				name = new String( name.getBytes("ISO8859-1"),"utf-8") ;
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			product.setName(name);
			product.setPrice(price);
			mav.setViewName("settlement2");
			mav.addObject("addresses", addresses) ;
			mav.addObject("product", product) ;
			mav.addObject("quantity", quantity) ;
		}else{
			mav.setViewName("login");
		}
		return mav ;
	}
}
