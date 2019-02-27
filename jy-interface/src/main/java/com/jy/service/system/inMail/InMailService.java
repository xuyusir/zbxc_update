package com.jy.service.system.inMail;

import java.util.List;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.inMail.Message;
import com.jy.entiy.system.inMail.Messagetext;

/**
 * @ClassName:  inMailService   
 * @Description:站内信Service接口 
 * @author: chen ye
 * @date:   2018-08-27 16:35
 */
public interface InMailService {
	
	public Result getMailList(Long recid,Integer page, Integer pageSize);
	
	/**
	 * 写信
	 * @param Message_text
	 * @return
	 * @throws MyException 
	 */
	public Result writeMail(AccountInfo accountInfo,String CONTROLLER_CODE,Messagetext messageText) throws MyException;
	
	/**
	 * 查询最近一次插入的信内容ID
	 * @return
	 */
	public Integer getRecentlyTextId();
	
	/**
	 * 发送
	 * @param file
	 * @param account
	 */
	public Result sendMail(AccountInfo accountInfo,String CONTROLLER_CODE,Message message) throws MyException;
	

	
	/**
	 * 根据用户编号获取该用户的消息列表
	 * @param 
	 * @return
	 */
	public List<Message> getMailbyUserID(AccountInfo accountInfo);
	
	/**
	 * 根据信内容id读取详细信息
	 * @param textId
	 * @return
	 */
	public Messagetext getDetailMailbyTextID(Integer textId);
	
	/**
	 * 修改消息记录表
	 * @param reading_status
	 * @param delete_status
	 * @return
	 */
	public Result updateMailMessage(AccountInfo accountInfo, String CONTROLLER_CODE,Message message)throws MyException;
	
	/**
	 * 修改消息内容表
	 * @param reading_status
	 * @param delete_status
	 * @return
	 */
	public Result updateMailText(AccountInfo accountInfo, String CONTROLLER_CODE,Messagetext messageText)throws MyException;
	
	
	/**
	 * 删除/回收我的消息记录
	 * @param id 站内信记录表id
	 * @param CONTROLLER_CODE 后台管理人员使用该方法时使用的权限码
	 * @return
	 */
	public Result deleteMail(AccountInfo accountInfo, String CONTROLLER_CODE,Integer id,Integer typeId)throws MyException;
	
	/**
	 * 删除消息内容
	 * @param file
	 * @return
	 */
	public Result deleteMailText(AccountInfo accountInfo, String CONTROLLER_CODE,Integer textId)throws MyException;
	
	
	/**
	 * 根据用户编号获取该用户的未读消息数
	 * @param 
	 * @return
	 */
	public int getMessageNum(AccountInfo accountInfo);

}
