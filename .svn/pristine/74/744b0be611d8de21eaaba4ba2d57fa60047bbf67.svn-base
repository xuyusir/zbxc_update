package com.jy.service.function.person.memberFunction;

import com.jy.common.exception.MyException;
import com.jy.common.redis.JedisClient;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.LiuUtils;
import com.jy.dao.function.person.memberFunction.ComplaintapplicationMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.function.person.memberFunction.Complaintapplication;
import com.jy.service.base.BaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComplaintApplicationServiceImpl extends BaseService implements ComplaintApplicationService {

	private static final String DB_LOG_TYPE = "DB_LOG_COMPLAINT_APPLICATION";

	@Resource
	private ComplaintapplicationMapper complaintapplicationMapper;

    @Resource
    private JedisClient jedisClient;

    @Value("${REDIS_PASSWORD}")
    private String REDIS_PASSWORD;

	@Override
	public Result processingComplaint(AccountInfo accountInfo, String AUTHORITY_CODE, Long complaintapplicationid,
			Integer applicationStatusID) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		
		//参数检查
		if(complaintapplicationid==null || applicationStatusID==null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		
		Complaintapplication complaintapplication = complaintapplicationMapper
				.selectByPrimaryKey(complaintapplicationid);
		complaintapplication.setHandletime(new Date());
		complaintapplication.setApplicationstatusid(applicationStatusID);
		int i = complaintapplicationMapper.updateByPrimaryKeySelective(complaintapplication);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		//数据库操作日志
		String log = "[ " + accountInfo.getAccount().getName() + " ]处理了投诉建议[ " + complaintapplication.getComplainttarget() + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result getComplaintApplicationList(AccountInfo accountInfo, String AUTHORITY_CODE,
			String applicationstatusname, String targetSearch, String personSearch, String complainttime, Integer page,
			Integer pageSize) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 处理参数
		personSearch = this.checkSearch(personSearch);
		targetSearch = this.checkSearch(targetSearch);
		complainttime = this.checkSearchTime(complainttime);
		List<Complaintapplication> rows = complaintapplicationMapper.selectComplaintList(applicationstatusname, complainttime, personSearch, targetSearch,
				(page - 1) * pageSize, pageSize);
		int count = complaintapplicationMapper.selectCountComplaintList(applicationstatusname, complainttime, personSearch, targetSearch);
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

	@Override
	public Result insertComplaintApplication(AccountInfo accountInfo, Complaintapplication complaintapplication, String code, String ip) throws MyException {
		
		//判断账号类型
        Integer accountTypePerson = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON);
        if (accountTypePerson.intValue() != accountInfo.getAccount().getDictionariesid()){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}

        //校验验证码
        String service_code = jedisClient.get(Constant.VERIFICATION_CODE + ip, REDIS_PASSWORD);
        if (code == null || !code.equalsIgnoreCase(service_code)) {
            return Result.build(ResultEnum.LOGIN_CODE_ERROR);
        }

		//补全参数
        complaintapplication.setApplicationstatusid(1);
        complaintapplication.setComplaintno(LiuUtils.getServeIdByUUId());
        complaintapplication.setComplaintperson(accountInfo.getAccount().getName());
        complaintapplication.setPhone(accountInfo.getAccount().getPhone());
        complaintapplication.setComplainttime(new Date());

        complaintapplication.setCreateby(accountInfo.getAccount().getName());
        complaintapplication.setCreatepersonid(accountInfo.getAccount().getAccountid());
        complaintapplication.setCreatetime(new Date());

        int i = complaintapplicationMapper.insertSelective(complaintapplication);
        if (i < 1){
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }

        //数据库操作日志
		String log = "[ " + accountInfo.getAccount().getName() + " ]提交了投诉建议";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
	}

}
