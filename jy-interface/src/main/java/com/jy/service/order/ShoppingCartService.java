package com.jy.service.order;


import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * 产品详情页面接口Dao层
 * 
 * @ClassName:ProductDetailsService
 * @Description:
 * @author:liuhong
 * @date:2018年8月10日
 */
public interface ShoppingCartService {

	/**
	 * 将产品加入购物车
	 * 
	 * @param productId
	 * @param AccountInfo
	 * @return
	 * @throws MyException 
	 */
	public Result addToShoppingCart(Long productId,
			AccountInfo accountInfo) throws MyException;

	/**
	 * 查询购物车信息
	 * 
	 * @param pageNumber
	 * @param pageCount
	 * @param AccountInfo
	 * @return
	 */
	public Result getShoppingCart(AccountInfo accountInfo);


	/**
	 * 删除购物车列表中物品详情
	 * 
	 * @param orderId
	 * @return
	 * @throws MyException 
	 */
	public Result deleteShopping(Long cartitemid, AccountInfo account) throws MyException;
	

}
