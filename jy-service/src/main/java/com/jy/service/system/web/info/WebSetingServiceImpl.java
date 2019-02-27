package com.jy.service.system.web.info;


import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.RegexUtils;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.dao.content.file.file.UsefileMapper;
import com.jy.dao.system.web.info.SetcostomerserviceinfoMapper;
import com.jy.dao.system.web.info.SetwebinfoMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.web.info.Setcostomerserviceinfo;
import com.jy.entiy.system.web.info.Setwebinfo;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: customer_serviceService
 * @Description:客服接口实现
 * @author: chenye
 * @date: 2018-08-11 10:11
 */

@Service
public class WebSetingServiceImpl extends BaseService implements WebSetingService {

    // 菜单数据库操作日志类型
    private static final String DB_LOG_TYPE = "DB_LOG_WEBSETING";
    //文件引用表名
    private static final String TABLE_NAME = "SetWebInfo";

    // 状态类型
    private static final String[] STATUS = {"0", "1"};

    @Resource
    private SetcostomerserviceinfoMapper setcostomerserviceinfoMapper;

    @Resource
    private SetwebinfoMapper setwebinfoMapper;

    @Resource
    private FileinfoMapper fileinfoMapper;

    @Resource
    private UsefileMapper usefileMapper;

    @Override
    public Result insertOrUpdateSiteInfo(AccountInfo accountInfo, String AUTHORITY_CODE, Setwebinfo siteinfo) throws MyException, IOException {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
        if (checkAuthority.getStatus() != 200) {
            return checkAuthority;
        }

        //检测参数
        Result checkParam = checkParam(siteinfo);
        if (checkParam.getStatus() != 200) {
            return checkParam;
        }

        int i = setwebinfoMapper.countByExample(null);
        if (i > 0) {
            siteinfo.setWebsetinfoid(getWebsetinfoid());
            Setwebinfo old_siteinfo = setwebinfoMapper.selectByPrimaryKey(siteinfo.getWebsetinfoid());
            i = setwebinfoMapper.updateByPrimaryKeySelective(siteinfo);
            if (i < 1) {
                throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
            }

            //添加文件使用和删除旧文件
            if (siteinfo.getWeblogo() != null) {
                this.addUseFile(siteinfo.getWeblogo(), TABLE_NAME, (long) siteinfo.getWebsetinfoid());
                if (old_siteinfo.getWeblogo() != null) {
                    this.deleteFile(accountInfo, DB_LOG_TYPE, old_siteinfo.getWeblogo(), TABLE_NAME, (long) old_siteinfo.getWebsetinfoid());
                }
            }
            if (siteinfo.getMobilelogo() != null) {
                this.addUseFile(siteinfo.getMobilelogo(), TABLE_NAME, (long) siteinfo.getWebsetinfoid());
                if (old_siteinfo.getMobilelogo() != null) {
                    this.deleteFile(accountInfo, DB_LOG_TYPE, old_siteinfo.getMobilelogo(), TABLE_NAME, (long) old_siteinfo.getWebsetinfoid());
                }
            }
            if (siteinfo.getWechatqrcode() != null) {
                this.addUseFile(siteinfo.getWechatqrcode(), TABLE_NAME, (long) siteinfo.getWebsetinfoid());
                if (old_siteinfo.getWechatqrcode() != null) {
                    this.deleteFile(accountInfo, DB_LOG_TYPE, old_siteinfo.getWechatqrcode(), TABLE_NAME, (long) old_siteinfo.getWebsetinfoid());
                }
            }

        } else {
            i = setwebinfoMapper.insertSelective(siteinfo);
            if (i < 1) {
                throw new MyException(ResultEnum.INSERT_SQL_ERROR);
            }
            if (siteinfo.getWeblogo() != null) {
                this.addUseFile(siteinfo.getWeblogo(), TABLE_NAME, (long) siteinfo.getWebsetinfoid());
            }
            if (siteinfo.getMobilelogo() != null) {
                this.addUseFile(siteinfo.getMobilelogo(), TABLE_NAME, (long) siteinfo.getWebsetinfoid());
            }
            if (siteinfo.getWechatqrcode() != null) {
                this.addUseFile(siteinfo.getWechatqrcode(), TABLE_NAME, (long) siteinfo.getWebsetinfoid());
            }
        }


        // 插入数据库操作日志
        String log = "设置了网站信息 : [ ";
        log += StringUtils.isBlank(siteinfo.getName()) ? "" : "网站名称=" + siteinfo.getName() + ",";
        log += StringUtils.isBlank(siteinfo.getUrl()) ? "" : "客服地址=" + siteinfo.getUrl() + ",";
        log += StringUtils.isBlank(siteinfo.getTitle()) ? "" : "网站标题=" + siteinfo.getTitle() + ",";
        log += StringUtils.isBlank(siteinfo.getIcpid()) ? "" : "ICP备案号=" + siteinfo.getIcpid() + ",";
        log += StringUtils.isBlank(siteinfo.getProvinceinitial()) ? "" : "公网安备省字头=" + siteinfo.getProvinceinitial() + ",";
        log += StringUtils.isBlank(siteinfo.getCaseid()) ? "" : "公网安备号=" + siteinfo.getCaseid() + ",";
        log += StringUtils.isBlank(siteinfo.getKeyword()) ? "" : "公网关键字=" + siteinfo.getKeyword() + ",";
        log += StringUtils.isBlank(siteinfo.getDepict()) ? "" : "网站描述=" + siteinfo.getDepict() + ",";
        log += StringUtils.isBlank(siteinfo.getCopyright()) ? "" : "网站版权=" + siteinfo.getCopyright() + ",";
        log += StringUtils.isBlank(siteinfo.getAddress()) ? "" : "联系地址=" + siteinfo.getAddress() + ",";
        log += StringUtils.isBlank(siteinfo.getPhone()) ? "" : "联系电话=" + siteinfo.getPhone() + ",";
        log += StringUtils.isBlank(siteinfo.getMobilephone()) ? "" : "移动电话=" + siteinfo.getMobilephone() + ",";
        log += StringUtils.isBlank(siteinfo.getFax()) ? "" : "传真=" + siteinfo.getFax() + ",";
        log += StringUtils.isBlank(siteinfo.getMail()) ? "" : "邮箱=" + siteinfo.getMail() + ",";
        log += StringUtils.isBlank(siteinfo.getPostalcode()) ? "" : "邮政编码=" + siteinfo.getPostalcode() + ",";
        log += siteinfo.getWeblogo() == null ? "" : "网站logo文件ID=" + siteinfo.getWeblogo() + ",";
        log += siteinfo.getWechatqrcode() == null ? "" : "微信公众号二维码文件ID=" + siteinfo.getWechatqrcode() + ",";
        log += StringUtils.isBlank(siteinfo.getStart()) ? "" : "手机版开关=" + (siteinfo.getStart() == "0" ? "关" : "开") + ",";
        log += siteinfo.getMobilelogo() == null ? "" : "手机版logo文件ID=" + siteinfo.getMobilelogo() + ",";
        log = log.substring(0, log.length() - 1) + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result deleteLogo(AccountInfo accountInfo, String AUTHORITY_CODE, String logo_name) throws MyException {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
        if (checkAuthority.getStatus() != 200) {
            return checkAuthority;
        }
        int i = setwebinfoMapper.updateLogo(logo_name, getWebsetinfoid());
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }
        return Result.succee();
    }

