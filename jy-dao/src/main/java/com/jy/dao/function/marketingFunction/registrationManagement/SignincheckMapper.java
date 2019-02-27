package com.jy.dao.function.marketingFunction.registrationManagement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.marketingFunction.registrationManagement.Signincheck;
import com.jy.entiy.function.marketingFunction.registrationManagement.SignincheckExample;

public interface SignincheckMapper {
    int countByExample(SignincheckExample example);

    int deleteByExample(SignincheckExample example);

    int deleteByPrimaryKey(Integer signincheckid);

    int insert(Signincheck record);

    int insertSelective(Signincheck record);

    List<Signincheck> selectByExample(SignincheckExample example);

    Signincheck selectByPrimaryKey(Integer signincheckid);

    int updateByExampleSelective(@Param("record") Signincheck record, @Param("example") SignincheckExample example);

    int updateByExample(@Param("record") Signincheck record, @Param("example") SignincheckExample example);

    int updateByPrimaryKeySelective(Signincheck record);

    int updateByPrimaryKey(Signincheck record);
    
    List<Signincheck> selectSignincheckList(
    		@Param("votestatusid")Integer votestatusid,//状态id
    		@Param("search") String search,
    		@Param("startSize") Integer startSize, 
    		@Param("pageSize") Integer pageSize);
    
    int selectCountSignincheckList(
    		@Param("votestatusid")Integer votestatusid,//状态id
    		@Param("search") String search);
}