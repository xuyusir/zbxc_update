package com.jy.dao.function.enterprise.recruitment;

import com.jy.entiy.function.enterprise.recruitment.Interviewremark;
import com.jy.entiy.function.enterprise.recruitment.InterviewremarkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterviewremarkMapper {
    int countByExample(InterviewremarkExample example);

    int deleteByExample(InterviewremarkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Interviewremark record);

    int insertSelective(Interviewremark record);

    List<Interviewremark> selectByExample(InterviewremarkExample example);

    Interviewremark selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Interviewremark record, @Param("example") InterviewremarkExample example);

    int updateByExample(@Param("record") Interviewremark record, @Param("example") InterviewremarkExample example);

    int updateByPrimaryKeySelective(Interviewremark record);

    int updateByPrimaryKey(Interviewremark record);
}