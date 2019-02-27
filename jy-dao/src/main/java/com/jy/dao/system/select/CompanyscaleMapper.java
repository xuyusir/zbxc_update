package com.jy.dao.system.select;

import com.jy.entiy.system.select.Companyscale;
import com.jy.entiy.system.select.CompanyscaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyscaleMapper {
    int countByExample(CompanyscaleExample example);

    int deleteByExample(CompanyscaleExample example);

    int deleteByPrimaryKey(Integer companyscaleid);

    int insert(Companyscale record);

    int insertSelective(Companyscale record);

    List<Companyscale> selectByExample(CompanyscaleExample example);

    Companyscale selectByPrimaryKey(Integer companyscaleid);

    int updateByExampleSelective(@Param("record") Companyscale record, @Param("example") CompanyscaleExample example);

    int updateByExample(@Param("record") Companyscale record, @Param("example") CompanyscaleExample example);

    int updateByPrimaryKeySelective(Companyscale record);

    int updateByPrimaryKey(Companyscale record);
}