package com.jy.dao.system.web.info;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.web.info.Setwebinfo;
import com.jy.entiy.system.web.info.SetwebinfoExample;

public interface SetwebinfoMapper {
    int countByExample(SetwebinfoExample example);

    int deleteByExample(SetwebinfoExample example);

    int deleteByPrimaryKey(Integer websetinfoid);

    int insert(Setwebinfo record);

    int insertSelective(Setwebinfo record);

    List<Setwebinfo> selectByExample(SetwebinfoExample example);

    Setwebinfo selectByPrimaryKey(Integer websetinfoid);

    int updateByExampleSelective(@Param("record") Setwebinfo record, @Param("example") SetwebinfoExample example);

    int updateByExample(@Param("record") Setwebinfo record, @Param("example") SetwebinfoExample example);

    int updateByPrimaryKeySelective(Setwebinfo record);

    int updateByPrimaryKey(Setwebinfo record);
    
    int updateLogo(@Param("logo_name") String logo_name, @Param("id") Integer id);
}