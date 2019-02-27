package com.jy.dao.system.web.bottomLink;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.web.bottomLink.Bottomlinktype;
import com.jy.entiy.system.web.bottomLink.BottomlinktypeExample;

public interface BottomlinktypeMapper {
    int countByExample(BottomlinktypeExample example);

    int deleteByExample(BottomlinktypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bottomlinktype record);

    int insertSelective(Bottomlinktype record);

    List<Bottomlinktype> selectByExample(BottomlinktypeExample example);

    Bottomlinktype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bottomlinktype record, @Param("example") BottomlinktypeExample example);

    int updateByExample(@Param("record") Bottomlinktype record, @Param("example") BottomlinktypeExample example);

    int updateByPrimaryKeySelective(Bottomlinktype record);

    int updateByPrimaryKey(Bottomlinktype record);
}