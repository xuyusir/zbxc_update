package com.jy.dao.function.enterprise.recruitment;

import com.jy.entiy.function.enterprise.recruitment.Enterpriserecruitingprocess;
import com.jy.entiy.function.enterprise.recruitment.EnterpriserecruitingprocessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EnterpriserecruitingprocessMapper {
    int countByExample(EnterpriserecruitingprocessExample example);

    int deleteByExample(EnterpriserecruitingprocessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Enterpriserecruitingprocess record);

    int insertSelective(Enterpriserecruitingprocess record);

    List<Enterpriserecruitingprocess> selectByExample(EnterpriserecruitingprocessExample example);

    Enterpriserecruitingprocess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Enterpriserecruitingprocess record, @Param("example") EnterpriserecruitingprocessExample example);

    int updateByExample(@Param("record") Enterpriserecruitingprocess record, @Param("example") EnterpriserecruitingprocessExample example);

    int updateByPrimaryKeySelective(Enterpriserecruitingprocess record);

    int updateByPrimaryKey(Enterpriserecruitingprocess record);

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/8 17:39
     * 描述 : 查询企业简历投递列表
     * @param enterpriseID 企业ID
     * @param jobID 职位ID
     * @param search 关键词:投递人姓名,学校,手机
     * @param status 简历投递状态
     * @return
     */
    List<Map<String, Object>> getPersonDeliveryApplicationListByEnterprise(@Param("enterpriseID")Integer enterpriseID, @Param("jobID")Integer jobID, @Param("search")String search, @Param("status")Integer status);

    /**
     *作者: cheng fei
     * 创建日期: 2018/11/12 17:12
     * 描述 : 查询企业职位申请人数总数
     * @param jobID 职位ID
     * @param personDeliveryStatusIDList 招聘流程状态ID列表
     * @return
     */
    int getPersonDeliveryApplicationCountByPersonDeliveryStatusIDList(@Param("jobID")Integer jobID, @Param("personDeliveryStatusIDList")List<Integer> personDeliveryStatusIDList);

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/15 0:01
     * 描述 : 获取企业已投递的简历ID列表
     *
     * @param enterpriseID
     * @return
     */
    List<Long> getAccountIDList(@Param("enterpriseID")Integer enterpriseID);

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/4 13:55
     * 描述 : 查询已评价的投递ID列表
     *
     * @param enterpriseID
     * @return
     */
    List<Integer> getHasHiredIDList(@Param("enterpriseID")Integer enterpriseID);
}
