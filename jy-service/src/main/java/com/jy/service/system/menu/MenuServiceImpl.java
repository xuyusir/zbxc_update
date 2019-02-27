package com.jy.service.system.menu;

import com.jy.common.exception.MyException;
import com.jy.common.result.EasyUITreeNode;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.RightsHelper;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.account.authority.RoleMapper;
import com.jy.dao.system.dictionaries.DictionariesMapper;
import com.jy.dao.system.menu.MenuMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.account.authority.Role;
import com.jy.entiy.content.file.directory.VueTreeNode;
import com.jy.entiy.system.menu.Menu;
import com.jy.entiy.system.menu.MenuExample;
import com.jy.entiy.system.menu.MenuExample.Criteria;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl extends BaseService implements MenuService {


    // 菜单数据库操作日志类型
    private static final String DB_LOG_TYPE = "DB_LOG_MENU";

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private DictionariesMapper dictionariesMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Result getMenuByUser(AccountInfo accountInfo) {
        List<Menu> list = getMenuByParentId(0, true);
        if (checkAdministrator(accountInfo)) {
            return Result.succee(list);
        }
        List<Menu> data = new ArrayList<>();
        Role role = accountInfo.getRole();
        if (role != null && role.getRoleid() != null) {
            role = roleMapper.selectByPrimaryKey(role.getRoleid());
            if (StringUtils.isNotBlank(role.getMenurights())) {
                String rights = role.getMenurights();
                for (Menu menu : list) {
                    boolean b = RightsHelper.testRights(rights, menu.getMenuid());
                    if (b) {
                        data.add(menu);
                        List<Menu> child_menus_data = new ArrayList<>();
                        for (Menu child_menu : menu.getChildMenus()) {
                            boolean c = RightsHelper.testRights(rights, child_menu.getMenuid());
                            if (c) {
                                child_menus_data.add(child_menu);
                            }
                        }
                        menu.setChildMenus(child_menus_data);
                    }
                }
            }
        }
        return Result.succee(data);
    }

    @Override
    public Result getMenuList(AccountInfo accountInfo, Integer parent_id) throws MyException {

        //检测账号类型
        if (!checkManageAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        if (parent_id == null) {
            parent_id = 0;
        }
        List<Menu> menus = getMenuByParentId(parent_id, false);
        return Result.succee(menus);
    }

    @Override
    public Result insertMenu(AccountInfo accountInfo, String CONTROLLER_CODE, Menu menu) throws MyException {

        // 检测权限
        Result result = this.checkAuthority(accountInfo, CONTROLLER_CODE);
        if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
            return result;
        }

        // 检测重名
        if (!checkMenuName(menu.getName(), menu.getParentid())) {
            return Result.build(ResultEnum.MENU_NAME_EXIST);
        }

        menu.setCreatepersonid(accountInfo.getAccount().getAccountid());
        menu.setCreatetime(new Date());
        menu.setCreateby(accountInfo.getAccount().getName());

        if (StringUtils.isBlank(menu.getUrl())) {
            menu.setUrl("#");
        }
        int i = menuMapper.insertSelective(menu);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }

        // 插入数据库操作日志
        String log = "添加了一个菜单 : [ ";
        log += StringUtils.isBlank(menu.getName()) ? "" : "菜单名=" + menu.getName() + ",";
        log += "url=" + menu.getUrl() + ",";
        log += menu.getParentid() == null ? "" : "父菜单=" + menuMapper.getMenuNameByMenuId(menu.getParentid()) + ",";
        log += StringUtils.isBlank(menu.getIcon()) ? "" : "菜单图标=" + menu.getIcon() + ",";
        log = log.substring(0, log.length() - 1) + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result getMenu(AccountInfo accountInfo, Integer menu_id) {

        if (!checkManageAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        return Result.succee(menuMapper.selectByPrimaryKey(menu_id));
    }

    @Override
    public Result updateMenu(AccountInfo accountInfo, String CONTROLLER_CODE, Menu menu) throws MyException {

        // 检测权限
        Result result = this.checkAuthority(accountInfo, CONTROLLER_CODE);
        if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
            return result;
        }

        //查询原始数据
        Menu old_menu = menuMapper.selectByPrimaryKey(menu.getMenuid());
        if (StringUtils.isBlank(menu.getUrl())) {
            menu.setUrl(old_menu.getUrl());
        }
        menu.setUpdatepersonid(accountInfo.getAccount().getAccountid());
        menu.setUpdatetime(new Date());
        //修改
        int i = menuMapper.updateByPrimaryKeySelective(menu);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }

        //数据库操作日志
        String log = "修改了[ " + old_menu.getName() + " ]菜单 : [ ";
        log += StringUtils.isBlank(menu.getName()) ? "" : "菜单名=" + menu.getName() + ",";
        log += StringUtils.isBlank(menu.getUrl()) ? "" : "url=" + menu.getUrl() + ",";
        log += menu.getParentid() == null ? "" : "父菜单=" + menuMapper.getMenuNameByMenuId(menu.getParentid()) + ",";
        log += StringUtils.isBlank(menu.getIcon()) ? "" : "菜单图标=" + menu.getIcon() + ",";
        log = log.substring(0, log.length() - 1) + " ]";


        // 添加数据库操作日志
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result deleteMenu(AccountInfo accountInfo, String CONTROLLER_CODE, Integer menu_id) throws MyException {

        // 检测权限
        Result result = this.checkAuthority(accountInfo, CONTROLLER_CODE);
        if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
            return result;
        }

        //查询子菜单
        MenuExample example = new MenuExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(menu_id);
        List<Menu> childs = menuMapper.selectByExample(example);

        //删除子菜单
        if (childs != null && childs.size() > 0) {
            for (Menu menu : childs) {
                int i = menuMapper.deleteByPrimaryKey(menu.getMenuid());
                if (i < 1) {
                    throw new MyException(ResultEnum.DELETE_SQL_ERROR);
                }
            }
        }

        //删除菜单
        String menu_name = menuMapper.getMenuNameByMenuId(menu_id);
        int i = menuMapper.deleteByPrimaryKey(menu_id);
        if (i < 1) {
            throw new MyException(ResultEnum.DELETE_SQL_ERROR);
        }
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), "删除了一个菜单:[ " + menu_name + ",及以下子菜单 ]", DB_LOG_TYPE);
        return Result.succee();
    }


    @Override
    public List<EasyUITreeNode> getEasyUITree(Integer parent_id) throws MyException {

        MenuExample example = new MenuExample();
        example.setOrderByClause("DisplayOrder");
        Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(parent_id);
        List<Menu> list = menuMapper.selectByExample(example);
        List<EasyUITreeNode> data = new ArrayList<>();
        for (Menu menu : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(menu.getMenuid());
            node.setText(menu.getName());
            node.setState(menu.getParentid() == 0 ? "closed" : "open");
            data.add(node);
        }
        return data;
    }

    @Override
    public Result getVueTree(AccountInfo accountInfo, Integer parentID) {

        //判断账号类型
        if (!checkManageAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        MenuExample example = new MenuExample();
        example.setOrderByClause("DisplayOrder");
        Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(parentID);
        List<Menu> list = menuMapper.selectByExample(example);
        List<VueTreeNode> data = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            VueTreeNode node = new VueTreeNode();
            node.setName(list.get(i).getName());
            node.setCode(list.get(i).getMenuid());
            node.setExpand(list.get(i).getParentid() == 0);
            data.add(node);
        }
        return Result.succee(data);
    }

    /**
     * 检测菜单名是否可用
     *
     * @param name
     */
    private boolean checkMenuName(String name, Integer parent_id) {
        int i = menuMapper.getMenuCountByName(name, parent_id);
        if (i > 0) {
            return false;
        } else {
            return true;
        }

    }


    /**
     * 根据父菜单id查询所有菜单
     *
     * @param parent_id 父菜单id
     * @param recursion 是否递归查询
     * @return
     */
    private List<Menu> getMenuByParentId(Integer parent_id, boolean recursion) {
        MenuExample example = new MenuExample();
        example.setOrderByClause("DisplayOrder");
        Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(parent_id);
        List<Menu> list = menuMapper.selectByExample(example);
        if (recursion) {
            for (Menu menu : list) {
                menu.setChildMenus(getMenuByParentId(menu.getMenuid(), recursion));
            }
        }
        return list;
    }


}
