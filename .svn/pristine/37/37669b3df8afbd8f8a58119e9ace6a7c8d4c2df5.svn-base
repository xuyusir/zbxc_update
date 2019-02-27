package com.jy.dao.system.select;

import com.jy.entiy.system.select.Trainingtype;
import com.jy.entiy.system.select.TrainingtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrainingtypeMapper {
    int countByExample(TrainingtypeExample example);

    int deleteByExample(TrainingtypeExample example);

    int deleteByPrimaryKey(Integer trainingtypeid);

    int insert(Trainingtype record);

    int insertSelective(Trainingtype record);

    List<Trainingtype> selectByExample(TrainingtypeExample example);

    Trainingtype selectByPrimaryKey(Integer trainingtypeid);

    int updateByExampleSelective(@Param("record") Trainingtype record, @Param("example") TrainingtypeExample example);

    int updateByExample(@Param("record") Trainingtype record, @Param("example") TrainingtypeExample example);

    int updateByPrimaryKeySelective(Trainingtype record);

    int updateByPrimaryKey(Trainingtype record);
}