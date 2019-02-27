package com.jy.dao.function.marketingFunction.lotteryManagement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.marketingFunction.lotteryManagement.Drawlotteryconfig;
import com.jy.entiy.function.marketingFunction.lotteryManagement.DrawlotteryconfigExample;

public interface DrawlotteryconfigMapper {
    int countByExample(DrawlotteryconfigExample example);

    int deleteByExample(DrawlotteryconfigExample example);

    int deleteByPrimaryKey(Integer drawlotteryconfigid);

    int insert(Drawlotteryconfig record);

    int insertSelective(Drawlotteryconfig record);

    List<Drawlotteryconfig> selectByExample(DrawlotteryconfigExample example);

    Drawlotteryconfig selectByPrimaryKey(Integer drawlotteryconfigid);

    int updateByExampleSelective(@Param("record") Drawlotteryconfig record, @Param("example") DrawlotteryconfigExample example);

    int updateByExample(@Param("record") Drawlotteryconfig record, @Param("example") DrawlotteryconfigExample example);

    int updateByPrimaryKeySelective(Drawlotteryconfig record);

    int updateByPrimaryKey(Drawlotteryconfig record);
    
    List<Drawlotteryconfig> selectDrawlotteryconfigList(
    		@Param("votestatusid")Integer votestatusid,//状态id
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountDrawlotteryconfigList(
    		@Param("votestatusid")Integer votestatusid,//状态id
    		@Param("search") String search);
}