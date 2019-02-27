package com.jy.service.function.marketingFunction.lotteryManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.marketingFunction.lotteryManagement.Drawlotteryconfig;
import com.jy.entiy.function.marketingFunction.lotteryManagement.Persondrawlottery;

/**
 * 抽奖管理Service
 * @author chenye
 *
 */
public interface LotteryManageService {
	
	/**
	 * 获取抽奖列表
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param votestatusid
	 * @param search
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws MyException 
	 */
	public Result getLotteryList(AccountInfo accountInfo,String AUTHORITY_CODE,Integer votestatusid,  String search,Integer page, Integer pageSize) throws MyException;
	

	/**
	 * 添加抽奖
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param drawlotteryconfig
	 * @return
	 * @throws MyException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Result addLottery(AccountInfo accountInfo,String AUTHORITY_CODE,Drawlotteryconfig drawlotteryconfig,String qRpath) throws MyException, FileNotFoundException, IOException;
	

	/**
	 * 编辑抽奖
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param drawlotteryconfig
	 * @return
	 * @throws MyException
	 */
	public Result updateLottery(AccountInfo accountInfo,String AUTHORITY_CODE,Drawlotteryconfig drawlotteryconfig) throws MyException;
	

	/**
	 * 删除抽奖
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param drawlotteryconfigid
	 * @return
	 * @throws MyException
	 */
	public Result deleteLottery(AccountInfo accountInfo,String AUTHORITY_CODE,Integer drawlotteryconfigid) throws MyException;
	

	/**
	 * 获取活动详细
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param drawlotteryconfigid
	 * @return
	 * @throws MyException 
	 */
	public Result getLotteryInfo(AccountInfo accountInfo,String AUTHORITY_CODE,Integer drawlotteryconfigid) throws MyException;
	
	

	/**
	 * 导出列表预览
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param drawlotteryconfigid
	 * @return
	 * @throws MyException 
	 */
	public Result exportListView(AccountInfo accountInfo,String AUTHORITY_CODE,Integer drawlotteryconfigid) throws MyException;
	
	/**
	 * 导出列表
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param drawlotteryconfigid
	 * @return
	 * @throws MyException 
	 * @throws ParseException 
	 */
	public Result exportList(AccountInfo accountInfo,String AUTHORITY_CODE,Integer drawlotteryconfigid,String url) throws MyException, ParseException;
	
	
	/**
	 * 抽奖操作
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param drawlotteryconfigid
	 * @param persondrawlottery
	 * @return
	 * @throws MyException 
	 */
	public Result lotterying(AccountInfo accountInfo,String AUTHORITY_CODE,Integer drawlotteryconfigid,Persondrawlottery persondrawlottery) throws MyException;


	/**
	 * 加载奖项等级
	 * @return
	 */
	public Result load();
	
	
	/**
	 * 抽奖记录
	 * @param accountInfo
	 * @param drawlotteryconfigid
	 * @return
	 */
	public Result lotteryingRecord(AccountInfo accountInfo,Integer drawlotteryconfigid);
}
