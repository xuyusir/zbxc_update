package com.jy.dao.system.inMail;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.inMail.Message;
import com.jy.entiy.system.inMail.MessageExample;

public interface MessageMapper {
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    
    public List<Message> getMailList(@Param("recid")Long recid,@Param("startSize") Integer startSize, @Param("pageSize") Integer pageSize);
  
	public Integer getCountMailList(@Param("recid")Long recid);
}