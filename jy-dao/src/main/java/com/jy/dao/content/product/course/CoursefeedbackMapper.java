package com.jy.dao.content.product.course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.product.course.Coursefeedback;
import com.jy.entiy.content.product.course.CoursefeedbackExample;

public interface CoursefeedbackMapper {
    int countByExample(CoursefeedbackExample example);

    int deleteByExample(CoursefeedbackExample example);

    int deleteByPrimaryKey(Long coursefeedbackid);

    int insert(Coursefeedback record);

    int insertSelective(Coursefeedback record);

    List<Coursefeedback> selectByExample(CoursefeedbackExample example);

    Coursefeedback selectByPrimaryKey(Long coursefeedbackid);

    int updateByExampleSelective(@Param("record") Coursefeedback record, @Param("example") CoursefeedbackExample example);

    int updateByExample(@Param("record") Coursefeedback record, @Param("example") CoursefeedbackExample example);

    int updateByPrimaryKeySelective(Coursefeedback record);

    int updateByPrimaryKey(Coursefeedback record);
}