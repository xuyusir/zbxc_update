package com.jy.service.system.login;

import com.jy.common.exception.MyException;
import com.jy.common.redis.JedisClient;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.AESCBCUtils;
import com.jy.common.utils.JsonUtils;
import com.jy.common.utils.RegexUtils;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.account.authority.RoleMapper;
import com.jy.dao.function.person.resume.ResumeinfoMapper;
import com.jy.dao.system.dictionaries.DictionariesMapper;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountExample;
import com.jy.entiy.account.account.AccountExample.Criteria;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.account.authority.Role;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.system.dictionaries.Dictionaries;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName:  LoginServiceImpl
 * @Description:登录服务实现类
 * @author: cheng fei
 * @date:   2018-07-31 10:01
 */
@Service
@SuppressWarnings("restriction")
public class LoginServiceImpl extends BaseService implements LoginService{

	@Resource
	private AccountMapper accountMapper;

	@Resource
	private RoleMapper roleMapper;

	@Resource
	private DictionariesMapper dictionariesMapper;

	@Resource
	private JedisClient jedisClient;

	@Resource
	private ResumeinfoMapper resumeinfoMapper;

	/**
	 * web端appkey
	 */
	@Value("${WEB_APP_KEY}")
	private String WEB_APP_KEY;

	/**
	 * 移动端appkey
	 */
	@Value("${MOBILE_APP_KEY}")
	private String MOBILE_APP_KEY;

	/**
	 * 微信端appkey
	 */
	@Value("${WE_CHAT_APP_KEY}")
	private String WE_CHAT_APP_KEY;

	@Value("${REDIS_PASSWORD}")
	private String REDIS_PASSWORD;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;

	@Override
	public Result doManageLogin(String data, String ip, String code ,String requestHome) throws MyException {
		return doLogin(data, ip, code,requestHome, true, false);
	}

	@Override
	public Result douccnLoging(String data, String ip, String code, String requestHome, boolean isSign) throws MyException {
		return doLogin(data, ip, code, requestHome, false, isSign);
	}

