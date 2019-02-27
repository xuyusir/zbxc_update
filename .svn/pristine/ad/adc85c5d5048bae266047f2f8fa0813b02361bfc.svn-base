package com.jy.dao.system.select;

import com.jy.entiy.system.select.Paystatus;
import com.jy.entiy.system.select.PaystatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaystatusMapper {
    int countByExample(PaystatusExample example);

    int deleteByExample(PaystatusExample example);

    int deleteByPrimaryKey(Integer paystatusid);

    int insert(Paystatus record);

    int insertSelective(Paystatus record);

    List<Paystatus> selectByExample(PaystatusExample example);

    Paystatus selectByPrimaryKey(Integer paystatusid);

    int updateByExampleSelective(@Param("record") Paystatus record, @Param("example") PaystatusExample example);

    int updateByExample(@Param("record") Paystatus record, @Param("example") PaystatusExample example);

    int updateByPrimaryKeySelective(Paystatus record);

    int updateByPrimaryKey(Paystatus record);
}