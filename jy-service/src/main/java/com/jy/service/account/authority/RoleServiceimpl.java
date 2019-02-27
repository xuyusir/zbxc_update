package com.jy.service.account.authority;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.RightsHelper;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.account.authority.AuthorityMapper;
import com.jy.dao.account.authority.RoleMapper;
import com.jy.dao.system.menu.MenuMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.account.authority.Authority;
import com.jy.entiy.account.authority.AuthorityExample;
import com.jy.entiy.account.authority.Role;
import com.jy.entiy.account.authority.RoleExample;
import com.jy.entiy.account.authority.RoleExample.Criteria;
import com.jy.entiy.system.menu.Menu;
import com.jy.entiy.system.menu.MenuExample;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName: RoleServiceimpl
 * @Description:角色管理服务实现
 * @author: cheng fei
 * @date: 2018-08-03 01:15
 */
@Service
public class RoleServiceimpl extends BaseService implements RoleService {

	/**
	 * 角色数据库操作日志类型
	 */
	private static final String DB_LOG_TYPE = "DB_LOG_MENU";

	private static final Integer [] STATUS = {0, 1};

	@Resource
	private RoleMapper roleMapper;
	
	@Resource 
	private AccountMapper accountMapper;
	
	@Resource
	private AuthorityMapper authorityMapper;
	
	@Resource
	private MenuMapper menuMapper;

	@Override
	public Result checkRoleName(Integer role_id, String role_name) {
		RoleExample example = new RoleExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(role_name);
        if (role_id != null){
        	criteria.andRoleidNotEqualTo(role_id);
		}
        int count = roleMapper.countByExample(example);

        return Result.succee(count == 0);
	}

