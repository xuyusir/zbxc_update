package com.jy.service.function.marketingFunction.votingManagement;

import java.io.IOException;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.marketingFunction.votingManagement.Voteconfig;
import com.jy.entiy.function.marketingFunction.votingManagement.Votedetails;
import com.jy.entiy.function.marketingFunction.votingManagement.Voteitem;
import com.jy.entiy.function.marketingFunction.votingManagement.Voteoption;

/**
 * 营销功能-投票管理
 * @author chenye
 *
 */
public interface VotingManageService {
	
	
	/**
	 * 获取投票列表
	 * @param votestatusid
	 * @param search
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws MyException 
	 */
	public Result getVoteConfigList(AccountInfo accountInfo,String AUTHORITY_CODE,Integer votestatusid, String search,Integer page, Integer pageSize) throws MyException;
	
	
	/**
	 * 获取指定投票下的题目列表
	 * @param voteid
	 * @param voteitemid
	 * @param search
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws MyException 
	 */
	public Result getItemList(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteid,Integer voteitemid,  String search,Integer page, Integer pageSize) throws MyException;
	
	
	/**
	 * 获取指定题目下的选项列表
	 * @param voteitemid
	 * @param voteoptionid
	 * @param search
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws MyException 
	 */
	public Result getOptionList(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteitemid,Integer voteoptionid,  String search,Integer page, Integer pageSize) throws MyException;
	
	/**
	 * 添加题目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteitem
	 * @return
	 * @throws MyException 
	 */
	public Result addItem(AccountInfo accountInfo,String AUTHORITY_CODE,Voteitem voteitem) throws MyException;
	
	/**
	 * 编辑题目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteitem
	 * @return
	 * @throws MyException 
	 */
	public Result updateItem(AccountInfo accountInfo,String AUTHORITY_CODE,Voteitem voteitem) throws MyException;
	

	/**
	 * 删除题目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteitemid
	 * @return
	 * @throws MyException 
	 */
	public Result deleteItem(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteitemid) throws MyException;
	

	/**
	 * 查询题目详细信息
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteitemid
	 * @return
	 * @throws MyException 
	 */
	public Result getItemInfo(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteitemid) throws MyException;
	
	/**
	 * 添加选项
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteoption
	 * @return
	 * @throws MyException 
	 */
	public Result addOption(AccountInfo accountInfo,String AUTHORITY_CODE,Voteoption voteoption) throws MyException;
	
	/**
	 * 编辑选项
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteoption
	 * @return
	 * @throws MyException 
	 */
	public Result updateOption(AccountInfo accountInfo,String AUTHORITY_CODE,Voteoption voteoption) throws MyException;
	

	/**
	 * 删除选项
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteoptionid
	 * @return
	 * @throws MyException 
	 */
	public Result deleteOption(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteoptionid) throws MyException;
	

	/**
	 * 查询选项详细信息
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteoptionid
	 * @return
	 * @throws MyException 
	 */
	public Result getOption(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteoptionid) throws MyException;
	
	
	/**
	 * 添加投票
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteitem
	 * @param qRpath 二维码存放地址
	 * @return
	 * @throws MyException 
	 * @throws IOException 
	 */
	public Result addVoteConfig(AccountInfo accountInfo,String AUTHORITY_CODE,Voteconfig record,String voteUrl,String qRpath) throws MyException, IOException;
	
	/**
	 * 编辑投票
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param record
	 * @return
	 * @throws MyException 
	 */
	public Result updateVoteConfig(AccountInfo accountInfo,String AUTHORITY_CODE,Voteconfig record) throws MyException;
	

	/**
	 * 删除投票
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteid
	 * @return
	 * @throws MyException 
	 */
	public Result deleteVoteConfig(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteid) throws MyException;
	

	/**
	 * 查询投票详细信息
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param voteid
	 * @return
	 * @throws MyException 
	 */
	public Result getVoteConfigInfo(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteid) throws MyException;
	
	
	/**
	 * 投票前加载
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param 
	 * @return
	 * @throws MyException 
	 */
	public Result loadVote(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteid) throws MyException;
	
	
	/**
	 * 投票操作
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param votedetails
	 * @return
	 * @throws MyException 
	 */
	public Result voting(AccountInfo accountInfo,Integer voteid,Integer voteitemid,String[] voteoptionids) throws MyException;
	

	/**
	 * 导出投票
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result exportVote(AccountInfo accountInfo,String AUTHORITY_CODE,Integer voteid) throws MyException;
	
	/**
	 * 检查题目类型
	 * @param voteId
	 * @param voteItemId
	 * @return
	 */
	public int itemType(Integer voteId,Integer voteItemId);

}
