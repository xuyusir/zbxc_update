package com.jy.dao.content.file.question_bank;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.file.question_bank.Interviewquestionbank;
import com.jy.entiy.content.file.question_bank.InterviewquestionbankExample;

public interface InterviewquestionbankMapper {
    int countByExample(InterviewquestionbankExample example);

    int deleteByExample(InterviewquestionbankExample example);

    int deleteByPrimaryKey(Long interviewqbid);

    int insert(Interviewquestionbank record);

    int insertSelective(Interviewquestionbank record);

    List<Interviewquestionbank> selectByExample(InterviewquestionbankExample example);

    Interviewquestionbank selectByPrimaryKey(Long interviewqbid);

    int updateByExampleSelective(@Param("record") Interviewquestionbank record, @Param("example") InterviewquestionbankExample example);

    int updateByExample(@Param("record") Interviewquestionbank record, @Param("example") InterviewquestionbankExample example);

    int updateByPrimaryKeySelective(Interviewquestionbank record);

    int updateByPrimaryKey(Interviewquestionbank record);
    
    List<Map<String, String>> getInterviewQuestionBankList(@Param("company_id") Integer company_id,@Param("search") String search, @Param("start_size") Integer start_size,@Param("page_size") Integer page_size );
    
    int getInterviewQuestionBankCount(@Param("company_id") Integer company_id,@Param("search") String search);
    
}