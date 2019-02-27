package com.jy.dao.system.select;

import com.jy.entiy.system.select.Appointservicetime;
import com.jy.entiy.system.select.AppointservicetimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppointservicetimeMapper {
    int countByExample(AppointservicetimeExample example);

    int deleteByExample(AppointservicetimeExample example);

    int deleteByPrimaryKey(Integer appointservicetimeid);

    int insert(Appointservicetime record);

    int insertSelective(Appointservicetime record);

    List<Appointservicetime> selectByExample(AppointservicetimeExample example);

    Appointservicetime selectByPrimaryKey(Integer appointservicetimeid);

    int updateByExampleSelective(@Param("record") Appointservicetime record, @Param("example") AppointservicetimeExample example);

    int updateByExample(@Param("record") Appointservicetime record, @Param("example") AppointservicetimeExample example);

    int updateByPrimaryKeySelective(Appointservicetime record);

    int updateByPrimaryKey(Appointservicetime record);
}