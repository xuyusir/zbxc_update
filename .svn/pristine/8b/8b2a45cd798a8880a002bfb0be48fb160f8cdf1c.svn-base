package com.jy.dao.order.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.order.order.Orderscolse;
import com.jy.entiy.order.order.OrderscolseExample;

public interface OrderscolseMapper {
    int countByExample(OrderscolseExample example);

    int deleteByExample(OrderscolseExample example);

    int deleteByPrimaryKey(String code);

    int insert(Orderscolse record);

    int insertSelective(Orderscolse record);

    List<Orderscolse> selectByExample(OrderscolseExample example);

    Orderscolse selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") Orderscolse record, @Param("example") OrderscolseExample example);

    int updateByExample(@Param("record") Orderscolse record, @Param("example") OrderscolseExample example);

    int updateByPrimaryKeySelective(Orderscolse record);

    int updateByPrimaryKey(Orderscolse record);
}