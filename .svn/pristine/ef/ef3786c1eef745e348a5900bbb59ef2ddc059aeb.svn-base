package com.jy.dao.function.person;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.person.Customresume;
import com.jy.entiy.function.person.CustomresumeExample;

public interface CustomresumeMapper {
    int countByExample(CustomresumeExample example);

    int deleteByExample(CustomresumeExample example);

    int deleteByPrimaryKey(Long customresumeid);

    int insert(Customresume record);

    int insertSelective(Customresume record);

    List<Customresume> selectByExample(CustomresumeExample example);

    Customresume selectByPrimaryKey(Long customresumeid);

    int updateByExampleSelective(@Param("record") Customresume record, @Param("example") CustomresumeExample example);

    int updateByExample(@Param("record") Customresume record, @Param("example") CustomresumeExample example);

    int updateByPrimaryKeySelective(Customresume record);

    int updateByPrimaryKey(Customresume record);
}