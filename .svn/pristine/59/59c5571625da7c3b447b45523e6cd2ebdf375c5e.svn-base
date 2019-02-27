package com.jy.service.system.menu;

import com.jy.common.exception.MyException;
import com.jy.common.result.EasyUITreeNode;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.menu.Menu;

import java.util.List;

/**
 * @ClassName:  MenuService   
 * @Description:菜单服务接口 
 * @author: cheng fei
 * @date:   2018-07-31 16:19
 */
public interface MenuService {

	/**
	 * 通过用户获取用户可访问菜单
	 * @param accountInfo
	 * @return
	 */
	Result getMenuByUser(AccountInfo accountInfo);

	/**
	 * 获取菜单列表
	 * @param accountInfo
	 * @param parent_id
	 * @return
	 */
	Result getMenuList(AccountInfo accountInfo, Integer parent_id) throws MyException;

	/**
	 * 添加一个菜单
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param menu
	 * @return
	 * @throws MyException 
	 */
	Result insertMenu(AccountInfo accountInfo,String AUTHORITY_CODE, Menu menu) throws MyException;

	/**
	 * 更具菜单id 获取菜单
	 * @param accountInfo
	 * @param menu_id
	 * @return
	 */
	Result getMenu(AccountInfo accountInfo, Integer menu_id);

	/**
	 * 修改一个菜单
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param menu
	 * @return
	 * @throws MyException 
	 */
	Result updateMenu(AccountInfo accountInfo,String AUTHORITY_CODE, Menu menu) throws MyException;

	
	/**
	 * 删除一个菜单
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param menu_id
	 * @return
	 * @throws MyException 
	 */
	Result deleteMenu(AccountInfo accountInfo,String AUTHORITY_CODE, Integer menu_id) throws MyException;

	/**
	 * 获取菜单EasyUITree
	 * @param parent_id 菜单父节点ID
	 * @return
	 * @throws MyException 
	 */
	List<EasyUITreeNode> getEasyUITree(Integer parent_id) throws MyException;


	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/16 16:36
	 * 描述 : 获取菜单VueTree
	 * @param accountInfo
	 * @param parentID
	 * @return
	 */
	Result getVueTree(AccountInfo accountInfo, Integer parentID);
}