    @Override
    public Result getAuthority(AccountInfo accountInfo, Integer menu_id) {
        return Result.succee(this.getPageButtonAuthority(accountInfo, menu_id));
    }

	/*@Override
	public Result deleteWeChatQRCode(AccountInfo accountInfo, String controllerCode) throws MyException {
		Setwebinfo siteinfo = new Setwebinfo();
		siteinfo.setWebsetinfoid(getWebsetinfoid());
		siteinfo.setWechatqrcode(null);
		Setwebinfo old_siteinfo = setwebinfoMapper.selectByPrimaryKey(siteinfo.getWebsetinfoid());
		if (old_siteinfo.getWechatqrcode() == null) {
			return Result.succee();
		}
		int i = setwebinfoMapper.updateByPrimaryKeySelective(siteinfo);
		if (i < 1 ) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}
		this.deleteFile(accountInfo, DB_LOG_TYPE, old_siteinfo.getWechatqrcode(),TABLE_NAME, (long)old_siteinfo.getWebsetinfoid());
		String log = "设置了网站信息:[ 删除了微信公众号二维码 ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();
	}*/

	/*@Override
	public Result deleteWebLogo(AccountInfo accountInfo, String controllerCode) throws MyException {
		Setwebinfo siteinfo = new Setwebinfo();
		siteinfo.setWebsetinfoid(getWebsetinfoid());
		siteinfo.setWeblogo(null);
		Setwebinfo old_siteinfo = setwebinfoMapper.selectByPrimaryKey(siteinfo.getWebsetinfoid());
		if (old_siteinfo.getWeblogo() == null) {
			return Result.succee();
		}
		int i = setwebinfoMapper.updateByPrimaryKeySelective(siteinfo);
		if (i < 1 ) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}
		this.deleteFile(accountInfo, DB_LOG_TYPE, old_siteinfo.getWeblogo(),TABLE_NAME, (long)old_siteinfo.getWebsetinfoid());
		String log = "设置了网站信息:[ 删除了微信公众号二维码 ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();
	}*/

