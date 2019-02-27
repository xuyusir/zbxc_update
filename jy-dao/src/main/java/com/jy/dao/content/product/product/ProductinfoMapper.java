package com.jy.dao.content.product.product;

import com.jy.entiy.content.product.product.Productinfo;
import com.jy.entiy.content.product.product.ProductinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductinfoMapper {
    int countByExample(ProductinfoExample example);

    int deleteByExample(ProductinfoExample example);

    int deleteByPrimaryKey(Long productid);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    List<Productinfo> selectByExampleWithBLOBs(ProductinfoExample example);

    List<Productinfo> selectByExample(ProductinfoExample example);

    Productinfo selectByPrimaryKey(Long productid);

    int updateByExampleSelective(@Param("record") Productinfo record, @Param("example") ProductinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Productinfo record, @Param("example") ProductinfoExample example);

    int updateByExample(@Param("record") Productinfo record, @Param("example") ProductinfoExample example);

    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKeyWithBLOBs(Productinfo record);

    int updateByPrimaryKey(Productinfo record);
}