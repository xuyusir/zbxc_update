package com.jy.dao.vedio;

import com.jy.entiy.vedio.Vedioinfo;
import com.jy.entiy.vedio.VedioinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VedioinfoMapper {
    int countByExample(VedioinfoExample example);

    int deleteByExample(VedioinfoExample example);

    int deleteByPrimaryKey(Long vedioid);

    int insert(Vedioinfo record);

    int insertSelective(Vedioinfo record);

    List<Vedioinfo> selectByExample(VedioinfoExample example);

    Vedioinfo selectByPrimaryKey(Long vedioid);

    int updateByExampleSelective(@Param("record") Vedioinfo record, @Param("example") VedioinfoExample example);

    int updateByExample(@Param("record") Vedioinfo record, @Param("example") VedioinfoExample example);

    int updateByPrimaryKeySelective(Vedioinfo record);

    int updateByPrimaryKey(Vedioinfo record);
}