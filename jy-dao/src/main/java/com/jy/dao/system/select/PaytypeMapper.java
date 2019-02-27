package com.jy.dao.system.select;

import com.jy.entiy.system.select.Paytype;
import com.jy.entiy.system.select.PaytypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaytypeMapper {
    int countByExample(PaytypeExample example);

    int deleteByExample(PaytypeExample example);

    int deleteByPrimaryKey(Integer paytypeid);

    int insert(Paytype record);

    int insertSelective(Paytype record);

    List<Paytype> selectByExample(PaytypeExample example);

    Paytype selectByPrimaryKey(Integer paytypeid);

    int updateByExampleSelective(@Param("record") Paytype record, @Param("example") PaytypeExample example);

    int updateByExample(@Param("record") Paytype record, @Param("example") PaytypeExample example);

    int updateByPrimaryKeySelective(Paytype record);

    int updateByPrimaryKey(Paytype record);
}