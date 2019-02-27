package com.jy.dao.system.web.bottomLink;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.web.bottomLink.Bottomlink;
import com.jy.entiy.system.web.bottomLink.BottomlinkExample;

public interface BottomlinkMapper {
    int countByExample(BottomlinkExample example);

    int deleteByExample(BottomlinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bottomlink record);

    int insertSelective(Bottomlink record);

    List<Bottomlink> selectByExample(BottomlinkExample example);

    Bottomlink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bottomlink record, @Param("example") BottomlinkExample example);

    int updateByExample(@Param("record") Bottomlink record, @Param("example") BottomlinkExample example);

    int updateByPrimaryKeySelective(Bottomlink record);

    int updateByPrimaryKey(Bottomlink record);
}