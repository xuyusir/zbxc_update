package com.jy.dao.order.shopping_cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.order.shopping_cart.Shoppingcart;
import com.jy.entiy.order.shopping_cart.ShoppingcartExample;

public interface ShoppingcartMapper {
    int countByExample(ShoppingcartExample example);

    int deleteByExample(ShoppingcartExample example);

    int deleteByPrimaryKey(Long cartid);

    int insert(Shoppingcart record);

    int insertSelective(Shoppingcart record);

    List<Shoppingcart> selectByExample(ShoppingcartExample example);

    Shoppingcart selectByPrimaryKey(Long cartid);

    int updateByExampleSelective(@Param("record") Shoppingcart record, @Param("example") ShoppingcartExample example);

    int updateByExample(@Param("record") Shoppingcart record, @Param("example") ShoppingcartExample example);

    int updateByPrimaryKeySelective(Shoppingcart record);

    int updateByPrimaryKey(Shoppingcart record);
}