package com.jy.controller.function.person;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.JsonUtils;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.entiy.function.person.*;
import com.jy.entiy.function.person.resume.Resumeinfo;
import com.jy.service.function.person.ResumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 简历模块控制层
 *
 * @author liuhong
 * @date: 2018年8月29日 下午3:18:27
 * @Package: com.jy.controller.resume_controller
 */
@Api(tags = "function.person.ResumeController", description = "内容-个人-简历模块")
@Controller
@RequestMapping("/resume")
public class ResumeController extends BaseController {

    @Resource
    ResumeService resumeService;


	/*@RequestMapping(value = "/addResumeInfo", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加个人标准简历", httpMethod = "POST", produces = "application/json")
	public Result addResumeInfo(@ApiParam(value = "简历标题", required = false) String ResumeTitle,
			@ApiParam(value = "简历名字", required = true) String ResumeName,
			@ApiParam(value = "性别", required = true) String Sex,
			@ApiParam(value = "期望工作开始时间", required = true) String ExpectJobStartDate,
			@ApiParam(value = "期望工作结束时间", required = true) String ExpectJobEndDate,
			@ApiParam(value = "期望工作地点省(与另外两个对应，没有传-1)，多个格式：1,2,3...", required = false) String Province,
			@ApiParam(value = "期望工作地点市(与另外两个对应，没有传-1)，多个格式：1,2,3...", required = false) String City,
			@ApiParam(value = "期望工作地点县(与另外两个对应，没有传-1)，多个格式：1,2,3...", required = false) String County,
			@ApiParam(value = "年龄", required = true) Integer Age,
			@ApiParam(value = "目前居住地省", required = false) Integer liveProvince,
			@ApiParam(value = "目前居住地市", required = false) Integer liveCity,
			@ApiParam(value = "目前居住地县", required = false) Integer liveCounty,
			@ApiParam(value = "联系电话", required = true) String Phone,
			@ApiParam(value = "电子邮箱", required = true) String Email,
			@ApiParam(value = "所读大学", required = true) String University,
			@ApiParam(value = "专业", required = true) String Specialty,
			@ApiParam(value = "年级", required = true) String Grade,
			@ApiParam(value = "绩点", required = true) Double Score,
			@ApiParam(value = "学历ID", required = true) Integer EducationID,
			HttpServletRequest request) {

		Resumeinfo resumeinfo = new Resumeinfo();
		resumeinfo.setResumetitle(ResumeTitle);
		resumeinfo.setResumename(ResumeName);
		resumeinfo.setSex(Sex);
		if (ExpectJobStartDate!=null) {
			resumeinfo.setExpectjobstartdate(super.getDate(ExpectJobStartDate));
		}
		if (ExpectJobEndDate!=null) {
			resumeinfo.setExpectjobenddate(super.getDate(ExpectJobEndDate));
		}

		resumeinfo.setAge(Age);
		resumeinfo.setPhone(Phone);
		resumeinfo.setEmail(Email);
		resumeinfo.setUniversity(University);
		resumeinfo.setSpecialty(Specialty);
		resumeinfo.setGrade(Grade);
		resumeinfo.setScore(Score);

		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);

		Map<String, Object> param = new HashMap<>();
		param.put("Province", Province);
		param.put("City", City);
		param.put("County", County);
		param.put("liveProvince", liveProvince);
		param.put("liveCity", liveCity);
		param.put("liveCounty", liveCounty);
		return resumeService.addResumeInfo(resumeinfo, accountInfo,param);
	}*/

