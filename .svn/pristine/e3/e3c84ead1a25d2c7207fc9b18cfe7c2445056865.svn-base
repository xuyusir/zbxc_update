package com.jy.dao.system.select;

import com.jy.entiy.system.select.Applicationstatus;
import com.jy.entiy.system.select.ApplicationstatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationstatusMapper {
    int countByExample(ApplicationstatusExample example);

    int deleteByExample(ApplicationstatusExample example);

    int deleteByPrimaryKey(Integer applicationstatusid);

    int insert(Applicationstatus record);

    int insertSelective(Applicationstatus record);

    List<Applicationstatus> selectByExample(ApplicationstatusExample example);

    Applicationstatus selectByPrimaryKey(Integer applicationstatusid);

    int updateByExampleSelective(@Param("record") Applicationstatus record, @Param("example") ApplicationstatusExample example);

    int updateByExample(@Param("record") Applicationstatus record, @Param("example") ApplicationstatusExample example);

    int updateByPrimaryKeySelective(Applicationstatus record);

    int updateByPrimaryKey(Applicationstatus record);
}