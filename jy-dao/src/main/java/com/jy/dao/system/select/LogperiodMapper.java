package com.jy.dao.system.select;

import com.jy.entiy.system.select.Logperiod;
import com.jy.entiy.system.select.LogperiodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogperiodMapper {
    int countByExample(LogperiodExample example);

    int deleteByExample(LogperiodExample example);

    int deleteByPrimaryKey(Integer logperiodid);

    int insert(Logperiod record);

    int insertSelective(Logperiod record);

    List<Logperiod> selectByExample(LogperiodExample example);

    Logperiod selectByPrimaryKey(Integer logperiodid);

    int updateByExampleSelective(@Param("record") Logperiod record, @Param("example") LogperiodExample example);

    int updateByExample(@Param("record") Logperiod record, @Param("example") LogperiodExample example);

    int updateByPrimaryKeySelective(Logperiod record);

    int updateByPrimaryKey(Logperiod record);
}