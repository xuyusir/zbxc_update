package com.jy.dao.content.product.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.product.course.Personcourse;
import com.jy.entiy.content.product.course.PersoncourseExample;

public interface PersoncourseMapper {
    int countByExample(PersoncourseExample example);

    int deleteByExample(PersoncourseExample example);

    int deleteByPrimaryKey(Long personcourseid);

    int insert(Personcourse record);

    int insertSelective(Personcourse record);

    List<Personcourse> selectByExample(PersoncourseExample example);

    Personcourse selectByPrimaryKey(Long personcourseid);

    int updateByExampleSelective(@Param("record") Personcourse record, @Param("example") PersoncourseExample example);

    int updateByExample(@Param("record") Personcourse record, @Param("example") PersoncourseExample example);

    int updateByPrimaryKeySelective(Personcourse record);

    int updateByPrimaryKey(Personcourse record);
}