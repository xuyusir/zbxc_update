package com.jy.dao.system.select;

import com.jy.entiy.system.select.Votetype;
import com.jy.entiy.system.select.VotetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VotetypeMapper {
    int countByExample(VotetypeExample example);

    int deleteByExample(VotetypeExample example);

    int deleteByPrimaryKey(Integer votetypeid);

    int insert(Votetype record);

    int insertSelective(Votetype record);

    List<Votetype> selectByExample(VotetypeExample example);

    Votetype selectByPrimaryKey(Integer votetypeid);

    int updateByExampleSelective(@Param("record") Votetype record, @Param("example") VotetypeExample example);

    int updateByExample(@Param("record") Votetype record, @Param("example") VotetypeExample example);

    int updateByPrimaryKeySelective(Votetype record);

    int updateByPrimaryKey(Votetype record);
}