package com.jy.dao.function.enterprise.enterpriseFunction;

import com.jy.entiy.function.enterprise.enterpriseFunction.Enterpriseappraise;
import com.jy.entiy.function.enterprise.enterpriseFunction.EnterpriseappraiseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EnterpriseappraiseMapper {
    int countByExample(EnterpriseappraiseExample example);

    int deleteByExample(EnterpriseappraiseExample example);

    int deleteByPrimaryKey(Long enterpriseappraiseid);

    int insert(Enterpriseappraise record);

    int insertSelective(Enterpriseappraise record);

    List<Enterpriseappraise> selectByExample(EnterpriseappraiseExample example);

    Enterpriseappraise selectByPrimaryKey(Long enterpriseappraiseid);

    int updateByExampleSelective(@Param("record") Enterpriseappraise record, @Param("example") EnterpriseappraiseExample example);

    int updateByExample(@Param("record") Enterpriseappraise record, @Param("example") EnterpriseappraiseExample example);

    int updateByPrimaryKeySelective(Enterpriseappraise record);

    int updateByPrimaryKey(Enterpriseappraise record);


    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/16 2:46
     * 描述 : 查询企业以招聘人员列表
     * @param enterpriseID 企业ID
     * @param jobID        职位ID
     * @param ids  需要排除的账号列表
     * @param search       关键词: 姓名/手机号/岗位
     * @return
     */
    List<Map<String, Object>> getHasHiredByNotAppraiseList(@Param("enterpriseID")Integer enterpriseID, @Param("jobID")Integer jobID, @Param("ids")List<Integer> ids, @Param("search")String search);

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/17 22:36
     * 描述 : 查询未评级总数
     *ids
     * @param enterpriseID
     * @param ids
     * @return
     */
    int getHasHiredByNotAppraiseCount(@Param("enterpriseID")Integer enterpriseID, @Param("ids")List<Integer> ids);

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/16 9:18
     * 描述 : 查询企业招聘已评价列表
     *
     * @param enterpriseID 企业ID
     * @param jobID        职位ID
     * @param search       关键词: 姓名/手机号/岗位
     * @return
     */
    List<Map<String, Object>> getHasHiredByAppraiseList(@Param("enterpriseID")Integer enterpriseID, @Param("jobID")Integer jobID, @Param("search")String search);


    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/20 16:34
     * 描述 : 查询所有已评价
     *
     * @param search     姓名
     * @param searchDate 评价时间
     * @return
     */
    List<Map<String, Object>> getHasHiredByAppraiseListAll(@Param("search")String search, @Param("searchDate")String searchDate);
}
