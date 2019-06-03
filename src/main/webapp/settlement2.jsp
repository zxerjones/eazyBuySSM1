<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="header.jsp" %>
    <style type="">
    	#product_name_span {
				margin-left: -80px;
			    width: 100px;
			    display: inline-block;
			    height: 105px;
			    line-height: 105px;
}
    	
    </style>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$(".nav").hover(function(){						   
				$(this).find(".leftNav").show();
			},function(){
				$(this).find(".leftNav").hide();
			});
			$(".leftNav ul li").hover(
				function(){
					$(this).find(".fj").addClass("nuw");
					$(this).find(".zj").show();
				}
				,
				function(){
					$(this).find(".fj").removeClass("nuw");
					$(this).find(".zj").hide();
				}
			);
    	})
    </script>
    <title>易买网</title>
</head>
<body>
<!--Begin Header Begin-->
<div id="searchBar">
    <%@ include file="searchBar.jsp" %>
</div>
<!--End Header End-->
<!--Begin Menu Begin-->
<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        <%@ include file="categoryBar.jsp" %>
        <!--End 商品分类详情 End-->
    </div>
</div>
<!--End Menu End-->
<div class="i_bg">
    <div id="settlement">
    
			<div class="content mar_20">
			    <img src="images/img2.jpg"/>
			</div>
			<div class="content mar_20">
			    <div class="two_bg">
			        <div class="two_t">
			            <span class="fr"><a href="toSettlement.jsp" ">修改</a></span>商品列表
			        </div>
			        <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
			            <tr>
			                <td class="car_th" width="550">商品名称</td>
			                <td class="car_th" width="150">购买数量</td>
			                <td class="car_th" width="130">小计</td>
			            </tr>
			            <tr>
		                    <td align="center">
		                        <div class="c_s_img">
		                            <img src="images/${product.fileName }" width="73" height="73"/>
		                        </div>
		                         <span id="product_name_span">${product.name }<span>
		                    </td>
		                    <td align="center">${quantity }</td>
		                    <td align="center" style="color:#ff4e00;">￥${product.price*quantity  }</td>
		                </tr>
			            
			            <!-- 
			            <c:forEach items="${sessionScope.cart }" var="product">
			            	<tr>
			                    <td align="center">
			                        <div class="c_s_img">
			                            <img src="images/${product.value.fileName }" width="73" height="73"/>
			                        </div>
			                            ${product.value.name }
			                    </td>
			                    <td align="center">${product.value.quantity }</td>
			                    <td align="center" style="color:#ff4e00;">￥${product.value.price*product.value.quantity  }</td>
			                </tr>
			            </c:forEach>
			             -->    
			            
			        </table>
			
			        <div class="two_t">
			            <span class="fr"></span>收货人信息
			        </div>
			        <table border="0" class="peo_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
			            <tr>
			                <td class="p_td" width="160">用户名称</td>
			                <td width="395">${user.userName }</td>
			                <td class="p_td">登录名称</td>
			                <td>${user.loginName }</td>
			            </tr>
			            <tr>
			                <td class="p_td">手机</td>
			                <td>${user.mobile }</td>
			                <td class="p_td" width="160">电子邮件</td>
			                <td width="395">${user.email }</td>
			            </tr>
			        </table>
			        <div class="two_t">
			            <span class="fr"></span>选择地址
			        </div>
			        <table border="0" class="peo_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
			            <c:forEach items="${addresses }" var="address">
			            	<tr>
			                    <td class="p_td" width="160">
			                        <input type="radio" name="selectAddress" value="${address.id }">
			                    </td>
			                    <td>
			                            ${address.address }
			                    </td>
			                </tr>
			            </c:forEach>
			            <tr>
			                <td class="p_td" width="160">
			                    新地址<input type="radio" name="selectAddress" value="-1">
			                </td>
			                <td>
			                    地址 <input type="text" value="" name="address" class="add_ipt"> 
			                    备注 <input type="text" value="" name="remark" class="add_ipt">
			                </td>
			            </tr>
			            
			        </table>
			        <table border="0" style="width:900px; margin-top:20px;" cellspacing="0" cellpadding="0">
			            <tr height="70">
			                <td align="right">
			                    <b style="font-size:14px;">应付款金额：<span
			                            style="font-size:22px; color:#ff4e00;">￥${product.price*quantity  }</span></b>
			                </td>
			            </tr>
			            <tr height="70">
			                <td align="right"><a href="javascript:void(0)" onclick="settlement3();"><img
			                        src="images/btn_sure.gif"/></a></td>
			            </tr>
			        </table>
			    </div>
			</div>
    </div>
    <script>
        $(function(){
           // settlement1();
        });
    </script>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
