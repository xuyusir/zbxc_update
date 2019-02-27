package com.jy.dao.function.person.info;

import com.jy.entiy.function.person.info.Personinfo;
import com.jy.entiy.function.person.info.PersoninfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersoninfoMapper {
    int countByExample(PersoninfoExample example);

    int deleteByExample(PersoninfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Personinfo record);

    int insertSelective(Personinfo record);

    List<Personinfo> selectByExample(PersoninfoExample example);

    Personinfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Personinfo record, @Param("example") PersoninfoExample example);

    int updateByExample(@Param("record") Personinfo record, @Param("example") PersoninfoExample example);

    int updateByPrimaryKeySelective(Personinfo record);

    int updateByPrimaryKey(Personinfo record);
}