package com.jy.service.base;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.jy.common.exception.MyException;
import com.jy.common.redis.JedisClient;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.AliyunOSSClientUtil;
import com.jy.common.utils.IDUtils;
import com.jy.common.utils.JsonUtils;
import com.jy.common.utils.RightsHelper;
import com.jy.dao.account.authority.AuthorityMapper;
import com.jy.dao.account.authority.RoleMapper;
import com.jy.dao.content.file.directory.DocumentdirectoryMapper;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.dao.content.file.file.UsefileMapper;
import com.jy.dao.system.db_log.DblogMapper;
import com.jy.dao.system.dictionaries.DictionariesMapper;
import com.jy.dao.system.menu.MenuMapper;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.account.authority.Authority;
import com.jy.entiy.account.authority.AuthorityExample;
import com.jy.entiy.account.authority.Role;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.content.file.directory.Documentdirectory;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.entiy.content.file.file.Usefile;
import com.jy.entiy.content.file.file.UsefileExample;
import com.jy.entiy.system.db_log.Dblog;

import sun.misc.BASE64Encoder;

/**
 * @ClassName: BaseService
 * @Description:基础Service
 * @author: cheng fei
 * @date: 2018-07-31 09:33
 */
@SuppressWarnings("restriction")
public class BaseService {
	// 日志
	protected Logger logger = Logger.getLogger(this.getClass());

	@Resource
	protected DblogMapper dblogMapper;

	@Resource
	protected RoleMapper roleMapper;

	@Resource
	protected DictionariesMapper dictionariesMapper;

	@Resource
	protected MenuMapper menuMapper;

	@Resource
	protected FileinfoMapper fileinfoMapper;

	@Resource
	protected UsefileMapper usefileMapper;

	@Resource
    protected AuthorityMapper authorityMapper;

	@Resource
	protected DocumentdirectoryMapper documentdirectoryMapper;

	@Resource
    protected AliyunOSSClientUtil aliyunOSSClientUtil;

	@Resource
	protected JedisClient jedisClient;

	/**
	 * @Description : 用户登陆有效时间
	 */
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;

	/**
	 * @Description : redis 密码
	 */
	@Value("${REDIS_PASSWORD}")
	protected String REDIS_PASSWORD;


	@Value("${ADMINISTRATOR}")
    protected String ADMINISTRATOR;

	@Value("${DEBUG}")
    protected boolean DEBUG;

	@Value("${TEST_ACCOUNT}")
    protected String TEST_ACCOUNT;

	//url 加密
	protected String getBASE64Encoder(String url) {
		// 97 - 123
		//65 - 91
		//48 - 58
		//61
		//前加7位，后加11位干扰码
		//获取URL连接
		url = aliyunOSSClientUtil.getUrl(url);
		aliyunOSSClientUtil.closeOSSClient();
		try {
			 byte[] b = url.getBytes("UTF-8");
			 url = new BASE64Encoder().encode(b);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//加入干扰信息
		List<Integer> list = new ArrayList<>();
		for(int i = 48;i<59;i++) {
			list.add(i);
		}
		for(int i = 65;i<92;i++) {
			list.add(i);
		}
		for(int i = 97;i<124;i++) {
			list.add(i);
		}
		list.add(61);


		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<11;i++) {
			int random = (int) (Math.random()*63);
			sb.append((char)(list.get(random).intValue()));
		}
		url = url.substring(0, url.length()-5) +sb+url.substring(url.length()-5,url.length());
		sb = new StringBuffer();
		for(int i = 0;i<7;i++) {
			int random = (int) (Math.random()*59);
			sb.append((char)(list.get(random).intValue()));
		}
		url = sb+url;
		return url;
	}



