package com.jy.service.function.enterprise.enterpriseFunction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.function.enterprise.enterpriseFunction.AccountenterpriseMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.EnterpriseappraiseMapper;
import com.jy.dao.function.enterprise.recruitment.EnterpriserecruitingprocessMapper;
import com.jy.dao.function.person.PersonexaminereportMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.function.enterprise.enterpriseFunction.Enterpriseappraise;
import com.jy.entiy.function.enterprise.enterpriseFunction.EnterpriseappraiseExample;
import com.jy.service.function.enterprise.base.BaseEnterpriseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AppreciationServiceImpl extends BaseEnterpriseService implements AppreciationService {

	/**
	 * 数据库操作日志类型
	 */
	private static final String DB_LOG_TYPE = "DB_LOG_APPRECIATION";

	private static final String [] IS_EVALUATE_PARAMS = {"Y", "N"};

	@Resource
	private AccountenterpriseMapper accountenterpriseMapper;

	@Resource
	private EnterpriseappraiseMapper enterpriseappraiseMapper;

	@Resource
    private PersonexaminereportMapper personexaminereportMapper;

	@Resource
    private EnterpriserecruitingprocessMapper enterpriserecruitingprocessMapper;

	@Override
	public Result getList(AccountInfo accountInfo, Integer jobID, String isEvaluate, String search, Integer pageNumber, Integer pageCount) {

		//检测账号类型
		if (!this.checkIsEnterpriseAccount(accountInfo.getAccount())){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}

		//检测参数
		if (StringUtils.isBlank(isEvaluate) || !Arrays.asList(IS_EVALUATE_PARAMS).contains(isEvaluate)){
			return  Result.build(ResultEnum.PARAMETER_ERROR);
		}
        jobID = jobID == null || jobID == 0 ? null : jobID;
		search = this.checkSearch(search);

        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());


        List<Map<String, Object>> list ;
        if (IS_EVALUATE_PARAMS[0].equals(isEvaluate)){
            //开始分页
		    PageHelper.startPage(pageNumber, pageCount);
        	//查询已评价列表
            list = enterpriseappraiseMapper.getHasHiredByAppraiseList(enterpriseID, jobID, search);

        }else {
        	//查询未评价列表
            //查询已评价的投递表ID列表
            List<Integer> ids = enterpriserecruitingprocessMapper.getHasHiredIDList(enterpriseID);

            ids = (ids == null ||ids.size() == 0) ? null : ids;

            //开始分页
            PageHelper.startPage(pageNumber, pageCount);
            list = enterpriseappraiseMapper.getHasHiredByNotAppraiseList(enterpriseID, jobID, ids, search);
		}

        PageInfo<Map<String, Object>> info = new PageInfo<>(list);
        List<Map<String, Object>> data = info.getList();

        //查询增值报告下载地址
        for (Map<String, Object> row : data) {
            Long accountID = (Long) row.get("AccountID");
            String FilePath = personexaminereportMapper.getFilePath(accountID);
            if (StringUtils.isNotBlank(FilePath)){
                FilePath = aliyunOSSClientUtil.getUrl(FilePath);
            }
            row.put("FilePath", FilePath);
        }
        aliyunOSSClientUtil.closeOSSClient();

        Map<Object, Object> map = new HashMap<>(2);
        map.put("rows",data );
        map.put("count", info.getTotal());

        return Result.succee(map);
	}

    @Override
    public Result getCount(AccountInfo accountInfo) {

	    //判断账号类型
        if (!this.checkIsEnterpriseAccount(accountInfo.getAccount())){
            return  Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());

        //查询已评价总数
        EnterpriseappraiseExample example = new EnterpriseappraiseExample();
        EnterpriseappraiseExample.Criteria criteria = example.createCriteria();
        criteria.andEnterpriseidEqualTo(enterpriseID);

        //查询已评价总数
        int isAppraise = enterpriseappraiseMapper.countByExample(example);

        //查询已评价的投递ID
        List<Integer> ids = enterpriserecruitingprocessMapper.getHasHiredIDList(enterpriseID);

        ids = (ids == null ||ids.size() == 0) ? null : ids;

        //查询未评价总数
        int notAppraise = enterpriseappraiseMapper.getHasHiredByNotAppraiseCount(enterpriseID, ids);

        HashMap<String, Integer> map = new HashMap<>(2);

        map.put("isAppraise", isAppraise);
        map.put("notAppraise", notAppraise);

        return Result.succee(map);
    }

    @Override
    public Result getAppreciationAllList(AccountInfo accountInfo, String search, String searchDate, Integer page, Integer pageSize) {

	    //判断账号类型
        Integer accountTypeManage = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_MANAGE);
        if (accountTypeManage.intValue() != accountInfo.getAccount().getDictionariesid()){
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        search = this.checkSearch(search);
        searchDate  = this.checkSearchTime(searchDate);

        //开始分页
        PageHelper.startPage(page, pageSize);
        List<Map<String, Object>> list = enterpriseappraiseMapper.getHasHiredByAppraiseListAll(search, searchDate);
        PageInfo<Map<String, Object>> info = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();
        map.put("rows", info.getList());
        map.put("count", info.getTotal());

        return Result.succee(map);
    }

    @Override
	public Result insertEnterpriseAppraise(AccountInfo accountInfo, Enterpriseappraise enterpriseappraise) throws MyException {

	    //判读账号类型
        if (!this.checkIsEnterpriseAccount(accountInfo.getAccount())){
            return  Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());
        enterpriseappraise.setEnterpriseid(enterpriseID);

        //查询是否有评价记录
        EnterpriseappraiseExample example = new EnterpriseappraiseExample();
        EnterpriseappraiseExample.Criteria criteria = example.createCriteria();
        criteria.andEjobvacancyidEqualTo(enterpriseappraise.getEjobvacancyid());
        criteria.andAccountidEqualTo(enterpriseappraise.getAccountid());
        List<Enterpriseappraise> list = enterpriseappraiseMapper.selectByExample(example);

        Date date = new Date();
        if (list == null || list.size() == 0){
            //无记录新增
            enterpriseappraise.setAppraisetime(date);
            enterpriseappraise.setCreateby(accountInfo.getAccount().getName());
            enterpriseappraise.setCreatepersonid(accountInfo.getAccount().getAccountid());
            enterpriseappraise.setCreatetime(date);

            int i = enterpriseappraiseMapper.insertSelective(enterpriseappraise);
            if (i < 1){
                throw new MyException(ResultEnum.INSERT_SQL_ERROR);
            }
        }else {
            //有记录修改
            Enterpriseappraise oldEnterpriseappraise = list.get(0);
            if (!oldEnterpriseappraise.getAppraisedetail().equals(enterpriseappraise.getAppraisedetail())){
                //新旧评价不一致
                enterpriseappraise.setAppraisetime(date);
                enterpriseappraise.setEnterpriseappraiseid(oldEnterpriseappraise.getEnterpriseappraiseid());
                enterpriseappraise.setUpdateby(accountInfo.getAccount().getName());
                enterpriseappraise.setUpdatepersonid(accountInfo.getAccount().getAccountid());
                enterpriseappraise.setCreatetime(date);

                int i = enterpriseappraiseMapper.updateByPrimaryKeySelective(enterpriseappraise);
                if(i < 1){
                    throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
                }
            }
        }
        return Result.succee();
    }
}
