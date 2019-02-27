package com.jy.controller.function.enterprise.recruitment.rz;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.service.function.enterprise.recruitment.rz.InterviewRemarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description : 企业面试备注接口
 * @Author : cheng fei
 * @Date : 2018/11/10 17:12
 */

@Controller
@RequestMapping("/function/interview/remark")
@Api(tags = "function.enterprise.recruitment.rz.InterviewRemarkController", description = "功能-企业端-企业招聘-企业面试备注模块")
public class InterviewRemarkController extends BaseController {

    @Resource
    private InterviewRemarkService interviewRemarkService;


    @ApiOperation(value = "添加面试备注接口", httpMethod = "POST", produces = "application/json")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result insertInterviewRemark(
            @ApiParam(value = "账号ID", required = true) @RequestParam(required = true) long accountID,
            @ApiParam(value = "职位ID", required = true) @RequestParam(required = true) Integer jobID,
            @ApiParam(value = "备注内容", required = true) @RequestParam(required = true) String content,
            @ApiParam(value = "备注类型:1.面试备注,2.录用未入职备注", required = true) @RequestParam(required = true) Integer type
    ) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return interviewRemarkService.insertInterviewRemark(accountInfo, accountID, jobID, content, type);
    }


    @ApiOperation(value = "加载面试备注列表接口", httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Result getInterviewRemarkList(
            @ApiParam(value = "账号ID", required = true) @RequestParam(required = true) long accountID,
            @ApiParam(value = "职位ID", required = true) @RequestParam(required = true) Integer jobID,
            @ApiParam(value = "备注类型:1.面试备注,2.录用未入职备注", required = true) @RequestParam(required = true) Integer type,
            @ApiParam(value = "页码", required = false) @RequestParam(required = false, defaultValue = "1") Integer page,
            @ApiParam(value = "每页加载条数", required = false) @RequestParam(required = false, defaultValue = "4") Integer pageSize
    ) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return interviewRemarkService.getInterviewRemarkList(accountInfo, accountID, jobID, type, page, pageSize);
    }



}
