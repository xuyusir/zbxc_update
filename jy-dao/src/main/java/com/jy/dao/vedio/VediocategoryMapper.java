package com.jy.dao.vedio;

import com.jy.entiy.vedio.Vediocategory;
import com.jy.entiy.vedio.VediocategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VediocategoryMapper {
    int countByExample(VediocategoryExample example);

    int deleteByExample(VediocategoryExample example);

    int deleteByPrimaryKey(Integer vediocategoryid);

    int insert(Vediocategory record);

    int insertSelective(Vediocategory record);

    List<Vediocategory> selectByExample(VediocategoryExample example);

    Vediocategory selectByPrimaryKey(Integer vediocategoryid);

    int updateByExampleSelective(@Param("record") Vediocategory record, @Param("example") VediocategoryExample example);

    int updateByExample(@Param("record") Vediocategory record, @Param("example") VediocategoryExample example);

    int updateByPrimaryKeySelective(Vediocategory record);

    int updateByPrimaryKey(Vediocategory record);
}