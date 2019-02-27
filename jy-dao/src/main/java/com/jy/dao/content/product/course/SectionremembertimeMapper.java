package com.jy.dao.content.product.course;

import com.jy.entiy.content.product.course.Sectionremembertime;
import com.jy.entiy.content.product.course.SectionremembertimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SectionremembertimeMapper {
    int countByExample(SectionremembertimeExample example);

    int deleteByExample(SectionremembertimeExample example);

    int deleteByPrimaryKey(Long sectionremembertimeid);

    int insert(Sectionremembertime record);

    int insertSelective(Sectionremembertime record);

    List<Sectionremembertime> selectByExample(SectionremembertimeExample example);

    Sectionremembertime selectByPrimaryKey(Long sectionremembertimeid);

    int updateByExampleSelective(@Param("record") Sectionremembertime record, @Param("example") SectionremembertimeExample example);

    int updateByExample(@Param("record") Sectionremembertime record, @Param("example") SectionremembertimeExample example);

    int updateByPrimaryKeySelective(Sectionremembertime record);

    int updateByPrimaryKey(Sectionremembertime record);
}