package com.jy.dao.function.enterprise.enterpriseFunction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.enterprise.enterpriseFunction.EnterpriseServiceApplicationView;
import com.jy.entiy.function.enterprise.enterpriseFunction.EnterpriseServiceApplicationViewExample;
import com.jy.entiy.function.enterprise.enterpriseFunction.JobAuditManageView;

public interface EnterpriseServiceApplicationViewMapper {
    int countByExample(EnterpriseServiceApplicationViewExample example);

    int deleteByExample(EnterpriseServiceApplicationViewExample example);

    int insert(EnterpriseServiceApplicationView record);

    int insertSelective(EnterpriseServiceApplicationView record);

    List<EnterpriseServiceApplicationView> selectByExample(EnterpriseServiceApplicationViewExample example);

    int updateByExampleSelective(@Param("record") EnterpriseServiceApplicationView record, @Param("example") EnterpriseServiceApplicationViewExample example);

    int updateByExample(@Param("record") EnterpriseServiceApplicationView record, @Param("example") EnterpriseServiceApplicationViewExample example);
    
    List<EnterpriseServiceApplicationView> selectEnterpriseApplicationList(
    		@Param("applicationstatusname")String applicationstatusname,
    		@Param("applcationdate") String applcationdate,//申请时间
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountEnterpriseApplicationList(
    		@Param("applicationstatusname")String applicationstatusname,
    		@Param("applcationdate") String applcationdate,
    		@Param("search") String search);
}