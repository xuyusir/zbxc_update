package com.jy.dao.function.marketingFunction.votingManagement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.marketingFunction.votingManagement.Voteconfig;
import com.jy.entiy.function.marketingFunction.votingManagement.VoteconfigExample;
import com.jy.entiy.function.marketingFunction.votingManagement.Voteitem;

public interface VoteconfigMapper {
    int countByExample(VoteconfigExample example);

    int deleteByExample(VoteconfigExample example);

    int deleteByPrimaryKey(Integer voteid);

    int insert(Voteconfig record);

    int insertSelective(Voteconfig record);

    List<Voteconfig> selectByExample(VoteconfigExample example);

    Voteconfig selectByPrimaryKey(Integer voteid);

    int updateByExampleSelective(@Param("record") Voteconfig record, @Param("example") VoteconfigExample example);

    int updateByExample(@Param("record") Voteconfig record, @Param("example") VoteconfigExample example);

    int updateByPrimaryKeySelective(Voteconfig record);

    int updateByPrimaryKey(Voteconfig record);
    
    List<Voteconfig> selectVoteconfigList(
    		@Param("votestatusid")Integer votestatusid,//状态id
    		@Param("voteparticipanttypeid")Integer voteparticipanttypeid,//参与人群类别
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountVoteconfigList(
    		@Param("votestatusid")Integer votestatusid,//状态id
    		@Param("voteparticipanttypeid")Integer voteparticipanttypeid,//参与人群类别
    		@Param("search") String search);
}