package com.jy.dao.function.person;

import com.jy.entiy.function.person.Persondeliveryapplication;
import com.jy.entiy.function.person.PersondeliveryapplicationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersondeliveryapplicationMapper {
    int countByExample(PersondeliveryapplicationExample example);

    int deleteByExample(PersondeliveryapplicationExample example);

    int deleteByPrimaryKey(Long pdapplciationid);

    int insert(Persondeliveryapplication record);

    int insertSelective(Persondeliveryapplication record);

    List<Persondeliveryapplication> selectByExample(PersondeliveryapplicationExample example);

    Persondeliveryapplication selectByPrimaryKey(Long pdapplciationid);

    int updateByExampleSelective(@Param("record") Persondeliveryapplication record, @Param("example") PersondeliveryapplicationExample example);

    int updateByExample(@Param("record") Persondeliveryapplication record, @Param("example") PersondeliveryapplicationExample example);

    int updateByPrimaryKeySelective(Persondeliveryapplication record);

    int updateByPrimaryKey(Persondeliveryapplication record);

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/21 10:53
     * 描述 : 查询投递列表
     *
     * @param accountID
     * @param personDeliveryStatusIDs
     * @return
     */
    List<Map<String, Object>> getDeliverList(@Param("accountID")Long accountID, @Param("personDeliveryStatusIDs")List<Integer> personDeliveryStatusIDs);
}
