/**
 * ul li选项选中状态的切换
 */
$(function(){

	$("li").click(function(){
		$(this).siblings().removeClass("checked") ;
		$(this).addClass("checked") ;
		
	});
});

/**
 * 控制商品数量的增加
 * @param entityId
 * @param stock
 */
function addUpdate( entityId , stock ){
	var quantity = $("input[name='quantity']").val() ;
	if( stock <= quantity ){
		alert("库存不足") ;
		return false ;
	}
	$("input[name='quantity']").val( ++quantity ) ;
	
}
/**
 * 控制商品数量的减少
 * */
function jianUpdate( entityId ){
	var quantity = $("input[name='quantity']").val() ;
	--quantity ;
	if( quantity == 0 ){
		quantity = 1 ;
	}
	$("input[name='quantity']").val( quantity ) ;
	
}
/**
 * 筛选页面，跳转到购物车
 */
function addCard(){
	var quantity = $("input[name='quantity']").val() ;
	var productId = $("input[name='entityId']").val() ;
	//跳转到后台取出商品
	window.location.href="http://localhost:8080/easybuySSM1/addCar?productId="
		+productId+ "&quantity="+quantity;
}
/*
 * 修改购物车中的数量
 */
function subQuantity( obj , price , entityId ){
	var index = $(".car_btn_1").index(obj) ;
	var quantity = $("input[name='quantit']").eq(index).val() ;
	--quantity ;
	if( quantity == 0 ){
		return false ;
	}
	//将数据写到原有的输入框内
	$("input[name='quantit']").eq(index).val( quantity ) ;
	// 单品价格
	var price = quantity * price ;
	$(".qprice").eq(index).html( price ) ;
	// 总价格
	var price_sku = $(".qprice");
	var values = 0;
	for (var i = 0; i < price_sku.length; i++){
		values += ( (parseFloat(price_sku[i].innerHTML)));
	}
	values = values.toFixed(1);	
	var result = values.toString();
	$("#totleprice").text("￥" + result);
	
}
function addQuantity( obj , price , entityId , stock ){
	var index = $(".car_btn_1").index(obj) ;	
	var quantity = $("input[name='quantit']").eq(index).val() ;
	if( quantity >= stock ){
		return false ;
	}
	quantity++ ;
	//将数据写到原有的输入框内
	$("input[name='quantit']").eq(index).val( quantity ) ;
	var price = quantity * price ;
	$(".qprice").eq(index).html( price ) ;
	
	var price_sku = $(".qprice");
	var values = 0;
	for (var i = 0; i < price_sku.length; i++){
		values += ( (parseFloat(price_sku[i].innerHTML)));
	}
	values = values.toFixed(1);
	var result = values.toString();
	$("#totleprice").text("￥" + result);
	
}


function removeCart( obj ){
	$(obj).parent().parent().remove() ;
}
/*
 * 确认信息页面
 */

function jiesuan(){
	var fileName = $("#fileName").val() ;
	var name = $("#name").val() ;
	var price = $("#myPrice").val() ;
	var quantity = $("input[name='quantit']").val() ;
	var totalPrice = $("#totleprice").text();
	window.location.href="isLogin?fileName="+fileName+"&name="+name+"&price="+price+"&quantity="+quantity + "&totalPirce=" + totalPrice;
	
}
