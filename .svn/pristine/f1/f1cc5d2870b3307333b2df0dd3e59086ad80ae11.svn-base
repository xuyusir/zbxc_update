package com.jy.dao.function.marketingFunction.votingManagement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.marketingFunction.votingManagement.Votedetails;
import com.jy.entiy.function.marketingFunction.votingManagement.VotedetailsExample;

public interface VotedetailsMapper {
    int countByExample(VotedetailsExample example);

    int deleteByExample(VotedetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Votedetails record);

    int insertSelective(Votedetails record);

    List<Votedetails> selectByExample(VotedetailsExample example);

    Votedetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Votedetails record, @Param("example") VotedetailsExample example);

    int updateByExample(@Param("record") Votedetails record, @Param("example") VotedetailsExample example);

    int updateByPrimaryKeySelective(Votedetails record);

    int updateByPrimaryKey(Votedetails record);
}