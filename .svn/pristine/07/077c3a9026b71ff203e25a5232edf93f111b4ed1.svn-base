package com.jy.dao.function.enterprise.enterpriseFunction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.enterprise.enterpriseFunction.AppraisaManageView;

public interface AppraisaManageViewMapper {

    
    List<AppraisaManageView> selectAppraise(
    		@Param("inductiondate") String inductiondate,
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountAppraise(
    		@Param("inductiondate") String inductiondate,
    		@Param("search") String search);

}