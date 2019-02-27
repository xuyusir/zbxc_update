package com.jy.dao.system.select;

import com.jy.entiy.system.select.Contactstatus;
import com.jy.entiy.system.select.ContactstatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactstatusMapper {
    int countByExample(ContactstatusExample example);

    int deleteByExample(ContactstatusExample example);

    int deleteByPrimaryKey(Integer contactstatusid);

    int insert(Contactstatus record);

    int insertSelective(Contactstatus record);

    List<Contactstatus> selectByExample(ContactstatusExample example);

    Contactstatus selectByPrimaryKey(Integer contactstatusid);

    int updateByExampleSelective(@Param("record") Contactstatus record, @Param("example") ContactstatusExample example);

    int updateByExample(@Param("record") Contactstatus record, @Param("example") ContactstatusExample example);

    int updateByPrimaryKeySelective(Contactstatus record);

    int updateByPrimaryKey(Contactstatus record);
}