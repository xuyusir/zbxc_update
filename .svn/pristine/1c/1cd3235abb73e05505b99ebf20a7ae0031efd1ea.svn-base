package com.jy.dao.order.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.order.order.Orderactionlog;
import com.jy.entiy.order.order.OrderactionlogExample;

public interface OrderactionlogMapper {
    int countByExample(OrderactionlogExample example);

    int deleteByExample(OrderactionlogExample example);

    int deleteByPrimaryKey(Long orderactionlogid);

    int insert(Orderactionlog record);

    int insertSelective(Orderactionlog record);

    List<Orderactionlog> selectByExample(OrderactionlogExample example);

    Orderactionlog selectByPrimaryKey(Long orderactionlogid);

    int updateByExampleSelective(@Param("record") Orderactionlog record, @Param("example") OrderactionlogExample example);

    int updateByExample(@Param("record") Orderactionlog record, @Param("example") OrderactionlogExample example);

    int updateByPrimaryKeySelective(Orderactionlog record);

    int updateByPrimaryKey(Orderactionlog record);
}