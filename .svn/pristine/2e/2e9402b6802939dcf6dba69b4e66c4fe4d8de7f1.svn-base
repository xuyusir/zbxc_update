package com.jy.dao.function.enterprise.enterpriseFunction;


import com.jy.entiy.function.enterprise.enterpriseFunction.Accountenterprise;
import com.jy.entiy.function.enterprise.enterpriseFunction.AccountenterpriseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountenterpriseMapper {
    int countByExample(AccountenterpriseExample example);

    int deleteByExample(AccountenterpriseExample example);

    int deleteByPrimaryKey(Long accountenterpriseid);

    int insert(Accountenterprise record);

    int insertSelective(Accountenterprise record);

    List<Accountenterprise> selectByExample(AccountenterpriseExample example);

    Accountenterprise selectByPrimaryKey(Long accountenterpriseid);

    int updateByExampleSelective(@Param("record") Accountenterprise record, @Param("example") AccountenterpriseExample example);

    int updateByExample(@Param("record") Accountenterprise record, @Param("example") AccountenterpriseExample example);

    int updateByPrimaryKeySelective(Accountenterprise record);

    int updateByPrimaryKey(Accountenterprise record);
    
    /**
     * 查询企业ID
     * @param account_id
     * @return
     */
	Integer getEnterpriseIDByAccountID(@Param("account_id") Long account_id);
}