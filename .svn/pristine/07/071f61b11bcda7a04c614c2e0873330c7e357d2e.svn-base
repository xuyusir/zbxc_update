package com.jy.service.vedio;

import java.util.Map;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.vedio.Livevediolist;

/**
 * 视频管理业务逻辑层接口
 * 
 * @author liuhong
 * @date: 2018年8月24日 下午3:51:11
 * @Package: com.jy.service.vedio
 */
public interface VedioService {
	/**
	 * 课程章节绑定视频
	 * 
	 * @param accountInfo
	 * @param bind
	 * @return
	 */
	/*public Result bindVedio(AccountInfo accountInfo, Sectionvediobind bind, String CONTROLLER_CODE);

	*//**
	 * 修改视频绑定
	 * 
	 * @param accountInfo
	 * @param bind
	 * @param CONTROLLER_CODE
	 * @return
	 *//*
	public Result updateBindVedio(AccountInfo accountInfo, Sectionvediobind bind, String CONTROLLER_CODE);

	*//**
	 * 删除绑定信息
	 * 
	 * @param accountInfo
	 * @param bind
	 * @param CONTROLLER_CODE
	 * @return
	 *//*
	public Result deleteBindVedio(AccountInfo accountInfo, Sectionvediobind bind, String CONTROLLER_CODE);

	*//**
	 * 查询视频绑定信息
	 * 
	 * @param accountInfo
	 * @param bind
	 * @param CONTROLLER_CODE
	 * @return
	 *//*
	public Result getBindVedio(AccountInfo accountInfo, Sectionvediobind bind, String CONTROLLER_CODE);
*/
	/**
	 * 添加直播信息
	 * 
	 * @param accountInfo
	 * @param livevediolist
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result addLiveVedioList(AccountInfo accountInfo, Livevediolist livevediolist ) throws MyException;

	/**
	 * 修改直播信息
	 * 
	 * @param accountInfo
	 * @param livevediolist
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result updateLiveVedioList(AccountInfo accountInfo, Livevediolist livevediolist) throws MyException;

	/**
	 * 查询直播信息
	 * 
	 * @param param
	 * @return
	 */
	public Result getLiveVedioList(Map<String, Object> param);

	/**
	 * 删除直播信息
	 * 
	 * @param accountInfo
	 * @param LiveVedioListID
	 * @return
	 * @throws MyException 
	 */
	public Result deleteLiveVedioList(AccountInfo accountInfo, Long LiveVedioListID) throws MyException;

	/**
	 * 视频上传
	 * 
	 * @param accountInfo
	 * @param CONTROLLER_CODE
	 * @param uploadFile
	 * @return
	 * 
	 * 		public Result uploadVedio(AccountInfo accountInfo,String
	 *         CONTROLLER_CODE,MultipartFile uploadFile);
	 */
	/**
	 * 删除视频
	 * 
	 * @param accountInfo
	 * @param CONTROLLER_CODE
	 * @param VedioID
	 * @return
	 * 
	 * 		public Result deleteVedio(AccountInfo accountInfo,String
	 *         CONTROLLER_CODE,Long VedioID);
	 */
	/**
	 * 修改视频信息
	 * 
	 * @param accountInfo
	 * @param CONTROLLER_CODE
	 * @param vedioinfo
	 * @return
	 * 
	 * 		public Result updateVedio(AccountInfo accountInfo,String
	 *         CONTROLLER_CODE,Vedioinfo vedioinfo);
	 */
	/**
	 * 获取点播地址
	 
	public Result getVedio(AccountInfo accountInfo, Long VedioID);
	*/
	/**
	 * 获取视频基本信息
	 * 
	 * @param param
	 * @return
	 
	public Result getVedioinfo(Map<String, Object> param);
	*/
	/**
	 * 获取宣传视频URL（无需登录判断权限）
	 * 
	 * @return
	 
	public Result getPublicityVedio(Long VedioID);
	*/
}