	/**
	 * 获取yyyy-MM-dd HH:mm:ss格式的当前时间字符串
	 *
	 * @return
	 */
	protected String getNow() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * 获取UUID
	 *
	 * @return
	 */
	protected String getUUID() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}

	/**
	 * 检测是否是系统超级管理员
	 *
	 * @param accountInfo
	 * @return
	 */
	protected boolean checkAdministrator(AccountInfo accountInfo) {
		if (TEST_ACCOUNT.equals(accountInfo.getAccount().getUsername())) {
			return false;
		} else if (DEBUG) {
			return true;
		} else if (ADMINISTRATOR.equals(accountInfo.getAccount().getUsername())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检测权限
	 * @param accountInfo 当前登录用户
	 * @param AUTHORITY_CODE 权限编码
	 * @return
	 * @throws MyException
	 */
	protected Result checkAuthority(AccountInfo accountInfo, String AUTHORITY_CODE) throws MyException {
		Integer  ACCOUNT_TYPE_MANAGE =  dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_MANAGE);
		if (ACCOUNT_TYPE_MANAGE.intValue() != accountInfo.getAccount().getDictionariesid()) {
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}else {
			boolean b = checkAdministrator(accountInfo);
			if (b) {
				return Result.succee();
			}
			if (accountInfo.getRole() == null || accountInfo.getRole().getAuthority() == null) {
				return Result.build(ResultEnum.NOT_AUTHORITY);
			}else {
                Role role = roleMapper.selectByPrimaryKey(accountInfo.getRole().getRoleid());
                String authority = role.getAuthority();
				Integer authority_id = authorityMapper.getIdByCode(AUTHORITY_CODE);
				if (authority_id == null) {
					return Result.build(ResultEnum.MENU_AUTHORITY_NOT_EXIST);
				}
				boolean c = RightsHelper.testRights(authority, authority_id);
				if (c) {
					return Result.succee();
				}else {
					return Result.build(ResultEnum.NOT_AUTHORITY);
				}
			}
		}
	}

	/**
	 * 获取菜单id
	 *
	 * @param SERVICE_COED
	 * @return
	 */
	protected Integer getMenuIds(String CONTROLLER_CODE) {
		Integer controller_id = dictionariesMapper.getDictionariesIDByCode(CONTROLLER_CODE);
		if (controller_id == null) {
			return null;
		}
		return menuMapper.getMenuIdByDictionariesID(controller_id);
	}

	/**
	 * @param accountInfo 当前登录人员
	 * @param menu_id 菜单ID
	 * @return
	 */
	protected Result getPageButtonAuthority(AccountInfo accountInfo,Integer menu_id) {
		boolean flag = true;
		String authority2 = "";
		if (accountInfo.getRole() == null || accountInfo.getRole().getRoleid() == null) {
			flag = false;
		}else {
            Role role = roleMapper.selectByPrimaryKey(accountInfo.getRole().getRoleid());
            authority2 = role.getAuthority();
		}

		AuthorityExample example = new AuthorityExample();
		example.setOrderByClause("DisplayOrder");
		com.jy.entiy.account.authority.AuthorityExample.Criteria criteria = example.createCriteria();
		criteria.andMenuidEqualTo(menu_id);
		List<Authority> list = authorityMapper.selectByExample(example);
		Map<String,Boolean> map = new HashMap<>();
		boolean checkAdministrator = checkAdministrator(accountInfo);
		for (Authority authority : list) {
			boolean flag2 = false;
			if (checkAdministrator) {
				flag2 = true;
			}else if (flag) {
				flag2 = RightsHelper.testRights(authority2, authority.getId());
			}
			map.put(authority.getCode(), flag2);
		}

		return Result.succee(map);
	}

	/**
	 * 添加数据库操作日志
	 *
	 * @param name
	 * @param log
	 * @throws MyException
	 */
	protected void dbLog(Long create_person_id, String create_by, String db_log, String DB_LOG_TYPE)
			throws MyException {
		Integer dictionaries_id = dictionariesMapper.getDictionariesIDByCode(DB_LOG_TYPE);
		if (dictionaries_id == null) {
			throw new MyException(ResultEnum.INSERT_DB_LOG_ERROR);
		}
		Dblog dbLog = new Dblog();
		long id = IDUtils.createID();
		dbLog.setDblogid(id);
		dbLog.setCreatepersonid(create_person_id);
		dbLog.setCreateby(create_by);
		dbLog.setCreatetime(new Date());
		dbLog.setDblog(db_log);
		dbLog.setDictionariesid(dictionaries_id);
		int i = dblogMapper.insertSelective(dbLog);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_DB_LOG_ERROR);
		}
	}

	/**
	 * 验证是否是日期
	 *
	 * @param str
	 * @return
	 */
	protected boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/**
	 * 检查模糊查询参数
	 *
	 * @param search
	 * @return
	 */
	protected String checkSearch(String search) {
		if (search == null || "".equals(search) || "undefined".equals(search)) {
			search = null;
		} else {
			search = "%" + search + "%";
		}
		return search;
	}

	/**
	 * 检查时间查询参数
	 *
	 * @param data
	 * @return
	 */
	protected String checkSearchTime(String data) {
		if (data == null || "".equals(data) || !isValidDate(data)) {
			return null;
		}
		return data;
	}

	/**
	 * 添加文件引用
	 * @param file_id 文件ID
	 * @param tableName 引用表名
	 * @param useID 引用记录主键
	 * @throws MyException
	 */
	protected void addUseFile(Long file_id, String tableName, Long useID) throws MyException {
		Usefile usefile = new Usefile();
		usefile.setFileid(file_id);
		usefile.setTablename(tableName);
		usefile.setUseid(useID);
		int i = usefileMapper.insert(usefile);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
	}

	/**
	 * 删除文件引用以及文件
	 * @param accountInfo 当前登录人员
	 * @param DB_LOG_TYPE 数据库操作日志类型
	 * @param file_id 文件ID
	 * @param tableName 引用表名
	 * @param useID 引用记录主键
	 * @throws MyException
	 */
	protected void deleteFile(AccountInfo accountInfo, String DB_LOG_TYPE, Long file_id, String tableName, Long useID) throws MyException {

		Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(file_id);
		if(fileinfo == null) {
			return;
		}
		//删除文件引用
		UsefileExample example = new UsefileExample();
		com.jy.entiy.content.file.file.UsefileExample.Criteria criteria = example.createCriteria();
		criteria.andTablenameEqualTo(tableName);
		criteria.andFileidEqualTo(fileinfo.getFileid());
		criteria.andUseidEqualTo(useID);
		List<Usefile> list = usefileMapper.selectByExample(example);
		if(list.size() != 0) {
			int i = usefileMapper.deleteByPrimaryKey(list.get(0).getId());
			if (i < 1) {
				System.err.println("删除文件引用错误。。。。。。。。。。。。。。。。。。。。");
				throw new MyException(ResultEnum.DELETE_SQL_ERROR);
			}
		}


		UsefileExample example2 = new UsefileExample();
		com.jy.entiy.content.file.file.UsefileExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andFileidEqualTo(file_id);
		int i = usefileMapper.countByExample(example2);

		//没有其他表引用删除文件
		if (i == 0) {
			i = fileinfoMapper.deleteByPrimaryKey(file_id);
			if (i < 1) {
				System.err.println("删除文件错误..........................");
				throw new MyException(ResultEnum.DELETE_SQL_ERROR);
			}
			dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(),
					"删除了文件[ " + fileinfo.getFilename() + " ]", DB_LOG_TYPE);
            aliyunOSSClientUtil.deleteFile(fileinfo.getFilefullpath());
            aliyunOSSClientUtil.closeOSSClient();
			/*if (!deleteFile) {
				throw new MyException(ResultEnum.DELETE_FILE_ERROR);
			}*/
		}
	}

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/12/24 22:40
	 * 描述 : 阿里云获取上传文件目录
	 *
	 * @param folderID   文件目录ID
	 * @param createDate 创建文件时间
	 * @return
	 */
	protected String getFolder(Long folderID, Date createDate) {
		List<String> folders = new ArrayList<>();
		getParentFolderList(folders, folderID);
		Collections.reverse(folders);
		String data = "";
		for (String folder : folders) {
			data += folder + "/";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		String format = simpleDateFormat.format(createDate);
		data += format + "/";
		return data;
	}

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/25 0:36
     * 描述 : 获取二维码上传文件夹
     * @return
     */
    protected String createRQCodeFolder(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String format = simpleDateFormat.format(new Date());
	    return Constant.QR_CODE_FOLDER + "/" + format;
    }

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/12/24 22:45
	 * 描述 : 递归查询文件夹所有父文件夹名称
	 *
	 * @param folders  文件夹名称列表
	 * @param folderID 文件夹ID
	 * @return
	 */
	protected List<String> getParentFolderList(List<String> folders, Long folderID) {
		Documentdirectory documentdirectory = documentdirectoryMapper.selectByPrimaryKey(folderID);
		folders.add(documentdirectory.getDirectoryname());
		if (documentdirectory.getParentid() != 0) {
			getParentFolderList(folders, documentdirectory.getParentid());
		}
		return folders;
	}


	/**
	 *	插入日志
	 * @param DB_LOG_TYPE
	 *  @param object 新增的实体类或被删除的实体类或修改前的实体类
	 * @param accountInfo
	 * @param code 操作类型编码1新增2修改3删除
	 * @param table被操作表明
	 * @param object1修改操作时，修改后的实体类，新增、删除为null
	 * @throws MyException
	 */
	protected void log(String DB_LOG_TYPE,Object object,AccountInfo accountInfo,int code,String table,Object object1)
			throws MyException {
		Integer dictionaries_id = dictionariesMapper.getDictionariesIDByCode(DB_LOG_TYPE);
		if (dictionaries_id == null) {
			throw new MyException(ResultEnum.INSERT_DB_LOG_ERROR);
		}
		Dblog dbLog = new Dblog();
		long id = IDUtils.createID();
		dbLog.setDblogid(id);
		dbLog.setCreatepersonid(accountInfo.getAccount().getAccountid());
		dbLog.setCreateby(accountInfo.getAccount().getName());
		dbLog.setCreatetime(new Date());
		dbLog.setDblog(setLog(object, accountInfo, code, table, object1));
		dbLog.setDictionariesid(dictionaries_id);
		int i = dblogMapper.insertSelective(dbLog);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_DB_LOG_ERROR);
		}
	}

	/**
	 * 生成数据库日志字段
	 * @param object 新增的实体类或被删除的实体类或修改前的实体类
	 * @param accountInfo
	 * @param code 操作类型编码1新增2修改3删除
	 * @param table被操作表明
	 * @param object1修改操作时，修改后的实体类，新增、删除为null
	 * @return
	 */
    public String  setLog(Object object,AccountInfo accountInfo,int code,String table,Object object1){
        StringBuffer sb = new StringBuffer();
        String handle = null;
        if (code==1) {
        	handle = "新增";
		}
        if (code==2) {
        	handle = "修改";
		}
        if (code==3) {
        	handle = "删除";
		}
        sb.append("用户["+accountInfo.getAccount().getName()+"],用户ID为["+accountInfo.getAccount().getAccountid()
        		+"],对数据库进行了["+handle+"]操作,操作表为["+table+"]");
        if(code==1) {//增加
        	sb.append("添加数据字段与对应值依次为：[{"+getValues(object)+"}]");
        }
        if(code==2) {//修改
        	sb.append("修改前数据字段与对应值依次为：[{"+getValues(object)+"}]");
        	sb.append("被修改的数据字段与对应值依次为：[{"+getValues(object1)+"}]");
        }
        if(code==3) {//删除
        	sb.append("被删除值的数据字段与对应值依次为：[{"+getValues(object)+"}]");
        }
        return sb.toString();
    }

    private String getValues(Object object) {
    	StringBuffer sb = new StringBuffer();
    	// 获取实体类的所有属性，返回Field数组
    	if (object == null) {
			return null;
		}
        Field[] field = object.getClass().getDeclaredFields();
        for (Field field2 : field) {
        	 // 获取属性的名字
            String name = field2.getName();
            String name1 =name;

            // 将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method m = null;
			try {
				m = object.getClass().getMethod("get" + name);
			} catch (Exception e) {
				try {
					m = object.getClass().getMethod(name1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
            // 调用getter方法获取属性值
			Object  value = null;
            try {
				value= m.invoke(object);
			} catch (Exception e) {
				e.printStackTrace();
			}
            if (value != null) {
				sb.append(name1+":");
				sb.append(value);
				sb.append(",");
			}
		}
        return sb.substring(0,sb.length()-1);
    }

    /**
     * 获取对象所有属性值,返回String集合
     * @param object
     * @return
     */
    public List<String> getValue(Object object) {
    	List<String> stings = new ArrayList<>();
    	// 获取实体类的所有属性，返回Field数组
        Field[] field = object.getClass().getDeclaredFields();
        for (Field field2 : field) {
        	 // 获取属性的名字
            String name = field2.getName();
            String name1 =name;

            // 将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method m = null;
			try {
				m = object.getClass().getMethod("get" + name);
			} catch (Exception e) {
				try {
					m = object.getClass().getMethod(name1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
            // 调用getter方法获取属性值
			Object  value = null;
            try {
				value= m.invoke(object);
			} catch (Exception e) {
				e.printStackTrace();
			}
            stings.add(value+"");
		}
        return stings;
    }

	/**
	 * @Author : Cheng Fei
	 * @Date : 2018/10/29 9:24
	 * @Description  更新Token中的账号信息
	 * @Param  accountInfo
	 * @Return
	 */
	protected void updateToken(AccountInfo accountInfo){
		String json = JsonUtils.objectToJson(accountInfo);
		jedisClient.set(accountInfo.getRequestHome() + Constant.SESSION_PRE + accountInfo.getToken(), json);
		jedisClient.expire(accountInfo.getRequestHome() + Constant.SESSION_PRE + accountInfo.getToken(), SESSION_EXPIRE, REDIS_PASSWORD);
	}

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/23 22:41
     * 描述 : 检测是否是后台管理员账号
     * @param account 账号
     * @return
     */
	protected boolean checkManageAccount(Account account){
        Integer accountTypeManage = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_MANAGE);
        if (accountTypeManage.intValue() == account.getDictionariesid()){
            return true;
        }else {
            return false;
        }
    }
}
