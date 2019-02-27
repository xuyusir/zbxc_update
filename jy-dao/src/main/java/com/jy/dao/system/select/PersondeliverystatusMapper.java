package com.jy.dao.system.select;

import com.jy.entiy.system.select.Persondeliverystatus;
import com.jy.entiy.system.select.PersondeliverystatusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersondeliverystatusMapper {

    int countByExample(PersondeliverystatusExample example);

    int deleteByExample(PersondeliverystatusExample example);

    int deleteByPrimaryKey(Integer pdeliverystatusid);

    int insert(Persondeliverystatus record);

    int insertSelective(Persondeliverystatus record);

    List<Persondeliverystatus> selectByExample(PersondeliverystatusExample example);

    Persondeliverystatus selectByPrimaryKey(Integer pdeliverystatusid);

    int updateByExampleSelective(@Param("record") Persondeliverystatus record, @Param("example") PersondeliverystatusExample example);

    int updateByExample(@Param("record") Persondeliverystatus record, @Param("example") PersondeliverystatusExample example);

    int updateByPrimaryKeySelective(Persondeliverystatus record);

    int updateByPrimaryKey(Persondeliverystatus record);
}