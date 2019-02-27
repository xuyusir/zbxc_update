package com.jy.service.system.web.bottomLink;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.system.web.bottomLink.BottomlinkMapper;
import com.jy.dao.system.web.bottomLink.BottomlinktypeMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.web.bottomLink.Bottomlink;
import com.jy.entiy.system.web.bottomLink.BottomlinkExample;
import com.jy.entiy.system.web.bottomLink.Bottomlinktype;
import com.jy.entiy.system.web.bottomLink.BottomlinktypeExample;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BottomLinkServiceImpl
 * @Description:底部链接管理实现类
 * @author: chenye
 * @date: 2018-09-28 10:25
 */
@Service
public class BottomLinkServiceImpl extends BaseService implements BottomLinkService {

	// 数据库操作日志类型
	private static final String DB_LOG_TYPE = "DB_LOG_BOTTOM_MANAGE";

	@Resource
	private BottomlinkMapper bottomlinkMapper;

	@Resource
	private BottomlinktypeMapper bottomlinktypeMapper;

	@Override
	public Result getAuthority(AccountInfo accountInfo, Integer menu_id) {
		return Result.succee(this.getPageButtonAuthority(accountInfo, menu_id));
	}

	@Override
	public Result getAllType() throws MyException {
		List<Bottomlinktype> list = bottomlinktypeMapper.selectByExample(null);
		return Result.succee(list);
	}

	public Result getAllBottomLink() throws MyException {

		List<Bottomlinktype> list = bottomlinktypeMapper.selectByExample(null);
		for (Bottomlinktype bottomlinktype : list) {
			BottomlinkExample bottomlinkExample = new BottomlinkExample();
			bottomlinkExample.setOrderByClause("DisplayOrder");
			com.jy.entiy.system.web.bottomLink.BottomlinkExample.Criteria createCriteria = bottomlinkExample.createCriteria();
			createCriteria.andTypeidEqualTo(bottomlinktype.getId());
			List<Bottomlink> bottomlinkList = bottomlinkMapper.selectByExample(bottomlinkExample);
			bottomlinktype.setBottomlinks(bottomlinkList);

		}
		return Result.succee(list);

	}

