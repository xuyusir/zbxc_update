package com.jy.service.content.file.directory;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.file.directory.Documentdirectory;

/**
 * @ClassName:  DocumentDirectoryService
 * @Description:文件目录接口
 * @author: cheng fei
 * @date:   2018-09-11 09:08
 */
public interface DocumentDirectoryService {


	/**
	 * 获取文件库的文件树形列表
	 * @param accountInfo 当前登陆账号
	 * @param directory_id 父文件夹ID
	 * @return
	 */
	Result getFileDirectoryTree(AccountInfo accountInfo, Long directory_id);

	/**
	 * 创建子文件夹
	 * @param accountInfo 当前登录用户
	 * @param AUTHORITY_CODE 操作权限
	 * @param directory 创建文件夹
	 * @return
	 * @throws MyException
	 */
	Result insertDirectory(AccountInfo accountInfo, String AUTHORITY_CODE, Documentdirectory directory) throws Exception;

	/**
	 * 修改文件夹
	 * @param accountInfo 当前登录用户
	 * @param AUTHORITY_CODE 操作权限
	 * @param directory 修改的文件夹
	 * @return
	 * @throws MyException
	 */
	Result updateDirectory(AccountInfo accountInfo, String AUTHORITY_CODE, Documentdirectory directory) throws MyException;

	/**
	 * 删除子文件夹
	 * @param accountInfo 当前登录用户
	 * @param AUTHORITY_CODE 权限编码
	 * @param directory_id 要删除的ID
	 * @return
	 * @throws MyException
	 */
	Result deleteFileDirectory(AccountInfo accountInfo, String AUTHORITY_CODE, Long directory_id) throws Exception;

}
