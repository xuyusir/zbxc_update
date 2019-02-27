package com.jy.dao.content.product.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.product.course.Personcoursenote;
import com.jy.entiy.content.product.course.PersoncoursenoteExample;

public interface PersoncoursenoteMapper {
    int countByExample(PersoncoursenoteExample example);

    int deleteByExample(PersoncoursenoteExample example);

    int deleteByPrimaryKey(Long coursenoteid);

    int insert(Personcoursenote record);

    int insertSelective(Personcoursenote record);

    List<Personcoursenote> selectByExample(PersoncoursenoteExample example);

    Personcoursenote selectByPrimaryKey(Long coursenoteid);

    int updateByExampleSelective(@Param("record") Personcoursenote record, @Param("example") PersoncoursenoteExample example);

    int updateByExample(@Param("record") Personcoursenote record, @Param("example") PersoncoursenoteExample example);

    int updateByPrimaryKeySelective(Personcoursenote record);

    int updateByPrimaryKey(Personcoursenote record);
}