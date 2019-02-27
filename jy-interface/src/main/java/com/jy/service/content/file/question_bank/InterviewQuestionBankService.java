package com.jy.service.content.file.question_bank;

import com.jy.entiy.account.account.Account;
import org.springframework.web.multipart.MultipartFile;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * @ClassName:  InterviewQuestionBankService   
 * @Description:面经题库接口
 * @author: cheng fei
 * @date:   2018-09-21 15:32
 */
public interface InterviewQuestionBankService {

	/**
	 * 上传面经题库文件
	 * @param accountInfo 当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param uploadFile 上传的文件
	 * @param company_id 所属公司ID
	 * @return
	 * @throws Exception 
	 */
	Result insertInterviewQuestionBank(AccountInfo accountInfo, String AUTHORITY_CODE, MultipartFile uploadFile, Integer company_id) throws Exception;

	/**
	 * 查询面经题库列表
	 * @param accountInfo 当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param company_id 所属公司ID
 	 * @param search 关键字
	 * @param page 页码
	 * @param pageSize 每页条数
	 * @return
	 * @throws MyException 
	 */
	Result getInterviewQuestionBankList(AccountInfo accountInfo , Integer company_id, String search, Integer page, Integer page_size) throws MyException;

	/**
	 * 获取页面按钮权限列表
	 * @param accountInfo 当前登陆人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param fileID 文件ID
	 * @param fileName 新名称
	 * @return
	 */
	Result updateFileName(AccountInfo accountInfo, String AUTHORITY_CODE, Long fileID, String fileName) throws MyException;

	/**
	 * 删除面经题库
	 * @param accountInfo 当前登录人员 
	 * @param AUTHORITY_CODE 权限编码
	 * @param ids 要删除的文件ID列表,用","隔开
	 * @return
	 * @throws MyException 
	 */
	Result deleteInterviewQuestionBank(AccountInfo accountInfo, String AUTHORITY_CODE, String ids) throws MyException;

	/**
	 * 查询面经题库文件
	 * @param interview_question_bank_id 面经题库表主键
	 * @param token 登陆token
	 * @return
	 */
	Result getInterviewQuestionBankFile(Long interview_question_bank_id, String token);

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/12/5 11:25
	 * 描述 : 修改面经题库下载权限
	 * @param accountInfo 当前登陆用户
	 * @param authorityCode 权限编码
	 * @param authority 面经题库下载权限:1任何人,2:已登录用户,3:会员
	 * @return
	 */
    Result updateDownloadAuthority(AccountInfo accountInfo, String authorityCode, Integer authority) throws MyException;

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/12/5 14:45
	 * 描述 : 查询面经题库下载权限
	 * @return
	 */
	Result getDownloadAuthority();
}
