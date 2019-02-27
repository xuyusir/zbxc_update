package com.jy.service.account.authority;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.account.authority.AuthorityMapper;
import com.jy.dao.system.menu.MenuMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.account.authority.Authority;
import com.jy.entiy.account.authority.AuthorityExample;
import com.jy.entiy.account.authority.AuthorityExample.Criteria;
import com.jy.entiy.system.menu.Menu;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName:  AuthorityServiceImpl   
 * @Description:权限接口实现类
 * @author: cheng fei
 * @date:   2018-09-15 10:02
 */
@Service
public class AuthorityServiceImpl extends BaseService implements AuthorityService{
	
	//数据库操作日志类型
	private static final String DB_LOG_TYPE = "DB_LOG_AUTHORITY";
	
	@Resource
	private AuthorityMapper authorityMapper;
	
	@Resource
	private MenuMapper menuMapper;

	@Override
	public Result getAuthorityList(AccountInfo accountInfo, String AUTHORITY_CODE, Integer menu_Id) throws MyException {
		
		//检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		
		AuthorityExample example = new AuthorityExample();
		example.setOrderByClause("DisplayOrder");
		Criteria criteria = example.createCriteria();
		criteria.andMenuidEqualTo(menu_Id);
		List<Authority> list = authorityMapper.selectByExample(example);
		return Result.succee(list);
	}

	@Override
	public Result insertAuthority(AccountInfo accountInfo, String AUTHORITY_CODE, Authority authority) throws MyException {
		
		//检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		
		//补全参数
		authority.setCreatepersonid(accountInfo.getAccount().getAccountid());
		authority.setCreateby(accountInfo.getAccount().getName());
		authority.setCreatetime(new Date());
		
		//检测编码是否重复
		Result checkAuthorityCode = checkAuthorityCode(null, authority.getCode());
		if (!(boolean) checkAuthorityCode.getData()) {
			return Result.build(ResultEnum.AUTHORITY_CODE_EXIST);
		}
		
		int i = authorityMapper.insertSelective(authority);
		if (i < 1 ) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		
		//添加数据库操作日志
		String log = "[ "+ menuMapper.getMenuNameByMenuId(authority.getMenuid()) + " ]菜单添加了权限[ ";
		log += "权限=" + authority.getName() + ",固定编码=" + authority.getCode() + ",";
		log += StringUtils.isBlank(authority.getRemark()) ?  "" : "备注=" + authority.getRemark() + ","; 
		log = log.substring(0, log.length()-1) + " ]";
		
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log , DB_LOG_TYPE);
		
		return Result.succee();
	}
	
	@Override
	public Result updateAuthority(AccountInfo accountInfo, String AUTHORITY_CODE, Authority authority) throws MyException {
		
		//检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		
		//补全参数
		authority.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		authority.setUpdateby(accountInfo.getAccount().getName());
		authority.setUpdatetime(new Date());
		
		//检测固定编码
		Result result = checkAuthorityCode(authority.getId(), authority.getCode());
		if (!(boolean) result.getData()) {
			return Result.build(ResultEnum.AUTHORITY_CODE_EXIST);
		}
		
		Authority old_authority = authorityMapper.selectByPrimaryKey(authority.getId());
		
		int i = authorityMapper.updateByPrimaryKeySelective(authority);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		
		//添加数据库操作日志
		String log = "[ "+ menuMapper.getMenuNameByMenuId(authority.getMenuid()) + " ]菜单修改了[ "+ old_authority.getName() +" ]权限[ ";
		log += StringUtils.isBlank(authority.getName()) ? "" : "权限=" + authority.getName() + ",";
		log += StringUtils.isBlank(authority.getCode()) ? "" : "固定编码=" + authority.getCode() + ",";
		log += StringUtils.isBlank(authority.getRemark()) ?  "" : "备注=" + authority.getRemark() + ","; 
		log = log.substring(0, log.length()-1) + " ]";
		
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log , DB_LOG_TYPE);
		
		return Result.succee();
	}

	@Override
	public Result getAuthority(AccountInfo accountInfo, Integer id) throws MyException {

		//检测账号类型
		if (checkManageAccount(accountInfo.getAccount())){
			Result.build(ResultEnum.ACCOUNT_ERROR);
		}
		
		return Result.succee(authorityMapper.selectByPrimaryKey(id));
	}
	
	@Override
	public Result checkAuthorityCode(Integer id, String Code) {
		
		AuthorityExample example = new AuthorityExample();
		Criteria criteria = example.createCriteria();
		if (id != null) {
			criteria.andIdNotEqualTo(id);
		}
		criteria.andCodeEqualTo(Code);
		int count = authorityMapper.countByExample(example);
		return Result.succee(count > 0 ? false : true);
	}

	@Override
	public Result deleteAuthority(AccountInfo accountInfo, String AUTHORITY_CODE, Integer id) throws MyException {
		
		//检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		
		Authority authority = authorityMapper.selectByPrimaryKey(id);
		Menu menu = menuMapper.selectByPrimaryKey(authority.getMenuid());
		int i = authorityMapper.deleteByPrimaryKey(id);
		if (i < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}
		
		String log = "删除了[ " + menu.getName() + " ]菜单[ " + authority.getName() + " ]权限";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log , DB_LOG_TYPE);
		
		return Result.succee();
	}

	@Override
	public Result getPageAuthorityCode(AccountInfo accountInfo, Integer menu_id) {

       return this.getPageButtonAuthority(accountInfo, menu_id);
	}

}
