package com.jy.dao.content.product.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.product.product.Productrecommendpostionbind;
import com.jy.entiy.content.product.product.ProductrecommendpostionbindExample;

public interface ProductrecommendpostionbindMapper {
    int countByExample(ProductrecommendpostionbindExample example);

    int deleteByExample(ProductrecommendpostionbindExample example);

    int deleteByPrimaryKey(Integer productrpid);

    int insert(Productrecommendpostionbind record);

    int insertSelective(Productrecommendpostionbind record);

    List<Productrecommendpostionbind> selectByExample(ProductrecommendpostionbindExample example);

    Productrecommendpostionbind selectByPrimaryKey(Integer productrpid);

    int updateByExampleSelective(@Param("record") Productrecommendpostionbind record, @Param("example") ProductrecommendpostionbindExample example);

    int updateByExample(@Param("record") Productrecommendpostionbind record, @Param("example") ProductrecommendpostionbindExample example);

    int updateByPrimaryKeySelective(Productrecommendpostionbind record);

    int updateByPrimaryKey(Productrecommendpostionbind record);
}