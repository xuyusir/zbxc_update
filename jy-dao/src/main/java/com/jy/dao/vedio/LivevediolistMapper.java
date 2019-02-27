package com.jy.dao.vedio;

import com.jy.entiy.vedio.Livevediolist;
import com.jy.entiy.vedio.LivevediolistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LivevediolistMapper {
    int countByExample(LivevediolistExample example);

    int deleteByExample(LivevediolistExample example);

    int deleteByPrimaryKey(Long livevediolistid);

    int insert(Livevediolist record);

    int insertSelective(Livevediolist record);

    List<Livevediolist> selectByExample(LivevediolistExample example);

    Livevediolist selectByPrimaryKey(Long livevediolistid);

    int updateByExampleSelective(@Param("record") Livevediolist record, @Param("example") LivevediolistExample example);

    int updateByExample(@Param("record") Livevediolist record, @Param("example") LivevediolistExample example);

    int updateByPrimaryKeySelective(Livevediolist record);

    int updateByPrimaryKey(Livevediolist record);
}