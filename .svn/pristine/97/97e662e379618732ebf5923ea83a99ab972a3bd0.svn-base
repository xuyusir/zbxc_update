package com.jy.service.system.web.info;

import java.io.IOException;
import java.util.List;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.web.info.Setcostomerserviceinfo;
import com.jy.entiy.system.web.info.Setwebinfo;

/**
 * @ClassName:  customer_serviceService   
 * @Description:客服接口 
 * @author: chenye
 * @date:   2018-08-11 10:11
 */
public interface WebSetingService {
	
	
	/**
	 * 通过用户获取网站原设置信息
	 * @return
	 */
	public Result getSiteinfoByUser();
	
	
	/**
	 * 通过用户获取网站原客服设置信息
	 * @param userInfo
	 * @return
	 */
	public List<Setcostomerserviceinfo> getCustomerServiceByUser(AccountInfo accountInfo, String AUTHORITY_CODE);
	
	
	
	
	/**
	 * 网站设置客服列表(新增)
	 * @param customerService
	 * @return
	 * @throws MyException 
	 */
	public Result insertCustomerService(AccountInfo accountInfo,String AUTHORITY_CODE,Setcostomerserviceinfo setcostomerserviceinfo) throws MyException;
	
	
	/**
	 * 网站设置客服列表(修改)
	 * @param customerService
	 * @return
	 * @throws MyException 
	 */
	public Result updateCustomerService(AccountInfo accountInfo,String AUTHORITY_CODE,Setcostomerserviceinfo setcostomerserviceinfo) throws MyException;
	
	
	/**
	 * 网站设置网站信息和手机状态
	 * @param customerService
	 * @return
	 * @throws MyException 
	 * @throws IOException 
	 */
	public Result insertOrUpdateSiteInfo(AccountInfo accountInfo,String AUTHORITY_CODE,Setwebinfo siteinfo) throws MyException, IOException;
	
	/**
	 * 删除logo文件
	 * @param accountInfo 当前登录用户
	 * @param AUTHORITY_CODE 权限编码
	 * @param logo_name 删除的logo存在数据的字段名
	 * @return
	 * @throws MyException 
	 */
	public Result deleteLogo(AccountInfo accountInfo, String AUTHORITY_CODE, String logo_name) throws MyException;

	/**
	 * 获取页面操作权限
	 * @param accountInfo 当前登录用户
	 * @param menu_id 菜单ID
	 * @return
	 */
	public Result getAuthority(AccountInfo accountInfo, Integer menu_id);
	
	/**
	 * 删除网站公众号二维码
	 * @param accountInfo
	 * @param controllerCode
	 * @return
	 * @throws MyException 
	 */
	//public Result deleteWeChatQRCode(AccountInfo accountInfo, String controllerCode) throws MyException;

	/**
	 * 删除网站logo
	 * @param accountInfo
	 * @param controllerCode
	 * @return
	 * @throws MyException 
	 */
	//public Result deleteWebLogo(AccountInfo accountInfo, String controllerCode) throws MyException;


	/**
	 * 删除手机版logo
	 * @param accountInfo
	 * @param controllerCode
	 * @return
	 * @throws MyException 
	 */
	//public Result deleteMobileLOGO(AccountInfo accountInfo, String controllerCode) throws MyException;

}
