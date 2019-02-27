package com.jy.dao.function.marketingFunction.votingManagement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.marketingFunction.votingManagement.Voteoption;
import com.jy.entiy.function.marketingFunction.votingManagement.VoteoptionExample;

public interface VoteoptionMapper {
    int countByExample(VoteoptionExample example);

    int deleteByExample(VoteoptionExample example);

    int deleteByPrimaryKey(Integer voteoptionid);

    int insert(Voteoption record);

    int insertSelective(Voteoption record);

    List<Voteoption> selectByExample(VoteoptionExample example);

    Voteoption selectByPrimaryKey(Integer voteoptionid);

    int updateByExampleSelective(@Param("record") Voteoption record, @Param("example") VoteoptionExample example);

    int updateByExample(@Param("record") Voteoption record, @Param("example") VoteoptionExample example);

    int updateByPrimaryKeySelective(Voteoption record);

    int updateByPrimaryKey(Voteoption record);
    List<Voteoption> selectVoteoptionList(
    		@Param("voteitemid")Integer voteitemid,//所属题目id
    		@Param("voteoptionid") Integer voteoptionid,//选项编号
    		@Param("search") String search,//选项名字
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountVoteoptionList(
    		@Param("voteitemid")Integer voteitemid,//所属题目id
    		@Param("voteoptionid") Integer voteoptionid,//选项编号
    		@Param("search") String search);
}