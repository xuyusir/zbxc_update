package com.jy.dao.staff;

import com.jy.entiy.staff.Staffarchives;
import com.jy.entiy.staff.StaffarchivesExample;
import com.jy.entiy.staff.StaffarchivesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffarchivesMapper {
    int countByExample(StaffarchivesExample example);

    int deleteByExample(StaffarchivesExample example);

    int deleteByPrimaryKey(StaffarchivesKey key);

    int insert(Staffarchives record);

    int insertSelective(Staffarchives record);

    List<Staffarchives> selectByExample(StaffarchivesExample example);

    Staffarchives selectByPrimaryKey(StaffarchivesKey key);

    int updateByExampleSelective(@Param("record") Staffarchives record, @Param("example") StaffarchivesExample example);

    int updateByExample(@Param("record") Staffarchives record, @Param("example") StaffarchivesExample example);

    int updateByPrimaryKeySelective(Staffarchives record);

    int updateByPrimaryKey(Staffarchives record);
}