	@Override
	public Result doUccnPhoneLoging(String phone, String ip, String code ,String requestHome) throws MyException {

		//验证参数
		if (StringUtils.isBlank(phone) || StringUtils.isBlank(code)) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		//获取手机验证码
		String server_code = jedisClient.get(Constant.PHONE_CODE_PRE + phone, REDIS_PASSWORD);

		if (!code.equals(server_code)) {
			return Result.build(ResultEnum.PHONE_CODE_ERROR);
		}

		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<Account> list = accountMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return Result.build(ResultEnum.LOGIN_PHONE_ERROR);
		}
		//登录成功
		return loginSuccess(list.get(0), ip, false,requestHome);
	}

	/**
	 *
	 * @param data 加密后的用户数据
	 * @param ip 登陆IP
	 * @param code 验证码
	 * @param requestHome 请求来源
	 * @param isManage 是否是后台管理系统登录
	 * @param isSign 是否是签到登录
	 * @return
	 * @throws MyException
	 */
	public Result doLogin(String data, String ip, String code, String requestHome, boolean isManage, boolean isSign) throws MyException {

		//手机端不验证验证码
		if (requestHome.equals(Constant.WEB)) {
			//校验验证码
			String service_code = jedisClient.get(Constant.VERIFICATION_CODE + ip, REDIS_PASSWORD);
			if (code == null || !code.equalsIgnoreCase(service_code)) {
				return Result.build(ResultEnum.LOGIN_CODE_ERROR);
			}
		}

		//检测参数
		if (StringUtils.isBlank(data)) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		// 数据解包
		String vi = "";
		String user_name = "";
		int username_length = 0;


		try {
			BASE64Decoder dn = new BASE64Decoder();
			data = new String(dn.decodeBuffer(data), "UTF-8");
			vi = data.substring(0, 16);
			username_length = Integer.parseInt(data.substring(16, 19));
			user_name = data.substring(data.length() - username_length);
		} catch (Exception e) {
			return Result.build(ResultEnum.LOGIN_DATA_UNPACK_ERROR);
		}

		int manageType = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_MANAGE);

		//验证登录
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		boolean checkPhone = RegexUtils.checkPhone(user_name);
		boolean checkEmail = RegexUtils.checkEmail(user_name);
		//判断登录类型
		if (checkPhone) {
			criteria.andPhoneEqualTo(user_name);
		}else if (checkEmail) {
			criteria.andEmailEqualTo(user_name);
		}else if (!checkPhone && !checkEmail) {
			criteria.andUsernameEqualTo(user_name);
		}
		if (isManage) {
			criteria.andDictionariesidEqualTo(manageType);
		}else {
            //手机端,微信端只支持个人用户登陆
            if (!isSign && (Constant.MOBILE.equals(requestHome)|| Constant.WECHAT.equals(requestHome))){
                Integer personType = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON);
                criteria.andDictionariesidEqualTo(personType);
            }else {
                //官网不支持后天管理员登陆
			    criteria.andDictionariesidNotEqualTo(manageType);
            }
		}

		//状态: 1可用,0,不可用,2已删除
		criteria.andStatusNotEqualTo(2);

        List<Account> list = accountMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return Result.build(ResultEnum.LOGIN_NAME_OR_PASS_ERROR);
		}
		Account account = list.get(0);
		if (account.getStatus() == 0){
			return Result.build(ResultEnum.ACCOUNT_UNALLOWABLE);
		}
		String str = data.substring(19,data.length() - username_length);
		AESCBCUtils aes = new AESCBCUtils(account.getPassword(),vi);
		//根据请求来源获取appkey
		String appKey = "";
		if (requestHome.equals(Constant.WEB)) {
			appKey = WEB_APP_KEY;
		}else if (requestHome.equals(Constant.MOBILE)) {
			appKey = MOBILE_APP_KEY;
		}else if (requestHome.equals(Constant.WECHAT)) {
			appKey = WE_CHAT_APP_KEY;
		}

		String encrypt = aes.encrypt(appKey);
		if (!str.equals(encrypt)) {
			return Result.build(ResultEnum.LOGIN_NAME_OR_PASS_ERROR);
		}
		//登录成功
		return loginSuccess(account,ip, isManage, requestHome);
	}

	@Override
	public Result loginSuccess(Account account, String ip, boolean isManage, String requestHome) throws MyException {

		//如果是前端登录,判断登录类型
		if (! isManage) {
			Dictionaries dictionaries = dictionariesMapper.selectByPrimaryKey(account.getDictionariesid());
			account.setPerson((Constant.ACCOUNT_TYPE_PERSON.equals(dictionaries.getCode())));
		}

		//修改登录用户最后登录时间时间,和登录ip
		Account account2 = new Account();
		account2.setAccountid(account.getAccountid());
		account2.setLastlogintime(this.getNow());
		account2.setLastloginip(ip);
		int i = accountMapper.updateByPrimaryKeySelective(account2);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		//获取登录用户必要信息
		//用户性别信息
		account.setSex(resumeinfoMapper.getSexByAccountID(account.getAccountid()));
		//密码设为null
		account.setPassword(null);
		//获取用户头像
		String filePath = account.getHeadphoto() == null ? null : fileinfoMapper.getFileFullPathByFileID(account.getHeadphoto());
		if (StringUtils.isNotBlank(filePath)){
			filePath = aliyunOSSClientUtil.getUrl(filePath);
			//关闭阿里云OSS连接
			aliyunOSSClientUtil.closeOSSClient();
		}
		account.setHeadPhotoPath(filePath);
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccount(account);
		//后台管理员用户查询权限
		if (isManage && account.getRoleid() != null) {
			Role role = roleMapper.selectByPrimaryKey(account.getRoleid());
			accountInfo.setRole(role);
		}

		//存入redis
		String token = this.getUUID();
		accountInfo.setToken(token);

		Boolean exists = jedisClient.exists(requestHome + Constant.ACCOUNTINFO  + account.getAccountid(), REDIS_PASSWORD);
		if (exists) {
			String old_token = jedisClient.get(requestHome + Constant.ACCOUNTINFO + account.getAccountid(), REDIS_PASSWORD);
			jedisClient.set(requestHome + Constant.SESSION_PRE + old_token, Constant.LOST_CONNECTION, REDIS_PASSWORD);
		}
		jedisClient.set(requestHome + Constant.SESSION_PRE + token, JsonUtils.objectToJson(accountInfo),REDIS_PASSWORD);
		jedisClient.expire(requestHome + Constant.SESSION_PRE + token, SESSION_EXPIRE, REDIS_PASSWORD);
		jedisClient.set(requestHome + Constant.ACCOUNTINFO + account.getAccountid(), token,REDIS_PASSWORD);
		jedisClient.expire(requestHome + Constant.ACCOUNTINFO + account.getAccountid(), SESSION_EXPIRE, REDIS_PASSWORD);

		accountInfo.setRole(null);
		return Result.succee(accountInfo);
	}

	@Override
	public Result getAccountInfo(String token, String requestHome) {

        String json = jedisClient.get(requestHome + Constant.SESSION_PRE + token, REDIS_PASSWORD);
        if (StringUtils.isBlank(json)){
            return Result.succee();
        }

        AccountInfo accountInfo = JsonUtils.jsonToPojo(json, AccountInfo.class);

        return Result.succee(accountInfo);
	}

	@Override
	public Result logout(AccountInfo accountInfo) {
		jedisClient.del(Constant.SESSION_PRE + accountInfo.getToken(), REDIS_PASSWORD);
		jedisClient.del(Constant.ACCOUNTINFO + accountInfo.getAccount().getAccountid(), REDIS_PASSWORD);
		return Result.succee();
	}

}
