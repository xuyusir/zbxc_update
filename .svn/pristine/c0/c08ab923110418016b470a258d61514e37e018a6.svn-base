package com.jy.service.function.enterprise.enterpriseFunction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.LiuUtils;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.AccountenterpriseMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.DownloadcountMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.TalentpoolMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.TalentpoolapplicationMapper;
import com.jy.dao.function.enterprise.info.EnterpriseinfoMapper;
import com.jy.dao.function.enterprise.recruitment.EnterpriserecruitingprocessMapper;
import com.jy.dao.function.person.resume.ResumeinfoMapper;
import com.jy.dao.system.select.ApplicationstatusMapper;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.enterpriseFunction.*;
import com.jy.entiy.function.enterprise.info.Enterpriseinfo;
import com.jy.service.function.enterprise.base.BaseEnterpriseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class TalentPoolServiceImpl extends BaseEnterpriseService implements TalentPoolService {

    /**
     * 数据库操作日志
     */
    private static final String DB_LOG_TYPE = "DB_LOG_TALENT_POOL";

    /**
     * 人才库状态:
     * 0.未开启
     * 1.申请中
     * 2.已开启
     */
    private static final String[] TALENT_POOL_STATUS = {"N", "P", "Y"};

    /**
     * 排序参数允许的范围
     * 0.绩点排序
     * 1.更新时间排序
     */
    private static final Integer[] ORDER_PARAMS = {1, 2};


    @Resource
    AccountenterpriseMapper accountenterpriseMapper;

    @Resource
    EnterpriseinfoMapper enterpriseinfoMapper;

    @Resource
    TalentpoolapplicationMapper talentpoolapplicationMapper;

    @Resource
    ResumeinfoMapper resumeinfoMapper;

    @Resource
    AccountMapper accountMapper;

    @Resource
    DownloadcountMapper downloadcountMapper;

    @Resource
    TalentpoolMapper talentpoolMapper;

    @Resource
    ApplicationstatusMapper applicationstatusMapper;

    @Resource
    private EnterpriserecruitingprocessMapper enterpriserecruitingprocessMapper;

    @Override
    public Result insertApplicationServer(AccountInfo accountinfo) throws MyException {

        //检测账号类型
        if (!this.checkIsEnterpriseAccount(accountinfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        //查询企业信息表主键
        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountinfo.getAccount().getAccountid());

        //新增申请信息
        Talentpoolapplication talentpoolapplication = new Talentpoolapplication();
        talentpoolapplication.setApplicationstatusid(1);
        talentpoolapplication.setAccountid(accountinfo.getAccount().getAccountid());
        talentpoolapplication.setApplcationdate(new Date());
        talentpoolapplication.setCreateby(accountinfo.getAccount().getName());
        talentpoolapplication.setCreatepersonid(accountinfo.getAccount().getAccountid());
        talentpoolapplication.setCreatetime(new Date());
        talentpoolapplication.setServiceno(LiuUtils.getServeIdByUUId());
        talentpoolapplication.setEnterpriseid(enterpriseID);
        talentpoolapplication.setApplicationservicetype(1);
        talentpoolapplication.setIsbrowseagreement(TALENT_POOL_STATUS[1]);

        //查询申请表是否有申请成功记录
        TalentpoolapplicationExample example = new TalentpoolapplicationExample();
        TalentpoolapplicationExample.Criteria criteria = example.createCriteria();
        criteria.andEnterpriseidEqualTo(enterpriseID);
        criteria.andApplicationstatusidEqualTo(2);
        criteria.andIsbrowseagreementEqualTo(TALENT_POOL_STATUS[2]);
        int count = talentpoolapplicationMapper.countByExample(example);
        if (count == 0) {
            //无申请成功记录,添加申请
            int i = talentpoolapplicationMapper.insertSelective(talentpoolapplication);
            if (i < 1) {
                return Result.build(ResultEnum.INSERT_SQL_ERROR);
            }

            //数据库操作日志
            Enterpriseinfo enterpriseinfo = enterpriseinfoMapper.selectByPrimaryKey(enterpriseID);
            String log = "[ " + enterpriseinfo.getEnterprisename() + " ]企业申请了人才库简历查看权限";
            this.dbLog(accountinfo.getAccount().getAccountid(), accountinfo.getAccount().getName(), log, DB_LOG_TYPE);
        }
        //有申请成功记录,人才库查看权限只需要申请一次,申请后成功后不需要再次申请,直接返回成功

        return Result.succee();
    }

    @Override
    public Result server(AccountInfo accountInfo) {
        Talentpoolapplication lastDownLoadApplication = talentpoolapplicationMapper.getLastDownLoadApplication(accountInfo.getAccount().getAccountid());
        if (lastDownLoadApplication == null){
            return Result.succee(TALENT_POOL_STATUS[0]);
        }else {
            return Result.succee(lastDownLoadApplication.getIsbrowseagreement());
        }
    }

    @Override
    public Result server(AccountInfo accountInfo, String cityCode, String search, Integer order, Integer pageNumber, Integer pageCount) {

        //检测账号类型
        if (!checkIsEnterpriseAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        //检测参数类型
        if (!Arrays.asList(ORDER_PARAMS).contains(order)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        cityCode = StringUtils.isBlank(cityCode) ? null : cityCode;

        search = this.checkSearch(search);

        //人才库是否开启
        Result result = server(accountInfo);
        if (!result.getData().toString().equals(TALENT_POOL_STATUS[2])) {
            return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
        }
        //查询已投递的简历ID列表
        //获取企业ID
        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());
        //获取投递简历账号列表
//        List<Long> accountIDList = enterpriserecruitingprocessMapper.getAccountIDList(enterpriseID);

        //分页
        PageHelper.startPage(pageNumber, pageCount);

//        List<Map<String,Object>> list = resumeinfoMapper.getResume(cityCode, search, order, accountIDList);
        List<Map<String, Object>> list = resumeinfoMapper.getResume(cityCode, search, order);

        PageInfo<Map<String, Object>> info = new PageInfo<>(list);

        Map<String, Object> r = new HashMap<>(2);

        List<Map<String, Object>> data = info.getList();
        for (Map<String, Object> row : data) {
            int count = talentpoolMapper.getCountByEnterpriseIDAndAccountID(enterpriseID, (Long) row.get("AccountID"));
            row.put("isDown", count >= 1);
            if (row.get("FilePath") != null && StringUtils.isNotBlank(row.get("FilePath").toString())) {
                row.put("FilePath", aliyunOSSClientUtil.getUrl(row.get("FilePath").toString()));
            }
        }
        aliyunOSSClientUtil.closeOSSClient();
        r.put("rows", data);
        r.put("count", info.getTotal());
        return Result.succee(r);
    }

    @Override
    public Result updateServer(AccountInfo accountInfo, Long AccountID) throws MyException {

        //检测账号类型
        if (!this.checkIsEnterpriseAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        //检测下载权限
        Result result = checkResumeDown(accountInfo);
        Map<String, Object> map = (Map<String, Object>) result.getData();
        if (!TALENT_POOL_STATUS[2].equals(map.get("status"))) {
            return Result.build(ResultEnum.NOT_TALENT_POOL_DOWN_AUTHORITY);
        }

        Account account = accountMapper.selectByPrimaryKey(AccountID);

        //判断的当前简历是否已下载
        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());
        int count = talentpoolMapper.getCountByEnterpriseIDAndAccountID(enterpriseID, AccountID);

        //已下载返回成功
        if (count > 0) {
            return Result.succee(account);
        }

        //修改人才库下载次数
        DownloadcountExample downloadcountExample = new DownloadcountExample();
        DownloadcountExample.Criteria downLoadCountExampleCriteria = downloadcountExample.createCriteria();
        downLoadCountExampleCriteria.andEnterpriseidEqualTo(enterpriseID);
        Downloadcount downloadcount = new Downloadcount();
        downloadcount.setResidue(Integer.parseInt(map.get("countDown").toString()));

        int i = downloadcountMapper.updateByExampleSelective(downloadcount, downloadcountExample);
        if (i < 0) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }


        Long resumeID = resumeinfoMapper.getResumeIDByAccountID(AccountID);

        //将简历添加到已下载
        Talentpool talentpool = new Talentpool();
        talentpool.setEnterpriseid(enterpriseID);
        talentpool.setAccountid(AccountID);
        talentpool.setResumeid(resumeID);
        i = talentpoolMapper.insertSelective(talentpool);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }
        return Result.succee(account);
    }

    @Override
    public Result down(AccountInfo accountInfo, String cityCode, String search, Integer order, Integer pageNumber, Integer pageCount) {

        //检测账号类型
        if (!this.checkIsEnterpriseAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        //检测参数
        cityCode = StringUtils.isBlank(cityCode) ? null : cityCode;
        search = this.checkSearch(search);
        if (!Arrays.asList(ORDER_PARAMS).contains(order)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());

        //分页
        PageHelper.startPage(pageNumber, pageCount);

        //查询
        List<Map<String, Object>> list = talentpoolMapper.getDownList(enterpriseID, cityCode, search, order);

        PageInfo<Map<String, Object>> info = new PageInfo<>(list);

        Map<String, Object> r = new HashMap<>(2);

        List<Map<String, Object>> data = info.getList();

        for (Map<String, Object> row : data) {
            if (row.get("FilePath") != null && StringUtils.isNotBlank(row.get("FilePath").toString())) {
                row.put("FilePath", aliyunOSSClientUtil.getUrl(row.get("FilePath").toString()));
            }
        }

        aliyunOSSClientUtil.closeOSSClient();
        r.put("rows", data);
        r.put("count", info.getTotal());
        return Result.succee(r);
    }

    @Override
    public Result resumeCount(AccountInfo accountInfo) {

        //检测账号类型
        if (!checkIsEnterpriseAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        //查询企业ID
        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());
        //查询已投递的简历列表
//        List<Long> accountIDList = enterpriserecruitingprocessMapper.getAccountIDList(enterpriseID);
        //查询所有简历总数
//        Integer allCount = resumeinfoMapper.getResumeCountByAll(accountIDList);
        Integer allCount = resumeinfoMapper.getResumeCountByAll();

        //查询已下载的简历总数
        TalentpoolExample example = new TalentpoolExample();
        TalentpoolExample.Criteria criteria = example.createCriteria();
        criteria.andEnterpriseidEqualTo(enterpriseID);
        int count = talentpoolMapper.countByExample(example);

        Map<String, Object> map = new HashMap<>(2);
        map.put("all", allCount);
        map.put("down", count);
        return Result.succee(map);
    }

    @Override
    public Result checkResumeDown(AccountInfo accountInfo) throws MyException {

        //检测是否是企业账号
        if (!checkIsEnterpriseAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        HashMap<String, Object> map = new HashMap<>(2);

        Talentpoolapplication lastDownLoadApplication = talentpoolapplicationMapper.getLastDownLoadApplication(accountInfo.getAccount().getAccountid());
        if (lastDownLoadApplication == null || lastDownLoadApplication.getApplicationservicetype() == 1) {
            map.put("status", TALENT_POOL_STATUS[0]);
            return Result.succee(map);
        }

        String status = StringUtils.isBlank(lastDownLoadApplication.getIsdownloadagreement()) ? TALENT_POOL_STATUS[0] : lastDownLoadApplication.getIsdownloadagreement();
        map.put("status", status);
        if (TALENT_POOL_STATUS[2].equals(status)) {
            //可下载简历,查询剩余下载次数
            Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());
            DownloadcountExample example1 = new DownloadcountExample();
            DownloadcountExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andEnterpriseidEqualTo(enterpriseID);
            List<Downloadcount> list1 = downloadcountMapper.selectByExample(example1);
            if (list1 == null || list1.size() == 0) {
                throw new MyException(ResultEnum.DB_ERROR);
            }
            if (list1.get(0).getResidue() == 0){
                //无下载次数时,返回无下载权限
                map.put("status", TALENT_POOL_STATUS[0]);
            }
            map.put("countDown", list1.get(0).getResidue());
        }
        return Result.succee(map);
    }

    @Override
    public Result updateServerDown(AccountInfo accountinfo) throws MyException {

        //检测账号
        if (!this.checkIsEnterpriseAccount(accountinfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountinfo.getAccount().getAccountid());

        //查询上一次下载申请
        Talentpoolapplication lastTalentPoolApplication = talentpoolapplicationMapper.getLastDownLoadApplication(accountinfo.getAccount().getAccountid());

        //判断是否有人才库查看权限
        if (lastTalentPoolApplication == null || !TALENT_POOL_STATUS[2].equals(lastTalentPoolApplication.getIsbrowseagreement())) {
            //无人才库查看权限
            return Result.build(ResultEnum.TALENTPOOL_NOT_SELECT_AUTHORITY);
        }

        //有人才库有查看权限
        if (lastTalentPoolApplication.getApplicationservicetype() == 2 && TALENT_POOL_STATUS[2].equals(lastTalentPoolApplication.getIsdownloadagreement())) {
            //上次申请为人才库下载权限,并且以通过
            //查询人才库下载次数
            DownloadcountExample example = new DownloadcountExample();
            DownloadcountExample.Criteria criteria = example.createCriteria();
            criteria.andEnterpriseidEqualTo(enterpriseID);
            List<Downloadcount> list = downloadcountMapper.selectByExample(example);
            if (list == null || list.size() == 0) {
                throw new MyException(ResultEnum.DB_ERROR);
            } else {
                //判断是否拥有下载次数
                if (list.get(0).getResidue() > 0) {
                    //有下载次数,返回成功
                    return Result.succee();
                }
            }
        }else if (lastTalentPoolApplication.getApplicationservicetype() == 2 && TALENT_POOL_STATUS[1].equals(lastTalentPoolApplication.getIsdownloadagreement())){
            //已申请,未处理,返回成功
            return Result.succee();
        }
        //次申请为人才库下载权限,并且以通过,且无下载次数,或上次申请为人才库查询权限或上次申请人才库下载权限已被拒绝,添加申请

        Talentpoolapplication talentpoolapplication = new Talentpoolapplication();
        talentpoolapplication.setApplicationstatusid(1);
        talentpoolapplication.setAccountid(accountinfo.getAccount().getAccountid());
        talentpoolapplication.setApplcationdate(new Date());
        talentpoolapplication.setCreateby(accountinfo.getAccount().getName());
        talentpoolapplication.setCreatepersonid(accountinfo.getAccount().getAccountid());
        talentpoolapplication.setCreatetime(new Date());
        talentpoolapplication.setServiceno(LiuUtils.getServeIdByUUId());
        talentpoolapplication.setEnterpriseid(enterpriseID);
        talentpoolapplication.setApplicationservicetype(2);
        talentpoolapplication.setIsbrowseagreement(TALENT_POOL_STATUS[2]);
        talentpoolapplication.setIsdownloadagreement(TALENT_POOL_STATUS[1]);

        int i = talentpoolapplicationMapper.insertSelective(talentpoolapplication);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }
        Enterpriseinfo enterpriseinfo = enterpriseinfoMapper.selectByPrimaryKey(enterpriseID);
        //数据库操作日志
        String log = "[ " + enterpriseinfo.getEnterprisename() + " ]企业申请了人才库简历下载权限";
        this.dbLog(accountinfo.getAccount().getAccountid(), accountinfo.getAccount().getName(), log, DB_LOG_TYPE);
        return Result.succee();
    }
}
