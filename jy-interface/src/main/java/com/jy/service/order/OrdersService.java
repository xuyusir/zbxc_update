package com.jy.service.order;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.order.order.Orders;

/**
 * 前后台订单管理业务逻辑层接口
 * @ClassName:OrdersService
 * @Description:	
 * @author:liuhong
 * @date:2018年8月17日
 */
public interface OrdersService {

	/**
	 * 获取订单列表
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws MyException 
	 */
	public Result getOrder(Map<String, Object> param, AccountInfo accountInfo) throws MyException;
	
	/**
	 * 删除订单详情信息
	 * @param orderdetailsID
	 * @param accountInfo
	 * @return
	 */
	//public Result deleteOrderdetails(Long orderdetailsID,AccountInfo accountInfo);
	
	/**
	 * 删除订单信息
	 * @param orderId
	 * @return
	 * @throws MyException 
	 */
	public Result deleteOrder(String ids,AccountInfo accountInfo) throws MyException;
	
	/**
	 * 生成订单
	 * @param AccountInfo
	 * @param orderName
	 * @param cartItems
	 * @return
	 * @throws MyException 
	 */
	public Result addOrder(AccountInfo accountInfo,Long ProductID,String ids) throws MyException;
	
	/**
	 * 往已有订单中添加订单详情订单
	 * @param account
	 * @param orderDetail
	 * @return
	 */
	//public Result addOrderdetails(AccountInfo account,List<Orderdetails> orderDetail);
	
	/**
	 * 获取订单状态
	 * @param OrderDetailsID
	 * @return
	 */
	//public Result getOrderStatus();
	
	/**
	 * 获取支付状态表
	 * @return
	 */
	//public Result getPayStatus();
	
	/**
	 * 根据订单ID获取订单详情
	 * @param orderId
	 * @return
	 */
	//public Result getOrderDetails(Map<String,Object> param,AccountInfo account);
	
	/**
	 * 后台确认关闭订单
	 * @param orderId
	 * @param account
	 * @return
	 * @throws MyException 
	 */
	public Result putOrder(AccountInfo account,Orders order) throws MyException;
	
	/**
	 * 修改订单详情信息
	 * @param account
	 * @param details
	 * @return
	 */
	//public Result putOrderdetails(AccountInfo account,Orderdetails details);
	
	/**
	 * 支付时查询订单信息
	 * @param orderId
	 * @param accountInfo
	 * @return
	 */
	public Map<String, String> payMoney(Long orderId,AccountInfo accountInfo);
	
	/**
	 *支付成功修改订单信息接口
	 * @param param
	 */
	public Result paySucess(Map<String,String> param);
	
	
	/**
	 * 修改订单自动关闭时间
	 * @param accountInfo
	 * @param time
	 * @return
	 * @throws MyException 
	 */
	public Result orderscolse(AccountInfo accountInfo,Integer time) throws MyException;
	
	/**
	 * 查询订单自动关闭时间
	 * @return
	 */
	public Result orderscolse();
	
	/**
	 * 导出订单
	 * @param OrderStatusID
	 * @param accountInfo
	 * @return
	 * @throws MyException 
	 */
	public HSSFWorkbook exportOrders(Integer OrderStatusID,AccountInfo accountInfo,String s,String date) throws MyException;
}
