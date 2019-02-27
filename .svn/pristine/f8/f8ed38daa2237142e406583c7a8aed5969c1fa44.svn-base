package com.jy.dao.function.enterprise.enterpriseFunction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.enterprise.enterpriseFunction.RecruitmentStatusProcessingView;
import com.jy.entiy.function.enterprise.enterpriseFunction.RecruitmentStatusProcessingViewExample;

public interface RecruitmentStatusProcessingViewMapper {
    int countByExample(RecruitmentStatusProcessingViewExample example);

    int deleteByExample(RecruitmentStatusProcessingViewExample example);

    int insert(RecruitmentStatusProcessingView record);

    int insertSelective(RecruitmentStatusProcessingView record);

    List<RecruitmentStatusProcessingView> selectByExample(RecruitmentStatusProcessingViewExample example);

    int updateByExampleSelective(@Param("record") RecruitmentStatusProcessingView record, @Param("example") RecruitmentStatusProcessingViewExample example);

    int updateByExample(@Param("record") RecruitmentStatusProcessingView record, @Param("example") RecruitmentStatusProcessingViewExample example);
    
    List<RecruitmentStatusProcessingView> selectRecruitmentStatusProcessingList(
    		@Param("applicationstatusname")String applicationstatusname,
    		@Param("deleiverystatusname")String deleiverystatusname,//操作类型
    		@Param("applicationtime") String applicationtime,//申请时间
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountRecruitmentStatusProcessingList(
    		@Param("applicationstatusname")String applicationstatusname,
    		@Param("deleiverystatusname")String deleiverystatusname,//操作类型
    		@Param("applicationtime") String applicationtime,//申请时间
    		@Param("search") String search);
}