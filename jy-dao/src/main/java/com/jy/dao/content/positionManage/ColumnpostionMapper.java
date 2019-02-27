package com.jy.dao.content.positionManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.positionManage.Columnpostion;
import com.jy.entiy.content.positionManage.ColumnpostionExample;

public interface ColumnpostionMapper {
    int countByExample(ColumnpostionExample example);

    int deleteByExample(ColumnpostionExample example);

    int deleteByPrimaryKey(Integer columnpostionid);

    int insert(Columnpostion record);

    int insertSelective(Columnpostion record);

    List<Columnpostion> selectByExample(ColumnpostionExample example);

    Columnpostion selectByPrimaryKey(Integer columnpostionid);

    int updateByExampleSelective(@Param("record") Columnpostion record, @Param("example") ColumnpostionExample example);

    int updateByExample(@Param("record") Columnpostion record, @Param("example") ColumnpostionExample example);

    int updateByPrimaryKeySelective(Columnpostion record);

    int updateByPrimaryKey(Columnpostion record);
}