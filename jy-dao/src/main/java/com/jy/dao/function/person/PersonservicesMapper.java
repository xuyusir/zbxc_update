package com.jy.dao.function.person;

import com.jy.entiy.function.person.Personservices;
import com.jy.entiy.function.person.PersonservicesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonservicesMapper {
    int countByExample(PersonservicesExample example);

    int deleteByExample(PersonservicesExample example);

    int deleteByPrimaryKey(Long personserviceid);

    int insert(Personservices record);

    int insertSelective(Personservices record);

    List<Personservices> selectByExample(PersonservicesExample example);

    Personservices selectByPrimaryKey(Long personserviceid);

    int updateByExampleSelective(@Param("record") Personservices record, @Param("example") PersonservicesExample example);

    int updateByExample(@Param("record") Personservices record, @Param("example") PersonservicesExample example);

    int updateByPrimaryKeySelective(Personservices record);

    int updateByPrimaryKey(Personservices record);
}