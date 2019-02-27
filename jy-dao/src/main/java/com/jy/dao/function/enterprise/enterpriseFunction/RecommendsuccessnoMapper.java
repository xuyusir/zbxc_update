package com.jy.dao.function.enterprise.enterpriseFunction;

import com.jy.entiy.function.enterprise.enterpriseFunction.Recommendsuccessno;
import com.jy.entiy.function.enterprise.enterpriseFunction.RecommendsuccessnoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendsuccessnoMapper {
    int countByExample(RecommendsuccessnoExample example);

    int deleteByExample(RecommendsuccessnoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recommendsuccessno record);

    int insertSelective(Recommendsuccessno record);

    List<Recommendsuccessno> selectByExample(RecommendsuccessnoExample example);

    Recommendsuccessno selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recommendsuccessno record, @Param("example") RecommendsuccessnoExample example);

    int updateByExample(@Param("record") Recommendsuccessno record, @Param("example") RecommendsuccessnoExample example);

    int updateByPrimaryKeySelective(Recommendsuccessno record);

    int updateByPrimaryKey(Recommendsuccessno record);
}