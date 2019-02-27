package com.jy.dao.function.person;

import com.jy.entiy.function.person.Personexaminereport;
import com.jy.entiy.function.person.PersonexaminereportExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonexaminereportMapper {
    int countByExample(PersonexaminereportExample example);

    int deleteByExample(PersonexaminereportExample example);

    int deleteByPrimaryKey(Long pexaminereportid);

    int insert(Personexaminereport record);

    int insertSelective(Personexaminereport record);

    List<Personexaminereport> selectByExample(PersonexaminereportExample example);

    Personexaminereport selectByPrimaryKey(Long pexaminereportid);

    int updateByExampleSelective(@Param("record") Personexaminereport record, @Param("example") PersonexaminereportExample example);

    int updateByExample(@Param("record") Personexaminereport record, @Param("example") PersonexaminereportExample example);

    int updateByPrimaryKeySelective(Personexaminereport record);

    int updateByPrimaryKey(Personexaminereport record);

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/16 12:53
     * 描述 : 查询增值报告地址
     *
     * @param accountID 账号ID
     * @return
     */
    String getFilePath(@Param("accountID")Long accountID);
}