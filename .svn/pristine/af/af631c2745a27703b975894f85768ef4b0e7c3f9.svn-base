package com.jy.dao.content.file.directory;

import com.jy.entiy.content.file.directory.Documentdirectory;
import com.jy.entiy.content.file.directory.DocumentdirectoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocumentdirectoryMapper {
    int countByExample(DocumentdirectoryExample example);

    int deleteByExample(DocumentdirectoryExample example);

    int deleteByPrimaryKey(Long documentdirectoryid);

    int insert(Documentdirectory record);

    int insertSelective(Documentdirectory record);

    List<Documentdirectory> selectByExample(DocumentdirectoryExample example);

    Documentdirectory selectByPrimaryKey(Long documentdirectoryid);

    int updateByExampleSelective(@Param("record") Documentdirectory record, @Param("example") DocumentdirectoryExample example);

    int updateByExample(@Param("record") Documentdirectory record, @Param("example") DocumentdirectoryExample example);

    int updateByPrimaryKeySelective(Documentdirectory record);

    int updateByPrimaryKey(Documentdirectory record);

    List<Long> getDocumentDirectoryIDByParentID(@Param("parent_id") Long parent_id);

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/20 14:08
     * 描述 : 根据文件夹ID获取父级ID
     *
     * @param directoryID
     * @return
     */
    Long getParentIDByDocumentDirectoryID(@Param("directoryID")Long directoryID);
}
