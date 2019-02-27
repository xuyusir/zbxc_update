package com.jy.controller.content.file.question_bank;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.AliyunOSSClientUtil;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.service.content.file.question_bank.InterviewQuestionBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName:  InterviewQuestionBankController
 * @Description:面经题库接口
 * @author: cheng fei
 * @date:   2018-09-21 15:28
 */
@Controller
@RequestMapping("/content/file/question/bank/file")
@Api(tags = "content.file.question_bank.InterviewQuestionBankController",description = "内容-文件-面经题库-面经题库模块")
public class InterviewQuestionBankController extends BaseController{

	@Resource
	private InterviewQuestionBankService interviewQuestionBankService;

	@Resource
	private AliyunOSSClientUtil aliyunOSSClientUtil;

	@ApiOperation(value = "上传面经题库资料", httpMethod = "POST", produces = "application/json")
	@RequestMapping("/upload")
	@ResponseBody
	public Result uploadInterviewQuestionBank(
			@ApiParam(value = "要上传的文件", required = true) @RequestParam MultipartFile uploadFile,
			@ApiParam(value = "所属公司ID", required = false) @RequestParam(required = false) Integer company_id
			) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		return interviewQuestionBankService.insertInterviewQuestionBank(accountInfo, AuthorityCode.CONTENT_INTERVIEW_UPLOAD_AUTHORITY, uploadFile,company_id);
	}

	@ApiOperation(value = "查询文件列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getFileList(
			@ApiParam(value = "面经题库公司ID") @RequestParam(required = true) Integer company_id,
			@ApiParam("关键词") @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam("页码") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam("每页条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return interviewQuestionBankService.getInterviewQuestionBankList(accountInfo, company_id,search, page, pageSize);
	}

	@ApiOperation(value = "修改文件名称接口", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateFileName(
			@ApiParam(value = "文件ID", required = true) @RequestParam(required = true) Long fileID,
			@ApiParam(value = "文件名称", required = true) @RequestParam(required = true) String fileName
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return interviewQuestionBankService.updateFileName(accountInfo,AuthorityCode.CONTENT_INTERVIEW_UPDATE_AUTHORITY ,fileID,fileName);
	}

	@ApiOperation(value = "删除文件", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "",  method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteInterviewQuestionBank(
			@ApiParam("要删除的文件id列表,用,隔开") @RequestParam(required = true) String ids
			) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		return interviewQuestionBankService.deleteInterviewQuestionBank(accountInfo,AuthorityCode.CONTENT_INTERVIEW_DELETE_AUTHORITY,ids);
	}

	@ApiOperation(value = "下载文件", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public Result downloadInterviewQuestionBank(
			@ApiParam(value = "要下载的文件id", required = true) @RequestParam Long interview_question_bank_id,
			@ApiParam(hidden = true) HttpServletRequest request,
			@ApiParam(hidden = true) HttpServletResponse response
			) throws IOException {
        String token = request.getParameter("token");

        Result result = interviewQuestionBankService.getInterviewQuestionBankFile(interview_question_bank_id, token);
		Fileinfo fileinfo = (Fileinfo) result.getData();
		if (fileinfo == null) {
			return Result.build(ResultEnum.NOT_FIND_FILE);
		}

		//设置请求头
		response.setContentType("application/x-msdownload;");
		response.setHeader("Content-disposition", "attachment; filename=" + new String(fileinfo.getFilename().getBytes("utf-8"), "ISO8859-1"));
		response.setHeader("Content-Length", fileinfo.getFilesize());

        InputStream inputStream = aliyunOSSClientUtil.downLoadFile(fileinfo.getFilefullpath());

        ServletOutputStream outputStream = response.getOutputStream();
        byte [] data = new byte[1024 * 1024];
        int len = -1;
        while ((len = inputStream.read(data)) > -1) {
            outputStream.write(data, 0, len);
        }
		inputStream.close();
		outputStream.close();
		aliyunOSSClientUtil.closeOSSClient();
		return null;
	}

	@ApiOperation(value = "修改面经图库下载权限接口", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/download/authority",  method = RequestMethod.PUT)
	@ResponseBody
	private Result updateDownloadAuthority(
			@ApiParam(value = "面经题库下载权限:1任何人,2:已登录用户,3:会员", required = true) @RequestParam(required = true) Integer authority
	) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return interviewQuestionBankService.updateDownloadAuthority(accountInfo, AuthorityCode.CONTENT_INTERVIEW_DOWNLOAD_AUTHORITY, authority);
	}

    @ApiOperation(value = "查询面经图库下载权限接口", httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "/download/authority",  method = RequestMethod.GET)
    @ResponseBody
    private Result getDownloadAuthority() throws MyException {
        return interviewQuestionBankService.getDownloadAuthority();
    }

}
