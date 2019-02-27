package com.jy.dao.system.select;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.select.Salarytype;
import com.jy.entiy.system.select.SalarytypeExample;

public interface SalarytypeMapper {
    int countByExample(SalarytypeExample example);

    int deleteByExample(SalarytypeExample example);

    int deleteByPrimaryKey(Integer salarytypeid);

    int insert(Salarytype record);

    int insertSelective(Salarytype record);

    List<Salarytype> selectByExample(SalarytypeExample example);

    Salarytype selectByPrimaryKey(Integer salarytypeid);

    int updateByExampleSelective(@Param("record") Salarytype record, @Param("example") SalarytypeExample example);

    int updateByExample(@Param("record") Salarytype record, @Param("example") SalarytypeExample example);

    int updateByPrimaryKeySelective(Salarytype record);

    int updateByPrimaryKey(Salarytype record);
}