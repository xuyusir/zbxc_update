package com.jy.service.system.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.jy.common.exception.MyException;
import com.jy.common.redis.JedisClient;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.system.sms.SetsmsMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.system.sms.Setsms;
import com.jy.service.base.BaseService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName: smsServiceImpl
 * @Description:短信设置服务实现
 * @author: chenye
 * @date: 2018-08-14 16:18
 */
@Service
public class SmsServiceImpl extends BaseService implements SmsService {

	// 菜单数据库操作日志类型
	private static final String DB_LOG_TYPE = "DB_LOG_WEBSETING";

    //产品名称:云通信短信API产品,开发者无需替换
    static final String PRODUCT = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIRraJFvUNfNnt";
    static final String accessKeySecret = "niQ9SRjGBL1qbPLQmVZ0h88RviLwRy";
    //短信签名
    static final String SignName = "中博星辰";
    //短信模板1 短信测试
    static final String TemplateCode1 = "SMS_25480299";
    //短信模板2 身份验证验证码
    static final String TemplateCode2 = "SMS_25480300";
    //短信模板3 登录确认验证码
    static final String TemplateCode3 = "SMS_25480298";
    //短信模板4 登录异常验证码
    static final String TemplateCode4 = "SMS_25480297";
    //短信模板5 用户注册验证码
    static final String TemplateCode5 = "SMS_25480296";
    //短信模板6 活动确认验证码
    static final String TemplateCode6 = "SMS_25480295";
    //短信模板7 修改密码验证码
    static final String TemplateCode7 = "SMS_25480294";
    //短信模板8 信息变更验证码
    static final String TemplateCode8 = "SMS_25480293";

	@Resource
	private JedisClient jedisClient;

	@Resource
	private SetsmsMapper smsMapper;

	@Value("${DEBUG}")
	private boolean DEBUG;

	@Value("${PHONE_CODE_EXPIRE}")
	private Integer PHONE_CODE_EXPIRE;

	@Value("${REDIS_PASSWORD}")
	private String REDIS_PASSWORD;

	@Override
	public Setsms getSetingSMS() {

		List<Setsms> SmsList = smsMapper.selectByExample(null);// 查询客服设置信息
		Setsms sms = SmsList.get(SmsList.size() - 1);
		return sms;
	}

	@Override
	public Result insertSetingSMS(AccountInfo accountInfo, String AUTHORITY_CODE, Setsms sms) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		
		sms.setCreatetime(new Date());
		sms.setCreateby(accountInfo.getAccount().getName());
		sms.setCreatepersonid(accountInfo.getAccount().getAccountid());
		int i = smsMapper.insertSelective(sms);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "设置了短信配置信息 : [ ";
		log += StringUtils.isBlank(sms.getUsername()) ? "" : "AccessKeyId=" + sms.getUsername() + ",";
		log += StringUtils.isBlank(sms.getCreateby()) ? "" : "设置人=" + sms.getCreateby() + ",";
		log += sms.getCreatepersonid() != null ? "" : "设置人id=" + sms.getCreatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result updatesetingSMS(AccountInfo accountInfo, String AUTHORITY_CODE, Setsms sms) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		//参数检查
		if(sms.getSetinfoid()==null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Setsms old_sms = getSetingSMS();
		sms.setUpdatetime(new Date());
		sms.setUpdateby(accountInfo.getAccount().getName());
		sms.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		sms.setSetinfoid(old_sms.getSetinfoid());// 根据原id修改
		int i = smsMapper.updateByPrimaryKeySelective(sms);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		// 插入数据库操作日志
				String log = "设置了短信配置信息 : [ ";
				log += StringUtils.isBlank(sms.getUsername()) ? "" : "AccessKeyId=" + sms.getUsername() + ",";
				log += StringUtils.isBlank(sms.getUpdateby()) ? "" : "设置人=" + sms.getUpdateby() + ",";
				log += sms.getUpdatepersonid() != null ? "" : "设置人id=" + sms.getCreatepersonid() + ",";
				log = log.substring(0, log.length() - 1) + " ]";
				this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

				return Result.succee();
	}
	
