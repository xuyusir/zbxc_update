package com.jy.service.function.enterprise.base;

import com.jy.dao.function.enterprise.enterpriseFunction.AccountenterpriseMapper;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.function.enterprise.enterpriseFunction.Accountenterprise;
import com.jy.entiy.function.enterprise.enterpriseFunction.AccountenterpriseExample;
import com.jy.entiy.function.enterprise.enterpriseFunction.AccountenterpriseExample.Criteria;
import com.jy.service.base.BaseService;

import javax.annotation.Resource;
import java.util.List;

public class BaseEnterpriseService extends BaseService{
	
	@Resource
	private AccountenterpriseMapper accountenterpriseMapper;

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/6 12:56
     * 描述 : 检测账号是否是企业账号
     * @param account 账号
     * @return
     */
	protected boolean checkIsEnterpriseAccount(Account account){
        Integer accountTypeEnterprise = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE);
        if (account.getDictionariesid().intValue() == accountTypeEnterprise) {
            return true;
        }else {
            return false;
        }
    }

	/**
	 * 获取当前账号和企业的关联信息
	 * 
	 * @param account_id
	 * @return
	 */
	protected Accountenterprise getAccountenterpriseByAccountID(Long account_id) {
		AccountenterpriseExample example = new AccountenterpriseExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(account_id);
		List<Accountenterprise> list = accountenterpriseMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
}
