package com.jy.dao.system.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.dao.system.select.SelectResult;
import com.jy.entiy.system.dictionaries.Dictionaries;
import com.jy.entiy.system.dictionaries.DictionariesExample;

public interface DictionariesMapper {
    int countByExample(DictionariesExample example);

    int deleteByExample(DictionariesExample example);

    int deleteByPrimaryKey(Integer dictionariesid);

    int insert(Dictionaries record);

    int insertSelective(Dictionaries record);

    List<Dictionaries> selectByExample(DictionariesExample example);

    Dictionaries selectByPrimaryKey(Integer dictionariesid);

    int updateByExampleSelective(@Param("record") Dictionaries record, @Param("example") DictionariesExample example);

    int updateByExample(@Param("record") Dictionaries record, @Param("example") DictionariesExample example);

    int updateByPrimaryKeySelective(Dictionaries record);

    int updateByPrimaryKey(Dictionaries record);
    
    String getNameByDictionariesID(@Param("DictionariesID") Integer DictionariesID);

	Integer getDictionariesIDByCode(@Param("Code") String Code);

	List<Dictionaries> getDictionariesByParam(@Param("ParentID") Integer ParentID, 
			@Param("Status") Integer Status,
			@Param("search") String search, 
			@Param("startSize") Integer startSize, 
			@Param("pageSize") Integer pageSize);

	List<Dictionaries> getDictionariesCountByParam(
			@Param("ParentID") Integer parent_id,
			@Param("Status") Integer Status, 
			@Param("search") String search);
	
	List<SelectResult> getSelectDictionariesByParentId(@Param("ParentID") Integer ParentID);
}