	@Override
	public  Result sendSms(Integer scene, String phone, String product, String item , String customer) throws ClientException {

		//参数检查
		if(scene==null || phone==null  ) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		String code = getSMSCode();

		//将验证码存入redis
		jedisClient.set(Constant.PHONE_CODE_PRE + phone, code, REDIS_PASSWORD);
		jedisClient.expire(Constant.PHONE_CODE_PRE + phone, PHONE_CODE_EXPIRE, REDIS_PASSWORD);
		
        //可自助调整超时时间(默认连接超时,默认读取超时)
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        
        if(scene != 1) {

        }
        
        if(product == null) {
        	product = "中博星辰";
        }
        
        Setsms sms = getSetingSMS();
        if(sms == null || sms.getUsername() == null || sms.getPassword() ==  null) {
        	return Result.build(ResultEnum.SMS_ACCESSKEY);
        }
        if(sms.getState().equals("0")) {
        	return Result.build(50002,400,"短信已禁用,请先在系统设置-短信设置中打开短信开关!");
        }
        if(sms.getRegistedsend().equals("0")) {
        	return Result.build(50002,400,"注册发送短信已禁用,请先在系统设置-短信设置中打开注册发送短信开关!");
        }
        if(sms.getLoginsend().equals("0")) {
        	return Result.build(50002,400,"登录发送短信已禁用,请先在系统设置-短信设置中打开登录发送短信开关!");
        }
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", sms.getUsername(), sms.getPassword());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SignName);
        if(scene == 1) {
        	if(customer == null) {
        		Result.build(ResultEnum.PARAMETER_ERROR);
        	}
        	Map <String, String> param = new HashMap <String, String>();
        	param.put("customer", customer);
        	JSONObject jsonObject = JSONObject.fromObject(param);
        	String josnParam = jsonObject.toString();//将参数转为josn字符串
        	 //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(TemplateCode1);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(josnParam);//request.setTemplateParam("{\"product\":\"中博星辰官网\", \"code\":\"576872\"}");
        };
        if(scene == 2) {
        	if(code == null || product == null) {
        		Result.build(ResultEnum.PARAMETER_ERROR);
        	}
        	Map <String, String> param = new HashMap <String, String>();
        	param.put("code", code);
        	param.put("product", product);
        	JSONObject jsonObject = JSONObject.fromObject(param);
        	String josnParam = jsonObject.toString();//将参数转为josn字符串
        	 //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(TemplateCode2);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(josnParam);
        };
        if(scene == 3) {
        	if(code == null || product == null) {
        		Result.build(ResultEnum.PARAMETER_ERROR);
        	}
        	Map <String, String> param = new HashMap <String, String>();
        	param.put("code", code);
        	param.put("product", product);
        	JSONObject jsonObject = JSONObject.fromObject(param);
        	String josnParam = jsonObject.toString();//将参数转为josn字符串
        	 //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(TemplateCode3);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(josnParam);
        };
        if(scene == 4) {
        	if(code == null || product == null) {
        		Result.build(ResultEnum.PARAMETER_ERROR);
        	}
        	Map <String, String> param = new HashMap <String, String>();
        	param.put("code", code);
        	param.put("product", product);
        	JSONObject jsonObject = JSONObject.fromObject(param);
        	String josnParam = jsonObject.toString();//将参数转为josn字符串
        	 //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(TemplateCode4);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(josnParam);
        };
        if(scene == 5) {
        	if(code == null || product == null) {
        		Result.build(ResultEnum.PARAMETER_ERROR);
        	}
        	Map <String, String> param = new HashMap <String, String>();
        	param.put("code", code);
        	param.put("product", product);
        	JSONObject jsonObject = JSONObject.fromObject(param);
        	String josnParam = jsonObject.toString();//将参数转为josn字符串
        	 //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(TemplateCode5);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(josnParam);
        };
        if(scene == 6) {
        	if(code == null || product == null || item == null) {
        		Result.build(ResultEnum.PARAMETER_ERROR);
        	}
        	Map <String, String> param = new HashMap <String, String>();
        	param.put("code", code);
        	param.put("product", product);
        	param.put("item", item);
        	JSONObject jsonObject = JSONObject.fromObject(param);
        	String josnParam = jsonObject.toString();//将参数转为josn字符串
        	 //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(TemplateCode6);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(josnParam);
        };
        if(scene == 7) {
        	if(code == null || product == null) {
        		Result.build(ResultEnum.PARAMETER_ERROR);
        	}
        	Map <String, String> param = new HashMap <String, String>();
        	param.put("code", code);
        	param.put("product", product);
        	JSONObject jsonObject = JSONObject.fromObject(param);
        	String josnParam = jsonObject.toString();//将参数转为josn字符串
        	 //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(TemplateCode7);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(josnParam);
        };
        if(scene == 8) {
        	if(code == null || product == null) {
        		Result.build(ResultEnum.PARAMETER_ERROR);
        	}
        	Map <String, String> param = new HashMap <String, String>();
        	param.put("code", code);
        	param.put("product", product);
        	JSONObject jsonObject = JSONObject.fromObject(param);
        	String josnParam = jsonObject.toString();//将参数转为josn字符串
        	 //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(TemplateCode8);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(josnParam);
        };
//        
//        //必填:短信模板-可在短信控制台中找到
//        request.setTemplateCode("SMS_25480298");
//        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
//        request.setTemplateParam("{\"product\":\"中博星辰官网\", \"code\":\"576872\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return Result.succee(sendSmsResponse);
    }
	

//	@Override
//	public Result sendSMSCode(String phone) {
//		
//		if (!RegexUtils.checkMobile(phone)) {
//			return Result.build(ResultEnum.MOBILE_PHONE_ERROR);
//		}
//		String smsCode = getSMSCode();
//		if (DEBUG) {
//			smsCode = "123456";
//		}
//		//验证码存入redis
//		jedisClient.set(Constant.PHONE_CODE_PRE + phone, smsCode, REDIS_PASSWORD);
//		jedisClient.expire(Constant.PHONE_CODE_PRE + phone, PHONE_CODE_EXPIRE, REDIS_PASSWORD);
//		if (! DEBUG) {
//			String smsText =  "【中博星辰】您的验证码是" +smsCode + "，在5分钟内有效。如非本人操作请忽略本短信。";
//			Result sendSMS = sendSMS(smsText, phone);
//			return sendSMS;
//		}
//		return Result.succee();
//	}



	/**
	 * 产生6位短信验证码
	 * 
	 * @return
	 */
	private String getSMSCode() {
		String code = "";
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			code += (random.nextInt(9) + 1);
		}

		return code;
	}

}
