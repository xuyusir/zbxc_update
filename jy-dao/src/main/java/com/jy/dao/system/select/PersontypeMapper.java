package com.jy.dao.system.select;

import com.jy.entiy.system.select.Persontype;
import com.jy.entiy.system.select.PersontypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersontypeMapper {
    int countByExample(PersontypeExample example);

    int deleteByExample(PersontypeExample example);

    int deleteByPrimaryKey(Integer persontypeid);

    int insert(Persontype record);

    int insertSelective(Persontype record);

    List<Persontype> selectByExample(PersontypeExample example);

    Persontype selectByPrimaryKey(Integer persontypeid);

    int updateByExampleSelective(@Param("record") Persontype record, @Param("example") PersontypeExample example);

    int updateByExample(@Param("record") Persontype record, @Param("example") PersontypeExample example);

    int updateByPrimaryKeySelective(Persontype record);

    int updateByPrimaryKey(Persontype record);
    
   String getPersonTypeNameByPersonTypeID(@Param("person_type_id") Integer person_type_id);
}