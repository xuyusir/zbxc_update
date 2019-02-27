package com.jy.entiy.constant;

public class Constant {

	/**
	 * 请求来源-网页端
	 */
	public static final String WEB = "web";

	/**
	 * 请求来源-手机端
	 */
	public static final String MOBILE = "mobile";

	/**
	 * 请求来源-微信端
	 */
	public static final String WECHAT = "WeChat";

	/**
	 * 请求来源存入request的key
	 */

	public static final String REQUEST_HOME = "request_home";

	/**
	 * 编码集
	 */
	public static String CODED_SET = "UTF-8";

	public static  String LOST_CONNECTION = "lost_connection";

	/**
	 * 二维码文件夹
	 */
	public static String QR_CODE_FOLDER = "二维码";



	/**
	 * 将验证码存放在session中的key
	 */
	public static final String VERIFICATION_CODE = "verification_code:";

	// 将登录用户存放在redis中的key前缀
	public static final String SESSION_PRE = "_session:";

	// 记录登录用户在reids中存入session的token 的key前缀
	public static final String ACCOUNTINFO = "_accountInfo:";

	//手机验证码前缀
	public static final String PHONE_CODE_PRE = "phone_code:";

	//邮箱验证前缀
	public static final String JSP_PRE = "jsp:";

	//邮箱找回密码前缀
	public static final String RESET_PASSWORD_PRE = "reset_password:";

	//用户验证邮箱前缀
	public static final String EMAIL_PRE = "email:";

	//导出PDF PDF暂存在redis中的前缀
	public static final String PDF_HTML_CODE_PRE = "pdf_html_code_pre:";
	//PDF存放在服务器上的基本地址
	public static final String PDF_HTML_CODE_BASE_PATH = "/usr/local/pdf/";

	// 后台接口在数据字典中的编码
	public static final String Controller_COED = "CONTROLLER";

	// 数据库操作日志在数据字典中的code
	public static final String DB_LOG_TYPE = "DB_LOG_TYPE";

	// 账户类型在数据字典中的编码
	public static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";

	// 后台管理员在数据字典中的 编码
	public static final String ACCOUNT_TYPE_MANAGE = "ACCOUNT_TYPE_MANAGE";

	// 个人端用户在数据字典中的编码
	public static final String ACCOUNT_TYPE_PERSON = "ACCOUNT_TYPE_PERSON";

	// 企业用户在数据字典中的编码
	public static final String ACCOUNT_TYPE_ENTERPRISE = "ACCOUNT_TYPE_ENTERPRISE";

	// 无后台接口编码
	public static final String CONTROLLER_NULL = "CONTROLLER_NULL";

	//服务类型编码
	public static final String APPLY_UPDATE_RESUME = "APPLY_UPDATE_RESUME";//简历修改服务固定编码
	public static final String APPLY_MOCK_INTERVIEW = "APPLY_MOCK_INTERVIEW";//单面模拟服务固定编码
	public static final String APPLY_MOCK_BEISEN = "APPLY_MOCK_BEISEN";//北森测试服务固定编码
	public static final String MOCK_INTERVIEW = "MOCK_INTERVIEW";//群面服务固定编码
	public static final String OFFLINE_COURSE = "OFFLINE_COURSE";//线下课程服务固定编码
	public static final String ICDL = "ICDL";//ICDL报考服务固定编码

	//服务状态编码
	public static final String SERVICE_STATUS_UNUSE = "UNUSE";//服务状态为未使用
	public static final String SERVICE_STATUS_USE = "USE";//服务状态为使用

	//服务申请结果
	public static final String APPLICATION_STATUS_WAIT = "APPLICATION_STATUS_WAIT";//服务处理结果为待处理
	public static final String APPLICATION_STATUS_AGREE = "APPLICATION_STATUS_AGREE";//服务处理结果为已同意
	public static final String APPLICATION_STATUS_DISAGREE = "APPLICATION_STATUS_DISAGREE";//服务处理结果为已拒绝

	public static final String APPLICATION_STATUS_INAPPROPRIATE = "APPLICATION_STATUS_INAPPROPRIATE";//服务处理结果为不合适
	public static final String APPLICATION_STATUS_UNDERWAY = "APPLICATION_STATUS_UNDERWAY";//服务处理结果为进行中
	public static final String APPLICATION_STATUS_TO_BE_HIRED = "APPLICATION_STATUS_TO_BE_HIRED";//服务处理结果为待入职
	public static final String APPLICATION_STATUS_HAS_HIRED = "APPLICATION_STATUS_HAS_HIRED";//服务处理结果为已入职
	public static final String APPLICATION_STATUS_NO_ENTRY = "APPLICATION_STATUS_NO_ENTRY";//服务处理结果为未入职

	//薪资类型
	public static final String SALARY_ON_FACE = "SALARY_ON_FACE";//薪资面谈

	//简历投递状态
	public static final String PERSON_DELIVERY_STATUS_DELIVER = "PERSON_DELIVERY_STATUS_DELIVER";//投递
	public static final String PERSON_DELIVERY_STATUS_INTERVIEW = "PERSON_DELIVERY_STATUS_INTERVIEW";//面试
	public static final String PERSON_DELIVERY_STATUS_HIRE = "PERSON_DELIVERY_STATUS_HIRE";//录用
	public static final String PERSON_DELIVERY_STATUS_INAPPROPRIATE="PERSON_DELIVERY_STATUS_INAPPROPRIATE";//不合适
	//工作台任务状态
	public static final String TASK_STATUS_UNFINISHED = "TASK_STATUS_UNFINISHED";//未完成
	public static final String TASK_STATUS_OVERDUE = "TASK_STATUS_OVERDUE";//已过期
	public static final String TASK_STATUS_FINISHED = "TASK_STATUS_FINISHED";//已完成

	//报告类型
	public static final String PERSON_REPORT_TYPE_TAX_DECLARATION = "PERSON_REPORT_TYPE_TAX_DECLARATION";//增值报告

	//支付类型
	public static final String PAY_TYPE_EARNEST = "PAY_TYPE_EARNEST";//定金
	public static final String PAY_TYPE_BALANCE = "PAY_TYPE_BALANCE";//尾款
	public static final String PAY_TYPE_ALL = "PAY_TYPE_ALL";//全款

	//客户——商机意向
	public static final String INTENTION_TYPE_PAY_ALL = "INTENTION_TYPE_PAY_ALL";//已支付全款
	public static final String INTENTION_TYPE_PAY_EARNEST = "INTENTION_TYPE_PAY_EARNEST";//已支付定金
	/**********************************订单定时关闭，定时时间*****************************************/
	public static final String ORDER_COLSE_TIME = "time";//订单未付款关闭时间，储存在数据字典表中，DisplayOrder字段存储时间，单位分钟


}
