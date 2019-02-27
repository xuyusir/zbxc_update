package com.jy.dao.function.person.memberFunction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.person.memberFunction.Personserviceapplication;
import com.jy.entiy.function.person.memberFunction.PersonserviceapplicationExample;

public interface PersonserviceapplicationMapper {
    int countByExample(PersonserviceapplicationExample example);

    int deleteByExample(PersonserviceapplicationExample example);

    int deleteByPrimaryKey(Long serviceapplicationid);

    int insert(Personserviceapplication record);

    int insertSelective(Personserviceapplication record);

    List<Personserviceapplication> selectByExample(PersonserviceapplicationExample example);

    Personserviceapplication selectByPrimaryKey(Long serviceapplicationid);

    int updateByExampleSelective(@Param("record") Personserviceapplication record, @Param("example") PersonserviceapplicationExample example);

    int updateByExample(@Param("record") Personserviceapplication record, @Param("example") PersonserviceapplicationExample example);

    int updateByPrimaryKeySelective(Personserviceapplication record);

    int updateByPrimaryKey(Personserviceapplication record);
}