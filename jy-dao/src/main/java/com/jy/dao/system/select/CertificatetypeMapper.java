package com.jy.dao.system.select;

import com.jy.entiy.system.select.Certificatetype;
import com.jy.entiy.system.select.CertificatetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CertificatetypeMapper {
    int countByExample(CertificatetypeExample example);

    int deleteByExample(CertificatetypeExample example);

    int deleteByPrimaryKey(Integer certificatetypeid);

    int insert(Certificatetype record);

    int insertSelective(Certificatetype record);

    List<Certificatetype> selectByExample(CertificatetypeExample example);

    Certificatetype selectByPrimaryKey(Integer certificatetypeid);

    int updateByExampleSelective(@Param("record") Certificatetype record, @Param("example") CertificatetypeExample example);

    int updateByExample(@Param("record") Certificatetype record, @Param("example") CertificatetypeExample example);

    int updateByPrimaryKeySelective(Certificatetype record);

    int updateByPrimaryKey(Certificatetype record);
}