package com.jy.dao.system.inMail;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.inMail.Messagetext;
import com.jy.entiy.system.inMail.MessagetextExample;

public interface MessagetextMapper {
    int countByExample(MessagetextExample example);

    int deleteByExample(MessagetextExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Messagetext record);

    int insertSelective(Messagetext record);

    List<Messagetext> selectByExample(MessagetextExample example);

    Messagetext selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Messagetext record, @Param("example") MessagetextExample example);

    int updateByExample(@Param("record") Messagetext record, @Param("example") MessagetextExample example);

    int updateByPrimaryKeySelective(Messagetext record);

    int updateByPrimaryKey(Messagetext record);

	Integer getRecentlyTextId();
}