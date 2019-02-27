package com.jy.dao.system.select;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.system.select.Select;

public interface SelectMapper {

	/**
	 * 添加配置
	 * @param table_name 配置表名
	 * @param column_id 配置表主键名
	 * @param column_name 配置表name
	 * @param select 配置
	 * @return
	 */
	int insertSelect(@Param("table_name") String table_name, @Param("column_id") String column_id, @Param("column_name") String column_name, @Param("select")Select select);
	
	/**
	 * 查询配置表名
	 * @param id 配置表的配置表主键
	 * @return
	 */
	String  getTableName(@Param("id") Integer id);
	
	/**
	 * 查询下拉列表
	 * @param column_id 配置表主键名
	 * @param column_name 配置表name
	 * @param table_name 配置表名
	 * @return
	 */
	List<Map<String, Object>> getSelect(@Param("column_id") String column_id, @Param("column_name") String column_name, @Param("table_name") String table_name);
	
	/**
	 * 
	 * @param column_id 配置表主键名
	 * @param column_name 配置表name
	 * @param table_name 配置表名
	 * @return
	 */
	List<Map<String, Object>> getSelectList(@Param("column_id") String column_id, @Param("column_name") String column_name, @Param("table_name") String table_name);

	/**
	 * 修改配置
	 * @param table_name 配置表名
	 * @param column_id 配置表主键名
	 * @param column_name 配置表name
	 * @param select 配置
	 * @return
	 */
	int updateSelect(@Param("table_name") String table_name, @Param("column_id") String column_id, @Param("column_name") String column_name, @Param("select") Select select);

	/**
	 * 删除配置
	 * @param table_name 表名
	 * @param id 主键
	 * @return
	 */
	int deleteSelect(@Param("table_name") String table_name, @Param("column_id") String column_id,@Param("id") Integer id);

	/**
	 * 查询一条配置
	 * @param column_id 配置表主键名
	 * @param column_name 配置表name
	 * @param table_name 配置表名
	 * @param id 主键
	 * @return
	 */
	Map<String, Object> getOne(@Param("column_id") String column_id, @Param("column_name") String column_name, @Param("table_name") String table_name, @Param("id") Integer id);

	/**
	 * 查询固定编码总数
	 * @param table_name 配置表名
	 * @param code 固定编码
	 * @param column_id 配置表主键名
	 * @param id 主键
	 * @return
	 */
	int checkCode( @Param("table_name") String table_name, @Param("code") String code, @Param("column_id") String column_id, @Param("id") Integer id);

}
