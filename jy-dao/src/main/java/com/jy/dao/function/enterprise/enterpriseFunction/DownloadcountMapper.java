package com.jy.dao.function.enterprise.enterpriseFunction;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.enterprise.enterpriseFunction.Downloadcount;
import com.jy.entiy.function.enterprise.enterpriseFunction.DownloadcountExample;

public interface DownloadcountMapper {
    int countByExample(DownloadcountExample example);

    int deleteByExample(DownloadcountExample example);

    int deleteByPrimaryKey(Long downloadcountid);

    int insert(Downloadcount record);

    int insertSelective(Downloadcount record);

    List<Downloadcount> selectByExample(DownloadcountExample example);

    Downloadcount selectByPrimaryKey(Long downloadcountid);

    int updateByExampleSelective(@Param("record") Downloadcount record, @Param("example") DownloadcountExample example);

    int updateByExample(@Param("record") Downloadcount record, @Param("example") DownloadcountExample example);

    int updateByPrimaryKeySelective(Downloadcount record);

    int updateByPrimaryKey(Downloadcount record);
}