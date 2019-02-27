package com.jy.dao.function.person.memberFunction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.person.memberFunction.DeliverMannageView;

public interface DeliverMannageViewMapper {
    
    

    List<DeliverMannageView> selectDeliverList(
    		@Param("applicationstatusname")String applicationstatusname,
    		@Param("deliverydate") String deliverydate,//申请时间
    		@Param("search") String search,
    		@Param("ismember") Integer ismember,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountDeliver(
    		@Param("applicationstatusname")String applicationstatusname,
    		@Param("deliverydate") String deliverydate,//申请时间
    		@Param("search") String search,
    		@Param("ismember") Integer ismember);
    
    
}