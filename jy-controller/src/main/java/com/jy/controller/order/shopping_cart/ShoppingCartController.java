package com.jy.controller.order.shopping_cart;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.service.order.ShoppingCartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 购物车
 * 
 * @ClassName:ProductController
 * @Description:TODO
 * @author:liuhong
 * @date:2018年8月14日
 */
@Controller
@RequestMapping("/shoppingCart")
@Api(tags = "ShoppingCartController", description = "购物车模块")
public class ShoppingCartController extends BaseController {

	@Resource
	ShoppingCartService productService;

	/**
	 * 产品加入购物车
	 * 
	 * @param productId
	 * @param UnitPrice
	 * @param Discount
	 * @param Quainty
	 * @param request
	 * @return
	 * @throws MyException 
	 */
	@RequestMapping(value = "/addToShoppingCart", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "产品加入购物车", httpMethod = "POST", produces = "application/json")
	public Result addToShoppingCart(
			@ApiParam(value = "产品ID", required = true) Long productId,
			HttpServletRequest request) throws MyException {
		AccountInfo account = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return productService.addToShoppingCart(productId, account);
	}

	/**
	 * 查询购物车
	 * ok
	 * @param pageNumber
	 * @param pageCount
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getShoppingCart", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询购物车", httpMethod = "GET", produces = "application/json")
	public Result getShoppingCart(
			HttpServletRequest request) {
		AccountInfo account = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return productService.getShoppingCart(account);
	}

	/**
	 * 从购物车中删除商品
	 * 
	 * @param pageNumber
	 * @param pageCount
	 * @param request
	 * @return
	 * @throws MyException 
	 */
	@RequestMapping(value = "/deleteShopping", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "从购物车中删除商品", httpMethod = "DELETE", produces = "application/json")
	public Result deleteShopping(
			@ApiParam(value = "购物车中物品列表ID", required = true) Long cartitemid,
			HttpServletRequest request
			) throws MyException {
		AccountInfo account= (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return productService.deleteShopping(cartitemid,account);
	}
	

}
