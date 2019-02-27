package com.jy.dao.system.select;

import com.jy.entiy.system.select.Recruitorderdate;
import com.jy.entiy.system.select.RecruitorderdateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecruitorderdateMapper {
    int countByExample(RecruitorderdateExample example);

    int deleteByExample(RecruitorderdateExample example);

    int deleteByPrimaryKey(Integer recruitorderdateid);

    int insert(Recruitorderdate record);

    int insertSelective(Recruitorderdate record);

    List<Recruitorderdate> selectByExample(RecruitorderdateExample example);

    Recruitorderdate selectByPrimaryKey(Integer recruitorderdateid);

    int updateByExampleSelective(@Param("record") Recruitorderdate record, @Param("example") RecruitorderdateExample example);

    int updateByExample(@Param("record") Recruitorderdate record, @Param("example") RecruitorderdateExample example);

    int updateByPrimaryKeySelective(Recruitorderdate record);

    int updateByPrimaryKey(Recruitorderdate record);
}