	/*@Override
	public Result deleteMobileLOGO(AccountInfo accountInfo, String controllerCode) throws MyException {
		Setwebinfo siteinfo = new Setwebinfo();
		siteinfo.setWebsetinfoid(getWebsetinfoid());
		siteinfo.setMobilelogo(null);
		Setwebinfo old_siteinfo = setwebinfoMapper.selectByPrimaryKey(siteinfo.getWebsetinfoid());
		if (old_siteinfo.getMobilelogo() == null) {
			return Result.succee();
		}
		int i = setwebinfoMapper.updateByPrimaryKeySelective(siteinfo);
		if (i < 1 ) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}
		this.deleteFile(accountInfo, DB_LOG_TYPE, old_siteinfo.getMobilelogo(),TABLE_NAME, (long)old_siteinfo.getWebsetinfoid());
		String log = "设置了网站信息:[ 删除了微信公众号二维码 ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();
	}*/

    @Override
    public Result getSiteinfoByUser() {
        // 查询网站信息
        List<Setwebinfo> list = setwebinfoMapper.selectByExample(null);
        if (list == null || list.size() == 0) {
            return Result.succee();
        }
        Setwebinfo setwebinfo = list.get(0);
        if (setwebinfo.getWeblogo() != null) {
            String filePath = fileinfoMapper.getFileFullPathByFileID(setwebinfo.getWeblogo());
            if (StringUtils.isNotBlank(filePath)) {
                filePath = aliyunOSSClientUtil.getUrl(filePath);
            }
            setwebinfo.setWebLogoPath(filePath);
        }
        if (setwebinfo.getWechatqrcode() != null) {
            String filePath = fileinfoMapper.getFileFullPathByFileID(setwebinfo.getWechatqrcode());
            if (StringUtils.isNotBlank(filePath)) {
                filePath = aliyunOSSClientUtil.getUrl(filePath);
            }
            setwebinfo.setWechatQRCodePath(filePath);
        }
        if (setwebinfo.getMobilelogo() != null) {
            String filePath = fileinfoMapper.getFileFullPathByFileID(setwebinfo.getMobilelogo());
            if (StringUtils.isNotBlank(filePath)) {
                filePath = aliyunOSSClientUtil.getUrl(filePath);
            }
            setwebinfo.setMobileLogoPath(filePath);
        }
        //关闭阿里云OSS连接
        aliyunOSSClientUtil.closeOSSClient();
        return Result.succee(setwebinfo);
    }

    @Override
    public List<Setcostomerserviceinfo> getCustomerServiceByUser(AccountInfo accountInfo, String AUTHORITY_CODE) {


        List<Setcostomerserviceinfo> CustomerServiceList = setcostomerserviceinfoMapper.selectByExample(null);// 查询客服设置信息
        return CustomerServiceList;
    }

    @Override
    public Result insertCustomerService(AccountInfo accountInfo, String AUTHORITY_CODE,
                                        Setcostomerserviceinfo setcostomerserviceinfo) throws MyException {
        //检查权限
        Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }
        // String start = setcostomerserviceinfo.getStart();
        // if (start != null) {
        // if (!start.equals(STUATS_MORENGTYPE) && !start.equals(STUATS_TYPE)) {
        // throw new MyException(ResultEnum.INSERT_SQL_ERROR);// 客服状态(0开启1关闭)
        // }
        // }
        //
        // String dialog = setcostomerserviceinfo.getDialog();
        // if (dialog != null) {
        // if (!dialog.equals(STUATS_MORENGTYPE) && !dialog.equals(STUATS_TYPE)) {
        // throw new MyException(ResultEnum.INSERT_SQL_ERROR);// 客服浮动框位置(0左边1右边)
        // }
        // }
        //
        // String site = setcostomerserviceinfo.getSite();
        // if (site != null) {
        // if (!site.equals(STUATS_MORENGTYPE) && !site.equals(STUATS_TYPE)) {
        // throw new MyException(ResultEnum.INSERT_SQL_ERROR);// 弹出邀请对话框(0开启1关闭)
        // }
        // }
        setcostomerserviceinfo.setCreatetime(new Date());
        setcostomerserviceinfo.setCreatepersonid(accountInfo.getAccount().getAccountid());
        setcostomerserviceinfo.setCreateby(accountInfo.getAccount().getCreateby());
        setcostomerserviceinfoMapper.insertSelective(setcostomerserviceinfo);

