package com.jy.dao.system.select;

import com.jy.entiy.system.select.Jobtype;
import com.jy.entiy.system.select.JobtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobtypeMapper {
    int countByExample(JobtypeExample example);

    int deleteByExample(JobtypeExample example);

    int deleteByPrimaryKey(Integer jobtypeid);

    int insert(Jobtype record);

    int insertSelective(Jobtype record);

    List<Jobtype> selectByExample(JobtypeExample example);

    Jobtype selectByPrimaryKey(Integer jobtypeid);

    int updateByExampleSelective(@Param("record") Jobtype record, @Param("example") JobtypeExample example);

    int updateByExample(@Param("record") Jobtype record, @Param("example") JobtypeExample example);

    int updateByPrimaryKeySelective(Jobtype record);

    int updateByPrimaryKey(Jobtype record);
}