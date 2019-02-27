package com.jy.dao.system.select;

import com.jy.entiy.system.select.Orderstatus;
import com.jy.entiy.system.select.OrderstatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderstatusMapper {
    int countByExample(OrderstatusExample example);

    int deleteByExample(OrderstatusExample example);

    int deleteByPrimaryKey(Integer orderstatusid);

    int insert(Orderstatus record);

    int insertSelective(Orderstatus record);

    List<Orderstatus> selectByExample(OrderstatusExample example);

    Orderstatus selectByPrimaryKey(Integer orderstatusid);

    int updateByExampleSelective(@Param("record") Orderstatus record, @Param("example") OrderstatusExample example);

    int updateByExample(@Param("record") Orderstatus record, @Param("example") OrderstatusExample example);

    int updateByPrimaryKeySelective(Orderstatus record);

    int updateByPrimaryKey(Orderstatus record);
}