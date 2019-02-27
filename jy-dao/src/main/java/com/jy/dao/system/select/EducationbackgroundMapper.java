package com.jy.dao.system.select;

import com.jy.entiy.system.select.Educationbackground;
import com.jy.entiy.system.select.EducationbackgroundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EducationbackgroundMapper {
    int countByExample(EducationbackgroundExample example);

    int deleteByExample(EducationbackgroundExample example);

    int deleteByPrimaryKey(Integer educationid);

    int insert(Educationbackground record);

    int insertSelective(Educationbackground record);

    List<Educationbackground> selectByExample(EducationbackgroundExample example);

    Educationbackground selectByPrimaryKey(Integer educationid);

    int updateByExampleSelective(@Param("record") Educationbackground record, @Param("example") EducationbackgroundExample example);

    int updateByExample(@Param("record") Educationbackground record, @Param("example") EducationbackgroundExample example);

    int updateByPrimaryKeySelective(Educationbackground record);

    int updateByPrimaryKey(Educationbackground record);
    
    String getEducationLevelByEducationID(@Param("education_id") Integer education_id);
}