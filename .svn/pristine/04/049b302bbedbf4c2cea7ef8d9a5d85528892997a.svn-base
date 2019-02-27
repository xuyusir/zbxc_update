package com.jy.dao.function.person.memberFunction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.person.memberFunction.ServiceAppointmentConfigurationView;
import com.jy.entiy.function.person.memberFunction.ServiceAppointmentConfigurationViewExample;

public interface ServiceAppointmentConfigurationViewMapper {
    int countByExample(ServiceAppointmentConfigurationViewExample example);

    int deleteByExample(ServiceAppointmentConfigurationViewExample example);

    int insert(ServiceAppointmentConfigurationView record);

    int insertSelective(ServiceAppointmentConfigurationView record);

    List<ServiceAppointmentConfigurationView> selectByExample(ServiceAppointmentConfigurationViewExample example);

    int updateByExampleSelective(@Param("record") ServiceAppointmentConfigurationView record, @Param("example") ServiceAppointmentConfigurationViewExample example);

    int updateByExample(@Param("record") ServiceAppointmentConfigurationView record, @Param("example") ServiceAppointmentConfigurationViewExample example);
    
    List<ServiceAppointmentConfigurationView> selectServiceAppointmentConfigurationList(
    		@Param("appointdate") String appointdate,//预约日期
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountServiceAppointmentConfigurationList(
    		@Param("appointdate") String appointdate,
    		@Param("search") String search);
    
    
    List<ServiceAppointmentConfigurationView> selectServiceAppointmentingList(
    		@Param("nowTimePhase") String nowTimePhase,//查询状态使用时间点
    		@Param("nowDate") String nowDate,//查询状态使用日期
    		@Param("appointdate") String appointdate,//预约日期
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountServiceAppointmentingList(
    		@Param("nowTimePhase") String nowTimePhase,//查询状态使用时间点
    		@Param("nowDate") String nowDate,//查询状态使用日期
    		@Param("appointdate") String appointdate,
    		@Param("search") String search);
    
    
    List<ServiceAppointmentConfigurationView> selectServiceAppointmentendList(
    		@Param("nowTimePhase") String nowTimePhase,//查询状态使用时间点
    		@Param("nowDate") String nowDate,//查询状态使用日期
    		@Param("appointdate") String appointdate,//预约日期
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountServiceAppointmentendList(
    		@Param("nowTimePhase") String nowTimePhase,//查询状态使用时间点
    		@Param("nowDate") String nowDate,//查询状态使用日期
    		@Param("appointdate") String appointdate,
    		@Param("search") String search);
}