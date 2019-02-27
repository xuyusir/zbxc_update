package com.jy.service.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.function.enterprise.enterpriseFunction.DownloadcountMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.EnterpriseServiceApplicationViewMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.TalentpoolapplicationMapper;
import com.jy.dao.system.select.PersonservicetypeMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.enterpriseFunction.Downloadcount;
import com.jy.entiy.function.enterprise.enterpriseFunction.DownloadcountExample;
import com.jy.entiy.function.enterprise.enterpriseFunction.DownloadcountExample.Criteria;
import com.jy.entiy.function.enterprise.enterpriseFunction.EnterpriseServiceApplicationView;
import com.jy.entiy.function.enterprise.enterpriseFunction.Talentpoolapplication;
import com.jy.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业服务申请实现类
 *
 * @author chenye
 *
 */
@Service
public class EnterpriseServiceApplicationServiceImpl extends BaseService
		implements EnterpriseServiceApplicationService {

	@Resource
	private EnterpriseServiceApplicationViewMapper enterpriseServiceApplicationViewMapper;
	@Resource
	private TalentpoolapplicationMapper talentpoolapplicationMapper;
	@Resource
	private DownloadcountMapper downloadcountMapper;

	@Resource
	private PersonservicetypeMapper personservicetypeMapper;

	// 同意服务申请
	private static final String AGREEMENT = "Y";

	// 不同意服务申请
	private static final String NOT_AGREEMENT = "N";

	// 简历查看
	private static final Integer SERVICE_TYPE1 = 1;

	// 简历下载
	private static final Integer SERVICE_TYPE2 = 2;

	@Override
	public Result processingEnterpriseService(AccountInfo accountInfo, String AUTHORITY_CODE,
			Integer talentpoolapplicationid, Integer applicationstatusid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}


		Talentpoolapplication talentpoolapplication = talentpoolapplicationMapper
				.selectByPrimaryKey(talentpoolapplicationid);
		if (talentpoolapplication.getApplicationservicetype() == SERVICE_TYPE1) {// 申请开启人才库,查看简历
			if (applicationstatusid == 2) {// 已处理
				talentpoolapplication.setIsbrowseagreement(AGREEMENT);
			}
			if (applicationstatusid == 3) {
				talentpoolapplication.setIsbrowseagreement(NOT_AGREEMENT);
			}
		}

		if (talentpoolapplication.getApplicationservicetype() == SERVICE_TYPE2) {// 申请下载简历
			if (applicationstatusid == 2) {// 已处理
				talentpoolapplication.setIsdownloadagreement(AGREEMENT);
				Integer enterpriseid = talentpoolapplication.getEnterpriseid();
				DownloadcountExample downloadcountExample = new DownloadcountExample();
				Criteria createCriteria = downloadcountExample.createCriteria();
				createCriteria.andEnterpriseidEqualTo(enterpriseid);
				List<Downloadcount> list = downloadcountMapper.selectByExample(downloadcountExample);
				int size = list.size();
				if (size > 1) {
					return Result.build(ResultEnum.SELECT_ERROR);
				}
				if (size == 1) {
					list.get(0).setResidue(100);
					downloadcountMapper.updateByPrimaryKeySelective(list.get(0));
				}
				if (size == 0) {
					Downloadcount downloadcount = new Downloadcount();
					downloadcount.setEnterpriseid(enterpriseid);
					downloadcount.setResidue(100);
					downloadcountMapper.insertSelective(downloadcount);
				}
			}
			if (applicationstatusid == 3) {
				talentpoolapplication.setIsdownloadagreement(NOT_AGREEMENT);
			}
		}

		talentpoolapplication.setApplicationstatusid(applicationstatusid);
		talentpoolapplication.setHandletime(new Date());
		talentpoolapplication.setUpdateby(accountInfo.getAccount().getName());
		talentpoolapplication.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		talentpoolapplication.setUpdatetime(new Date());
		int i = talentpoolapplicationMapper.updateByPrimaryKeySelective(talentpoolapplication);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		return Result.succee();
	}

	@Override
	public Result getEnterpriseServiceList(AccountInfo accountInfo, String AUTHORITY_CODE, String applicationstatusname,
			String search, String applcationdate, Integer page, Integer pageSize) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		// 处理参数
		search = this.checkSearch(search);
		applcationdate = this.checkSearchTime(applcationdate);
		List<EnterpriseServiceApplicationView> rows = enterpriseServiceApplicationViewMapper.selectEnterpriseApplicationList(
				applicationstatusname, applcationdate, search, (page - 1) * pageSize, pageSize);
		for (EnterpriseServiceApplicationView enterpriseServiceApplicationView : rows) {
			if(enterpriseServiceApplicationView.getApplicationservicetype() != null) {
				if(enterpriseServiceApplicationView.getApplicationservicetype() == 1) {
					enterpriseServiceApplicationView.setApplicationservicename("人才库服务");
				}else {
					enterpriseServiceApplicationView.setApplicationservicename("简历下载");
				}

			}
		}
		int count = enterpriseServiceApplicationViewMapper.selectCountEnterpriseApplicationList(applicationstatusname,
				applcationdate, search);
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

}
