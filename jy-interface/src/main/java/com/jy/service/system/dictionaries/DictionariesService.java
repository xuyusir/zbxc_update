package com.jy.service.system.dictionaries;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.dictionaries.Dictionaries;


/**
 * @ClassName:  DictionariesService   
 * @Description:数据字典服务接口  
 * @author: cheng fei
 * @date:   2018-08-05 12:04
 */
public interface DictionariesService {

	/**
	 * 通过数据字典code获取字典列表
	 * @param code
	 * @return
	 */
	Result getSelectDictionariesByCode(String code);

	/**
	 * 获取数据字典列表
	 * @param accountInfo
	 * @param parent_id
	 * @param search 
	 * @param pageSize 
	 * @param page 
	 * @return
	 */
	Result getDictionaries(AccountInfo accountInfo ,Integer parent_id, String search, Integer page, Integer pageSize);

	/**
	 * 获取所有父节点
	 * @param accountInfo
	 * @param parent_id
	 * @return
	 */
	Result getParentDictionaries(AccountInfo accountInfo, Integer parent_id);

	/**
	 * 检测数据字典code是否可用
	 * @param code
	 * @param id
	 * @return
	 */
	Result checkCode(String code, Integer id);

	
	/**
	 * 添加一个数据字典
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param dictionaries
	 * @return
	 * @throws MyException 
	 */
	Result InsertDictionaries(AccountInfo accountInfo, String AUTHORITY_CODE, Dictionaries dictionaries) throws MyException;

	
	/**
	 * 修改一个数据字典
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param dictionaries
	 * @return
	 * @throws MyException 
	 */
	Result updateDictionaries(AccountInfo accountInfo, String AUTHORITY_CODE, Dictionaries dictionaries) throws MyException;

	/**
	 * 删除一个数据字典
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param id
	 * @return
	 * @throws MyException
	 */
	Result deleteDictionaries(AccountInfo accountInfo, String AUTHORITY_CODE, Integer id) throws MyException;

	/**
	 * 根据id查询数据字典
	 * @param accountInfo
	 * @param id
	 * @return
	 */
	Result getDictionariesById(AccountInfo accountInfo, Integer id);

}
