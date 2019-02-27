package com.jy.dao.system.select;

import com.jy.entiy.system.select.Vediotype;
import com.jy.entiy.system.select.VediotypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VediotypeMapper {
    int countByExample(VediotypeExample example);

    int deleteByExample(VediotypeExample example);

    int deleteByPrimaryKey(Integer vediotypeid);

    int insert(Vediotype record);

    int insertSelective(Vediotype record);

    List<Vediotype> selectByExample(VediotypeExample example);

    Vediotype selectByPrimaryKey(Integer vediotypeid);

    int updateByExampleSelective(@Param("record") Vediotype record, @Param("example") VediotypeExample example);

    int updateByExample(@Param("record") Vediotype record, @Param("example") VediotypeExample example);

    int updateByPrimaryKeySelective(Vediotype record);

    int updateByPrimaryKey(Vediotype record);
}