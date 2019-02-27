package com.jy.dao.function.marketingFunction.registrationManagement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.marketingFunction.registrationManagement.Personsignin;
import com.jy.entiy.function.marketingFunction.registrationManagement.PersonsigninExample;
import com.jy.entiy.function.marketingFunction.registrationManagement.PersonsigninKey;

public interface PersonsigninMapper {
    int countByExample(PersonsigninExample example);

    int deleteByExample(PersonsigninExample example);

    int deleteByPrimaryKey(PersonsigninKey key);

    int insert(Personsignin record);

    int insertSelective(Personsignin record);

    List<Personsignin> selectByExample(PersonsigninExample example);

    Personsignin selectByPrimaryKey(PersonsigninKey key);

    int updateByExampleSelective(@Param("record") Personsignin record, @Param("example") PersonsigninExample example);

    int updateByExample(@Param("record") Personsignin record, @Param("example") PersonsigninExample example);

    int updateByPrimaryKeySelective(Personsignin record);

    int updateByPrimaryKey(Personsignin record);
}