    @RequestMapping(value = "/updateResumeInfo", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "修改个人标准简历", httpMethod = "PUT", produces = "application/json")
    public Result updateResumeInfo(
            @ApiParam(value = "简历标题", required = false) String ResumeTitle,
            @ApiParam(value = "简历名字", required = false) String ResumeName,
            @ApiParam(value = "性别", required = false) String Sex,
            @ApiParam(value = "期望工作开始时间", required = false) String ExpectJobStartDate,
            @ApiParam(value = "期望工作结束时间", required = false) String ExpectJobEndDate,
            @ApiParam(value = "期望工作地点省(与另外两个对应，没有传-1)，多个格式：1,2,3...", required = false) String Province,
            @ApiParam(value = "期望工作地点市(与另外两个对应，没有传-1)，多个格式：1,2,3...", required = false) String City,
            @ApiParam(value = "期望工作地点县(与另外两个对应，没有传-1)，多个格式：1,2,3...", required = false) String County,
            @ApiParam(value = "出生年", required = false) Integer Year,
            @ApiParam(value = "出生月", required = false) Integer Month,
            @ApiParam(value = "目前居住地省", required = false) String liveProvince,
            @ApiParam(value = "目前居住地市", required = false) String liveCity,
            @ApiParam(value = "目前居住地县", required = false) String liveCounty,
            @ApiParam(value = "所读大学", required = false) String University,
            @ApiParam(value = "专业", required = false) String Specialty,
            @ApiParam(value = "年级", required = false) String Grade,
            @ApiParam(value = "绩点", required = false) Double Score,
            @ApiParam(value = "学历ID", required = false) Integer EducationID,
            @ApiParam(value = "头像ID", required = false) Long FileinfoID,
            HttpServletRequest request) throws MyException {

        Resumeinfo resumeinfo = new Resumeinfo();
        resumeinfo.setYear(Year);
        resumeinfo.setMonth(Month);
        resumeinfo.setEducationid(EducationID);
        resumeinfo.setResumetitle(ResumeTitle);
        resumeinfo.setResumename(ResumeName);
        resumeinfo.setSex(Sex);
        if (ExpectJobStartDate != null) {
            resumeinfo.setExpectjobstartdate(super.getDate(ExpectJobStartDate));
        }
        if (ExpectJobEndDate != null) {
            resumeinfo.setExpectjobenddate(super.getDate(ExpectJobEndDate));
        }
        resumeinfo.setUniversity(University);
        resumeinfo.setSpecialty(Specialty);
        resumeinfo.setGrade(Grade);
        resumeinfo.setScore(Score);

        Map<String, String> param = new HashMap<>();
        param.put("Province", Province);
        param.put("City", City);
        param.put("County", County);
        param.put("liveProvince", liveProvince);
        param.put("liveCity", liveCity);
        param.put("liveCounty", liveCounty);

        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);

