package com.jy.dao.account.authority;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.dao.system.select.SelectResult;
import com.jy.entiy.account.authority.Role;
import com.jy.entiy.account.authority.RoleExample;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    Integer getRoleCountByParentID(@Param("ParentID") Integer ParentID);
    
    String getNameByRoleID(@Param("RoleID") Integer RoleID);
    
    List<SelectResult> getRoleSelect();
}