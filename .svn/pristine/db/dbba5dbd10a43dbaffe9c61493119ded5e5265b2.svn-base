package com.jy.dao.system.menu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.menu.Menu;
import com.jy.entiy.system.menu.MenuExample;

public interface MenuMapper {
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    String getMenuNameByMenuId(@Param("MenuID") Integer MenuID);
    
    int getMenuCountByName(@Param("Name") String Name,@Param("ParentID") Integer ParentID);
    
   Integer getMenuIdByDictionariesID(@Param("DictionariesID") Integer DictionariesID);

}