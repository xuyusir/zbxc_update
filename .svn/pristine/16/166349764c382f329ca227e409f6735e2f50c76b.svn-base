package com.jy.dao.function.marketingFunction.lotteryManagement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.marketingFunction.lotteryManagement.Persondrawlottery;
import com.jy.entiy.function.marketingFunction.lotteryManagement.PersondrawlotteryExample;
import com.jy.entiy.function.marketingFunction.lotteryManagement.PersondrawlotteryKey;

public interface PersondrawlotteryMapper {
    int countByExample(PersondrawlotteryExample example);

    int deleteByExample(PersondrawlotteryExample example);

    int deleteByPrimaryKey(PersondrawlotteryKey key);

    int insert(Persondrawlottery record);

    int insertSelective(Persondrawlottery record);

    List<Persondrawlottery> selectByExample(PersondrawlotteryExample example);

    Persondrawlottery selectByPrimaryKey(PersondrawlotteryKey key);

    int updateByExampleSelective(@Param("record") Persondrawlottery record, @Param("example") PersondrawlotteryExample example);

    int updateByExample(@Param("record") Persondrawlottery record, @Param("example") PersondrawlotteryExample example);

    int updateByPrimaryKeySelective(Persondrawlottery record);

    int updateByPrimaryKey(Persondrawlottery record);
}