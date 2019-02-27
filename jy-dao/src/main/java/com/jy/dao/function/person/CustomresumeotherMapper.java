package com.jy.dao.function.person;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.person.Customresumeother;
import com.jy.entiy.function.person.CustomresumeotherExample;

public interface CustomresumeotherMapper {
    int countByExample(CustomresumeotherExample example);

    int deleteByExample(CustomresumeotherExample example);

    int deleteByPrimaryKey(Long customresumeotherid);

    int insert(Customresumeother record);

    int insertSelective(Customresumeother record);

    List<Customresumeother> selectByExample(CustomresumeotherExample example);

    Customresumeother selectByPrimaryKey(Long customresumeotherid);

    int updateByExampleSelective(@Param("record") Customresumeother record, @Param("example") CustomresumeotherExample example);

    int updateByExample(@Param("record") Customresumeother record, @Param("example") CustomresumeotherExample example);

    int updateByPrimaryKeySelective(Customresumeother record);

    int updateByPrimaryKey(Customresumeother record);
}