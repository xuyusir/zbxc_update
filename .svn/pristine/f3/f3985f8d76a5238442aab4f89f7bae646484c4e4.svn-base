package com.jy.controller.system.web.info;


import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.system.web.info.Setwebinfo;
import com.jy.service.system.web.info.WebSetingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: CustomerServiceController
 * @Description:客服Controller
 * @author: chenye
 * @date: 2018-08-11 10:33
 */
@Controller
@RequestMapping("system/web/seting")
@Api(tags = "system.web.WebSetingController", description = "系统-网站-网站基本信息模块")
public class WebSetingController extends BaseController {

	//网站设置web端logo
	public static final String web_logo_column = "WebLOGO";

	//网站设置微信公众号二维码
	public static final String wechat_qr_code_column = "WeChatQRCode";


	//网站设置移动端logo
	public static final String mobile_logo_column = "MobileLOGO";

	@Resource
	private WebSetingService webSetingService;



	/**
	 * 查询网站信息原设置
	 * @return
	 */
	@ApiOperation(value = "加载网站基本信息接口", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public Result getInfo() {
		return webSetingService.getSiteinfoByUser();
	}

	/**
	 * 查询网站LOGO
	 * @return
	 */
	@ApiOperation(value = "加载LOGO接口", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/logo", method = RequestMethod.GET)
	@ResponseBody
	public Result getLogo() {
		Result siteinfoByUser = webSetingService.getSiteinfoByUser();
		if (siteinfoByUser.getData() == null){
			return Result.succee();
		}
		Setwebinfo data = (Setwebinfo) siteinfoByUser.getData();
		String webLogoPath = data.getWebLogoPath();
		return Result.succee(webLogoPath);
	}


	/**
	 * 查询网站二维码
	 * @return
	 */
	@ApiOperation(value = "加载二维码接口", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/qr", method = RequestMethod.GET)
	@ResponseBody
	public Result getEWM() {
		Result siteinfoByUser = webSetingService.getSiteinfoByUser();
		if(siteinfoByUser.getData() == null) {
			return Result.succee();
		}
		Setwebinfo data = (Setwebinfo) siteinfoByUser.getData();
		String QRCodePath = data.getWechatQRCodePath();
		return Result.succee(QRCodePath);
	}

	/**
	 * 查询客服原设置
	 *
	 * @return
	 */
/*	@ApiOperation(value = "查询客服原设置", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getCS", method = RequestMethod.GET)
	@ResponseBody
	public Result getCS() {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		List<Setcostomerserviceinfo> customerServiceList = webSetingService.getCustomerServiceByUser(accountInfo);
		if(customerServiceList.size()!=0) {
			Setcostomerserviceinfo setcostomerserviceinfo = customerServiceList.get(customerServiceList.size() - 1);// 最新一组数据为当前设置信息
			return Result.succee(setcostomerserviceinfo);
			}
			return Result.succee();

	}*/

	/**
	 * 网站设置-设置客服列表
	 *
	 * @param customerService
	 * @return
	 * @throws MyException
	 */
/*	@ApiOperation(value = "设置客服", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/setingCS", method = RequestMethod.POST)
	@ResponseBody
	public Result setCustomerService(
			@ApiParam(value = "客服状态(0开启1关闭)", required = true) String start,
			@ApiParam(value = "客服浮动框位置(0左边1右边)", required = true) String site,
			@ApiParam(value = "弹出邀请对话框(0开启1关闭)", required = true) String dialog,
			@ApiParam(value = "工作时间", required = true) String worktime,
			@ApiParam(value = "客服职务1", required = true) String position1,
			@ApiParam(value = "QQ号码1", required = true) String qq1,
			@ApiParam(value = "客服职务2", required = true) String position2,
			@ApiParam(value = "QQ号码2", required = true) String qq2,
			@ApiParam(value = "客服职务3", required = true) String position3,
			@ApiParam(value = "QQ号码3", required = true) String qq3

			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息

		Setcostomerserviceinfo setcostomerserviceinfo = new Setcostomerserviceinfo();
		setcostomerserviceinfo.setStart(start);
		setcostomerserviceinfo.setSite(site);
		setcostomerserviceinfo.setDialog(dialog);
		setcostomerserviceinfo.setWorktime(worktime);
		setcostomerserviceinfo.setPosition1(position1);
		setcostomerserviceinfo.setQq1(qq1);
		setcostomerserviceinfo.setPosition1(position2);
		setcostomerserviceinfo.setQq1(qq2);
		setcostomerserviceinfo.setPosition1(position3);
		setcostomerserviceinfo.setQq1(qq3);

			return webSetingService.insertCustomerService(accountInfo, setcostomerserviceinfo);

	}*/

	/**
	 * 网站设置-设置网站信息
	 *
	 * @param customerService
	 * @return
	 * @throws MyException
	 * @throws IOException
	 */
	@ApiOperation(value = "设置网站信息接口", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertOrUpdateSiteInfo(
			@ApiParam(value = "网站地址", required = false) @ RequestParam(required = false)  String url,
			@ApiParam(value = "网站名称", required = false) @ RequestParam(required = false) String name,
			@ApiParam(value = "网页标题", required = false) @ RequestParam(required = false) String title,
			@ApiParam(value = "ICP备案号", required = false) @ RequestParam(required = false) String icp_id,
			@ApiParam(value = "公网安备省字头", required = false) @ RequestParam(required = false) String province_initial,
			@ApiParam(value = "公网安备号", required = false) @ RequestParam(required = false)String case_id,
			@ApiParam(value = "网站关键字", required = false) @ RequestParam(required = false) String key_word,
			@ApiParam(value = "网站描述", required = false) @ RequestParam(required = false) String depict,
			@ApiParam(value = "网站版权", required = false) @ RequestParam(required = false) String copy_right,
			@ApiParam(value = "联系地址", required = false) @ RequestParam(required = false) String address,
			@ApiParam(value = "联系电话", required = false) @ RequestParam(required = false) String phone,
			@ApiParam(value = "移动电话", required = false) @ RequestParam(required = false) String mobile_phone,
			@ApiParam(value = "传真", required = false) @ RequestParam(required = false) String fax,
			@ApiParam(value = "邮箱", required = false) @ RequestParam(required = false) String mail,
			@ApiParam(value = "邮政编码", required = false) @ RequestParam(required = false) String postal_code
			) throws MyException, IOException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息

		Setwebinfo setwebinfo = new Setwebinfo();
		setwebinfo.setUrl(url);
		setwebinfo.setName(name);
		setwebinfo.setTitle(title);
		setwebinfo.setIcpid(icp_id);
		setwebinfo.setProvinceinitial(province_initial);
		setwebinfo.setCaseid(case_id);
		setwebinfo.setKeyword(key_word);
		setwebinfo.setDepict(depict);
		setwebinfo.setCopyright(copy_right);
		setwebinfo.setAddress(address);
		setwebinfo.setPhone(phone);
		setwebinfo.setMobilephone(mobile_phone);
		setwebinfo.setFax(fax);
		setwebinfo.setMail(mail);
		setwebinfo.setPostalcode(postal_code);
		return webSetingService.insertOrUpdateSiteInfo(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_UPDATE_AUTHORITY, setwebinfo);


	}

	/**
	 * 网站设置-上传网站log
	 * @param customerService
	 * @return
	 * @throws MyException
	 * @throws Exception
	 */
	@ApiOperation(value = "设置网站logo接口", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/web/logo", method = RequestMethod.POST)
	@ResponseBody
	public Result updateWebLogo(
			@ApiParam(value = "网站logo", required = true) @ RequestParam(required = true) Long web_logo
			) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		Setwebinfo setwebinfo = new Setwebinfo();
		setwebinfo.setWeblogo(web_logo);
		return webSetingService.insertOrUpdateSiteInfo(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_UPDATE_LOG_AUTHORITY,setwebinfo);

	}

	/**
	 * 网站设置-删除网站log
	 *
	 * @param customerService
	 * @return
	 * @throws MyException
	 */
	@ApiOperation(value = "删除网站logo接口", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/web/logo", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteWebLogo() throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		return webSetingService.deleteLogo(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_UPDATE_LOG_AUTHORITY, web_logo_column);

	}

	/**
	 * 网站设置-设置微信公众号log
	 *
	 * @param customerService
	 * @return
	 * @throws MyException
	 */
	@ApiOperation(value = "设置微信公众号二维码接口", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/wechat/qr/code", method = RequestMethod.POST)
	@ResponseBody
	public Result updateWechatQRCode(
			@ApiParam(value = "微信公众号二维码", required = true) @ RequestParam(required = true) Long wechat_qr_code
			) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		Setwebinfo setwebinfo = new Setwebinfo();
		setwebinfo.setWechatqrcode(wechat_qr_code);
		return webSetingService.insertOrUpdateSiteInfo(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_UPDATE_LOG_AUTHORITY,setwebinfo);

	}

	/**
	 * 网站设置-删除微信公众号log
	 *
	 * @param customerService
	 * @return
	 * @throws MyException
	 */
	@ApiOperation(value = "删除微信公众号二维码接口", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/wechat/qr/code", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteWeChatQRCode() throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		return webSetingService.deleteLogo(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_UPDATE_LOG_AUTHORITY, wechat_qr_code_column);

	}

	/**
	 * 网站设置-设置手机版log
	 *
	 * @param customerService
	 * @return
	 * @throws MyException
	 */
	@ApiOperation(value = "设置手机版logo接口", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/mobile/logo", method = RequestMethod.POST)
	@ResponseBody
	public Result updateMobileLOGO(
			@ApiParam(value = "手机版logo", required = true) @ RequestParam(required = true) Long mobile_logo
			) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		Setwebinfo setwebinfo = new Setwebinfo();
		setwebinfo.setMobilelogo(mobile_logo);
		return webSetingService.insertOrUpdateSiteInfo(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_UPDATE_LOG_AUTHORITY, setwebinfo);

	}

	/**
	 * 网站设置-删除手机版log
	 * @param customerService
	 * @return
	 * @throws MyException
	 */
	@ApiOperation(value = "删除手机版logo接口", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/mobile/logo", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deletemobileLOGO() throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		return webSetingService.deleteLogo(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_UPDATE_LOG_AUTHORITY, mobile_logo_column);

	}

	/**
	 * 网站设置-设置手机版开关
	 *
	 * @param customerService
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "设置手机版开关接口", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/mobile/start", method = RequestMethod.POST)
	@ResponseBody
	public Result updateMobileStatus(
			@ApiParam(value = "手机版开关,0关闭1开启", required = true) @ RequestParam(required = true) String start
			) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		Setwebinfo setwebinfo = new Setwebinfo();
		setwebinfo.setStart(start);
		return webSetingService.insertOrUpdateSiteInfo(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_UPDATE_MOBILE_START_AUTHORITY, setwebinfo);
	}

	/**
	 * 网站设置-获取页面操作权限
	 *
	 * @param customerService
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "加载页面按钮权限接口", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/authority", method = RequestMethod.GET)
	@ResponseBody
	public Result getAuthority(
			@ApiParam(value = "菜单ID,", required = true) @RequestParam(required = true) Integer menu_id
			) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		return webSetingService.getAuthority(accountInfo, menu_id);
	}

}
