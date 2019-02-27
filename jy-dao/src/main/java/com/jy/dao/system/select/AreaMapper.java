package com.jy.dao.system.select;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.select.Area;
import com.jy.entiy.system.select.AreaExample;

public interface AreaMapper {
    int countByExample(AreaExample example);

    int deleteByExample(AreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    List<Area> selectByExample(AreaExample example);

    Area selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    
    List<Map<String, String>> getSelect(@Param("code") String code);
    
    String getNameByCode(@Param("code") String code);
}