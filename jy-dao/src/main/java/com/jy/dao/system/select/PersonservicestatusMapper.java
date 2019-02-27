package com.jy.dao.system.select;

import com.jy.entiy.system.select.Personservicestatus;
import com.jy.entiy.system.select.PersonservicestatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonservicestatusMapper {
    int countByExample(PersonservicestatusExample example);

    int deleteByExample(PersonservicestatusExample example);

    int deleteByPrimaryKey(Integer personservicestatusid);

    int insert(Personservicestatus record);

    int insertSelective(Personservicestatus record);

    List<Personservicestatus> selectByExample(PersonservicestatusExample example);

    Personservicestatus selectByPrimaryKey(Integer personservicestatusid);

    int updateByExampleSelective(@Param("record") Personservicestatus record, @Param("example") PersonservicestatusExample example);

    int updateByExample(@Param("record") Personservicestatus record, @Param("example") PersonservicestatusExample example);

    int updateByPrimaryKeySelective(Personservicestatus record);

    int updateByPrimaryKey(Personservicestatus record);
}