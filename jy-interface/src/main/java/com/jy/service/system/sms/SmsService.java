package com.jy.service.system.sms;



import com.aliyuncs.exceptions.ClientException;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.sms.Setsms;

/**
 * @ClassName:  smsService   
 * @Description:短信设置服务接口 
 * @author: chenye
 * @date:   2018-08-14 16:18
 */
public interface SmsService {

	/**
	 * 获取原短信设置信息
	 * @return
	 */
	public Setsms getSetingSMS();
	
	
	/**
	 * 新增短信设置信息
	 * @param accountInfo
	 * @param sms
	 * @return
	 * @throws MyException 
	 */
	public Result insertSetingSMS(AccountInfo accountInfo,String CONTROLLER_CODE,Setsms sms) throws MyException;
	
	
	/**
	 * 修改短信设置信息
	 * @param accountInfo
	 * @param sms
	 * @return
	 */
	public Result updatesetingSMS(AccountInfo accountInfo,String CONTROLLER_CODE,Setsms sms) throws MyException;

	/**
	 * @param scene 验证场景 同 模板顺序 例scene=1 就是短信模板1短信测试
	 * @param phone
	 * @param product //可选:模板中的变量替换JSON串,request.setTemplateParam("{\"product\":\"中博星辰官网\", \"code\":\"123456\"}") 例:替换"中博星辰官网"
	 * @param item 模板中的变量替换JSON串 request.setTemplateParam("{\"item\":\"中博星辰官网\")
	 * @param customer 模板中的变量替换JSON串request.setTemplateParam("{\"customer\":\"admin\")
	 * @return
	 * @throws ClientException
	 */
	public  Result sendSms(Integer scene,String phone,String product ,String item ,String customer) throws ClientException;
	

//
//
//	/**
//	 * 发送手机验证码
//	 * @param phone
//	 * @return
//	 */
//	public Result sendSMSCode(String phone);
	
}
