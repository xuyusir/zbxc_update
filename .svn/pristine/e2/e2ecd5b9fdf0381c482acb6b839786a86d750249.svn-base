package com.jy.dao.function.enterprise.enterpriseFunction;

import com.jy.entiy.function.enterprise.enterpriseFunction.Enterprisejobdeployapplication;
import com.jy.entiy.function.enterprise.enterpriseFunction.EnterprisejobdeployapplicationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnterprisejobdeployapplicationMapper {
    int countByExample(EnterprisejobdeployapplicationExample example);

    int deleteByExample(EnterprisejobdeployapplicationExample example);

    int deleteByPrimaryKey(Integer ejdapplicationid);

    int insert(Enterprisejobdeployapplication record);

    int insertSelective(Enterprisejobdeployapplication record);

    List<Enterprisejobdeployapplication> selectByExample(EnterprisejobdeployapplicationExample example);

    Enterprisejobdeployapplication selectByPrimaryKey(Integer ejdapplicationid);

    int updateByExampleSelective(@Param("record") Enterprisejobdeployapplication record, @Param("example") EnterprisejobdeployapplicationExample example);

    int updateByExample(@Param("record") Enterprisejobdeployapplication record, @Param("example") EnterprisejobdeployapplicationExample example);

    int updateByPrimaryKeySelective(Enterprisejobdeployapplication record);

    int updateByPrimaryKey(Enterprisejobdeployapplication record);

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/7 11:32
     * 描述 : 获取职位审核状态
     *
     * @param jobID
     * @return
     */
    Integer getApplicationStatus(@Param("jobID")Integer jobID);
}