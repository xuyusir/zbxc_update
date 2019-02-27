package com.jy.dao.system.select;

import com.jy.entiy.system.select.Voteparticipanttype;
import com.jy.entiy.system.select.VoteparticipanttypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteparticipanttypeMapper {
    int countByExample(VoteparticipanttypeExample example);

    int deleteByExample(VoteparticipanttypeExample example);

    int deleteByPrimaryKey(Integer voteparticipanttypeid);

    int insert(Voteparticipanttype record);

    int insertSelective(Voteparticipanttype record);

    List<Voteparticipanttype> selectByExample(VoteparticipanttypeExample example);

    Voteparticipanttype selectByPrimaryKey(Integer voteparticipanttypeid);

    int updateByExampleSelective(@Param("record") Voteparticipanttype record, @Param("example") VoteparticipanttypeExample example);

    int updateByExample(@Param("record") Voteparticipanttype record, @Param("example") VoteparticipanttypeExample example);

    int updateByPrimaryKeySelective(Voteparticipanttype record);

    int updateByPrimaryKey(Voteparticipanttype record);
}