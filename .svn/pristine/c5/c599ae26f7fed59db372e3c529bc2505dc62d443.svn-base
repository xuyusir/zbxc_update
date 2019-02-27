package com.jy.dao.function.person;

import com.jy.entiy.function.person.Livelocation;
import com.jy.entiy.function.person.LivelocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LivelocationMapper {
    int countByExample(LivelocationExample example);

    int deleteByExample(LivelocationExample example);

    int deleteByPrimaryKey(Long livelocationid);

    int insert(Livelocation record);

    int insertSelective(Livelocation record);

    List<Livelocation> selectByExample(LivelocationExample example);

    Livelocation selectByPrimaryKey(Long livelocationid);

    int updateByExampleSelective(@Param("record") Livelocation record, @Param("example") LivelocationExample example);

    int updateByExample(@Param("record") Livelocation record, @Param("example") LivelocationExample example);

    int updateByPrimaryKeySelective(Livelocation record);

    int updateByPrimaryKey(Livelocation record);
}