        // 插入数据库操作日志
        String log = "设置了客服信息 : [ ";
        // log += StringUtils.isBlank(start) ? "" : "客服状态=" + start + ",";
        log += "workTime=" + setcostomerserviceinfo.getWorktime() + ",";
        log += StringUtils.isBlank(setcostomerserviceinfo.getPosition1()) ? ""
                : "客服职务=" + setcostomerserviceinfo.getPosition1() + ",";
        log += StringUtils.isBlank(setcostomerserviceinfo.getQq1()) ? ""
                : "QQ号码=" + setcostomerserviceinfo.getQq1() + ",";
        log = log.substring(0, log.length() - 1) + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result updateCustomerService(AccountInfo accountInfo, String AUTHORITY_CODE,
                                        Setcostomerserviceinfo setcostomerserviceinfo) throws MyException {
        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        if (StringUtils.isNotBlank(setcostomerserviceinfo.getStart()) && !Arrays.asList(STATUS).contains(setcostomerserviceinfo.getStart())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        if (StringUtils.isNotBlank(setcostomerserviceinfo.getDialog()) && !Arrays.asList(STATUS).contains(setcostomerserviceinfo.getDialog())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        if (StringUtils.isNotBlank(setcostomerserviceinfo.getSite()) && !Arrays.asList(STATUS).contains(setcostomerserviceinfo.getSite())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        // 查询原信息
        List<Setcostomerserviceinfo> setcostomerserviceinfoList = setcostomerserviceinfoMapper.selectByExample(null);
        if (setcostomerserviceinfoList.size() != 0) {
            Setcostomerserviceinfo old_setcostomerserviceinfo = setcostomerserviceinfoList
                    .get(setcostomerserviceinfoList.size() - 1);// 最新一组数据为当前设置信息
            setcostomerserviceinfo.setUpdatepersonid(accountInfo.getAccount().getAccountid());
            setcostomerserviceinfo.setUpdatetime(new Date());
            setcostomerserviceinfo.setUpdateby(accountInfo.getAccount().getCreateby());
            setcostomerserviceinfo.setSetcostomerserviceinfoid(old_setcostomerserviceinfo.getSetcostomerserviceinfoid());
        }

        int i = setcostomerserviceinfoMapper.updateByPrimaryKeySelective(setcostomerserviceinfo);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }

        // 插入数据库操作日志
        String log = "设置了客服信息 : [ ";
        log += StringUtils.isBlank(setcostomerserviceinfo.getStart()) ? "" : "客服状态=" + (setcostomerserviceinfo.getStart() == "1" ? "开" : "关") + ",";
        log += "workTime=" + setcostomerserviceinfo.getWorktime() + ",";
        log += StringUtils.isBlank(setcostomerserviceinfo.getPosition1()) ? "" : "客服职务=" + setcostomerserviceinfo.getPosition1() + ",";
        log += StringUtils.isBlank(setcostomerserviceinfo.getQq1()) ? "" : "QQ号码=" + setcostomerserviceinfo.getQq1() + ",";
        log = log.substring(0, log.length() - 1) + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }


    /**
     * 检测参数格式
     *
     * @param siteinfo
     * @return
     */
    private Result checkParam(Setwebinfo siteinfo) {
        //网站网站
        if (StringUtils.isNotBlank(siteinfo.getUrl()) && !RegexUtils.checkURL(siteinfo.getUrl())) {
            return Result.build(ResultEnum.URL_FORMAT_ERROR);
        }
        //联系电话
        if (StringUtils.isNotBlank(siteinfo.getPhone()) && (!RegexUtils.checkPhone(siteinfo.getPhone()) && !RegexUtils.checkMobile(siteinfo.getPhone()))) {
            return Result.build(ResultEnum.PHONE_ERROR);
        }
        //移动电话
        if (StringUtils.isNotBlank(siteinfo.getMobilephone()) && !RegexUtils.checkMobile(siteinfo.getMobilephone())) {
            return Result.build(ResultEnum.MOBILE_PHONE_ERROR);
        }
        //传真
        if (StringUtils.isNotBlank(siteinfo.getFax()) && !RegexUtils.checkFax(siteinfo.getFax())) {
            return Result.build(ResultEnum.FAX_FORMAT_ERROR);
        }
        //邮箱
        if (StringUtils.isNotBlank(siteinfo.getMail()) && !RegexUtils.checkEmail(siteinfo.getMail())) {
            return Result.build(ResultEnum.EMAIL_ERROR);
        }
        //邮政编码
        if (StringUtils.isNotBlank(siteinfo.getPostalcode()) && !RegexUtils.checkPostcode(siteinfo.getPostalcode())) {
            return Result.build(ResultEnum.EMAIL_ERROR);
        }
        //手机版开关
        if (StringUtils.isNotBlank(siteinfo.getStart()) && !Arrays.asList(STATUS).contains(siteinfo.getStart())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        return Result.succee();
    }

    /**
     * 获取网站设置id
     *
     * @return
     */
    private Integer getWebsetinfoid() {
        List<Setwebinfo> list = setwebinfoMapper.selectByExample(null);
        return list.get(0).getWebsetinfoid();
    }

}
