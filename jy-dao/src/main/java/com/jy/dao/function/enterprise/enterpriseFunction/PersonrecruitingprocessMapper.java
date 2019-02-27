package com.jy.dao.function.enterprise.enterpriseFunction;

import com.jy.entiy.function.enterprise.enterpriseFunction.Personrecruitingprocess;
import com.jy.entiy.function.enterprise.enterpriseFunction.PersonrecruitingprocessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonrecruitingprocessMapper {
    int countByExample(PersonrecruitingprocessExample example);

    int deleteByExample(PersonrecruitingprocessExample example);

    int deleteByPrimaryKey(Long personrecruitingprocessid);

    int insert(Personrecruitingprocess record);

    int insertSelective(Personrecruitingprocess record);

    List<Personrecruitingprocess> selectByExample(PersonrecruitingprocessExample example);

    Personrecruitingprocess selectByPrimaryKey(Long personrecruitingprocessid);

    int updateByExampleSelective(@Param("record") Personrecruitingprocess record, @Param("example") PersonrecruitingprocessExample example);

    int updateByExample(@Param("record") Personrecruitingprocess record, @Param("example") PersonrecruitingprocessExample example);

    int updateByPrimaryKeySelective(Personrecruitingprocess record);

    int updateByPrimaryKey(Personrecruitingprocess record);

    /**
     * 查询职位申请列表
     *
     * @param applicationStatus    申请状态
     * @param personDeliveryStatus 简历流程状态
     * @param applicationTime      申请时间
     * @param search               关键词: 企业名称/岗位名称/服务单号
     * @return
     */
    List<Map<String, Object>> getJobApplicationList(@Param("applicationStatus")Integer applicationStatus, @Param("personDeliveryStatus")Integer personDeliveryStatus, @Param("applicationTime")String applicationTime, @Param("search")String search);

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/12 19:44
     * 描述 : 查询个人投递申请
     *
     * @param applicationStatus 申请状态
     * @param isMember          是否是会员
     * @param applicationTime   模糊查询时间
     * @param search            关键词:姓名/岗位
     * @return
     */
    List<Map<String, Object>> getDeliveryApplicationList(@Param("applicationStatus")Integer applicationStatus, @Param("isMember")Integer isMember, @Param("applicationTime")String applicationTime, @Param("search")String search);


    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/4 16:35
     * 描述 : 查询企业招聘审核表最新数据ID
     *
     * @param accountID
     * @param jobID
     * @return
     */
    Long getLastDataID(@Param("accountID")Long accountID, @Param("jobID")Integer jobID);
}
