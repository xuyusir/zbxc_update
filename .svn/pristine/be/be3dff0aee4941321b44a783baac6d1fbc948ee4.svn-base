package com.jy.dao.function.marketingFunction.votingManagement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.marketingFunction.votingManagement.Voteitem;
import com.jy.entiy.function.marketingFunction.votingManagement.VoteitemExample;

public interface VoteitemMapper {
    int countByExample(VoteitemExample example);

    int deleteByExample(VoteitemExample example);

    int deleteByPrimaryKey(Integer voteitemid);

    int insert(Voteitem record);

    int insertSelective(Voteitem record);

    List<Voteitem> selectByExample(VoteitemExample example);

    Voteitem selectByPrimaryKey(Integer voteitemid);

    int updateByExampleSelective(@Param("record") Voteitem record, @Param("example") VoteitemExample example);

    int updateByExample(@Param("record") Voteitem record, @Param("example") VoteitemExample example);

    int updateByPrimaryKeySelective(Voteitem record);

    int updateByPrimaryKey(Voteitem record);
    
    List<Voteitem> selectVoteitemList(
    		@Param("voteid")Integer voteid,//所属投票id
    		@Param("voteitemid") Integer voteitemid,//题目编号
    		@Param("search") String search,//题目名字
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountVoteitemList(
    		@Param("voteid")Integer voteid,//所属投票id
    		@Param("voteitemid") Integer voteitemid,//题目编号
    		@Param("search") String search);
    /**
     * 本题的有效投票人次
     * @param voteid
     * @param voteitemid
     * @return
     */
    int pNum(@Param("voteid")Integer voteid,//所属投票id
    		@Param("voteitemid") Integer voteitemid//题目编号
    		);
}