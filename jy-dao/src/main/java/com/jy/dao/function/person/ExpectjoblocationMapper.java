package com.jy.dao.function.person;

import com.jy.entiy.function.person.Expectjoblocation;
import com.jy.entiy.function.person.ExpectjoblocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpectjoblocationMapper {
    int countByExample(ExpectjoblocationExample example);

    int deleteByExample(ExpectjoblocationExample example);

    int deleteByPrimaryKey(Long expectjoblocationid);

    int insert(Expectjoblocation record);

    int insertSelective(Expectjoblocation record);

    List<Expectjoblocation> selectByExample(ExpectjoblocationExample example);

    Expectjoblocation selectByPrimaryKey(Long expectjoblocationid);

    int updateByExampleSelective(@Param("record") Expectjoblocation record, @Param("example") ExpectjoblocationExample example);

    int updateByExample(@Param("record") Expectjoblocation record, @Param("example") ExpectjoblocationExample example);

    int updateByPrimaryKeySelective(Expectjoblocation record);

    int updateByPrimaryKey(Expectjoblocation record);
}