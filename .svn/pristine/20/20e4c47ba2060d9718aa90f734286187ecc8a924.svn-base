package com.jy.service.system.dictionaries;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.system.dictionaries.DictionariesMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.dictionaries.Dictionaries;
import com.jy.entiy.system.dictionaries.DictionariesExample;
import com.jy.entiy.system.dictionaries.DictionariesExample.Criteria;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName: DictionariesServiceImpl
 * @Description:数据字典服务实现类
 * @author: cheng fei
 * @date: 2018-08-05 12:04
 */
@Service
public class DictionariesServiceImpl extends BaseService implements DictionariesService {

	/**
	 * 数据数据库操作日志类型
 	 */
	private static final String DB_LOG_TYPE = "DB_LOG_DICTIONARIES";

	@Resource
	private DictionariesMapper dictionariesMapper;

	@Resource
	private AccountMapper accountMapper;

	@Override
	public Result getSelectDictionariesByCode(String code) {
		Integer id = dictionariesMapper.getDictionariesIDByCode(code);
		return Result.succee(dictionariesMapper.getSelectDictionariesByParentId(id));
	}


	@Override
	public Result getDictionaries(AccountInfo accountInfo, Integer parent_id, String search, Integer page, Integer pageSize) {

		//检测账号类型
		if (!checkManageAccount(accountInfo.getAccount())){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}

		//设置模糊查询
		if(search != null && !"".equals(search.trim())) {
			search = "%"+search.trim() + "%";
		}else {
			search = null;
		}

		List<Dictionaries> dics = dictionariesMapper.getDictionariesByParam(parent_id, null, search, (page-1)*pageSize, pageSize);
		List<Dictionaries> count = dictionariesMapper.getDictionariesCountByParam(parent_id, null, search);
		Map<String,Object> map = new HashMap<>();
		map.put("rows", dics);
		map.put("count", count);
		return Result.succee(map);
	}



	@Override
	public Result getParentDictionaries(AccountInfo accountInfo, Integer parent_id) {

		//检测账号类型
		if (!checkManageAccount(accountInfo.getAccount())){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}

		List<Dictionaries> list = new ArrayList<>();
		Dictionaries dic = dictionariesMapper.selectByPrimaryKey(parent_id);
		parent_id = dic.getParentid();
		list.add(dic);
		while (true) {
			if (parent_id == 0) {
				break;
			}
			Dictionaries dic1 = dictionariesMapper.selectByPrimaryKey(parent_id);
			parent_id = dic1.getParentid();
			list.add(dic1);
		}
		Collections.reverse(list);
		return Result.succee(list);
	}

	@Override
	public Result checkCode(String code, Integer id) {

		DictionariesExample example =  new DictionariesExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isBlank(code)) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		criteria.andCodeEqualTo(code);
		if (id != null && id > 0) {
			criteria.andDictionariesidNotEqualTo(id);
		}
		List<Dictionaries> list = dictionariesMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return Result.succee(true);
		}
		return Result.succee(false);
	}

	@Override
	public Result InsertDictionaries(AccountInfo accountInfo, String AUTHORITY_CODE, Dictionaries dictionaries) throws MyException {

		//检测权限
		Result result = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()){
			return result;
		}

		Dictionaries parent_dic = null;
		if (dictionaries.getParentid() !=0) {
			parent_dic = dictionariesMapper.selectByPrimaryKey(dictionaries.getParentid());
		}

		//补全属性
		dictionaries.setLevel(parent_dic == null ? 1 : parent_dic.getLevel() + 1);
		//状态设置为可用 1可用 0 不可用
		dictionaries.setStatus(1);
		dictionaries.setCreatepersonid(accountInfo.getAccount().getAccountid());
		dictionaries.setCreatetime(new Date());
		dictionaries.setCreateby(accountInfo.getAccount().getName());

		//添加
		int i = dictionariesMapper.insertSelective(dictionaries);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		//添加数据库操作日志
		String log = "添加了一个数据字典:[ ";
		log += "名字=" + dictionaries.getName() + ",";
		log += "编码=" + dictionaries.getCode() + ",";
		log += "排序码=" + dictionaries.getDisplayorder() + ",";
		log += parent_dic == null ? "" :"父节点=" + parent_dic.getName() + ",";
		log += "级别=" + dictionaries.getLevel() + ",";
		log = log.substring(0,log.length() -1 ) + " ]";

		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result updateDictionaries(AccountInfo accountInfo, String AUTHORITY_CODE, Dictionaries dictionaries) throws MyException {

		//检测权限
		Result result = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()){
			return result;
		}

		String old_name = dictionariesMapper.getNameByDictionariesID(dictionaries.getDictionariesid());
		//补全属性
		dictionaries.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		dictionaries.setUpdatetime(new Date());
		dictionaries.setUpdateby(accountInfo.getAccount().getName());
		int i = dictionariesMapper.updateByPrimaryKeySelective(dictionaries);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		//添加数据库操作日志
		String log = "修改了[ "+old_name+" ]数据字典:[ ";
		log += StringUtils.isBlank(dictionaries.getName()) ? "" : "名字=" + dictionaries.getName() + ",";
		log += StringUtils.isBlank(dictionaries.getCode()) ? "" : "编码=" + dictionaries.getCode() + ",";
		log += dictionaries.getDisplayorder() != null ? "" : "排序码=" + dictionaries.getDisplayorder() + ",";
		log = log.substring(0,log.length() -1 ) + " ]";

		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result deleteDictionaries(AccountInfo accountInfo, String AUTHORITY_CODE, Integer id) throws MyException {

		//检测权限
		Result result = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()){
			return result;
		}

		DictionariesExample example = new DictionariesExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(id);
		int count = dictionariesMapper.countByExample(example);
		if (count > 0) {
			return Result.build(0,500,"删除失败，请先删除其下级数据!");
		}
		String name = dictionariesMapper.getNameByDictionariesID(id);
		int i = dictionariesMapper.deleteByPrimaryKey(id);
		if (i < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}

		//添加数据库操作日志
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), "删除了一个数据字典:[ "+name+" ]", DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result getDictionariesById(AccountInfo accountInfo, Integer id) {

		//检测账号类型
		if (!checkManageAccount(accountInfo.getAccount())){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}
		return Result.succee(dictionariesMapper.selectByPrimaryKey(id));
	}
}












