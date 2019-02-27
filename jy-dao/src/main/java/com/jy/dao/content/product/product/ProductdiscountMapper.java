package com.jy.dao.content.product.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.product.product.Productdiscount;
import com.jy.entiy.content.product.product.ProductdiscountExample;

public interface ProductdiscountMapper {
    int countByExample(ProductdiscountExample example);

    int deleteByExample(ProductdiscountExample example);

    int deleteByPrimaryKey(Integer productdiscountid);

    int insert(Productdiscount record);

    int insertSelective(Productdiscount record);

    List<Productdiscount> selectByExample(ProductdiscountExample example);

    Productdiscount selectByPrimaryKey(Integer productdiscountid);

    int updateByExampleSelective(@Param("record") Productdiscount record, @Param("example") ProductdiscountExample example);

    int updateByExample(@Param("record") Productdiscount record, @Param("example") ProductdiscountExample example);

    int updateByPrimaryKeySelective(Productdiscount record);

    int updateByPrimaryKey(Productdiscount record);
}