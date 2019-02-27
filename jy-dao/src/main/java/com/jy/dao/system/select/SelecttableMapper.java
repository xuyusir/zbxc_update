package com.jy.dao.system.select;

import com.jy.entiy.system.select.Selecttable;
import com.jy.entiy.system.select.SelecttableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelecttableMapper {
    int countByExample(SelecttableExample example);

    int deleteByExample(SelecttableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Selecttable record);

    int insertSelective(Selecttable record);

    List<Selecttable> selectByExample(SelecttableExample example);

    Selecttable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Selecttable record, @Param("example") SelecttableExample example);

    int updateByExample(@Param("record") Selecttable record, @Param("example") SelecttableExample example);

    int updateByPrimaryKeySelective(Selecttable record);

    int updateByPrimaryKey(Selecttable record);
}