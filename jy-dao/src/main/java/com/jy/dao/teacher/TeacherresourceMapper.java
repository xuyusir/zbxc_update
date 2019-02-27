package com.jy.dao.teacher;

import com.jy.entiy.teacher.Teacherresource;
import com.jy.entiy.teacher.TeacherresourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherresourceMapper {
    int countByExample(TeacherresourceExample example);

    int deleteByExample(TeacherresourceExample example);

    int deleteByPrimaryKey(Integer teacherid);

    int insert(Teacherresource record);

    int insertSelective(Teacherresource record);

    List<Teacherresource> selectByExample(TeacherresourceExample example);

    Teacherresource selectByPrimaryKey(Integer teacherid);

    int updateByExampleSelective(@Param("record") Teacherresource record, @Param("example") TeacherresourceExample example);

    int updateByExample(@Param("record") Teacherresource record, @Param("example") TeacherresourceExample example);

    int updateByPrimaryKeySelective(Teacherresource record);

    int updateByPrimaryKey(Teacherresource record);
    
    /**
   	 * 分页导师列表
   	 * @return
   	 */
     	public List<Teacherresource> getTeacherresource(
         		@Param("startSize") Integer startSize, 
         		@Param("pageSize") Integer pageSize
     			);
     /**
   	 * 分页导师列表数量
   	 * @return
   	 */
     	public Integer getCountTeacherresource();
 
}