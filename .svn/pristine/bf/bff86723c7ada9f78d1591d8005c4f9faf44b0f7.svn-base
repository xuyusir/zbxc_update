package com.jy.dao.function.person.memberFunction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.person.memberFunction.MemberServiceManageView;
import com.jy.entiy.function.person.memberFunction.MemberServiceManageViewExample;

public interface MemberServiceManageViewMapper {
    int countByExample(MemberServiceManageViewExample example);

    int deleteByExample(MemberServiceManageViewExample example);

    int insert(MemberServiceManageView record);

    int insertSelective(MemberServiceManageView record);

    List<MemberServiceManageView> selectByExample(MemberServiceManageViewExample example);

    int updateByExampleSelective(@Param("record") MemberServiceManageView record, @Param("example") MemberServiceManageViewExample example);

    int updateByExample(@Param("record") MemberServiceManageView record, @Param("example") MemberServiceManageViewExample example);
    

    List<MemberServiceManageView> selectMemberServiceList(
    		@Param("applicationstatusname")String applicationstatusname,
    		@Param("appointdate") String appointdate,//预约日期
    		@Param("applicationtime") String applicationtime,//申请日期
    		@Param("search") String search);
//    
//    int selectCountMemberService(
//    		@Param("applicationstatusname")String applicationstatusname,
//    		@Param("appointdate") String appointdate,//预约日期
//    		@Param("applicationtime") String applicationtime,
//    		@Param("search") String search);
    
}