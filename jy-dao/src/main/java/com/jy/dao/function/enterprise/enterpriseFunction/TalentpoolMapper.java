package com.jy.dao.function.enterprise.enterpriseFunction;

import com.jy.entiy.function.enterprise.enterpriseFunction.Talentpool;
import com.jy.entiy.function.enterprise.enterpriseFunction.TalentpoolExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TalentpoolMapper {
    int countByExample(TalentpoolExample example);

    int deleteByExample(TalentpoolExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Talentpool record);

    int insertSelective(Talentpool record);

    List<Talentpool> selectByExample(TalentpoolExample example);

    Talentpool selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Talentpool record, @Param("example") TalentpoolExample example);

    int updateByExample(@Param("record") Talentpool record, @Param("example") TalentpoolExample example);

    int updateByPrimaryKeySelective(Talentpool record);

    int updateByPrimaryKey(Talentpool record);

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/15 18:50
     * 描述 : 查询已下载简历列表
     *
     * @param enterpriseID  企业信息ID
     * @param cityCode  期望工作城市编码
     * @param search    关键词:姓名/学校/电话
     * @param order     排序方式1.绩点,2.更新时间
     * @return
     */
    List<Map<String, Object>> getDownList(@Param("enterpriseID") Integer enterpriseID, @Param("cityCode")String cityCode, @Param("search")String search, @Param("order")Integer order);

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/16 2:04
     * 描述 : 查询总数
     *
     * @param enterpriseID 企业ID
     * @param accountID    账号ID
     * @return
     */
    int getCountByEnterpriseIDAndAccountID(@Param("enterpriseID")Integer enterpriseID, @Param("accountID")Long accountID);
}