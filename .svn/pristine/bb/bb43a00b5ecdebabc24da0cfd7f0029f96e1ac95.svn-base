package com.jy.service.content.navbarManage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.JsonUtils;
import com.jy.dao.content.columnManage.PagecolumnMapper;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.dao.content.file.file.UsefileMapper;
import com.jy.dao.content.navbarManage.BannerMapper;
import com.jy.dao.content.navbarManage.PageMapper;
import com.jy.dao.content.positionManage.ColumnpostionMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.columnManage.Pagecolumn;
import com.jy.entiy.content.columnManage.PagecolumnExample;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.entiy.content.navbarManage.Banner;
import com.jy.entiy.content.navbarManage.BannerExample;
import com.jy.entiy.content.navbarManage.Page;
import com.jy.entiy.content.navbarManage.PageExample;
import com.jy.entiy.content.navbarManage.PageExample.Criteria;
import com.jy.service.base.BaseService;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: NavbarManageServiceImpl
 * @Description:导航页管理实现类
 * @author: chenye
 * @date: 2018-09-18 10:21
 */
@Service
public class NavbarManageServiceImpl extends BaseService implements NavbarManageService {

	@Resource
	private PageMapper pageMapper;
	@Resource
	PagecolumnMapper pagecolumnMapper;
	@Resource
	private ColumnpostionMapper columnpostionMapper;
	@Resource
	private BannerMapper bannerMapper;
	@Resource
	private FileinfoMapper fileinfoMapper;
	@Resource
	private UsefileMapper usefileMapper;

	@Value("${REDIS_PASSWORD}")
	private String REDIS_PASSWORD;

	private static final String DB_LOG_TYPE = "DB_LOG_NAVBAR";

	private static final String TABLE_NAME = "Banner";