        return resumeService.updateResumeInfo(resumeinfo, accountInfo, param, FileinfoID);
    }

    @RequestMapping(value = "/getResumeInfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据登录人信息查询个人标准简历", httpMethod = "GET", produces = "application/json")
    public Result getResumeInfo(
            @ApiParam(value = "投递状态ID", required = false) Long PDeliveryStatusID,
            @ApiParam(value = "分页查询页数", required = false) Integer pageNumber,
            @ApiParam(value = "分页查询每页条数", required = false) Integer pageCount,
            @ApiParam(value = "排序", required = false) String orderBy,
            @ApiParam(value = "被查询人ID", required = false) Long AccountID,
            @ApiParam(value = "是否是查询人才库简历", required = false) @RequestParam(required = false, defaultValue = "false") boolean isTalentPool,
            @ApiParam(hidden = true) HttpServletRequest request
    ) throws MyException {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        Map<String, Object> param = new HashMap<>();
        param.put("PDeliveryStatusID", PDeliveryStatusID);
        if (pageNumber != null) {
            param.put("start", (pageNumber - 1) * pageCount);
            param.put("end", pageCount);
        }
        param.put("AccountID", AccountID);

        return resumeService.getResumeInfo(accountInfo, param, isTalentPool);
    }

    /***************************** 实践经历 ******************************************/

    @RequestMapping(value = "/addPracticalExpirence", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "增加实践经历", httpMethod = "POST", produces = "application/json")
    public Result PracticalExpirence(@ApiParam(value = "实践标题", required = true) String PracticeTitle,
                                     @ApiParam(value = "实践开始日期", required = true) String PracticeStartDate,
                                     @ApiParam(value = "实践结束日期", required = true) String PracticeEndDate,
                                     @ApiParam(value = "实践活动中的角色", required = true) String PracticeRole,
                                     @ApiParam(value = "实践描述", required = true) String PracticeDescription, HttpServletRequest request) {
        Practicalexpirence practicalexpirence = new Practicalexpirence();
        practicalexpirence.setPracticetitle(PracticeTitle);
        if (PracticeStartDate != null) {
            practicalexpirence.setPracticestartdate(super.getDate(PracticeStartDate));
        }
        if (PracticeEndDate != null) {
            practicalexpirence.setPracticeenddate(super.getDate(PracticeEndDate));
        }

        practicalexpirence.setPracticerole(PracticeRole);
        practicalexpirence.setPracticedescription(PracticeDescription);
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.addPracticalExpirence(practicalexpirence, accountInfo);
    }

    @RequestMapping(value = "/updatePracticalExpirence", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "修改实践经历", httpMethod = "PUT", produces = "application/json")
    public Result updatePracticalExpirence(@ApiParam(value = "实践ID", required = true) Long PracticeID,
                                           @ApiParam(value = "实践标题", required = true) String PracticeTitle,
                                           @ApiParam(value = "实践开始日期", required = true) String PracticeStartDate,
                                           @ApiParam(value = "实践结束日期", required = true) String PracticeEndDate,
                                           @ApiParam(value = "实践活动中的角色", required = true) String PracticeRole,
                                           @ApiParam(value = "实践描述", required = true) String PracticeDescription, HttpServletRequest request) {
        Practicalexpirence practicalexpirence = new Practicalexpirence();
        practicalexpirence.setPracticeid(PracticeID);
        practicalexpirence.setPracticetitle(PracticeTitle);
        if (PracticeStartDate != null) {
            practicalexpirence.setPracticestartdate(super.getDate(PracticeStartDate));
        }
        if (PracticeEndDate != null) {
            practicalexpirence.setPracticeenddate(super.getDate(PracticeEndDate));
        }
        practicalexpirence.setPracticerole(PracticeRole);
        practicalexpirence.setPracticedescription(PracticeDescription);
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.updatePracticalExpirence(accountInfo, practicalexpirence);
    }

    @RequestMapping(value = "/getPracticalExpirence", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询实践经历", httpMethod = "GET", produces = "application/json")
    public Result getPracticalExpirence(
            @ApiParam(value = "简历ID", required = true) Long ResumeID,
            @ApiParam(value = "实践ID", required = false) Long PracticeID,
            @ApiParam(value = "是否是查询人才库简历", required = false) @RequestParam(required = false, defaultValue = "false") boolean isTalentPool,
            @ApiParam(hidden = false) HttpServletRequest request
    ) throws MyException {
        Practicalexpirence practicalexpirence = new Practicalexpirence();
        practicalexpirence.setPracticeid(PracticeID);
        practicalexpirence.setResumeid(ResumeID);
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.getPracticalExpirence(accountInfo, practicalexpirence, isTalentPool);
    }

    @RequestMapping(value = "/deletePracticalExpirence/{PracticeID}", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除实践经历", httpMethod = "DELETE", produces = "application/json")
    public Result deletePracticalExpirence(
            @PathVariable @ApiParam(value = "实践ID", required = true) Long PracticeID,
            HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.deletePracticalExpirence(accountInfo, PracticeID);
    }

    /*************************************
     * 工作经验增删改查
     **************************************************/
    @RequestMapping(value = "/addWorkExpirence", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加工作经验", httpMethod = "POST", produces = "application/json")
    public Result addWorkExpirence(@ApiParam(value = "公司规模表ID", required = true) Integer CompanyScaleID,
                                   @ApiParam(value = "标题", required = true) String WorkExpirenceTitle,
                                   @ApiParam(value = "所在公司", required = true) String Company,
                                   @ApiParam(value = "工作开始日期", required = true) String WorkStartDate,
                                   @ApiParam(value = "工作结束日期", required = true) String WorkEndDate,
                                   @ApiParam(value = "工作角色", required = true) String WorkRole,
                                   @ApiParam(value = "工作职责", required = true) String WorkResponsiblility,
                                   @ApiParam(value = "工作收获", required = true) String WorkAchievement, HttpServletRequest request) {
        Workexpirence workexpirence = new Workexpirence();
        workexpirence.setCompanyscaleid(CompanyScaleID);
        workexpirence.setWorkexpirencetitle(WorkExpirenceTitle);
        workexpirence.setCompany(Company);
        if (WorkStartDate != null) {
            workexpirence.setWorkstartdate(super.getDate(WorkStartDate + " 00:00:00"));
        }
        if (WorkEndDate != null) {
            workexpirence.setWorkenddate(super.getDate(WorkEndDate + " 00:00:00"));
        }
        workexpirence.setWorkrole(WorkRole);
        workexpirence.setWorkresponsiblility(WorkResponsiblility);
        workexpirence.setWorkachievement(WorkAchievement);

        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.addWorkExpirence(accountInfo, workexpirence);
    }

    @RequestMapping(value = "/updateWorkExpirence", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "修改工作经验", httpMethod = "PUT", produces = "application/json")
    public Result updateWorkExpirence(@ApiParam(value = "工作经验ID", required = true) Long WorkExpirenceID,
                                      @ApiParam(value = "公司规模表ID", required = true) Integer CompanyScaleID,
                                      @ApiParam(value = "标题", required = true) String WorkExpirenceTitle,
                                      @ApiParam(value = "所在公司", required = true) String Company,
                                      @ApiParam(value = "工作开始日期", required = true) String WorkStartDate,
                                      @ApiParam(value = "工作结束日期", required = true) String WorkEndDate,
                                      @ApiParam(value = "工作角色", required = true) String WorkRole,
                                      @ApiParam(value = "工作职责", required = true) String WorkResponsiblility,
                                      @ApiParam(value = "工作收获", required = true) String WorkAchievement, HttpServletRequest request) {
        Workexpirence workexpirence = new Workexpirence();
        workexpirence.setWorkexpirenceid(WorkExpirenceID);
        workexpirence.setCompanyscaleid(CompanyScaleID);
        workexpirence.setWorkexpirencetitle(WorkExpirenceTitle);
        workexpirence.setCompany(Company);
        if (WorkStartDate != null) {
            workexpirence.setWorkstartdate(super.getDate(WorkStartDate + " 00:00:00"));
        }
        if (WorkEndDate != null) {
            workexpirence.setWorkenddate(super.getDate(WorkEndDate + " 00:00:00"));
        }
        workexpirence.setWorkrole(WorkRole);
        workexpirence.setWorkresponsiblility(WorkResponsiblility);
        workexpirence.setWorkachievement(WorkAchievement);

        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.updateWorkExpirence(accountInfo, workexpirence);
    }

    @RequestMapping(value = "/getWorkExpirence", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询工作经验", httpMethod = "GET", produces = "application/json")
    public Result getWorkExpirence(
            @ApiParam(value = "工作经验ID", required = false) Long WorkExpirenceID,
            @ApiParam(value = "简历ID", required = true) Long ResumeID,
            @ApiParam(value = "是否是查询人才库简历", required = false) @RequestParam(required = false, defaultValue = "false") boolean isTalentPool,
            @ApiParam(hidden = true) HttpServletRequest request
    ) throws MyException {
        Workexpirence workexpirence = new Workexpirence();
        workexpirence.setWorkexpirenceid(WorkExpirenceID);
        workexpirence.setResumeid(ResumeID);
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.getWorkExpirence(accountInfo, workexpirence, isTalentPool);
    }

    @RequestMapping(value = "/deleteWorkExpirence", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除工作经验", httpMethod = "DELETE", produces = "application/json")
    public Result deleteWorkExpirence(@ApiParam(value = "工作经验ID", required = true) Long WorkExpirenceID,
                                      HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.deleteWorkExpirence(accountInfo, WorkExpirenceID);
    }

    /*****************************************
     * 证书部分
     ********************************************************/
    @RequestMapping(value = "/addQualificationCertificate", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加证书", httpMethod = "POST", produces = "application/json")
    public Result addQualificationCertificate(
            @ApiParam(value = "证书类型1职业资格证书2英文证书3计算机证书4获奖情况", required = true) Integer CertificateTypeID,
            @ApiParam(value = "证书标题", required = true) String QCTitle,
            @ApiParam(value = "是否通过考试(Y,N)", required = true) String IsTotalPass,
            @ApiParam(value = "通过科目", required = true) String PassedSubject,
            @ApiParam(value = "证书考试的分", required = true) Float Score,
            @ApiParam(value = "证书获得日期", required = true) String QCDate, HttpServletRequest request) {
        Qualificationcertificate qualificationcertificate = new Qualificationcertificate();
        qualificationcertificate.setCertificatetypeid(CertificateTypeID);
        qualificationcertificate.setQctitle(QCTitle);
        qualificationcertificate.setIstotalpass(IsTotalPass);
        qualificationcertificate.setPassedsubject(PassedSubject);
        qualificationcertificate.setScore(Score);
        if (QCDate != null) {
            qualificationcertificate.setQcdate(super.getDate(QCDate));
        }


        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.addQualificationCertificate(accountInfo, qualificationcertificate);
    }

    @RequestMapping(value = "/updateQualificationCertificate", method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "修改证书", httpMethod = "PUT", produces = "application/json")
    public Result updateQualificationCertificate(
            @ApiParam(value = "证书ID", required = true) Integer QCID,
            @ApiParam(value = "证书类型1职业资格证书2英文证书3计算机证书4获奖情况", required = true) Integer CertificateTypeID,
            @ApiParam(value = "证书标题", required = true) String QCTitle,
            @ApiParam(value = "是否通过考试(Y,N)", required = true) String IsTotalPass,
            @ApiParam(value = "通过科目", required = true) String PassedSubject,
            @ApiParam(value = "证书考试的分", required = true) Float Score,
            @ApiParam(value = "证书获得日期", required = true) String QCDate, HttpServletRequest request) {
        Qualificationcertificate qualificationcertificate = new Qualificationcertificate();
        qualificationcertificate.setQcid(QCID);
        qualificationcertificate.setCertificatetypeid(CertificateTypeID);
        qualificationcertificate.setQctitle(QCTitle);
        qualificationcertificate.setIstotalpass(IsTotalPass);
        qualificationcertificate.setPassedsubject(PassedSubject);
        qualificationcertificate.setScore(Score);
        if (QCDate != null) {
            qualificationcertificate.setQcdate(super.getDate(QCDate));
        }

        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.updateQualificationCertificate(accountInfo, qualificationcertificate);
    }

    @RequestMapping(value = "/getQualificationcertificate", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询证书", httpMethod = "GET", produces = "application/json")
    public Result getQualificationcertificate(
            @ApiParam(value = "简历ID", required = false) Long ResumeID,
            @ApiParam(value = "证书ID", required = false) Integer QCID,
            @ApiParam(value = "是否是查询人才库简历", required = false) @RequestParam(required = false, defaultValue = "false") boolean isTalentPool,
            @ApiParam(hidden = true) HttpServletRequest request) throws MyException {
        Qualificationcertificate qualificationcertificate = new Qualificationcertificate();
        qualificationcertificate.setQcid(QCID);
        qualificationcertificate.setResumeid(ResumeID);
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.getQualificationcertificate(accountInfo, qualificationcertificate, isTalentPool);
    }

    @RequestMapping(value = "/deleteQualificationcertificate", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除证书", httpMethod = "DELETE", produces = "application/json")
    public Result deleteQualificationcertificate(
            @ApiParam(value = "证书ID", required = true) Integer QCID,
            HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.deleteQualificationcertificate(accountInfo, QCID);
    }

    /**********************************
     * 个性简历
     * @throws MyException 
     ****************************************************/

    @RequestMapping(value = "/customresume", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "个性简历生成、修改（用户已拥有个性简历则修改，没有则生成）", httpMethod = "POST", produces = "application/json")
    public Result customresume(
            @ApiParam(value = "doc文档文件ID", required = false) Long DocFileID,
            @ApiParam(value = "视频文件ID", required = false) Long VedioFileID,
            HttpServletRequest request) throws MyException {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        Customresume customresume = new Customresume();
        customresume.setDocfileid(DocFileID);
        customresume.setVediofileid(VedioFileID);
        return resumeService.customresume(accountInfo, customresume);
    }

    @RequestMapping(value = "/customOther", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "个性简历新增其他类型文件", httpMethod = "POST", produces = "application/json")
    public Result customOther(
            @ApiParam(value = "文件位置信息ID", required = true) Long FileID,
            HttpServletRequest request) throws MyException {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.customOther(accountInfo, FileID);
    }

    @RequestMapping(value = "/customOther", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "个性简历删除其他类型文件", httpMethod = "DELETE", produces = "application/json")
    public Result customOther(
            HttpServletRequest request,
            @ApiParam(value = "文件位置信息ID", required = true) Long FileID
    ) throws MyException {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.customOther(FileID, accountInfo);
    }

    @RequestMapping(value = "/customresume", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "个性简历文件删除", httpMethod = "DELETE", produces = "application/json")
    public Result deleteResume(
            @ApiParam(value = "删除文件的ID", required = true) Long FileID,
            HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.deleteCustomresume(accountInfo, FileID);
    }

    @RequestMapping(value = "/customresume", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "个性简历查询", httpMethod = "GET", produces = "application/json")
    public Result getResumeDoc(
            @ApiParam(value = "被查询者ID", required = false) Long AccountID,
            @ApiParam(value = "是否是查询人才库简历", required = false) @RequestParam(required = false, defaultValue = "false") boolean isTalentPool,
            HttpServletRequest request) throws MyException {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.getCustomresume(AccountID, accountInfo, isTalentPool);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/downCustomresume", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "个性简历文件下载", httpMethod = "GET", produces = "application/json")
    public Result downCustomresume(
            @ApiParam(value = "被下载简历者ID", required = false) Long AccountID,
            @ApiParam(value = "文件ID", required = false) Long FileID,
            @ApiParam(value = "是否是人才库下载简历", required = false) @RequestParam(required = false, defaultValue = "false") boolean isTalentPool,
            HttpServletResponse response,
            HttpServletRequest request) throws IOException, MyException {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        Result result = resumeService.getCustomresume(AccountID, accountInfo, isTalentPool);
        if (result.getStatus() == 200) {
            List<Fileinfo> fileinfos = new ArrayList<>();
            Map<String, Object> map = (Map<String, Object>) result.getData();
            fileinfos.add((Fileinfo) map.get("doc"));
            fileinfos.add((Fileinfo) map.get("vedio"));
            fileinfos.addAll((List<Fileinfo>) map.get("others"));
            for (Fileinfo fileinfo : fileinfos) {
                if (fileinfo == null) {
                    continue;
                }
                if (fileinfo.getFileid().equals(FileID)) {
                    super.baseDownloadFile(response, FileID);
                }
            }

        }
        return null;
    }


    @RequestMapping(value = "upload/html/code", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "上传html代码接口", httpMethod = "POST", produces = "application/json")
    public Result uploadHtmlCode(
            @ApiParam(value = "简历账号ID", required = true) @RequestParam(required = true) Long accountID,
            @ApiParam(value = "HTML页面代码", required = true) @RequestParam(required = true) String htmlCode
    ) {
        return resumeService.uploadHtmlCode(accountID, htmlCode);
    }

    @RequestMapping(value = "/exportPDF", method = RequestMethod.GET)
    @ApiOperation(value = "标准简历PDF导出", httpMethod = "GET", produces = "application/json")
    public String exportPDF(
            @ApiParam(value = "简历所属账号ID", required = true) @RequestParam(required = true) Long accountID,
            @ApiParam(value = "", hidden = true) HttpServletResponse response
    ) throws Exception {

        AccountInfo accountInfo = this.getAccountInfo();

        Result result = resumeService.exportPDF(accountInfo, accountID);
        if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
            PrintWriter writer = response.getWriter();
            writer.write(JsonUtils.objectToJson(result));
        } else {
            File file = (File) result.getData();
            // 下载PDF
            // 获取输入流
            InputStream bis = new BufferedInputStream(new FileInputStream(file));
            String filename = file.getName();
            // 转码，免得文件名中文乱码
            filename = URLEncoder.encode(filename, "UTF-8");
            // 设置文件下载头
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            // 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while ((len = bis.read()) != -1) {
                out.write(len);
            }
            out.flush();

            //关闭流
            out.close();
            bis.close();
            // 下载完成，删除文件
            if (file.isFile() && file.exists()) {
                file.delete();
            }
            File file1 = new File(Constant.PDF_HTML_CODE_BASE_PATH + accountID + ".html");
            if (file1.isFile() && file1.exists()) {
                file1.delete();
            }
        }
        return null;
    }

    /****************************
     * 报告文件上传下载删除
     * @throws MyException
     *********************************************/

	/*@RequestMapping(value = "/PersonExamineReport", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "报告文件上传", httpMethod = "POST", produces = "application/json")
	public Result personExamineReport(
			@ApiParam(value = "报告类型ID", required = true) Integer PersonReportTypeID,
			@ApiParam(value = "报告文件位置ID", required = true) Long FileID,
			@ApiParam(value = "备操作人ID", required = true) Long AccountID,
			HttpServletRequest request) {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return resumeService.personExamineReport(accountInfo, FileID, PersonReportTypeID,AccountID);
	}*/

	/*@RequestMapping(value = "/deletePersonExamineReport/{PExamineReportID}", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "报告文件删除", httpMethod = "DELETE", produces = "application/json")
	public Result deletePersonExamineReport(
			@PathVariable @ApiParam(value = "报告ID", required = true) Long PExamineReportID,
			HttpServletRequest request) {

		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return resumeService.deletePersonExamineReport(accountInfo, PExamineReportID);
	}*/
    @RequestMapping(value = "/PersonExamineReport", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询报告", httpMethod = "GET", produces = "application/json")
    public Result getPersonExamineReport(
            @ApiParam(value = "被查询人的ID", required = false) Long AccountID,
            @ApiParam(value = "被查询报告的ID", required = false) Long PExamineReportID,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, MyException {

        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.getPersonExamineReport(accountInfo, AccountID, PExamineReportID);
    }

    @RequestMapping(value = "/downPersonExamineReport", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "报告下载", httpMethod = "GET", produces = "application/json")
    public Result downPersonExamineReport(
            @ApiParam(value = "被查询人的ID", required = false) Long AccountID,
            @ApiParam(value = "被下载报告的ID", required = false) Long PExamineReportID,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, MyException {

        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);

        Result result = resumeService.getPersonExamineReport(accountInfo, AccountID, PExamineReportID);
        if (result.getStatus() == 200) {
            Map<String, List<Personexaminereport>> map = (Map<String, List<Personexaminereport>>) result.getData();
            for (String string : map.keySet()) {
                Personexaminereport personexaminereport = (Personexaminereport) (map.get(string).get(0));

                super.baseDownloadFile(response, personexaminereport.getFileid());
            }

        }
        return null;
    }

    /************************************
     * 个人投递增删改查
     ******************************************************/
    /**
     * @RequestMapping(value = "/addDeliver", method = RequestMethod.POST)
     * @ResponseBody
     * @ApiOperation(value = "增加投递申请", httpMethod = "POST", produces =
     * "application/json") public Result addDeliver(
     * @ApiParam(value = "空缺职位ID", required = false) Integer EJobVacancyID,
     * @ApiParam(value = "备注", required = false) String Remark, HttpServletRequest
     * request) { AccountInfo accountInfo = (AccountInfo)
     * request.getAttribute(Constant.ACCOUNTINFO); return
     * resumeService.addDeliver(accountInfo,EJobVacancyID,Remark); }
     * @RequestMapping(value = "/updateDeliver", method = RequestMethod.POST)
     * @ResponseBody
     * @ApiOperation(value = "修改投递申请", httpMethod = "POST", produces =
     * "application/json") public Result updateDeliver(
     * @ApiParam(value = "投递申请处理结果ID（后台管理员对投递申请的处理）", required = false) Integer
     * ApplicationStatusID,
     * @ApiParam(value = "简历投递结果ID（不适合，面试....）", required = false) Integer
     * PDeliveryStatusID,
     * @ApiParam(value = "备注", required = false) String Remark,
     * @ApiParam(value = "投递申请ID", required = true) Long PDApplciationID,
     * HttpServletRequest request) { AccountInfo accountInfo =
     * (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
     * Map<String, Object> param = new HashMap<String, Object>();
     * param.put("ApplicationStatusID", ApplicationStatusID);
     * param.put("PDeliveryStatusID", PDeliveryStatusID);
     * param.put("Remark", Remark); param.put("PDApplciationID",
     * PDApplciationID);
     * <p>
     * return resumeService.updateDeliver(accountInfo,param); }
     **/

    @RequestMapping(value = "/getDeliver", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询我的投递申请", httpMethod = "GET", produces = "application/json")
    public Result getDeliver(
            @ApiParam(value = "投递结果:1.全部,2.投递成功,3.邀请面试,4.不合适,5.录用", required = false) @RequestParam(required = false) Integer PDeliveryStatusID,
            @ApiParam(value = "页码", required = true) Integer pageNumber,
            @ApiParam(value = "每页条数", required = true) Integer pageCount
    ) {
        AccountInfo accountInfo = this.getAccountInfo();
        return resumeService.getDeliver(accountInfo, pageCount, pageNumber, PDeliveryStatusID);
    }

    /****************************************
     * 我的服务类
     ***************************************************/

    @RequestMapping(value = "/getOfflineSignIn", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询线下签到情况", httpMethod = "GET", produces = "application/json")
    public Result getOfflineSignIn(HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.getOfflineSignIn(accountInfo);
    }

    @RequestMapping(value = "/getPersonServices", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询个人服务状态", httpMethod = "GET", produces = "application/json")
    public Result getPersonServices(HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);

        return resumeService.getPersonServices(accountInfo);
    }

    @RequestMapping(value = "/isPersonServices", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询是否正在申请服务", httpMethod = "GET", produces = "application/json")
    public Result isPersonServices(
            @ApiParam(value = "服务类型1简历修改2单面模拟3北森测评4群面模拟5线下课程6LCDL报考", required = true) Integer type,
            HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);

        return resumeService.isPersonServices(accountInfo, type);
    }

    @RequestMapping(value = "/applyUpdateResume", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "申请修改简历服务", httpMethod = "POST", produces = "application/json")
    public Result applyUpdateResume(
            HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.applyUpdateResume(accountInfo);
    }

    @RequestMapping(value = "/applyMockInterview", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "申请单面模拟服务", httpMethod = "POST", produces = "application/json")
    public Result applyMockInterview(HttpServletRequest request,

                                     @ApiParam(value = "预约服务ID", required = true) Long AppointServiceID

    ) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.applyMockInterview(accountInfo, AppointServiceID);
    }

    @RequestMapping(value = "/applyBeiSen", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "北森测评服务申请", httpMethod = "POST", produces = "application/json")
    public Result applyBeiSen(HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.applyBeiSen(accountInfo);
    }

    @RequestMapping(value = "/mockInterview", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "群面模拟服务申请", httpMethod = "POST", produces = "application/json")
    public Result mockInterview(HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.mockInterview(accountInfo);
    }

    @RequestMapping(value = "/offlineCourse", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "线下课程服务申请", httpMethod = "POST", produces = "application/json")
    public Result offlineCourse(HttpServletRequest request) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.offlineCourse(accountInfo);
    }


    @RequestMapping(value = "/icdlTEST", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "ICDL报考服务申请", httpMethod = "POST", produces = "application/json")
    public Result icdlTEST(HttpServletRequest request,
                           @ApiParam(value = "预约服务ID", required = true) Long AppointServiceID
    ) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.icdlTEST(accountInfo, AppointServiceID);
    }

    @RequestMapping(value = "/activateCourst", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "激活课程服务申请", httpMethod = "POST", produces = "application/json")
    public Result activateCourst(HttpServletRequest request,
                                 @ApiParam(value = "课程ID", required = true) Long CourseID
    ) {
        AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
        return resumeService.activateCourst(accountInfo, CourseID);
    }

    @RequestMapping(value = "/appointServiceConfig", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "查询预约服务", httpMethod = "POST", produces = "application/json")
    public Result activateCourst(HttpServletRequest request,
                                 @ApiParam(value = "服务类型", required = true) String type
    ) {
        return resumeService.appointServiceConfig(type);
    }
}
