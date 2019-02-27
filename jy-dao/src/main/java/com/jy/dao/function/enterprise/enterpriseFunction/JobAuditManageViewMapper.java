package com.jy.dao.function.enterprise.enterpriseFunction;

import com.jy.entiy.function.enterprise.enterpriseFunction.JobAuditManageView;
import com.jy.entiy.function.enterprise.enterpriseFunction.JobAuditManageViewExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobAuditManageViewMapper {
    int countByExample(JobAuditManageViewExample example);

    int deleteByExample(JobAuditManageViewExample example);

    int insert(JobAuditManageView record);

    int insertSelective(JobAuditManageView record);

    List<JobAuditManageView> selectByExample(JobAuditManageViewExample example);

    int updateByExampleSelective(@Param("record") JobAuditManageView record, @Param("example") JobAuditManageViewExample example);

    int updateByExample(@Param("record") JobAuditManageView record, @Param("example") JobAuditManageViewExample example);

    List<JobAuditManageView> selectJobApplicationList(
    		@Param("applicationstatusname")String applicationstatusname,
    		@Param("applicationtime") String applicationtime,//申请时间
    		@Param("search") String search,
    		@Param("startSize") Integer startSize,
    		@Param("pageSize") Integer pageSize);
    
    int selectCountJobApplicationList(
    		@Param("applicationstatusname")String applicationstatusname,
    		@Param("applicationtime") String applicationtime,
    		@Param("search") String search);
}