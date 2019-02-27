package com.jy.dao.order.shopping_cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.order.shopping_cart.Shoppingcartitem;
import com.jy.entiy.order.shopping_cart.ShoppingcartitemExample;

public interface ShoppingcartitemMapper {
    int countByExample(ShoppingcartitemExample example);

    int deleteByExample(ShoppingcartitemExample example);

    int deleteByPrimaryKey(Long cartitemid);

    int insert(Shoppingcartitem record);

    int insertSelective(Shoppingcartitem record);

    List<Shoppingcartitem> selectByExample(ShoppingcartitemExample example);

    Shoppingcartitem selectByPrimaryKey(Long cartitemid);

    int updateByExampleSelective(@Param("record") Shoppingcartitem record, @Param("example") ShoppingcartitemExample example);

    int updateByExample(@Param("record") Shoppingcartitem record, @Param("example") ShoppingcartitemExample example);

    int updateByPrimaryKeySelective(Shoppingcartitem record);

    int updateByPrimaryKey(Shoppingcartitem record);
}