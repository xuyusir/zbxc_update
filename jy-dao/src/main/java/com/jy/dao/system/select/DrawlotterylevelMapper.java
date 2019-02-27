package com.jy.dao.system.select;

import com.jy.entiy.system.select.Drawlotterylevel;
import com.jy.entiy.system.select.DrawlotterylevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrawlotterylevelMapper {
    int countByExample(DrawlotterylevelExample example);

    int deleteByExample(DrawlotterylevelExample example);

    int deleteByPrimaryKey(Integer drawlotterylevelid);

    int insert(Drawlotterylevel record);

    int insertSelective(Drawlotterylevel record);

    List<Drawlotterylevel> selectByExample(DrawlotterylevelExample example);

    Drawlotterylevel selectByPrimaryKey(Integer drawlotterylevelid);

    int updateByExampleSelective(@Param("record") Drawlotterylevel record, @Param("example") DrawlotterylevelExample example);

    int updateByExample(@Param("record") Drawlotterylevel record, @Param("example") DrawlotterylevelExample example);

    int updateByPrimaryKeySelective(Drawlotterylevel record);

    int updateByPrimaryKey(Drawlotterylevel record);
}