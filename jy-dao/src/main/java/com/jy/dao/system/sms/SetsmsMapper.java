package com.jy.dao.system.sms;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.sms.Setsms;
import com.jy.entiy.system.sms.SetsmsExample;

public interface SetsmsMapper {
    int countByExample(SetsmsExample example);

    int deleteByExample(SetsmsExample example);

    int deleteByPrimaryKey(Integer setinfoid);

    int insert(Setsms record);

    int insertSelective(Setsms record);

    List<Setsms> selectByExample(SetsmsExample example);

    Setsms selectByPrimaryKey(Integer setinfoid);

    int updateByExampleSelective(@Param("record") Setsms record, @Param("example") SetsmsExample example);

    int updateByExample(@Param("record") Setsms record, @Param("example") SetsmsExample example);

    int updateByPrimaryKeySelective(Setsms record);

    int updateByPrimaryKey(Setsms record);
}