package com.jy.dao.system.select;

import com.jy.entiy.system.select.Votestatus;
import com.jy.entiy.system.select.VotestatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VotestatusMapper {
    int countByExample(VotestatusExample example);

    int deleteByExample(VotestatusExample example);

    int deleteByPrimaryKey(Integer votestatusid);

    int insert(Votestatus record);

    int insertSelective(Votestatus record);

    List<Votestatus> selectByExample(VotestatusExample example);

    Votestatus selectByPrimaryKey(Integer votestatusid);

    int updateByExampleSelective(@Param("record") Votestatus record, @Param("example") VotestatusExample example);

    int updateByExample(@Param("record") Votestatus record, @Param("example") VotestatusExample example);

    int updateByPrimaryKeySelective(Votestatus record);

    int updateByPrimaryKey(Votestatus record);
}