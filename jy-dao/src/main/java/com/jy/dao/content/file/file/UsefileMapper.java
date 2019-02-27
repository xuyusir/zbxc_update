package com.jy.dao.content.file.file;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.file.file.Usefile;
import com.jy.entiy.content.file.file.UsefileExample;

public interface UsefileMapper {
    int countByExample(UsefileExample example);

    int deleteByExample(UsefileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Usefile record);

    int insertSelective(Usefile record);

    List<Usefile> selectByExample(UsefileExample example);

    Usefile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Usefile record, @Param("example") UsefileExample example);

    int updateByExample(@Param("record") Usefile record, @Param("example") UsefileExample example);

    int updateByPrimaryKeySelective(Usefile record);

    int updateByPrimaryKey(Usefile record);
}