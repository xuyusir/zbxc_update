package com.jy.dao.system.email;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.email.Setmail;
import com.jy.entiy.system.email.SetmailExample;

public interface SetmailMapper {
    int countByExample(SetmailExample example);

    int deleteByExample(SetmailExample example);

    int deleteByPrimaryKey(Integer setmailid);

    int insert(Setmail record);

    int insertSelective(Setmail record);

    List<Setmail> selectByExample(SetmailExample example);

    Setmail selectByPrimaryKey(Integer setmailid);

    int updateByExampleSelective(@Param("record") Setmail record, @Param("example") SetmailExample example);

    int updateByExample(@Param("record") Setmail record, @Param("example") SetmailExample example);

    int updateByPrimaryKeySelective(Setmail record);

    int updateByPrimaryKey(Setmail record);
}