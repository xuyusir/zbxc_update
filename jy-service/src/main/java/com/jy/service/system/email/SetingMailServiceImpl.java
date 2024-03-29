package com.jy.service.system.email;

import com.jy.common.exception.MyException;
import com.jy.common.redis.JedisClient;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.DateUtils;
import com.jy.common.utils.MD5Utils;
import com.jy.common.utils.RegexUtils;
import com.jy.common.utils.sendMail.SendEmailUtil;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.system.email.SetmailMapper;
import com.jy.entiy.account.account.AccountExample;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.system.email.Setmail;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SetingMailServiceImpl extends BaseService implements SetingMailService {

	// 菜单数据库操作日志类型
	private static final String DB_LOG_TYPE = "DB_LOG_WEBSETING";

	@Resource
	SetmailMapper setingMailMapper;

	@Resource
	private JedisClient jedisClient;

	@Resource
	private AccountMapper accountMapper;

	@Value("${DEBUG}")
	private boolean DEBUG;

	@Value("${JSP_EXPIRE}")
	private Integer JSP_EXPIRE;

	@Value("${REDIS_PASSWORD}")
	private String REDIS_PASSWORD;

	@Value("${WEB_APP_KEY}")
    private String WEB_APP_KEY;

    @Value("${WEB_SERVER_URL}")
    private  String webServerUrl;

    @Value("${SIGN_URL}")
	private String serviceUrl ;

	@Override
	public Setmail getSetingMail() {

		List<Setmail> selectByExample = setingMailMapper.selectByExample(null);// 查询客服设置信息
		Setmail setingMail = selectByExample.get(selectByExample.size() - 1);
		return setingMail;
	}

	@Override
	public Result insertSetingMail(AccountInfo accountInfo, String CONTROLLER_CODE,Setmail setingMail) throws MyException {
		// 检测添加权限
		Result checkAuthority = this.checkAuthority(accountInfo, CONTROLLER_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}
		setingMail.setCreatetime(new Date());
		setingMail.setCreatepersonid(accountInfo.getAccount().getAccountid());
		int i = setingMailMapper.insertSelective(setingMail);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "设置了邮箱配置信息 : [ ";
		log += StringUtils.isBlank(setingMail.getMailserver()) ? "" : "邮箱服务器=" + setingMail.getMailserver() + ",";
		log += "发送端口=" + setingMail.getPort() + ",";
		log += StringUtils.isBlank(setingMail.getSenderip()) ? "" : "发送地址=" + setingMail.getSenderip() + ",";
		log += StringUtils.isBlank(setingMail.getReceptionip()) ? "" : "接收地址=" + setingMail.getReceptionip() + ",";
		log += StringUtils.isBlank(setingMail.getPassword()) ? "" : "密码=" + setingMail.getPassword() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result updateSetingMail(AccountInfo accountInfo,String CONTROLLER_CODE, Setmail setingMail) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, CONTROLLER_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}
		setingMail.setCreatetime(new Date());
		setingMail.setCreatepersonid(accountInfo.getAccount().getAccountid());
		Setmail old_setingMail = getSetingMail();
		setingMail.setSetmailid(old_setingMail.getSetmailid());
		int i = setingMailMapper.updateByPrimaryKeySelective(setingMail);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "设置了邮箱配置信息 : [ ";
		log += StringUtils.isBlank(setingMail.getMailserver()) ? "" : "邮箱服务器=" + setingMail.getMailserver() + ",";
		log += "发送端口=" + setingMail.getPort() + ",";
		log += StringUtils.isBlank(setingMail.getSenderip()) ? "" : "发送地址=" + setingMail.getSenderip() + ",";
		log += StringUtils.isBlank(setingMail.getReceptionip()) ? "" : "接收地址=" + setingMail.getReceptionip() + ",";
		log += StringUtils.isBlank(setingMail.getPassword()) ? "" : "密码=" + setingMail.getPassword() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result sendMail(AccountInfo accountInfo,String AUTHORITY_CODE ,Boolean IsCheckAuthority, String title, String content, String[] Files,String[] RmailIP) throws Exception {

		//检测是否鉴权
		if (IsCheckAuthority) {
			Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
			if (checkAuthority.getStatus() != 200) {
				return checkAuthority;
			}
		}

		Setmail setingMail = getSetingMail();
		if (setingMail != null && RmailIP != null) {
			List<File> FileList = new ArrayList<>();
			if(Files != null) {
				for (int i = 0; i < Files.length; i++) {
					File file = new File(Files[i]);
					FileList.add(file);

				}
			}
			SendEmailUtil.sendEmail(setingMail.getMailserver(), setingMail.getPort(), setingMail.getSenderip(), setingMail.getPassword(), title, content,FileList, RmailIP);
			return Result.succee();
		}
		if(setingMail == null) {
			return Result.build(ResultEnum.MAILSTING_NULL);
		}else{
			return Result.build(ResultEnum.MAILRECLED_ERROR);
		}

	}

	@Override
	public Result doJSP(AccountInfo accountInfo, String email, String redirectUrl) throws Exception {

		//校验邮箱格式
		if (!RegexUtils.checkEmail(email)) {
			return Result.build(ResultEnum.EMAIL_ERROR);
		}
		String emailToken = UUID.randomUUID().toString();
		Long accountID = accountInfo.getAccount().getAccountid();
		jedisClient.set(Constant.JSP_PRE + accountID, emailToken, REDIS_PASSWORD);
		jedisClient.expire(Constant.JSP_PRE + accountID, JSP_EXPIRE, REDIS_PASSWORD);
		jedisClient.set(Constant.EMAIL_PRE + accountID, email, REDIS_PASSWORD);
		jedisClient.expire(Constant.EMAIL_PRE + accountID, JSP_EXPIRE, REDIS_PASSWORD);
		String title = "【中博星辰】邮箱安全认证";
        String requestTime = DateUtils.dateFormat(new Date(), DateUtils.DATE_TIME_PATTERN);
        String sign = MD5Utils.MD5(requestTime + WEB_APP_KEY);
        String url = serviceUrl + "account/public/jsp?emailToken=" + emailToken + "&amp;redirectUrl=" + redirectUrl + "&amp;token=" + accountInfo.getToken() + "&amp;request_time=" + requestTime + "&amp;sign=" + sign;
		url = url.replace(" ", "%20");

		String content = "<html><head></head><body><h1>这是一封邮箱安全验证邮件,5分钟内有效,验证请点击以下链接</h1><h3><a href='"+ url +"'>"+ url +"</a></h3></body></html>";
		Result sendMail = sendMail(null, null, false, title, content, null, new String[] {email});
		return sendMail;
	}

	@Override
	public Result resetPassword(String email, String redirectUrl) throws Exception{
		//校验邮箱格式
		if (!RegexUtils.checkEmail(email)) {
			return Result.build(ResultEnum.EMAIL_ERROR);
		}
		//验证邮箱是否已注册
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        int i = accountMapper.countByExample(example);

        if (i < 1){
            return  Result.build(ResultEnum.EMAIL_NOT_EXIST);
        }
        String code = UUID.randomUUID().toString();
        String token = MD5Utils.MD5(code + WEB_APP_KEY);
        jedisClient.set(Constant.RESET_PASSWORD_PRE + email, token, REDIS_PASSWORD);
        jedisClient.expire(Constant.RESET_PASSWORD_PRE + email, JSP_EXPIRE, REDIS_PASSWORD);

		String title = "【中博星辰】找回密码";
		String url = webServerUrl + "/" + redirectUrl +"?email=" + email + "&amp;code=" + code;

		String content = "<html><head></head><body><h1>您正在申请找回密码服务,找回密码请点击以下链接,5分钟内有效</h1><h3><a href='"+ url +"'>"+ url +"</a></h3></body></html>";
		Result sendMail = sendMail(null, null, false, title, content, null, new String[] {email});
		return sendMail;
	}

}
