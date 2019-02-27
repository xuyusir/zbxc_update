package com.jy.dao.function.enterprise.enterpriseFunction;

import com.jy.entiy.function.enterprise.enterpriseFunction.Talentpoolapplication;
import com.jy.entiy.function.enterprise.enterpriseFunction.TalentpoolapplicationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TalentpoolapplicationMapper {
    int countByExample(TalentpoolapplicationExample example);

    int deleteByExample(TalentpoolapplicationExample example);

    int deleteByPrimaryKey(Integer talentpoolapplicationid);

    int insert(Talentpoolapplication record);

    int insertSelective(Talentpoolapplication record);

    List<Talentpoolapplication> selectByExample(TalentpoolapplicationExample example);

    Talentpoolapplication selectByPrimaryKey(Integer talentpoolapplicationid);

    int updateByExampleSelective(@Param("record") Talentpoolapplication record, @Param("example") TalentpoolapplicationExample example);

    int updateByExample(@Param("record") Talentpoolapplication record, @Param("example") TalentpoolapplicationExample example);

    int updateByPrimaryKeySelective(Talentpoolapplication record);

    int updateByPrimaryKey(Talentpoolapplication record);

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/15 15:51
     * 描述 : 查询人才库上一次权限申请
     *
     * @param accountID
     * @return
     */
    Talentpoolapplication getLastDownLoadApplication(@Param("accountID")Long accountID);
}
