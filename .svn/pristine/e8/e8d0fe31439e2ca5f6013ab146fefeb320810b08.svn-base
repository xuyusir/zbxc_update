package com.jy.dao.department;

import com.jy.entiy.department.Departmentpost;
import com.jy.entiy.department.DepartmentpostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentpostMapper {
    int countByExample(DepartmentpostExample example);

    int deleteByExample(DepartmentpostExample example);

    int deleteByPrimaryKey(Integer departmentpostid);

    int insert(Departmentpost record);

    int insertSelective(Departmentpost record);

    List<Departmentpost> selectByExample(DepartmentpostExample example);

    Departmentpost selectByPrimaryKey(Integer departmentpostid);

    int updateByExampleSelective(@Param("record") Departmentpost record, @Param("example") DepartmentpostExample example);

    int updateByExample(@Param("record") Departmentpost record, @Param("example") DepartmentpostExample example);

    int updateByPrimaryKeySelective(Departmentpost record);

    int updateByPrimaryKey(Departmentpost record);
}