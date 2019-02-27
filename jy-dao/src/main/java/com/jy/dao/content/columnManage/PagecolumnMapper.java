package com.jy.dao.content.columnManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.columnManage.Pagecolumn;
import com.jy.entiy.content.columnManage.PagecolumnExample;

public interface PagecolumnMapper {
    int countByExample(PagecolumnExample example);

    int deleteByExample(PagecolumnExample example);

    int deleteByPrimaryKey(Integer pagecolumnid);

    int insert(Pagecolumn record);

    int insertSelective(Pagecolumn record);

    List<Pagecolumn> selectByExample(PagecolumnExample example);

    Pagecolumn selectByPrimaryKey(Integer pagecolumnid);

    int updateByExampleSelective(@Param("record") Pagecolumn record, @Param("example") PagecolumnExample example);

    int updateByExample(@Param("record") Pagecolumn record, @Param("example") PagecolumnExample example);

    int updateByPrimaryKeySelective(Pagecolumn record);

    int updateByPrimaryKey(Pagecolumn record);
}