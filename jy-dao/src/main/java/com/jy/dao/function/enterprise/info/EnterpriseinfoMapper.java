package com.jy.dao.function.enterprise.info;

import com.jy.entiy.function.enterprise.info.Enterpriseinfo;
import com.jy.entiy.function.enterprise.info.EnterpriseinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnterpriseinfoMapper {
    int countByExample(EnterpriseinfoExample example);

    int deleteByExample(EnterpriseinfoExample example);

    int deleteByPrimaryKey(Integer enterpriseid);

    int insert(Enterpriseinfo record);

    int insertSelective(Enterpriseinfo record);

    List<Enterpriseinfo> selectByExample(EnterpriseinfoExample example);

    Enterpriseinfo selectByPrimaryKey(Integer enterpriseid);

    int updateByExampleSelective(@Param("record") Enterpriseinfo record, @Param("example") EnterpriseinfoExample example);

    int updateByExample(@Param("record") Enterpriseinfo record, @Param("example") EnterpriseinfoExample example);

    int updateByPrimaryKeySelective(Enterpriseinfo record);

    int updateByPrimaryKey(Enterpriseinfo record);

    String  getEnterpriseNameByAccountID(@Param("account_id") Long account_id);

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/2 15:34
     * 描述 : 查询企业列表
     *
     * @param search
     * @return
     */
    List<Enterpriseinfo> getEnterpriseList(@Param("search")String search);
}
