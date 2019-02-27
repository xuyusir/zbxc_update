package com.jy.dao.system.db_log;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.db_log.Dblog;

public interface DblogMapper {
    
    int insertSelective(Dblog record);

    List<Dblog> selectDbLogByParem(
    		@Param("DictionariesID") Integer DictionariesID,
    		@Param("startTime") String startTime,
    		@Param("endTime") String endTime,
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectDbLogCountByParem(
    		@Param("DictionariesID") Integer DictionariesID,
    		@Param("startTime") String startTime,
    		@Param("endTime") String endTime,
    		@Param("search") String search);


	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/9 23:13
	 * 描述 : 删除数据库日志
	 * @param time 要删除多久以前的日志
	 * @return
	 */
	int deleteDbLog(@Param("time")String time);
}