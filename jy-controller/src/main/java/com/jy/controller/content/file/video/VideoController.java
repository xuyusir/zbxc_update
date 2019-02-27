package com.jy.controller.content.file.video;

import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.service.content.file.file.FileService;
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
 * @ClassName: VideoController
 * @Description:视频库模块
 * @author: cheng fei
 * @date: 2018-09-12 09:59
 */

@Controller
@RequestMapping("/content/file/video")
@Api(tags = "content.file.VideoController", description = "内容-文件-视频库模块")
public class VideoController extends BaseController {

	@Resource
	private FileService fileService;

	@ApiOperation(value = "视频上传", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public Result uploadVideo(
			@ApiParam(value = "视频ID", required = true) @RequestParam String videoID,
			@ApiParam(value = "视频名称", required = true) @RequestParam String videoName,
			@ApiParam(value = "视频时长", required = true) @RequestParam Long videoTime

			) throws Exception {

		AccountInfo accountInfo = this.getAccountInfo();
		return fileService.insertVideo(accountInfo, videoID, videoName, videoTime);

	}

	@ApiOperation(value = "查询视频库文件月份列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/month/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getMonthList(
			@ApiParam(value = "文件夹ID", required = false) @RequestParam(required = false, defaultValue = "0") Long directory_id,
			@ApiParam("关键词") @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam("页码") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam("每页条数") @RequestParam(required = false, defaultValue = "9") Integer pageSize) {
		AccountInfo accountInfo = this.getAccountInfo();
		// type 0是图片,1是文件,2是视频,3是面经题库
		return fileService.getMonthList(accountInfo, 2, directory_id, search, page, pageSize);
	}

	@ApiOperation(value = "按月份查询视频列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getFileList(@ApiParam("月份") @RequestParam(required = true) String month,
			@ApiParam(value = "文件夹ID", required = false) @RequestParam(required = false, defaultValue = "0") Long directory_id,
			@ApiParam("关键词") @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam("页码") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam("每页条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		// type 0是图片,1是文件,2是视频,3是面经题库
		return fileService.getFileList(accountInfo, 2, month, directory_id, search, page, pageSize);
	}

	@ApiOperation(value = "修改视频", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateVideo(@ApiParam(value = "文件ID", required = true) @RequestParam(required = true) Long video_id,
			@ApiParam(value = "文件名", required = true) @RequestParam(required = true) String video_name)
			throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		Fileinfo fileinfo = new Fileinfo();
		fileinfo.setFileid(video_id);
		fileinfo.setFilename(video_name);
		return fileService.updateFiles(accountInfo, AuthorityCode.CONTENT_VIDEO_UPDATE_AUTHORITY, fileinfo);
	}

	@ApiOperation(value = "删除视频", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteVideo(
			@ApiParam(value = "要删除的图片id列表,用,隔开", required = true) @RequestParam(required = true) String ids)
			throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		return fileService.deleteFiles(accountInfo, AuthorityCode.CONTENT_VIDEO_DELETE_AUTHORITY, ids);
	}

	@ApiOperation(value = "获取视频播放地址", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/path", method = RequestMethod.GET)
	@ResponseBody
	public Result getVideoPath(
			@ApiParam(value = "视频ID", required = true) @RequestParam(required = true) String videoID
	)throws Exception {
        String videoUrl = aliyunOSSClientUtil.getVideoUrl(videoID);
        return Result.succee(videoUrl);
	}

	@ApiOperation(value = "获取视频上传地址和凭证", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/create/upload/video", method = RequestMethod.POST)
	@ResponseBody
	public Result createUploadVideo(
			@ApiParam(value = "视频标题", required = true) @RequestParam(required = true) String videoTitle,
			@ApiParam(value = "视频名称", required = true) @RequestParam(required = true) String videoName,
			@ApiParam(value = "视频分类ID", required = false) @RequestParam(required = false) Long cateId,
			@ApiParam(value = "视频模板组ID", required = false) @RequestParam(required = false) String templateGroupID

	) {
        CreateUploadVideoResponse uploadVideo = null;
        try {
            uploadVideo = aliyunOSSClientUtil.createUploadVideo(videoTitle, videoName, cateId, templateGroupID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.succee(uploadVideo);
	}

    @ApiOperation(value = "获取视频上传地址和凭证", httpMethod = "POST", produces = "application/json")
    @RequestMapping(value = "/refresh/upload/video", method = RequestMethod.POST)
    @ResponseBody
    public Result refreshUploadVideo(
            @ApiParam(value = "视频ID", required = true) @RequestParam(required = true) String videoID
    ) {
        RefreshUploadVideoResponse refreshUploadVideoResponse = null;
		try {
            refreshUploadVideoResponse = aliyunOSSClientUtil.refreshUploadVideo(videoID);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.succee(refreshUploadVideoResponse);
    }


	@ApiOperation(value = "获取视频播放凭证", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "play/auth", method = RequestMethod.POST)
	@ResponseBody
	public Result getVideoPlayAuth(
			@ApiParam(value = "视频ID", required = true) @RequestParam(required = true) String videoID
	) throws Exception {
		return Result.succee(aliyunOSSClientUtil.getVideoPlayAuth(videoID));
	}




}
