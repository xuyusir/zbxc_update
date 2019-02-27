package com.jy.dao.function.person;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.person.Workexpirence;
import com.jy.entiy.function.person.WorkexpirenceExample;

public interface WorkexpirenceMapper {
    int countByExample(WorkexpirenceExample example);

    int deleteByExample(WorkexpirenceExample example);

    int deleteByPrimaryKey(Long workexpirenceid);

    int insert(Workexpirence record);

    int insertSelective(Workexpirence record);

    List<Workexpirence> selectByExample(WorkexpirenceExample example);

    Workexpirence selectByPrimaryKey(Long workexpirenceid);

    int updateByExampleSelective(@Param("record") Workexpirence record, @Param("example") WorkexpirenceExample example);

    int updateByExample(@Param("record") Workexpirence record, @Param("example") WorkexpirenceExample example);

    int updateByPrimaryKeySelective(Workexpirence record);

    int updateByPrimaryKey(Workexpirence record);
}