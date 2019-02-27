package com.jy.dao.content.file.question_bank;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.file.question_bank.Business;
import com.jy.entiy.content.file.question_bank.BusinessExample;

public interface BusinessMapper {
    int countByExample(BusinessExample example);

    int deleteByExample(BusinessExample example);

    int deleteByPrimaryKey(Integer businessid);

    int insert(Business record);

    int insertSelective(Business record);

    List<Business> selectByExample(BusinessExample example);

    Business selectByPrimaryKey(Integer businessid);

    int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
    
    String getBusinessNameByBusinessID(@Param("business_id") Integer business_id);
}