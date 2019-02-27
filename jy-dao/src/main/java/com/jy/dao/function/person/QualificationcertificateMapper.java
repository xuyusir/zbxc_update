package com.jy.dao.function.person;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jy.entiy.function.person.Qualificationcertificate;
import com.jy.entiy.function.person.QualificationcertificateExample;

public interface QualificationcertificateMapper {
    int countByExample(QualificationcertificateExample example);

    int deleteByExample(QualificationcertificateExample example);

    int deleteByPrimaryKey(Integer qcid);

    int insert(Qualificationcertificate record);

    int insertSelective(Qualificationcertificate record);

    List<Qualificationcertificate> selectByExample(QualificationcertificateExample example);

    Qualificationcertificate selectByPrimaryKey(Integer qcid);

    int updateByExampleSelective(@Param("record") Qualificationcertificate record, @Param("example") QualificationcertificateExample example);

    int updateByExample(@Param("record") Qualificationcertificate record, @Param("example") QualificationcertificateExample example);

    int updateByPrimaryKeySelective(Qualificationcertificate record);

    int updateByPrimaryKey(Qualificationcertificate record);
}