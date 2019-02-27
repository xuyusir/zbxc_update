package com.jy.service.system.inMail;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.system.inMail.MessageMapper;
import com.jy.dao.system.inMail.MessagetextMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.inMail.Message;
import com.jy.entiy.system.inMail.MessageExample;
import com.jy.entiy.system.inMail.MessageExample.Criteria;
import com.jy.entiy.system.inMail.Messagetext;
import com.jy.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: inMailServiceImpl
 * @Description:站内信Service实现
 * @author: chen ye
 * @date: 2018-08-27 16:35
 */

@Service
public class InMailServiceImpl extends BaseService implements InMailService {

	@Resource
	private MessageMapper messageMapper;
	@Resource
	private MessagetextMapper messagetextMapper;

	@Override
	public Result writeMail(AccountInfo accountInfo, String CONTROLLER_CODE, Messagetext messageText)
			throws MyException {

		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, CONTROLLER_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}

		Long accountid = accountInfo.getAccount().getAccountid();
		String name = accountInfo.getAccount().getName();
		messageText.setCreateby(name);
		messageText.setCreatepersonid(accountid);
		messageText.setCreatetime(new Date());
		int i = messagetextMapper.insertSelective(messageText);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		return Result.succee();
	}

	@Override
	/**
	 * 查询最近一次插入的信内容ID
	 * 
	 * @return
	 */
	public Integer getRecentlyTextId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result sendMail(AccountInfo accountInfo, String CONTROLLER_CODE, Message message) throws MyException {
		// 检测添加权限
		Result checkAuthority = this.checkAuthority(accountInfo, CONTROLLER_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}
		if (message.getMessageid() == null) {
			Integer messageid = messagetextMapper.getRecentlyTextId();// 如果信消息id为空就是发送最新编写的那条消息
			message.setMessageid(messageid);
		}
		Long accountid = accountInfo.getAccount().getAccountid();
		String name = accountInfo.getAccount().getName();
		message.setCreateby(name);
		message.setCreatepersonid(accountid);
		message.setSendid(accountid);
		message.setCreatetime(new Date());
		message.setReadingstatus(0);
		int i = messageMapper.insertSelective(message);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		return Result.succee();
	}

	@Override
	public List<Message> getMailbyUserID(AccountInfo accountInfo) {
		MessageExample example = new MessageExample();
		com.jy.entiy.system.inMail.MessageExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andRecidEqualTo(accountInfo.getAccount().getAccountid());

		List<Message> MessageList = messageMapper.selectByExample(example);
		for (Message message : MessageList) {
			Integer messageid = message.getMessageid();
			Messagetext messagetext = messagetextMapper.selectByPrimaryKey(messageid);
			message.setMessagetext(messagetext);
		}
		return MessageList;
	}

	@Override
	public Messagetext getDetailMailbyTextID(Integer textId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateMailMessage(AccountInfo accountInfo, String CONTROLLER_CODE, Message message)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, CONTROLLER_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}
		Long accountid = accountInfo.getAccount().getAccountid();
		String name = accountInfo.getAccount().getName();
		message.setUpdateby(name);
		message.setUpdatepersonid(accountid);
		message.setUpdatetime(new Date());
		int i = messageMapper.updateByPrimaryKeySelective(message);

		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		return Result.succee();

	}

	@Override
	public Result updateMailText(AccountInfo accountInfo, String CONTROLLER_CODE, Messagetext messageText)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, CONTROLLER_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}
		Long accountid = accountInfo.getAccount().getAccountid();
		String name = accountInfo.getAccount().getName();
		messageText.setUpdateby(name);
		messageText.setUpdatepersonid(accountid);
		messageText.setUpdatetime(new Date());
		int i = messagetextMapper.updateByPrimaryKeySelective(messageText);

		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		return Result.succee();
	}
	/**
	 * 删除我的消息
	 */
	@Override
	public Result deleteMail(AccountInfo accountInfo, String CONTROLLER_CODE, Integer id,Integer typeId) throws MyException {
		// 检测账号是否登录
		if(accountInfo == null || accountInfo.getAccount() == null) {
			return Result.build(20003,400,"登录过期请重新登录!");
		}
		if (typeId != null && typeId == 2 && id != null) {
			//删除我的消息记录
			int i = messageMapper.deleteByPrimaryKey(id);
			if (i < 1) {
				throw new MyException(ResultEnum.DELETE_SQL_ERROR);
			}
			//查询这条消息是否还发给别人
			Message message = messageMapper.selectByPrimaryKey(id);
			//消息内容id
			Integer messageid = message.getMessageid();
			//条件查询出这条消息还发给了多少人
			MessageExample messageExample = new MessageExample();
			Criteria createCriteria = messageExample.createCriteria();
			createCriteria.andMessageidEqualTo(messageid);
			int count = messageMapper.countByExample(messageExample);
			//没有发送给其他人 删除消息内容
			if(count == 0) {
				int i2 = messagetextMapper.deleteByPrimaryKey(messageid);
				if (i2 < 1) {
					throw new MyException(ResultEnum.DELETE_SQL_ERROR);
				}
			}
			return Result.succee();
		}
		/**
		 * 放入回收站
		 */
		if (typeId != null && typeId == 1 && id != null) {
			Message message = messageMapper.selectByPrimaryKey(id);
			message.setDeletestatus(1);//回收
			int i = messageMapper.updateByPrimaryKeySelective(message);
			if (i < 1) {
				throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
			}
			return Result.succee();
		}

		return Result.build(ResultEnum.PARAMETER_ERROR);
	}

	@Override
	public Result deleteMailText(AccountInfo accountInfo, String CONTROLLER_CODE, Integer textId) throws MyException {
		// 检测删除权限
		Result checkAuthority = this.checkAuthority(accountInfo, CONTROLLER_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}
		if (textId != null) {
			int i = messagetextMapper.deleteByPrimaryKey(textId);
			if (i < 1) {
				throw new MyException(ResultEnum.DELETE_SQL_ERROR);
			}
			return Result.succee();
		}

		return Result.build(ResultEnum.PARAMETER_ERROR);
	}

	@Override
	public Result getMailList(Long recid,Integer page, Integer pageSize) {
		//参数检查
		if(recid == null) {
			return Result.build(20003,400,"登录信息异常!");
		}
		List<Message> MessageList = messageMapper.getMailList(recid, (page-1)*pageSize, pageSize);
		for (Message message : MessageList) {
			//站内信id
			Integer messageid = message.getMessageid();
			//查询出站内信内容
			Messagetext messagetext = messagetextMapper.selectByPrimaryKey(messageid);
			message.setMessagetext(messagetext);
			if(message.getReadingstatus() == 0) {
                Message message1 = new Message();
                message1.setId(message.getId());
                //查询后设置为已读
                message1.setReadingstatus(1);
				messageMapper.updateByPrimaryKeySelective(message1);
			}
		}
		Integer countMailList = messageMapper.getCountMailList(recid);
		Map<String, Object> map = new HashMap<>();
		map.put("rows", MessageList);
		map.put("count", countMailList);
		return Result.succee(map);
	}

	@Override
	public int getMessageNum(AccountInfo accountInfo) {
		
		MessageExample example = new MessageExample();
		com.jy.entiy.system.inMail.MessageExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andRecidEqualTo(accountInfo.getAccount().getAccountid());
		createCriteria.andDeletestatusNotEqualTo(1);//不在回收站
		List<Message> MessageList = messageMapper.selectByExample(example);
		int num = 0;
		for (Message message : MessageList) {
			if(message.getReadingstatus() != null && message.getReadingstatus() == 0) {//未读
				num++;
			}
		}
		return num;
	}

}
