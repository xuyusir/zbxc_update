package com.jy.dao.system.select;

import com.jy.entiy.system.select.Taskstatus;
import com.jy.entiy.system.select.TaskstatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskstatusMapper {
    int countByExample(TaskstatusExample example);

    int deleteByExample(TaskstatusExample example);

    int deleteByPrimaryKey(Integer taskstatusid);

    int insert(Taskstatus record);

    int insertSelective(Taskstatus record);

    List<Taskstatus> selectByExample(TaskstatusExample example);

    Taskstatus selectByPrimaryKey(Integer taskstatusid);

    int updateByExampleSelective(@Param("record") Taskstatus record, @Param("example") TaskstatusExample example);

    int updateByExample(@Param("record") Taskstatus record, @Param("example") TaskstatusExample example);

    int updateByPrimaryKeySelective(Taskstatus record);

    int updateByPrimaryKey(Taskstatus record);
}