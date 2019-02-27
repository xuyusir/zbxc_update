package com.jy.dao.system.select;

import com.jy.entiy.system.select.Jobproperty;
import com.jy.entiy.system.select.JobpropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobpropertyMapper {
    int countByExample(JobpropertyExample example);

    int deleteByExample(JobpropertyExample example);

    int deleteByPrimaryKey(Integer jobpropertyid);

    int insert(Jobproperty record);

    int insertSelective(Jobproperty record);

    List<Jobproperty> selectByExample(JobpropertyExample example);

    Jobproperty selectByPrimaryKey(Integer jobpropertyid);

    int updateByExampleSelective(@Param("record") Jobproperty record, @Param("example") JobpropertyExample example);

    int updateByExample(@Param("record") Jobproperty record, @Param("example") JobpropertyExample example);

    int updateByPrimaryKeySelective(Jobproperty record);

    int updateByPrimaryKey(Jobproperty record);
}