package com.jy.service.function.enterprise.recruitment.rz;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * @Description :
 * @Author : cheng fei
 * @Date : 2018/11/10 17:15
 */
public interface InterviewRemarkService {
    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/10 18:34
     * 描述 : 添加面试备注
     * @param accountInfo 当前登陆账号
     * @param accountID 备注账号
     * @param jobID 备注职位
     * @param content 备注内容
     * @param type 备注类型:1.面试备注,2.录用-未入职备注
     * @return
     */
    Result insertInterviewRemark(AccountInfo accountInfo, long accountID, Integer jobID, String content, Integer type) throws MyException;

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/10 18:43
     * 描述 : 查询企业面试备注列表接口
     * @param accountInfo 当前登陆人员
     * @param accountID 备注账号ID
     * @param jobID 备注职位ID
     * @param type 备注类型:1.面试备注,2.录用-未入职备注
     * @param page 页码
     * @param pageSize 每页加载条数
     * @return
     */
    Result getInterviewRemarkList(AccountInfo accountInfo, long accountID, Integer jobID, Integer type, Integer page, Integer pageSize);
}