	/**
	 * 递归查找子导航页
	 * 
	 * @param pageid
	 *            当前导航页id
	 * @param rootPage
	 *            要查找的列表
	 * @return
	 */
	private static List<Page> getChildPage(Integer pageid, List<Page> rootPage) {
		// 子菜单
		List<Page> childList = new ArrayList<>();
		for (Page page : rootPage) {
			// 遍历所有节点，将父菜单id与传过来的id比较
			if (page.getParentid() != null) {
				if (page.getParentid() == pageid) {
					childList.add(page);
				}
			}
		}
		// 把子菜单的子菜单再循环一遍
		for (Page page : childList) {// 没有url子菜单还有子菜单
			if (page.getUrl() != null) {
				// 递归
				page.setSubordinateList(getChildPage(page.getPageid(), rootPage));
			}
		} // 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}

	public Result loadNavbar(String remark) {
		if (remark == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		PageExample pageExample = new PageExample();
		pageExample.setOrderByClause("DisplayOrder");
		com.jy.entiy.content.navbarManage.PageExample.Criteria createCriteria = pageExample.createCriteria();
		createCriteria.andRemarkEqualTo(remark);
		List<Page> pageList = pageMapper.selectByExample(pageExample);

		return Result.succee(pageList);

	}

	public Result getNavbarList() {

		// redis
		// 查询缓存
		try {
			String jsonP = jedisClient.hget("pageP", 1 + "", REDIS_PASSWORD);
			String jsonE = jedisClient.hget("pageE", 2 + "", REDIS_PASSWORD);
			String jsonW = jedisClient.hget("pageW", 3 + "", REDIS_PASSWORD);
			// 判断json是否为空
			if (StringUtils.isNotBlank(jsonP) && StringUtils.isNotBlank(jsonE) && StringUtils.isNotBlank(jsonW)) {
				// 把json转换成list
				List<Page> listP = JsonUtils.jsonToList(jsonP, Page.class);
				List<Page> listE = JsonUtils.jsonToList(jsonE, Page.class);
				List<Page> listW = JsonUtils.jsonToList(jsonW, Page.class);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("Plist", listP);
				map.put("Elist", listE);
				map.put("Wlist", listW);
				return Result.succee(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Page> ElistAll = new ArrayList<>();// 全部企业导航页
		List<Page> PlistALL = new ArrayList<>();// 全部个人导航页
		List<Page> WlistAll = new ArrayList<>();// 全部官网导航页

		List<Page> Elist = new ArrayList<>();// 分级后的企业导航页
		List<Page> Plist = new ArrayList<>();// 分级后的个人导航页
		List<Page> Wlist = new ArrayList<>();// 分级后的官网导航页
		PageExample pageExample = new PageExample();
		pageExample.setOrderByClause("DisplayOrder");
		List<Page> pageList = pageMapper.selectByExample(pageExample);// 全部导航页
		if (pageList == null) {
			return Result.build(ResultEnum.SELECT_NULL);
		}

		for (Page page : pageList) {
			if (page.getRemark().equals("P")) {// 取得全部个人导航页
				PlistALL.add(page);
			} else if (page.getRemark().equals("W")) {
				WlistAll.add(page);
			} else {
				ElistAll.add(page);
			}
		}

		for (Page page2 : PlistALL) {
			if (page2.getParentid() == null || page2.getParentid() == 0) {
				Plist.add(page2);// 得到个人顶级导航页
			}
		}

		for (Page page2 : ElistAll) {
			if (page2.getParentid() == null || page2.getParentid() == 0) {
				Elist.add(page2);// 得到企业顶级导航页
			}
		}

		for (Page page2 : WlistAll) {
			if (page2.getParentid() == null || page2.getParentid() == 0) {
				Wlist.add(page2);// 得到企业顶级导航页
			}
		}

		for (Page page2 : Plist) {
			if (getChildPage(page2.getPageid(), PlistALL) != null) {
				page2.setSubordinateList(getChildPage(page2.getPageid(), PlistALL));
			}
		}

		for (Page page2 : Elist) {
			if (getChildPage(page2.getPageid(), ElistAll) != null) {
				page2.setSubordinateList(getChildPage(page2.getPageid(), ElistAll));
			}
		}

		for (Page page2 : Wlist) {
			if (getChildPage(page2.getPageid(), WlistAll) != null) {
				page2.setSubordinateList(getChildPage(page2.getPageid(), WlistAll));
			}
		}

		// 向缓存中添加数据
		try {
			if (Plist != null && Elist != null && Wlist != null) {
				jedisClient.hset("pageP", 1 + "", JsonUtils.objectToJson(Plist), REDIS_PASSWORD);
				jedisClient.hset("pageE", 2 + "", JsonUtils.objectToJson(Elist), REDIS_PASSWORD);
				jedisClient.hset("pageW", 3 + "", JsonUtils.objectToJson(Wlist), REDIS_PASSWORD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Plist", Plist);
		map.put("Elist", Elist);
		map.put("Wlist", Wlist);
		return Result.succee(map);

	}

	public Result loadNavbarByType(String remark) {
		if (remark == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		PageExample pageExample = new PageExample();
		pageExample.setOrderByClause("DisplayOrder");
		com.jy.entiy.content.navbarManage.PageExample.Criteria createCriteria = pageExample.createCriteria();
		createCriteria.andRemarkEqualTo(remark);
		List<Page> pageList = pageMapper.selectByExample(pageExample);
		// Page page = new Page();
		// page.setRemark(remark);
		// page.setPageid(0);
		// page.setDisplayorder(0);
		// page.setParentid(0);
		// page.setPagename("顶级导航页");
		// pageList.add(0,page);
		return Result.succee(pageList);

	}

	@Override
	public Result getNavbarList(Integer page, Integer pageSize) {

		List<Page> list = new ArrayList<>();

		PageHelper.startPage(page, pageSize);
		PageExample pageExample = new PageExample();
		com.jy.entiy.content.navbarManage.PageExample.Criteria createCriteria = pageExample.createCriteria();
		createCriteria.andParentidEqualTo(0);
		pageExample.setOrderByClause("DisplayOrder");
		List<Page> parentList = pageMapper.selectByExample(pageExample);// 顶级导航页分页

		PageExample pageExample2 = new PageExample();
		pageExample2.setOrderByClause("DisplayOrder");
		List<Page> pageList = pageMapper.selectByExample(pageExample2);// 全部导航页
		// for (Page page2 : pageList) {
		// if (page2.getParentid() == null || page2.getParentid() == 0) {
		// list.add(page2);// 得到顶级导航页
		// }
		// }

		for (Page page2 : parentList) {
			if (getChildPage(page2.getPageid(), pageList) != null) {
				page2.setSubordinateList(getChildPage(page2.getPageid(), pageList));
			}
		}

		PageInfo<Page> info = new PageInfo<>(parentList);
		List<Page> rows = info.getList();
		long count = info.getTotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);

	}

	@Override
	public Result getNavbarInfo(Integer pageid) {

		if (pageid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Page page = pageMapper.selectByPrimaryKey(pageid);
		Integer parentid = page.getParentid();// 所属导航id
		if (parentid != null && parentid != 0) {
			Page selectByPrimaryKey = pageMapper.selectByPrimaryKey(parentid);
			if (selectByPrimaryKey != null) {
				page.setParentname(selectByPrimaryKey.getPagename());
			}

		} else {
			page.setParentname("顶级导航页");
		}
		BannerExample bannerExample = new BannerExample();
		com.jy.entiy.content.navbarManage.BannerExample.Criteria createCriteria = bannerExample.createCriteria();
		createCriteria.andPageidEqualTo(pageid);
		List<Banner> banners = bannerMapper.selectByExample(bannerExample);
		for (Banner banner : banners) {
			if (banner.getFileid() != null) {
				Long fileid = banner.getFileid();
				Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(fileid);
				if (fileinfo != null) {
					//获取文件地址
					if (StringUtils.isNotBlank(fileinfo.getFilefullpath())){
						//查询出阿里云文件服务器当前可用文件地址返回
						banner.setPicturePath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));
					}
				}

			}
		}
		//关闭阿里云OSS
		aliyunOSSClientUtil.closeOSSClient();
		if (banners != null && page != null) {
			page.setBanners(banners);
		}
		return Result.succee(page);
	}

	public Result checkDisplayorder(Integer parentid, String remark, Integer pageid, Integer displayorder) {
		// 参数非空检查
		if (StringUtils.isBlank(remark) || displayorder == null || parentid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		if (pageid == null) {
			PageExample pageExample = new PageExample();
			com.jy.entiy.content.navbarManage.PageExample.Criteria createCriteria = pageExample.createCriteria();
			createCriteria.andDisplayorderEqualTo(displayorder);
			createCriteria.andRemarkEqualTo(remark);
			createCriteria.andParentidEqualTo(parentid);
			List<Page> list = pageMapper.selectByExample(pageExample);
			if (list.size() != 0) {
				return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);
			}
		}

		if (pageid != null) {// 修改时检查序号
			Page selectByPrimaryKey = pageMapper.selectByPrimaryKey(pageid);
			if (selectByPrimaryKey.getDisplayorder() == displayorder) {
				return Result.succee();// 输入序号和原序号一样不会报序号已存在
			}
			PageExample pageExample = new PageExample();
			com.jy.entiy.content.navbarManage.PageExample.Criteria createCriteria = pageExample.createCriteria();
			createCriteria.andDisplayorderEqualTo(displayorder);
			createCriteria.andRemarkEqualTo(remark);
			createCriteria.andParentidEqualTo(parentid);
			List<Page> list = pageMapper.selectByExample(pageExample);
			if (list.size() != 0) {
				return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);
			}
		}

		return Result.succee();

	}

	@Override
	public Result insertNavbar(AccountInfo accountInfo, String AUTHORITY_CODE, Page page) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查
		if (StringUtils.isBlank(page.getPagename()) || page.getDisplayorder() == null
				|| StringUtils.isBlank(page.getUrl()) || StringUtils.isBlank(page.getRemark())) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		if (!page.getRemark().equals("P") && !page.getRemark().equals("E") && !page.getRemark().equals("W")) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		PageExample pageExample = new PageExample();
		com.jy.entiy.content.navbarManage.PageExample.Criteria createCriteria = pageExample.createCriteria();
		createCriteria.andDisplayorderEqualTo(page.getDisplayorder());
		List<Page> list = pageMapper.selectByExample(pageExample);
		if (list.size() != 0) {
			return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);
		}

		List<Banner> banners = page.getBanners();

		page.setCreateby(accountInfo.getAccount().getName());
		page.setCreatetime(new Date());
		page.setCreatepersonid(accountInfo.getAccount().getAccountid());

		int i = pageMapper.insertSelective(page);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		for (Banner banner : banners) {
			banner.setPageid(page.getPageid());
			banner.setCreateby(accountInfo.getAccount().getName());
			banner.setCreatepersonid(accountInfo.getAccount().getAccountid());
			banner.setCreatetime(new Date());
			int i2 = bannerMapper.insertSelective(banner);
			if (i2 < 1) {
				throw new MyException(ResultEnum.INSERT_SQL_ERROR);
			}
			if (banner.getFileid() != null) {// 将图片id插入文件引用表
				this.addUseFile(banner.getFileid(), TABLE_NAME, (long) banner.getBannerid());
			}
		}

		// 插入数据库操作日志
		String log = "添加了一个导航页 : [ ";
		log += StringUtils.isBlank(page.getPagename()) ? "" : "导航页名称=" + page.getPagename() + ",";
		log += page.getPageid() == null ? "" : "导航页id=" + page.getPageid() + ",";
		log += StringUtils.isBlank(page.getCreateby()) ? "" : "创建者=" + page.getCreateby() + ",";
		log += page.getCreatepersonid() == null ? "" : "创建者id=" + page.getCreatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result updateNavbar(AccountInfo accountInfo, String AUTHORITY_CODE, Page page) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 主键非空检查
		if (page.getPageid() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		// 排序码检查
		if(page.getDisplayorder() != null && page.getDisplayorder() > 1000) {
			return Result.build(20001,400,"排序号不能大于1000!");
		}
		
		// 查询当前页面旧的banner 列表
		BannerExample example2 = new BannerExample();
		com.jy.entiy.content.navbarManage.BannerExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andPageidEqualTo(page.getPageid());
		List<Banner> old_banner_list = bannerMapper.selectByExample(example2);

		Page selectByPrimaryKey = pageMapper.selectByPrimaryKey(page.getPageid());
		if (selectByPrimaryKey == null) {// 没有该导航页
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		if (page.getDisplayorder() != null) {
			PageExample pageExample = new PageExample();
			com.jy.entiy.content.navbarManage.PageExample.Criteria createCriteria = pageExample.createCriteria();
			createCriteria.andDisplayorderEqualTo(page.getDisplayorder());
			createCriteria.andParentidEqualTo(page.getParentid());
			createCriteria.andPageidNotEqualTo(page.getPageid());
			int count = pageMapper.countByExample(pageExample);
			if (count != 0) {
				return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);
			}
//			// 二级导航排序拼接
//			if (selectByPrimaryKey.getParentid() != null && selectByPrimaryKey.getParentid() != 0) {
//				String Parentid = String.valueOf(selectByPrimaryKey.getParentid());
//				String Displayorder = String.valueOf(page.getDisplayorder());
//				String str = Parentid + "0" + Displayorder;
//				page.setDisplayorder(Integer.parseInt(str));
//			}
		}

		List<Banner> banners = page.getBanners();

		page.setUpdateby(accountInfo.getAccount().getName());
		page.setUpdatetime(new Date());
		page.setUpdatepersonid(accountInfo.getAccount().getAccountid());

		int i = pageMapper.updateByPrimaryKeySelective(page);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		for (Banner banner : banners) {
			if (banner.getFileid() == null) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			if (banner.getFileid() != null) {
				Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(banner.getFileid());
				if (fileinfo != null) {

					banner.setPageid(page.getPageid());
					banner.setCreateby(accountInfo.getAccount().getName());
					banner.setCreatepersonid(accountInfo.getAccount().getAccountid());
					banner.setCreatetime(new Date());
					i = bannerMapper.insertSelective(banner);
					System.out.println("新增了banner===================================" + banner.getBannerid());
					this.addUseFile(banner.getFileid(), TABLE_NAME, (long) banner.getBannerid());

				}

			}

		}

		for (Banner banner2 : old_banner_list) {
			int i2 = bannerMapper.deleteByPrimaryKey(banner2.getBannerid());

			this.deleteFile(accountInfo, DB_LOG_TYPE, banner2.getFileid(), TABLE_NAME, (long) banner2.getBannerid());
		}

		
		// 清除redis缓存
		try {
			
				jedisClient.del("pageP",REDIS_PASSWORD);
				jedisClient.del("pageE",REDIS_PASSWORD);
				jedisClient.del("pageW",REDIS_PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 插入数据库操作日志
		String log = "修改了一个导航页 : [ ";
		log += StringUtils.isBlank(page.getPagename()) ? "" : "导航页名称=" + page.getPagename() + ",";
		log += page.getPageid() == null ? "" : "导航页id=" + page.getPageid() + ",";
		log += StringUtils.isBlank(page.getUpdateby()) ? "" : "修改者=" + page.getUpdateby() + ",";
		log += page.getUpdatepersonid() == null ? "" : "修改者id=" + page.getUpdatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	/**
	 * 删除导航页 删除导航页之前要先删除导航下的banner,删除所属导航页的栏目,所属栏目的推荐位,以及他们引用的图片文件
	 * 
	 * 
	 */

	@Override
	public Result deleteNavbar(AccountInfo accountInfo, String AUTHORITY_CODE, Integer pageid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (pageid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		Page page = pageMapper.selectByPrimaryKey(pageid);
		if (page == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		BannerExample bannerExample = new BannerExample();
		com.jy.entiy.content.navbarManage.BannerExample.Criteria createCriteria2 = bannerExample.createCriteria();
		createCriteria2.andPageidEqualTo(pageid);

		List<Banner> bannerList = bannerMapper.selectByExample(bannerExample);
		if (bannerList.size() != 0) {// 有banner才删除

			int deleteBanner = bannerMapper.deleteByExample(bannerExample);// 删除该导航页下的banner
			// if (deleteBanner < 1) {
			// throw new MyException(ResultEnum.DELETE_SQL_ERROR);
			// }
			for (Banner banner : bannerList) {
				if (banner.getFileid() != null) {
					this.deleteFile(accountInfo, DB_LOG_TYPE, banner.getFileid(), TABLE_NAME,
							(long) banner.getBannerid());
				}

			}
		}
		PagecolumnExample pagecolumnExample = new PagecolumnExample();
		com.jy.entiy.content.columnManage.PagecolumnExample.Criteria createCriteria = pagecolumnExample
				.createCriteria();
		createCriteria.andPageidEqualTo(pageid);

		List<Pagecolumn> pagecolumnList = pagecolumnMapper.selectByExample(pagecolumnExample);// 该导航下的所有栏目

		if (pagecolumnList.size() != 0) {// 有栏目才删除栏目
			return Result.build(1002, 500, "请先删除导航下的栏目!");

			// for (Pagecolumn pagecolumn : pagecolumnList) {
			// ColumnpostionExample columnpostionExample = new ColumnpostionExample();
			// com.jy.entiy.position.ColumnpostionExample.Criteria createCriteria3 =
			// columnpostionExample
			// .createCriteria();
			// createCriteria3.andPagecolumnidEqualTo(pagecolumn.getPagecolumnid());
			//
			// List<Columnpostion> columnpostionList =
			// columnpostionMapper.selectByExample(columnpostionExample);
			// if(columnpostionList.size() != 0) {//有推荐位才删除推荐位
			// int deletePostion =
			// columnpostionMapper.deleteByExample(columnpostionExample);// 删除该导航下的所有推荐位
			// if (deletePostion < 1) {
			// throw new MyException(ResultEnum.DELETE_SQL_ERROR);
			// }
			// }
			//
			//
			// }
			//
			// int deleteColumn = pagecolumnMapper.deleteByExample(pagecolumnExample);
			// if (deleteColumn < 1) {
			// throw new MyException(ResultEnum.DELETE_SQL_ERROR);
			// }

		}

		int i = pageMapper.deleteByPrimaryKey(pageid);// 删除失败需要回滚
		if (i < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "删除了一个导航页 :  导航页id为";
		log += pageid;
		log += "删除者";
		log += accountInfo.getAccount().getName();

		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result deleteBanner(AccountInfo accountInfo, String AUTHORITY_CODE, Integer bannerid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (bannerid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		int i = bannerMapper.deleteByPrimaryKey(bannerid);
		if (i < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}

		Banner banner = bannerMapper.selectByPrimaryKey(bannerid);

		if (banner.getFileid() != null) {
			this.deleteFile(accountInfo, DB_LOG_TYPE, banner.getFileid(), TABLE_NAME, (long) banner.getBannerid());
		}
		return Result.succee();
	}

	// 根据导航页id获取子导航
	@Override
	public Result getCpage(Integer pageid) {
		if (pageid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		PageExample pageExample = new PageExample();
		Criteria createCriteria = pageExample.createCriteria();
		createCriteria.andParentidEqualTo(pageid);
		List<Page> Cpage = pageMapper.selectByExample(pageExample);
		return Result.succee(Cpage);
	}

}
