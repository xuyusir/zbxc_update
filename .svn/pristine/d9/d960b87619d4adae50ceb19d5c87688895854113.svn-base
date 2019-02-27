package com.jy.dao.function.person;

import com.jy.entiy.function.person.Recruitmentprocesslog;
import com.jy.entiy.function.person.RecruitmentprocesslogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecruitmentprocesslogMapper {
    int countByExample(RecruitmentprocesslogExample example);

    int deleteByExample(RecruitmentprocesslogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Recruitmentprocesslog record);

    int insertSelective(Recruitmentprocesslog record);

    List<Recruitmentprocesslog> selectByExample(RecruitmentprocesslogExample example);

    Recruitmentprocesslog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Recruitmentprocesslog record, @Param("example") RecruitmentprocesslogExample example);

    int updateByExample(@Param("record") Recruitmentprocesslog record, @Param("example") RecruitmentprocesslogExample example);

    int updateByPrimaryKeySelective(Recruitmentprocesslog record);

    int updateByPrimaryKey(Recruitmentprocesslog record);

    /**
     * 查询当前最后一条日志记录
     *
     * @param accountID 账号ID
     * @param jobID     职位ID
     * @param applicationStatusID   审核状态
     * @return
     */
    Recruitmentprocesslog selectLastLog(@Param("accountID") Long accountID, @Param("jobID") Integer jobID, @Param("applicationStatusID")Integer applicationStatusID);

}