	@Override
	public Result insertBottomLinkType(AccountInfo accountInfo, String AUTHORITY_CODE, Bottomlinktype bottomlinkType)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查
		if (StringUtils.isBlank(bottomlinkType.getTypename())) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		//名称重复检查
		BottomlinktypeExample bottomlinktypeExample = new BottomlinktypeExample();
		com.jy.entiy.system.web.bottomLink.BottomlinktypeExample.Criteria createCriteria = bottomlinktypeExample.createCriteria();
		createCriteria.andTypenameEqualTo(bottomlinkType.getTypename());
		int countByExample = bottomlinktypeMapper.countByExample(bottomlinktypeExample);
		if(countByExample > 0) {
			return Result.build(2004,400,"该类目名称已存在!");
		}
		int i = bottomlinktypeMapper.insertSelective(bottomlinkType);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "添加了一个底部链接类目 : [ ";
		log += StringUtils.isBlank(bottomlinkType.getTypename()) ? "" : "类目名称=" + bottomlinkType.getTypename() + ",";
		log += bottomlinkType.getId() == null ? "" : "类目id=" + bottomlinkType.getId() + ",";
		log += StringUtils.isBlank(bottomlinkType.getCreateby()) ? "" : "创建者=" + bottomlinkType.getCreateby() + ",";
		log += bottomlinkType.getCreatepersonid() == null ? "" : "创建者id=" + bottomlinkType.getCreatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}


	@Override
	public Result deleteBottomLinkType(AccountInfo accountInfo, String AUTHORITY_CODE, Integer id) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查
		if (id == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		BottomlinkExample bottomlinkExample = new BottomlinkExample();
		com.jy.entiy.system.web.bottomLink.BottomlinkExample.Criteria createCriteria = bottomlinkExample.createCriteria();
		createCriteria.andTypeidEqualTo(id);
		List<Bottomlink> bottomlinkList = bottomlinkMapper.selectByExample(bottomlinkExample);
		if(bottomlinkList.size() != 0) {
			return Result.build(3002,500,"请先删除类目下的底部链接!");
		}

		int i1 = bottomlinkMapper.deleteByExample(bottomlinkExample);//删除类目之前先删除该类目下的所有底部链接
//		if (i1 < 1) {类目下没有底部链接就删除条数为0
//			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
//		}
		int i2 = bottomlinktypeMapper.deleteByPrimaryKey(id);
		if (i2 < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "删除了一个底部类目 :  类目id为";
		log += id;
		log += "删除者";
		log += accountInfo.getAccount().getName();

		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result getBottomLinkList(AccountInfo accountInfo, String AUTHORITY_CODE, Integer page, Integer pageSize,
			Integer typeid) throws MyException {
		// 检测权限
//		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
//		if (checkAuthority.getStatus() != 200) {
//			return checkAuthority;
//		}

		PageHelper.startPage(page, pageSize);
		BottomlinkExample bottomlinkExample = new BottomlinkExample();
		bottomlinkExample.setOrderByClause("DisplayOrder");
		com.jy.entiy.system.web.bottomLink.BottomlinkExample.Criteria createCriteria = bottomlinkExample.createCriteria();
		if (typeid != null) {
			createCriteria.andTypeidEqualTo(typeid);
		}

		List<Bottomlink> list = bottomlinkMapper.selectByExample(bottomlinkExample);
		PageInfo<Bottomlink> info = new PageInfo<>(list);
		List<Bottomlink> rows = info.getList();
		long count = info.getTotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

	@Override
	public Result getBottomLinkInfo(Integer id) throws MyException {
		// 参数非空检查
		if (id == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Bottomlink bottomlink = bottomlinkMapper.selectByPrimaryKey(id);
		return Result.succee(bottomlink);
	}

	@Override
	public Result insertBottomLink(AccountInfo accountInfo, String AUTHORITY_CODE, Bottomlink bottomlink)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查
		Integer displayorder = bottomlink.getDisplayorder();
		if (StringUtils.isBlank(bottomlink.getTitle()) || displayorder == null
				|| StringUtils.isBlank(bottomlink.getUrl()) || bottomlink.getTypeid() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		Bottomlinktype bottomlinktype = bottomlinktypeMapper.selectByPrimaryKey(bottomlink.getTypeid());
		if(bottomlinktype == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);//该底部链接类目不存在不能添加底部链接
		}

		//序号是否重复检查
		BottomlinkExample bottomlinkExample = new BottomlinkExample();
		com.jy.entiy.system.web.bottomLink.BottomlinkExample.Criteria createCriteria = bottomlinkExample.createCriteria();
		createCriteria.andDisplayorderEqualTo(displayorder);
		createCriteria.andTypeidEqualTo(bottomlink.getTypeid());
		int count = bottomlinkMapper.countByExample(bottomlinkExample);
		if(count!=0) {
			return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);
		}
		int i = bottomlinkMapper.insertSelective(bottomlink);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "添加了一个底部链接 : [ ";
		log += StringUtils.isBlank(bottomlink.getTitle()) ? "" : "链接标题=" + bottomlink.getTitle() + ",";
		log += bottomlink.getId() == null ? "" : "标题id=" + bottomlink.getId() + ",";
		log += StringUtils.isBlank(bottomlink.getCreateby()) ? "" : "创建者=" + bottomlink.getCreateby() + ",";
		log += bottomlink.getCreatepersonid() == null ? "" : "创建者id=" + bottomlink.getCreatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result updateBottomLink(AccountInfo accountInfo, String AUTHORITY_CODE, Bottomlink bottomlink)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查


		if (StringUtils.isBlank(bottomlink.getTitle()) || bottomlink.getDisplayorder() == null
				|| StringUtils.isBlank(bottomlink.getUrl()) || bottomlink.getTypeid() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		//序号是否重复检查
		BottomlinkExample bottomlinkExample = new BottomlinkExample();
		com.jy.entiy.system.web.bottomLink.BottomlinkExample.Criteria createCriteria = bottomlinkExample.createCriteria();
		createCriteria.andIdNotEqualTo(bottomlink.getId());
		createCriteria.andDisplayorderEqualTo(bottomlink.getDisplayorder());
		createCriteria.andTypeidEqualTo(bottomlink.getTypeid());
		int count = bottomlinkMapper.countByExample(bottomlinkExample);
		if(count!=0) {
			return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);
		}
		int i = bottomlinkMapper.updateByPrimaryKeySelective(bottomlink);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "修改了一个底部链接 : [ ";
		log += StringUtils.isBlank(bottomlink.getTitle()) ? "" : "链接标题=" + bottomlink.getTitle() + ",";
		log += bottomlink.getId() == null ? "" : "标题id=" + bottomlink.getId() + ",";
		log += StringUtils.isBlank(bottomlink.getUpdateby()) ? "" : "修改者=" + bottomlink.getUpdateby() + ",";
		log += bottomlink.getUpdatepersonid() == null ? "" : "修改者id=" + bottomlink.getUpdatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result deleteBottomLink(AccountInfo accountInfo, String AUTHORITY_CODE, Integer id) throws MyException {
		// 检测权限
				Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
				if (checkAuthority.getStatus() != 200) {
					return checkAuthority;
				}
				// 参数非空检查
				if (id == null) {
					return Result.build(ResultEnum.PARAMETER_ERROR);
				}

				int i = bottomlinkMapper.deleteByPrimaryKey(id);
				if (i < 1) {
					throw new MyException(ResultEnum.INSERT_SQL_ERROR);
				}
				// 插入数据库操作日志
				String log = "删除了一个底部链接 :  id为";
				log += id;
				log += "删除者";
				log += accountInfo.getAccount().getName();

				this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

				return Result.succee();
	}

	@Override
	public Result updateBottomLinkType(AccountInfo accountInfo, String AUTHORITY_CODE, Bottomlinktype bottomlinkType)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查
		if (StringUtils.isBlank(bottomlinkType.getTypename()) || bottomlinkType.getId() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		//名称重复检查
		BottomlinktypeExample bottomlinktypeExample = new BottomlinktypeExample();
		com.jy.entiy.system.web.bottomLink.BottomlinktypeExample.Criteria createCriteria = bottomlinktypeExample.createCriteria();
		createCriteria.andTypenameEqualTo(bottomlinkType.getTypename());
		createCriteria.andIdNotEqualTo(bottomlinkType.getId());
		int countByExample = bottomlinktypeMapper.countByExample(bottomlinktypeExample);
		if(countByExample > 0) {
			return Result.build(2004,400,"该类目名称已存在!");
		}
		int i = bottomlinktypeMapper.updateByPrimaryKeySelective(bottomlinkType);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "修改了一个底部链接类目 : [ ";
		log += StringUtils.isBlank(bottomlinkType.getTypename()) ? "" : "类目名称=" + bottomlinkType.getTypename() + ",";
		log += bottomlinkType.getId() == null ? "" : "类目id=" + bottomlinkType.getId() + ",";
		log += StringUtils.isBlank(bottomlinkType.getCreateby()) ? "" : "修改者=" + bottomlinkType.getUpdateby() + ",";
		log += bottomlinkType.getUpdatepersonid() == null ? "" : "修改者id=" + bottomlinkType.getUpdatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}


}
