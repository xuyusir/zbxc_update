package com.jy.dao.order.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.order.order.Orderdetails;
import com.jy.entiy.order.order.OrderdetailsExample;

public interface OrderdetailsMapper {
    int countByExample(OrderdetailsExample example);

    int deleteByExample(OrderdetailsExample example);

    int deleteByPrimaryKey(Long orderdetailsid);

    int insert(Orderdetails record);

    int insertSelective(Orderdetails record);

    List<Orderdetails> selectByExample(OrderdetailsExample example);

    Orderdetails selectByPrimaryKey(Long orderdetailsid);

    int updateByExampleSelective(@Param("record") Orderdetails record, @Param("example") OrderdetailsExample example);

    int updateByExample(@Param("record") Orderdetails record, @Param("example") OrderdetailsExample example);

    int updateByPrimaryKeySelective(Orderdetails record);

    int updateByPrimaryKey(Orderdetails record);
}