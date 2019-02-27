package com.jy.dao.function.person.memberFunction;

import com.jy.entiy.function.person.memberFunction.Complaintapplication;
import com.jy.entiy.function.person.memberFunction.ComplaintapplicationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComplaintapplicationMapper {
    int countByExample(ComplaintapplicationExample example);

    int deleteByExample(ComplaintapplicationExample example);

    int deleteByPrimaryKey(Long complaintapplicationid);

    int insert(Complaintapplication record);

    int insertSelective(Complaintapplication record);

    List<Complaintapplication> selectByExample(ComplaintapplicationExample example);

    Complaintapplication selectByPrimaryKey(Long complaintapplicationid);

    int updateByExampleSelective(@Param("record") Complaintapplication record, @Param("example") ComplaintapplicationExample example);

    int updateByExample(@Param("record") Complaintapplication record, @Param("example") ComplaintapplicationExample example);

    int updateByPrimaryKeySelective(Complaintapplication record);

    int updateByPrimaryKey(Complaintapplication record);

    List<Complaintapplication> selectComplaintList(
            @Param("applicationstatusname")String applicationstatusname,
            @Param("complainttime")String complainttime,//投诉时间
            @Param("personSearch") String personSearch,
            @Param("targetSearch") String targetSearch,
            @Param("startSize") Integer startSize,
            @Param("pageSize") Integer pageSize);

    int selectCountComplaintList(
            @Param("applicationstatusname")String applicationstatusname,
            @Param("complainttime")String complainttime,//投诉时间
            @Param("personSearch") String personSearch,
            @Param("targetSearch") String targetSearch
    );
}