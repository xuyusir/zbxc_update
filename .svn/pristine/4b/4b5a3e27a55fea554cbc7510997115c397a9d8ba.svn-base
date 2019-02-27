package com.jy.dao.content.articleManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.articleManage.Articleinfo;
import com.jy.entiy.content.articleManage.ArticleinfoExample;

public interface ArticleinfoMapper {
    int countByExample(ArticleinfoExample example);

    int deleteByExample(ArticleinfoExample example);

    int deleteByPrimaryKey(Integer articleid);

    int insert(Articleinfo record);

    int insertSelective(Articleinfo record);

    List<Articleinfo> selectByExampleWithBLOBs(ArticleinfoExample example);

    List<Articleinfo> selectByExample(ArticleinfoExample example);

    Articleinfo selectByPrimaryKey(Integer articleid);

    int updateByExampleSelective(@Param("record") Articleinfo record, @Param("example") ArticleinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Articleinfo record, @Param("example") ArticleinfoExample example);

    int updateByExample(@Param("record") Articleinfo record, @Param("example") ArticleinfoExample example);

    int updateByPrimaryKeySelective(Articleinfo record);

    int updateByPrimaryKeyWithBLOBs(Articleinfo record);

    int updateByPrimaryKey(Articleinfo record);
    
    /**
     * @param pagecolumnid
     * @param articletitle 文章标题
     * @param search 官网搜索(学员案例时使用)
     * @param startSize
     * @param pageSize
     * @return
     */
    List<Articleinfo> getArticleinfoByPageColumnID(@Param("pagecolumnid") Integer pagecolumnid,
			@Param("articletitle") String articletitle,@Param("search") String search, @Param("startSize") Integer startSize,
			@Param("pageSize") Integer pageSize);

	/**
	 * @param pagecolumnid
	 * @param articletitle 文章标题
	 * @param search 官网搜索 (学员案例时使用)
	 * @return
	 */
	Integer getArticleinfoCountByPageColumnID(@Param("pagecolumnid") Integer pagecolumnid,
			@Param("articletitle") String articletitle,@Param("search") String search);
	
	List<Articleinfo> getRecycleInfoByPageColumnID(@Param("pagecolumnid") Integer pagecolumnid,
			@Param("articletitle") String articletitle, @Param("startSize") Integer startSize,
			@Param("pageSize") Integer pageSize);
	
	Integer getRecycleInfoCountByPageColumnID(@Param("pagecolumnid") Integer pagecolumnid,
			@Param("articletitle") String articletitle);
	
	List<Articleinfo> getNotAudit(@Param("pagecolumnid") Integer pagecolumnid,
			@Param("articletitle") String articletitle, @Param("startSize") Integer startSize,
			@Param("pageSize") Integer pageSize);
	
	Integer getNotAuditCount(@Param("pagecolumnid") Integer pagecolumnid,
			@Param("articletitle") String articletitle);
	
	/**
	 * 检测过期文章
	 * @param nowDate
	 * @return
	 */
	List<Articleinfo> getOverdueArticleList (@Param("nowDate")String nowDate);
}