package com.jy.service.function.enterprise.enterpriseFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.dao.function.enterprise.enterpriseFunction.AppraisaManageViewMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.enterpriseFunction.AppraisaManageView;
import com.jy.service.base.BaseService;

@Service
public class EnterpriseAppraiseServiceImpl extends BaseService implements EnterpriseAppraiseService {

	@Resource
	AppraisaManageViewMapper appraisaManageViewMapper;

	@Override
	public Result getAppraisalList(AccountInfo accountInfo, String AUTHORITY_CODE, String search, String inductiondate,
			Integer page, Integer pageSize) throws MyException {

		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		inductiondate = this.checkSearchTime(inductiondate);
		List<AppraisaManageView> rows = appraisaManageViewMapper.selectAppraise(inductiondate, search,
				(page - 1) * pageSize, pageSize);

		int count = appraisaManageViewMapper.selectCountAppraise(inductiondate, search);

		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);

		return Result.succee(map);
	}

}
