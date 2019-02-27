package com.jy.dao.content.file.question_bank;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.file.question_bank.Companyinfo;
import com.jy.entiy.content.file.question_bank.CompanyinfoExample;

public interface CompanyinfoMapper {
    int countByExample(CompanyinfoExample example);

    int deleteByExample(CompanyinfoExample example);

    int deleteByPrimaryKey(Integer companyid);

    int insert(Companyinfo record);

    int insertSelective(Companyinfo record);

    List<Companyinfo> selectByExample(CompanyinfoExample example);

    Companyinfo selectByPrimaryKey(Integer companyid);

    int updateByExampleSelective(@Param("record") Companyinfo record, @Param("example") CompanyinfoExample example);

    int updateByExample(@Param("record") Companyinfo record, @Param("example") CompanyinfoExample example);

    int updateByPrimaryKeySelective(Companyinfo record);

    int updateByPrimaryKey(Companyinfo record);
    
    String getCompanyNameByCompanyID(@Param("company_id") Integer company_id);
}