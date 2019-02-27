package com.jy.controller.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.service.function.enterprise.enterpriseFunction.RecruitmentStatusProcessingService;
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
 * @ClassName: RecruitmentStatusProcessingController
 * @Description:招聘状态处理Controller
 * @author: chenye
 * @date: 2018-09-6 20:29
 */
@Controller
@RequestMapping("function/RecruitmentStatusProcessing")
@Api(tags = "RecruitmentStatusProcessingController", description = "企业功能-招聘状态处理")
public class RecruitmentStatusProcessingController extends BaseController {

    @Resource
    private RecruitmentStatusProcessingService recruitmentStatusProcessingService;

    @ApiOperation(value = "获取岗位招聘流程状态变更申请列表", httpMethod = "POST", produces = "application/json")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Result getJobApplicationList(
            @ApiParam(value = "申请状态:0全部,1.待处理,2.已处理,3.已拒绝", required = false) @RequestParam(required = false, defaultValue = "0") Integer applicationStatus,
            @ApiParam(value = "简历投递流程状态:0全部,2.主动投递-不合适,3.面试-进行中,4.面试-不合适,5.录用", required = false) @RequestParam(required = false, defaultValue = "0") Integer personDeliveryStatus,
            @ApiParam(value = "申请时间:模糊查询当天记录", required = false) @RequestParam(required = false, defaultValue = "") String applicationTime,
            @ApiParam(value = "关键词: 申请职位人姓名/电话", required = false) @RequestParam(required = false, defaultValue = "") String search,
            @ApiParam(value = "页码", required = false) @RequestParam(required = false, defaultValue = "1") Integer page,
            @ApiParam(value = "每页加载记录数", required = false) @RequestParam(required = false, defaultValue = "10") Integer pageSize)
            throws MyException {

        AccountInfo accountInfo = this.getAccountInfo();
        return recruitmentStatusProcessingService.getJobApplicationList(applicationStatus, personDeliveryStatus, applicationTime, search, page, pageSize);
    }

    @ApiOperation(value = "处理招聘状态申请", httpMethod = "PUT", produces = "application/json")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result processingRecruitmentStatus(
            @ApiParam(value = "处理招聘状态申请id列表,用,隔开", required = true) @RequestParam(required = true) String ids,
            @ApiParam(value = "申请状态:2.已处理,3.已拒绝", required = true) Integer applicationStatus,
            @ApiParam(value = "面试时间", required = false) @RequestParam(required = false) String interviewDate
    ) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return recruitmentStatusProcessingService.updateProcessingRecruitmentStatus(accountInfo, AuthorityCode.ENTERPRISE_FUNCTION_RECRUITMENT_STUAS_DISPOSE, ids, applicationStatus, interviewDate);
    }

}
