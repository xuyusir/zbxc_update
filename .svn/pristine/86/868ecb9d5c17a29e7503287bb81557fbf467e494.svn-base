package com.jy.entiy.constant;

import java.lang.reflect.Field;

/**
 * 
 * @Description 配置表的配置表接口
 * @author manman
 * @date 2018年9月19日
 */
public class SelectConstant {
	
	public static final String SelectTable = "ID,Name";
	
	public static final String VedioType = "VedioTypeID,VedioTypeName";
	
	public static final String ApplicationStatus = "ApplicationStatusID,ApplicationStatusName";
	
	public static final String ArticleStatus = "ArticleStatusID,ArticleStatus";
	
	public static final String BusinessType = "BusinessTypeID,BusinessTypeName";
	
	public static final String CertificateType = "CertificateTypeID,CertificateTypeName";
	
	public static final String CompanyScale = "CompanyScaleID,CompanyPersonNumber";
	
	public static final String ContactStatus = "ContactStatusID,StatusName";
	
	public static final String CustomerTrackStatus = "CutomerTrackStatusID,TrackStatusName";
	
	public static final String DrawLotteryLevel = "DrawLotteryLevelID,DrawLotteryLevelName";
	
	public static final String EducationBackground = "EducationID,EducationLevel";
	
	public static final String IntentionType = "IntentionTypeID,IntentionName";
	
	public static final String JobProperty = "JobPropertyID,JobPropertyName";
	
	public static final String JobType = "JobTypeID,JobTypeName";
	
	public static final String LiveVedioStatus = "LiveVedioStatusID,LiveVeidoStatusName";
	
	public static final String LogPeriod = "LogPeriodID,LogPeriod";
	
	public static final String MarketingTrackType = "MarketingTrackTypeID,MarketingTrackTypeName";
	
	public static final String OrderStatus = "OrderStatusID,StatusName";
	
	public static final String PayStatus = "PayStatusID,PayStatusName";
	
	public static final String PayType = "PayTypeID,PayTypeName";
	
	public static final String PersonDeliveryStatus = "PDeliveryStatusID,DeleiveryStatusName";
	
	public static final String PersonReportType = "PersonReportTypeID,PReportTypeName";
	
	public static final String PersonServiceStatus = "PersonServiceStatusID,PSStatusName";
	
	public static final String PersonServiceType = "ServiceTypeID,ServiceTypeName";
	
	public static final String PersonType = "PersonTypeID,PersonTypeName";
	
	public static final String RecruitOrderDate = "RecruitOrderDateID,DateName";
	
	public static final String SalaryType = "SalaryTypeID,SalaryName";
	
	public static final String TaskStatus = "TaskStatusID,TaskStatusName";
	
	public static final String TrackPathType = "TrackPathTypeID,TrackPathTypeName";
	
	public static final String TrainingType = "TrainingTypeID,TrainingTypeName";
	
	public static final String VoteParticipantType = "VoteParticipantTypeID,VoteParticipantTypeName";
	
	public static final String VoteStatus = "VoteStatusID,VoteStatusName";
	
	public static final String VoteType = "VoteTypeID,VoteTypeName";
	
	public static final String AppointServiceTime = "AppointServiceTimeID,TimePhase";
	
	
	
	
	
	
	
	
	public static String[] getTableColumn(String tableName){
		try {
			SelectConstant selectConstant = new  SelectConstant();
			Class<SelectConstant> class1 = SelectConstant.class;
			Field field = class1.getField(tableName);
			Object object = field.get(selectConstant);
			return object.toString().split(",");
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
