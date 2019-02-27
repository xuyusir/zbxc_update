package com.jy.dao.order.order;

import com.jy.entiy.order.order.Orders;
import com.jy.entiy.order.order.OrdersExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
	List<Orders> selectOrders(Map<String, Object> param);

	Integer selectOrdersCount(Map<String, Object> param);

	int countByExample(OrdersExample example);

	int deleteByExample(OrdersExample example);

	int deleteByPrimaryKey(Long orderid);

	int insert(Orders record);

	int insertSelective(Orders record);

	List<Orders> selectByExample(OrdersExample example);

	Orders selectByPrimaryKey(Long orderid);

	int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

	int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

	int updateByPrimaryKeySelective(Orders record);

	int updateByPrimaryKey(Orders record);
}