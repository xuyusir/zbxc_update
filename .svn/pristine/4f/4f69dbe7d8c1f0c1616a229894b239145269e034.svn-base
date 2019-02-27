package com.jy.controller.content.file.directory;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.file.directory.Documentdirectory;
import com.jy.service.content.file.directory.DocumentDirectoryService;
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
 * @ClassName:  DocumentDirectoryController
 * @Description:文件目录接口
 * @author: cheng fei
 * @date:   2018-09-11 09:04
 */

@Controller
@RequestMapping("/content/file/directory")
@Api(tags = "content.file.directory.DocumentDirectoryController", description = "内容-文件-文件目录-文件目录模块")
public class DocumentDirectoryController extends BaseController{


	@Resource
	private DocumentDirectoryService documentDirectoryService;

	@ApiOperation(value = "获取文件管理目录树", httpMethod = "GET", produces = "application/json" )
	@RequestMapping(value = "/file/tree", method = RequestMethod.GET)
	@ResponseBody
	public Result getFileDirectoryTree(
			@ApiParam(value = "父节点ID,1为图片库，2为视频资源库，3为文件资源库", required = true) @RequestParam(required = true) Long directory_id
			) {
        AccountInfo accountInfo = this.getAccountInfo();
        return documentDirectoryService.getFileDirectoryTree(accountInfo, directory_id);
	}

	@ApiOperation(value = "添加子文件夹(只能操作课程视频目录下的文件夹)", httpMethod = "POST", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertFileDirectory(
			@ApiParam(value = "父节点ID", required = true) @RequestParam(required = true) Long parent_id,
			@ApiParam(value = "文件夹名称", required = true) @RequestParam(required = true) String directory_name
			) throws Exception {
		AccountInfo accountInfo = getAccountInfo();
		Documentdirectory directory = new Documentdirectory();
		directory.setParentid(parent_id);
		directory.setDirectoryname(directory_name);
		return documentDirectoryService.insertDirectory(accountInfo, AuthorityCode.CONTENT_VIDEO_DIRECTORY_INSERT_AUTHORITY,directory);
	}

	@ApiOperation(value = "修改文件夹接口(只能操作课程视频目录下的文件夹)", httpMethod = "PUT", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateFileDirectory(
			@ApiParam(value = "文件夹ID", required = true) @RequestParam(required = true) Long directory_id,
			@ApiParam(value = "文件夹名称", required = true) @RequestParam(required = true) String directory_name
			) throws MyException {
		AccountInfo accountInfo = getAccountInfo();
		Documentdirectory directory = new Documentdirectory();
		directory.setDocumentdirectoryid(directory_id);
		directory.setDirectoryname(directory_name);
		return documentDirectoryService.updateDirectory(accountInfo, AuthorityCode.CONTENT_VIDEO_DIRECTORY_UPDATE_AUTHORITY,directory);
	}

	@ApiOperation(value = "删除文件夹接口(只能操作课程视频目录下的文件夹)", httpMethod = "DELETE", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteFileDirectory(
			@ApiParam(value = "文件夹ID", required = true) @RequestParam(required = true) Long directory_id
			) throws Exception {
		AccountInfo accountInfo = getAccountInfo();
		return documentDirectoryService.deleteFileDirectory(accountInfo, AuthorityCode.CONTENT_VIDEO_DIRECTORY_DELETE_AUTHORITY,directory_id);
	}


}
