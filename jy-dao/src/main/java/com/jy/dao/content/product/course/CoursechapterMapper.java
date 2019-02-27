package com.jy.dao.content.product.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.product.course.Coursechapter;
import com.jy.entiy.content.product.course.CoursechapterExample;

public interface CoursechapterMapper {
    int countByExample(CoursechapterExample example);

    int deleteByExample(CoursechapterExample example);

    int deleteByPrimaryKey(Long charpterid);

    int insert(Coursechapter record);

    int insertSelective(Coursechapter record);

    List<Coursechapter> selectByExample(CoursechapterExample example);

    Coursechapter selectByPrimaryKey(Long charpterid);

    int updateByExampleSelective(@Param("record") Coursechapter record, @Param("example") CoursechapterExample example);

    int updateByExample(@Param("record") Coursechapter record, @Param("example") CoursechapterExample example);

    int updateByPrimaryKeySelective(Coursechapter record);

    int updateByPrimaryKey(Coursechapter record);
}