	@Override
	public Result getRoleList(AccountInfo accountInfo, String search, Integer page, Integer page_size) throws MyException {

		//检测账号类型
		if (!checkManageAccount(accountInfo.getAccount())){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}

		search = this.checkSearch(search);
		
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(search)) {
			criteria.andNameLike(search);
		}
		PageHelper.startPage(page, page_size);
		List<Role> list = roleMapper.selectByExample(example);
        PageInfo<Role> info = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>(2);
        map.put("rows", info.getList());
        map.put("count", info.getTotal());
        return Result.succee(map);
	}

	@Override
	public Result getAuthority(AccountInfo accountInfo, Integer menu_id) {
		return Result.succee(this.getPageButtonAuthority(accountInfo, menu_id));
	}
	
	@Override
	public Result insertRole(AccountInfo accountInfo, String AUTHORITY_CODE, Role role) throws MyException {
		
		//检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		//检测用户名是否可用
		if(!(boolean) checkRoleName(null, role.getName()).getData()){
		    return Result.build(ResultEnum.ROLE_NAME_EXIST);
		}

		//补全属性
		role.setCreatepersonid(accountInfo.getAccount().getAccountid());
		role.setCreatetime(new Date());
		role.setCreateby(accountInfo.getAccount().getName());
		//状态1可用,0不可用
		role.setStatus(1);
		int i = roleMapper.insertSelective(role);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		
		//添加数据库操作日志
		String log = "添加了一个用户组:[ " + role.getName() + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();
	}

	@Override
	public Result updateRole(AccountInfo accountInfo, String AUTHORITY_CODE, Role role) throws MyException {
		
		//检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}			
		//修改
		updateRole(accountInfo, role);
		
		return Result.succee();
	}

	@Override
	public Result deleteRole(AccountInfo accountInfo, String AUTHORITY_CODE, String role_ids) throws MyException {
		
		//检测删除权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		String[] split = role_ids.split(",");
		for (String role_id : split) {
			if (!StringUtils.isNumeric(role_id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			String old_name = roleMapper.getNameByRoleID(Integer.parseInt(role_id));
			int i = roleMapper.deleteByPrimaryKey(Integer.parseInt(role_id));
			if (i < 1) {
				throw new MyException(ResultEnum.DELETE_SQL_ERROR);
			}
			
			//数据库操作日志
			this.dbLog(accountInfo.getAccount().getAccountid(),accountInfo.getAccount().getName(), "删除了一个用户组: [ " + old_name +" ]", DB_LOG_TYPE);
		}
		
		return Result.succee();
	}

	@Override
	public Result getRoleById(AccountInfo accountInfo, Integer role_id) {

		//检测账号类型
		if (!checkManageAccount(accountInfo.getAccount())){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}
		
		return Result.succee(roleMapper.selectByPrimaryKey(role_id));
	}

	@Override
	public Result getRoleSelect(AccountInfo accountInfo) {

		//检测账号类型
		if (!checkManageAccount(accountInfo.getAccount())){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}

		return Result.succee(roleMapper.getRoleSelect());
	}

	@Override
	public Result getRoleAuthority(AccountInfo accountInfo, Integer role_id) {
		
		Role role = roleMapper.selectByPrimaryKey(role_id);
		
		//查询所有顶级菜单
		MenuExample example = new MenuExample();
		example.setOrderByClause("DisplayOrder");
		com.jy.entiy.system.menu.MenuExample.Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(0);
		List<Menu> list = menuMapper.selectByExample(example);
		//查询顶级菜单下子菜单
		for (Menu menu : list) {
			MenuExample example2 = new MenuExample();
			example2.setOrderByClause("DisplayOrder");
			com.jy.entiy.system.menu.MenuExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andParentidEqualTo(menu.getMenuid());
			List<Menu> list2 = menuMapper.selectByExample(example2);
			//查询子菜单的权限
			for (Menu menu2 : list2) {
				AuthorityExample example3 = new AuthorityExample();
				example3.setOrderByClause("DisplayOrder");
				com.jy.entiy.account.authority.AuthorityExample.Criteria criteria3 = example3.createCriteria();
				criteria3.andMenuidEqualTo(menu2.getMenuid());
				List<Authority> list3 = authorityMapper.selectByExample(example3);
				//检测当前角色是否拥有权限
				for (Authority authority : list3) {
					authority.setChecked(RightsHelper.testRights(role.getAuthority(), authority.getId()));
				}
				Authority menu_authority = new Authority();
				menu_authority.setName("菜单查看权限");
				menu_authority.setCode("PAGE_AUTHORITY");
				menu_authority.setChecked(RightsHelper.testRights(role.getMenurights(), menu2.getMenuid()));
				list3.add(0, menu_authority);
				menu2.setAuthoritys(list3);
			}
			menu.setChildMenus(list2);
		}
		
		return Result.succee(list);
	}

	@Override
	public Result updateRoleAuthority(AccountInfo accountInfo, String AUTHORITY_CODE, Integer role_id, String menu_ids, String authority_ids) throws MyException {
		
		if (role_id < 1) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		
		//检测修改权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		
		String[] split = null;
		if (StringUtils.isNotBlank(authority_ids)){
			split = authority_ids.split(",");
		}
		String authority = (split == null || split.length == 0 ) ? "" : RightsHelper.sumRights(split).toString();

		String[] split2 = null;
		if (StringUtils.isNotBlank(menu_ids)){
			split2 = menu_ids.split(",");
		}
		String[] arr = null;
		if (split2 != null && split2.length > 0 ) {
			Set<String> set = new HashSet<>(Arrays.asList(split2));
			arr = new String[set.size()];   
			set.toArray(arr);
		}
		String menu_rights = (arr == null || arr.length == 0 ) ? "" : RightsHelper.sumRights(arr).toString();
		Role role = new Role();
		role.setRoleid(role_id);
		role.setMenurights(menu_rights);
		role.setAuthority(authority);
		role.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		role.setUpdateby(accountInfo.getAccount().getName());
		role.setUpdatetime(new Date());
		//修改
		updateRole(accountInfo, role);
		
		return Result.succee();
	}

	@Override
	public Result updateRoleStatus(AccountInfo accountInfo, String AUTHORITY_CODE,String role_ids, Integer status) throws MyException {

	    //检测参数
        if (!Arrays.asList(STATUS).contains(status)){
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

		//检测修改权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

        String[] split = role_ids.split(",");
        for (String role_id_str : split) {

            if (!StringUtils.isNumeric(role_id_str)){
                return  Result.build(ResultEnum.PARAMETER_ERROR);
            }
            Role role = new Role();
            role.setRoleid(Integer.parseInt(role_id_str));
            role.setStatus(status);

            updateRole(accountInfo, role);
        }

        return Result.succee();
	}

	/**
	 * 修改用户组
	 * @param accountInfo 当前登录人员
	 * @param role 需要修改的用户组
	 * @throws MyException
	 */
	private void updateRole(AccountInfo accountInfo,Role role) throws MyException {
		
		//补全参数
		role.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		role.setUpdatetime(new Date());
		role.setUpdateby(accountInfo.getAccount().getName());
		
		//修改
		Role old_role = roleMapper.selectByPrimaryKey(role.getRoleid());
		int i = roleMapper.updateByPrimaryKeySelective(role);
		if (i < 1) {
			throw new  MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		
		//添加操作日志
		String log = "修改了[ "+old_role.getName()+" ]用户组 : [ ";
		log += StringUtils.isBlank(role.getName()) ? "" : "用户组名=" + role.getName() + ",";
		log += StringUtils.isBlank(role.getMenurights()) ? "" : "修改用户组菜单权限=" + role.getMenurights() + ",";
		log += StringUtils.isBlank(role.getAuthority()) ? "" : "修改用户组权限=" + role.getAuthority() + ",";
		log += role.getStatus() == null ? "" : "状态="+(role.getStatus() == 1 ? "可用" : "不可用") + "，";
		log = log.substring(0,log.length() -1)+" ]";
		
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		
	}

}
















