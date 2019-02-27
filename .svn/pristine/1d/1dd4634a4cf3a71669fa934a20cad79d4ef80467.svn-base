package com.jy.dao.content.file.file;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.entiy.content.file.file.FileinfoExample;

public interface FileinfoMapper {
    int countByExample(FileinfoExample example);

    int deleteByExample(FileinfoExample example);

    int deleteByPrimaryKey(Long fileid);

    int insert(Fileinfo record);

    int insertSelective(Fileinfo record);

    List<Fileinfo> selectByExample(FileinfoExample example);

    Fileinfo selectByPrimaryKey(Long fileid);

    int updateByExampleSelective(@Param("record") Fileinfo record, @Param("example") FileinfoExample example);

    int updateByExample(@Param("record") Fileinfo record, @Param("example") FileinfoExample example);

    int updateByPrimaryKeySelective(Fileinfo record);

    int updateByPrimaryKey(Fileinfo record);

    /**
     * 文件按月份分组组名
     * @param type 文件类型
     * @param directory_ids 所属文件夹列表
     * @param search 关键字
     * @return
     */
    List<String> getMonthList(@Param("type") Integer type, @Param("directory_ids")List<Long> directory_ids, @Param("search") String search);

    /**
     * 查询文件列表
     * @param type 文件类型
     * @param month 月份
     * @param directory_ids 所属文件夹列表
     * @param search 关键字
     * @return
     */
	List<Fileinfo> getFileListByMonth(@Param("type") Integer type, @Param("month")String month, @Param("directory_ids") List<Long> directory_ids, @Param("search") String search);

	/**
	 * 查询文件列表
	 * @param type 文件类型
	 * @param directory_ids 所属文件夹列表
	 * @param search 关键字
	 * @return
	 */
	List<Fileinfo> getFileListByParam(@Param("type") Integer type, @Param("directory_ids") List<Long> directory_ids, @Param("search") String search);

	/**
	 * 查询文件地址
	 * @param file_id 文件ID
	 * @return
	 */
	String getFileFullPathByFileID(@Param("file_id") Long file_id);
	/**
	 * 查询文件名
	 * @param file_id 文件ID
	 * @return
	 */
	String getFileNameByFileID(@Param("file_id") Long file_id);

}
