package com.jy.dao.system.select;

import com.jy.entiy.system.select.Articlestatus;
import com.jy.entiy.system.select.ArticlestatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticlestatusMapper {
    int countByExample(ArticlestatusExample example);

    int deleteByExample(ArticlestatusExample example);

    int deleteByPrimaryKey(Integer articlestatusid);

    int insert(Articlestatus record);

    int insertSelective(Articlestatus record);

    List<Articlestatus> selectByExample(ArticlestatusExample example);

    Articlestatus selectByPrimaryKey(Integer articlestatusid);

    int updateByExampleSelective(@Param("record") Articlestatus record, @Param("example") ArticlestatusExample example);

    int updateByExample(@Param("record") Articlestatus record, @Param("example") ArticlestatusExample example);

    int updateByPrimaryKeySelective(Articlestatus record);

    int updateByPrimaryKey(Articlestatus record);
}