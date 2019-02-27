package com.jy.dao.account.account;

import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccountMapper {
    int countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Long accountid);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Long accountid);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    /**
     * 查询管理员账号列表
     *
     * @param isDelete 是否查询回收站
     * @param search   关键词:用户名/姓名/邮箱
     * @return
     */
    List<Map<String, Object>> getManageAccountList(@Param("isDelete")boolean isDelete, @Param("search") String search);

    /**
     * 查询个人账号列表
     *
     * @param isDelete   是否查询回收站
     * @param search   关键词：姓名/联系电话/邮箱
     * @param isMember 是否是会员：null全部，0非会员，1会员
     * @return
     */
    List<Map<String, Object>> getPersonAccountList(@Param("isDelete")boolean isDelete, @Param("search") String search, @Param("isMember") Integer isMember);

	/**
	 * 查询企业账号列表
	 *
	 * @param isDelete 是否已删除
	 * @param search 关键词 模糊查询企业名称,联系人,联系电话
	 * @return
	 */
	List<Map<String, Object>> getEnterpriseAccountList(@Param("isDelete")boolean isDelete, @Param("search") String search);

	/**
	 * 查询用户名总数
	 * @param id 要排除的ID
	 * @param username 用户名
	 * @return
	 */
	Integer getAccountCountByUserName(@Param("id") Long id, @Param("username") String username);

	/**
	 * 查询联系电话总数
	 * @param id
	 * @param phone
	 * @return
	 */
	Integer getAccountCountByPhone(@Param("id") Long id, @Param("phone") String phone);

	/**
	 * 查询邮箱总数
	 * @param id
	 * @param email
	 * @return
	 */
	Integer getAccountCountByEmail(@Param("id") Long id, @Param("email") String email);

	/**
	 * 查询企业账号信息
	 * @param account_id 账号ID
	 * @return
	 */
	Map<String, Object> getEnterpriseAccount(@Param("account_id") Long account_id);

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/12/11 11:31
	 * 描述 : 查询企业账号信息,后台管理回显
	 *
	 * @param accountID
	 * @return
	 */
	Map<String, Object> getEnterpriseAccountByManage(@Param("accountID")Long accountID);

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/14 11:54
     * 描述 : 查询数据库中所有表名列表
     * @param dbName 数据库名称
     * @return
     */
    List<String> getAllTable(@Param("dbName")String dbName);

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/14 11:59
     * 描述 : 获取表的所有字段
     *
     * @param table
     * @return
     */
    List<String> getTableColumn(@Param("table")String table);
}
