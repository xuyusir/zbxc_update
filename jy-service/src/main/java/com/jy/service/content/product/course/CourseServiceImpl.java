package com.jy.service.content.product.course;

import com.aliyuncs.vod.model.v20170321.GetVideoInfoResponse;
import com.github.pagehelper.PageHelper;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.DateUtils;
import com.jy.common.utils.LiuUtils;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.dao.content.file.file.UsefileMapper;
import com.jy.dao.content.product.course.*;
import com.jy.dao.content.product.product.ProductbindcousreMapper;
import com.jy.dao.content.product.product.ProductinfoMapper;
import com.jy.dao.function.person.memberFunction.PersonserviceapplicationMapper;
import com.jy.dao.system.dictionaries.DictionariesMapper;
import com.jy.dao.system.select.ApplicationstatusMapper;
import com.jy.dao.vedio.SectionvediobindMapper;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.entiy.content.file.file.Usefile;
import com.jy.entiy.content.file.file.UsefileExample;
import com.jy.entiy.content.product.course.*;
import com.jy.entiy.content.product.product.Productbindcousre;
import com.jy.entiy.content.product.product.ProductbindcousreExample;
import com.jy.entiy.content.product.product.Productinfo;
import com.jy.entiy.function.person.memberFunction.Personserviceapplication;
import com.jy.entiy.system.select.Applicationstatus;
import com.jy.service.base.BaseService;
import com.jy.service.content.product.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.ParseException;
import java.util.*;

/**
 * 课程信息业务逻辑层实现类
 *
 * @author Administrator
 *
 */
@Service
public class CourseServiceImpl extends BaseService implements CourseService {

	@Resource
	PersonserviceapplicationMapper personserviceapplicationMapper;

	@Resource
	CourseMapper courseMapper;

	@Resource
	CoursechapterMapper chapterMapper;

	@Resource
	SectionMapper sectionMapper;

	@Resource
	PersoncoursenoteMapper personcoursenoteMapper;

	@Resource
	CoursefeedbackMapper coursefeedbackMapper;

	@Resource
	PersoncourseMapper personCourseMapper;

	@Resource
	DictionariesMapper dictionariesMapper;

	@Resource
	ProductbindcousreMapper productbindcousreMapper;

	@Resource
	SectionvediobindMapper sectionvediobindMapper;

	@Resource
	ApplicationstatusMapper applicationstatusMapper;

	@Resource
	FileinfoMapper fileinfoMapper;

	@Resource
	SectionremembertimeMapper sectionremembertimeMapper;

	@Resource
	UsefileMapper usefileMapper;

	@Resource
	AccountMapper accountMapper;

	@Resource
	ProductinfoMapper productinfoMapper;

	// 数据库操作日志类型
	private static final String DB_LOG_TYPE = "DB_LOG_COURSE";

	/**
	 * 查询课程信息
	 *
	 * @throws MyException
	 */
	@Override
	public Result getCourse(Map<String, Object> param, AccountInfo accountInfo) throws MyException {
		if (param.get("productId") != null) {
			ProductbindcousreExample example = new ProductbindcousreExample();
			com.jy.entiy.content.product.product.ProductbindcousreExample.Criteria criteria = example.createCriteria();
			criteria.andProductidEqualTo((Long) param.get("ProductId"));
			List<Productbindcousre> productbindcousres = productbindcousreMapper.selectByExample(example);

			List<Long> longs = new ArrayList<>();
			for (Productbindcousre productbindcousre : productbindcousres) {
				longs.add(productbindcousre.getCourseid());
			}
			CourseExample example2 = new CourseExample();
			com.jy.entiy.content.product.course.CourseExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andCourseidIn(longs);
			List<Course> courses = courseMapper.selectByExample(example2);
			return Result.succee(courses);

		} else {

			CourseExample example = new CourseExample();
			com.jy.entiy.content.product.course.CourseExample.Criteria criteria = example.createCriteria();
			if (param.get("CourseTitle") != null) {
				criteria.andCoursetitleLike(param.get("CourseTitle").toString());
			}
			if (param.get("CourseID") != null) {
				List<String> ids = LiuUtils.getIDS(param.get("CourseID").toString());
				List<Long> longs = new ArrayList<>();
				for (String string : ids) {
					longs.add(Long.valueOf(string));
				}
				criteria.andCourseidIn(longs);
			}
			int count = courseMapper.countByExample(example);
			if (param.get("page") != null) {
				PageHelper.startPage((Integer) param.get("page"), (Integer) param.get("pageSize"));
			}
			example.setOrderByClause("CreateTime DESC");
			List<Course> courses = courseMapper.selectByExample(example);

			List<Map<String, Object>> list = new ArrayList<>();
			for (Course course : courses) {
				Map<String, Object> map = new HashMap<>();
				map.put("course", course);
				if (course.getFileid() != null) {
					map.put("file", fileinfoMapper.selectByPrimaryKey(course.getFileid()));
				}
				if (course.getImage() != null) {
					Fileinfo file = fileinfoMapper.selectByPrimaryKey(course.getImage());
					file.setFilepath(aliyunOSSClientUtil.getUrl(file.getFilefullpath()));
					map.put("image", fileinfoMapper.selectByPrimaryKey(course.getImage()));
				}
				list.add(map);
			}
			aliyunOSSClientUtil.closeOSSClient();
			Map<String, Object> map = new HashMap<>();
			map.put("rows", list);
			map.put("count", count);
			if (param.get("CourseID") != null && list.size() < 2) {
				return Result.succee(list.get(0));
			}
			return Result.succee(map);
		}

	}

	/**
	 * 根据课程id查询课程章目信息
	 */
	@Override
	public Result getCourseCharpter(Long CourseID) {

		Course course = courseMapper.selectByPrimaryKey(CourseID);
		if (course == null) {
			return Result.build(ResultEnum.SELECT_SQL_ERROR);
		}
		Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(course.getFileid());

		CoursechapterExample example = new CoursechapterExample();
		com.jy.entiy.content.product.course.CoursechapterExample.Criteria criteria = example.createCriteria();
		criteria.andCourseidEqualTo(CourseID);

		example.setOrderByClause("DisplayOrder");
		List<Coursechapter> coursechapters = chapterMapper.selectByExample(example);
		List<Map<String, Object>> list = new ArrayList<>();
		for (Coursechapter coursechapter : coursechapters) {
			Map<String, Object> map = new HashMap<>();
			map.put("chapters", coursechapter);
			map.put("fileinfo", fileinfo);
			list.add(map);
		}

		return Result.succee(list);
	}

	/**
	 * 根据章目Id获取课程章节信息
	 *
	 * @throws MyException
	 */
	@Override
	public Result getCourseSection(Long CharpterID, AccountInfo accountInfo) throws MyException {
		SectionExample example = new SectionExample();
		com.jy.entiy.content.product.course.SectionExample.Criteria criteria = example.createCriteria();
		criteria.andCharpteridEqualTo(CharpterID);
		List<Personcourse> personcourses = new ArrayList<>();

		if (accountInfo == null) {
			return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
		}
		Result result = checkAuthority(accountInfo, AuthorityCode.SECTION_SELECT);
		int flag = -1;
		if (result.getStatus() != 200) {// 没有权限，则是注册用户，只能查看个人课程表中的章节
			PersoncourseExample example2 = new PersoncourseExample();
			com.jy.entiy.content.product.course.PersoncourseExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
			personcourses = personCourseMapper.selectByExample(example2);
			Coursechapter coursechapter = chapterMapper.selectByPrimaryKey(CharpterID);

			for (Personcourse personcourse : personcourses) {// 循环个人课表，确定是否有查看权限
				if (!personcourse.getCourseid().equals(coursechapter.getCourseid())) {
					return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
				} else {
					flag = 1;
				}

			}
		}

		example.setOrderByClause("DisplayOrder");
		List<Section> sections = sectionMapper.selectByExample(example);
		List<Map<String, Object>> list = new ArrayList<>();

		for (Section section : sections) {// 添加视频信息
			Map<String, Object> map = new HashMap<>();
			map.put("section", section);
			if (section.getFileid() != null) {
				Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(section.getFileid());
				fileinfo.setFilepath(super.getBASE64Encoder(fileinfo.getFilefullpath()));
				map.put("fileinfo", fileinfo);
			}
			if (flag == 1) {// 个人用户，添加记忆播放信息
				SectionremembertimeExample example2 = new SectionremembertimeExample();
				com.jy.entiy.content.product.course.SectionremembertimeExample.Criteria criteria2 = example2
						.createCriteria();
				criteria2.andPersoncourseidEqualTo(personcourses.get(0).getPersoncourseid());
				criteria2.andSectionidEqualTo(section.getSectionid());
				List<Sectionremembertime> sectionremembertimes = sectionremembertimeMapper.selectByExample(example2);
				if (sectionremembertimes.size() != 1) {
					return Result.build(ResultEnum.SELECT_SQL_ERROR);
				}
				map.put("sectionremembertimes", sectionremembertimes);
			}
			list.add(map);
		}
		return Result.succee(list);
	}

	/**
	 * 添加课程信息
	 *
	 * @param param
	 * @param account
	 * @return
	 * @throws MyException
	 */
	@Override
	public Result addCourse(Map<String, Object> param, AccountInfo account) throws MyException {

		// 检查权限
		Result result = checkAuthority(account, AuthorityCode.COURSE_ADD);
		if (result.getStatus() != 200) {
			return result;
		}
		Course course = new Course();
		course.setCoursetitle((String) param.get("CourseTitle"));
		course.setCourseabstract((String) param.get("CourseAbstract"));
		course.setCreatetime(new Date());
		course.setCreatepersonid(account.getAccount().getAccountid());
		course.setFileid((Long) param.get("FileID"));
		course.setValiddays((Integer) param.get("ValidDays"));
		course.setImage((Long) param.get("Image"));

		int i = courseMapper.insertSelective(course);

		if (i < 1) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 添加中间表信息
		if (param.get("FileID") != null) {
			try {
				super.addUseFile((Long) param.get("FileID"), "Course", course.getCourseid());
			} catch (MyException e) {
				e.printStackTrace();
			}
		}

		// 添加中间表信息
		if (param.get("Image") != null) {
			try {
				super.addUseFile((Long) param.get("Image"), "Course", course.getCourseid());
			} catch (MyException e) {
				e.printStackTrace();
			}
		}

		// 获取插入课程ID并将数据库操作信息存入数据库
		String log = "id为[" + account.getAccount().getAccountid() + "]的用户添加了课程，课程ID为[" + course.getCourseid()
				+ "]课程编号为[" + param.get("CourseCode") + "]";
		try {
			this.dbLog(account.getAccount().getAccountid(), account.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
			e.printStackTrace();
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	/**
	 * 添加课程章目信息
	 *
	 * @param param
	 * @param account
	 * @return
	 * @throws MyException
	 */
	@Override
	public Result addCourseCharpter(Map<String, Object> param, AccountInfo account) throws MyException {

		// 检查权限
		Result result = checkAuthority(account, AuthorityCode.COURSE_CHAPTER_ADD);
		if (result.getStatus() != 200) {
			return result;
		}
		// 查询最大排序码
		CoursechapterExample example = new CoursechapterExample();
		com.jy.entiy.content.product.course.CoursechapterExample.Criteria criteria = example.createCriteria();
		criteria.andCourseidEqualTo((Long) param.get("CourseID"));
		example.setOrderByClause("DisplayOrder DESC");
		List<Coursechapter> coursechapters = chapterMapper.selectByExample(example);

		Coursechapter chapter = new Coursechapter();
		chapter.setCourseid((Long) param.get("CourseID"));
		chapter.setCharptertitle((String) param.get("CharpterTitle"));
		chapter.setCreatetime(new Date());
		chapter.setCreateby(account.getAccount().getName());
		chapter.setCreatepersonid(account.getAccount().getAccountid());
		if (coursechapters.size() > 0) {
			chapter.setDisplayorder(coursechapters.get(0).getDisplayorder() + 1);
		} else {
			chapter.setDisplayorder(1);
		}

		chapterMapper.insertSelective(chapter);

		String log = "id为[" + account.getAccount().getAccountid() + "]的用户添加了课程章目，章目ID为[" + chapter.getCharpterid()
				+ "]课程ID为[" + param.get("CourseID") + "]";
		try {
			this.dbLog(account.getAccount().getAccountid(), account.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result addSection(Map<String, Object> param, AccountInfo account) throws MyException {

		// 检查权限
		Result result = checkAuthority(account, AuthorityCode.SECTION_ADD);
		if (result.getStatus() != 200) {
			return result;
		}
		// 查询排序码
		SectionExample example = new SectionExample();
		com.jy.entiy.content.product.course.SectionExample.Criteria criteria = example.createCriteria();
		criteria.andCharpteridEqualTo((Long) param.get("CharpterID"));
		example.setOrderByClause("DisplayOrder DESC");
		List<Section> sections = sectionMapper.selectByExample(example);

		Section section = new Section();
		section.setCharpterid((Long) param.get("CharpterID"));
		section.setSectiontitle((String) param.get("SectionTitle"));
		section.setCreateby(account.getAccount().getName());
		section.setCreatetime(new Date());
		section.setCreatepersonid(account.getAccount().getAccountid());
		section.setIsfree((String) param.get("IsFree"));
		section.setFileid((Long) param.get("FileID"));

		if (sections.size() > 0) {
			section.setDisplayorder(sections.get(0).getDisplayorder() + 1);
		} else {
			section.setDisplayorder(1);
		}

		int i = sectionMapper.insertSelective(section);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		if (section.getFileid() != null) {
			super.addUseFile(section.getFileid(), "Section", section.getSectionid());
		}

		// 获取插入课程章目ID并将数据库操作信息存入数据库
		String log = "id为[" + account.getAccount().getAccountid() + "]的用户添加了课程章节，章节ID为[" + section.getSectionid()
				+ "]，章目ID为[" + param.get("CharpterID") + "]";
		try {
			this.dbLog(account.getAccount().getAccountid(), account.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	/**
	 * 删除课程信息
	 *
	 * @throws MyException
	 */
	@Override
	public Result deleteCourse(AccountInfo info, String CourseIDs) throws MyException {

		// 检查权限
		Result result = checkAuthority(info, AuthorityCode.COURSE_DELETE);
		if (result.getStatus() != 200) {
			return result;
		}
		List<String> strings = LiuUtils.getIDS(CourseIDs);
		int j = 0;
		for (String string : strings) {
			Long CourseID = Long.valueOf(string);
			// 查询绑定情况，若是绑定有产品则不能删除
			ProductbindcousreExample example1 = new ProductbindcousreExample();
			com.jy.entiy.content.product.product.ProductbindcousreExample.Criteria criteria1 = example1
					.createCriteria();
			criteria1.andCourseidEqualTo(CourseID);
			List<Productbindcousre> productbindcousres = productbindcousreMapper.selectByExample(example1);
			if (productbindcousres.size() > 0) {
				j = j + 1;
				continue;
			}

			// 查询课程信息
			Course course = courseMapper.selectByPrimaryKey(CourseID);

			if (course.getFileid() != null) {
				deleteFile(info, DB_LOG_TYPE, course.getFileid(), "Course", CourseID);
			}

			if (course.getImage() != null) {
				deleteFile(info, DB_LOG_TYPE, course.getImage(), "Course", CourseID);
			}

			/*// 循环删除章目信息
			CoursechapterExample example = new CoursechapterExample();
			com.jy.entiy.content.product.course.CoursechapterExample.Criteria criteria = example.createCriteria();
			criteria.andCourseidEqualTo(CourseID);
			List<Coursechapter> coursechapters = chapterMapper.selectByExample(example);
			for (Coursechapter coursechapter : coursechapters) {
				deleteCourseCharpter(info, coursechapter.getCharpterid());
			}*/

			// 删除课程信息
			int i = courseMapper.deleteByPrimaryKey(CourseID);

			if (i < 0) {
				return Result.build(ResultEnum.DELETE_SQL_ERROR);
			}

			// 插入数据库日志
			String log = "用户ID为[" + info.getAccount().getAccountid() + "]的用户删除了ID为[" + CourseID + "]的课程！";
			try {
				this.dbLog(info.getAccount().getAccountid(), info.getAccount().getName(), log, DB_LOG_TYPE);
			} catch (MyException e) {
				e.printStackTrace();
				return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
			}
		}

		if (j > 0) {
			return Result.build(ResultEnum.COURSR_DELETE_FAIL);
		} else {
			return Result.build(ResultEnum.SUCCESS);
		}

	}

	/**
	 * 删除章目信息
	 *
	 * @throws MyException
	 */
	@Override
	public Result deleteCourseCharpter(AccountInfo info, Long CharpterID) throws MyException {

		// 检查权限
		Result result = checkAuthority(info, AuthorityCode.COURSE_CHAPTER_DELETE);
		if (result.getStatus() != 200) {
			return result;
		}

		// 循环删除章节
		SectionExample example = new SectionExample();
		com.jy.entiy.content.product.course.SectionExample.Criteria criteria = example.createCriteria();
		criteria.andCharpteridEqualTo(CharpterID);
		List<Section> sections = sectionMapper.selectByExample(example);
		if (sections.size()>0) {
			return Result.build(ResultEnum.DELETE_SECTION_FIRST);
		}

		int i = chapterMapper.deleteByPrimaryKey(CharpterID);

		if (i < 1) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}

		// 数据库插入日志信息
		String log = "用户ID为[" + info.getAccount().getAccountid() + "]的用户删除了章目ID为[" + CharpterID + "]的课程章目！";
		try {
			this.dbLog(info.getAccount().getAccountid(), info.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);

		}

		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result deleteSection(AccountInfo info, Long SectionID) throws MyException {

		// 检查权限
		Result result = checkAuthority(info, AuthorityCode.SECTION_DELETE);
		if (result.getStatus() != 200) {
			return result;
		}

		/*
		 * // 同步删除视频信息 SectionvediobindExample example = new SectionvediobindExample();
		 * com.jy.entiy.vedio.SectionvediobindExample.Criteria criteria =
		 * example.createCriteria(); criteria.andSectionidEqualTo(SectionID);
		 * List<Sectionvediobind> list =
		 * sectionvediobindMapper.selectByExample(example); for (Sectionvediobind
		 * sectionvediobind : list) { VedioServiceImpl vedioServiceImpl = new
		 * VedioServiceImpl(); vedioServiceImpl.deleteVedio(info, CONTROLLER_CODE,
		 * sectionvediobind.getVedioid()); }
		 */

		Section section = sectionMapper.selectByPrimaryKey(SectionID);
		int i = sectionMapper.deleteByPrimaryKey(SectionID);
		if (i < 1) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}

		// 删除视频文件信息
		/*
		 * if (section.getFileid() != null) { try { super.deleteFile(info, DB_LOG_TYPE,
		 * section.getFileid(), "Section", SectionID); } catch (MyException e) {
		 * e.printStackTrace(); } }
		 */

		// 删除视频引用信息
		if (section.getFileid() != null) {
			UsefileExample example = new UsefileExample();
			UsefileExample.Criteria criteria = example.createCriteria();
			criteria.andTablenameEqualTo("Section");
			criteria.andFileidEqualTo(section.getFileid());
			criteria.andUseidEqualTo(section.getSectionid());
			usefileMapper.deleteByExample(example);
		}

		// 数据库插入日志信息
		String log = "用户ID为[" + info.getAccount().getAccountid() + "]的用户删除了课程章节ID为[" + SectionID + "]的课程章节！";
		try {
			this.dbLog(info.getAccount().getAccountid(), info.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	/**
	 * 修改课程信息
	 *
	 * @throws MyException
	 */
	@Override
	public Result updateCourse(AccountInfo info, Course course) throws MyException {

		Result result = checkAuthority(info, AuthorityCode.COURSE_UPDATE);
		if (result.getStatus() != 200) {
			return result;
		}

		Course OldCourse = courseMapper.selectByPrimaryKey(course.getCourseid());
		if (  OldCourse.getFileid() != null) {
			if (course.getFileid() == null || course.getFileid().equals(OldCourse.getFileid())){
				deleteFile(info, DB_LOG_TYPE, OldCourse.getFileid(), "Course", OldCourse.getCourseid());
			}
			if (course.getFileid() != null){
				addUseFile(course.getFileid(), "Course", OldCourse.getCourseid());
			}
		}

		if ( course.getImage() != null ) {
			if (OldCourse.getImage() != null&& !course.getImage().equals(OldCourse.getImage())) {
				deleteFile(info, DB_LOG_TYPE, OldCourse.getImage(), "Course", OldCourse.getCourseid());
			}

			addUseFile(course.getImage(), "Course", OldCourse.getCourseid());
		}
		course.setCreatetime(OldCourse.getCreatetime());
		course.setCreatepersonid(OldCourse.getCreatepersonid());
		course.setUpdatepersonid(info.getAccount().getAccountid());
		course.setUpdatetime(new Date());

		courseMapper.updateByPrimaryKey(course);

		// 插入数据可操作日志
		String log = "ID为[" + info.getAccount().getAccountid() + "]的用户修改了ID为[" + course.getCourseid() + "]的课程信息！";
		try {
			this.dbLog(info.getAccount().getAccountid(), info.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result updateChapter(AccountInfo info, Coursechapter chapter) throws MyException {

		Result result = checkAuthority(info, AuthorityCode.COURSE_CHAPTER_UPDATE);
		if (result.getStatus() != 200) {
			return result;
		}

		chapterMapper.updateByPrimaryKeySelective(chapter);

		// 插入数据可操作日志
		String log = "ID为[" + info.getAccount().getAccountid() + "]的用户修改了ID为[" + chapter.getCharpterid() + "]的课程章目信息！";
		try {
			this.dbLog(info.getAccount().getAccountid(), info.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result updateSection(AccountInfo info, Section section) throws MyException {
		Result result = checkAuthority(info, AuthorityCode.SECTION_UPDATE);
		if (result.getStatus() != 200) {
			return result;
		}

		/*
		 * // 同步修改绑定内容 if (section.getIsfree() != null) { SectionvediobindExample
		 * example = new SectionvediobindExample();
		 * com.jy.entiy.vedio.SectionvediobindExample.Criteria criteria =
		 * example.createCriteria();
		 * criteria.andSectionidEqualTo(section.getSectionid()); List<Sectionvediobind>
		 * list = sectionvediobindMapper.selectByExample(example); for (Sectionvediobind
		 * sectionvediobind : list) { sectionvediobind.setIsfree(section.getIsfree());
		 * sectionvediobindMapper.updateByPrimaryKeySelective(sectionvediobind); } }
		 */
		Section section2 = sectionMapper.selectByPrimaryKey(section.getSectionid());
		if (section2.getFileid() != null && section.getFileid() != null) {
			// 删除文件引用
			UsefileExample example = new UsefileExample();
			com.jy.entiy.content.file.file.UsefileExample.Criteria criteria = example.createCriteria();
			criteria.andTablenameEqualTo("Section");
			criteria.andFileidEqualTo(section2.getFileid());
			criteria.andUseidEqualTo(section2.getSectionid());
			List<Usefile> list = usefileMapper.selectByExample(example);
			if (list.size() != 0) {
				int i = usefileMapper.deleteByPrimaryKey(list.get(0).getId());
				if (i < 1) {
					System.err.println("删除文件引用错误。。。。。。。。。。。。。。。。。。。。");
					throw new MyException(ResultEnum.DELETE_SQL_ERROR);
				}
			}
		}

		int i = sectionMapper.updateByPrimaryKeySelective(section);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		if (section2.getFileid() != null) {
			deleteFile(info, DB_LOG_TYPE, section2.getFileid(), "Section", section.getSectionid());
		}

		if (section.getFileid() != null) {// 绑定视频信息，添加中间表
			super.addUseFile(section.getFileid(), "Section", section.getSectionid());
		}

		// 插入数据可操作日志
		String log = "ID为[" + info.getAccount().getAccountid() + "]的用户修改了ID为[" + section.getSectionid() + "]的课程章节信息！";
		try {
			this.dbLog(info.getAccount().getAccountid(), info.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	/********************************
	 * 笔记部分
	 ************************************************************/

	/**
	 * 添加笔记
	 *
	 * @throws MyException
	 */
	@Override
	public Result addPersonCourseNote(Personcoursenote note) throws MyException {

		Section section = sectionMapper.selectByPrimaryKey(note.getSectionid());
		Coursechapter coursechapter = chapterMapper.selectByPrimaryKey(section.getCharpterid());
		note.setCharpterid(section.getCharpterid());
		note.setCourseid(coursechapter.getCourseid());

		int i = personcoursenoteMapper.insertSelective(note);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据可操作日志
		String log = "ID为[" + note.getAccountid() + "]的用户新增了笔记，笔记主键为[" + note.getCourseid() + "]";
		try {
			this.dbLog(note.getAccountid(), note.getCreateby(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result deletePersonCourseNote(AccountInfo accountInfo, Long CourseNoteID) {

		PersoncoursenoteExample example = new PersoncoursenoteExample();
		com.jy.entiy.content.product.course.PersoncoursenoteExample.Criteria criteria = example.createCriteria();
		criteria.andCoursenoteidEqualTo(CourseNoteID);
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());

		personcoursenoteMapper.deleteByExample(example);

		// 插入数据可操作日志
		String log = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户删除了笔记，笔记主键为[" + CourseNoteID + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result updatePersonCourseNote(Personcoursenote note) {

		int temp = personcoursenoteMapper.updateByPrimaryKeySelective(note);

		if (temp < 1) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}

		// 插入数据可操作日志
		String log = "ID为[" + note.getAccountid() + "]的用户删除了笔记，笔记主键为[" + note.getCoursenoteid() + "]";
		try {
			this.dbLog(note.getAccountid(), note.getUpdateby(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result getPersonCourseNote(Personcoursenote note) {

		PersoncoursenoteExample example = new PersoncoursenoteExample();
		com.jy.entiy.content.product.course.PersoncoursenoteExample.Criteria criteria = example.createCriteria();

		if (note.getCoursenoteid() != null) {
			criteria.andCoursenoteidEqualTo(note.getCoursenoteid());
		}
		criteria.andAccountidEqualTo(note.getAccountid());
		criteria.andCreatepersonidEqualTo(note.getAccountid());
		if (note.getNotetitle() != null) {
			String string = "%" + note.getNotetitle() + "%";
			criteria.andNotetitleLike(string);
		}
		if (note.getCourseid() != null) {
			criteria.andCourseidEqualTo(note.getCourseid());
		}
		if (note.getCharpterid() != null) {
			criteria.andCharpteridEqualTo(note.getCharpterid());
		}
		if (note.getSectionid() != null) {
			criteria.andSectionidEqualTo(note.getSectionid());
		}
		List<Personcoursenote> notes = personcoursenoteMapper.selectByExample(example);

		return Result.succee(notes);
	}

	@Override
	public Result addCourseFeedback(AccountInfo accountInfo, Coursefeedback feedbake,String flag) {

		CoursefeedbackExample example = new CoursefeedbackExample();
		com.jy.entiy.content.product.course.CoursefeedbackExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria.andCourseidEqualTo(feedbake.getCourseid());
		List<Coursefeedback> list = coursefeedbackMapper.selectByExample(example);
		if(list.size()>0) {
			return Result.build(ResultEnum.OF_PEOPLE_RECOMMENDED_THIS_PRODUCT);
		}
		if(flag != null && flag.equals("1")) {
			return Result.succee();
		}
		feedbake.setAccountid(accountInfo.getAccount().getAccountid());
		feedbake.setCreateby(accountInfo.getAccount().getName());
		feedbake.setCreatepersonid(accountInfo.getAccount().getAccountid());
		feedbake.setCreatetime(new Date());

		int count = coursefeedbackMapper.insertSelective(feedbake);
		if (count < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据可操作日志
		String log = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户添加了课程反馈信息了，课程反馈信息主键为["
				+ feedbake.getCoursefeedbackid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	/**
	 * 查询课程反馈信息
	 */
	@Override
	public Result getCourseFeedback(Map<String, Object> param) {

		CoursefeedbackExample example = new CoursefeedbackExample();
		com.jy.entiy.content.product.course.CoursefeedbackExample.Criteria criteria = example.createCriteria();
		if (param.get("CourseID") != null) {
			criteria.andCourseidEqualTo((Long) param.get("CourseID"));

		}
		int count = coursefeedbackMapper.countByExample(example);
		if (param.get("pageSize") != null) {
			PageHelper.startPage((Integer) param.get("page"), (Integer) param.get("pageSize"));
		}

		List<Coursefeedback> list = coursefeedbackMapper.selectByExample(example);
		List<Map<String, Object>> list2 = new ArrayList<>();
		for (Coursefeedback coursefeedback : list) {
			Map<String, Object> map = new HashMap<>();
			map.put("coursefeedback", coursefeedback);
			Account account = accountMapper.selectByPrimaryKey(coursefeedback.getAccountid());
			if (account != null) {
				map.put("accountName", account.getName());
			}
			map.put("course", courseMapper.selectByPrimaryKey(coursefeedback.getCourseid()));
			list2.add(map);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("rows", list2);
		map.put("count", count);
		return Result.succee(map);
	}

	/**
	 * 删除课程反馈信息
	 *
	 * @throws MyException
	 */
	@Override
	public Result deleteCourseFeedback(Long CourseFeedbackID, AccountInfo accountInfo, String AUTHORITY_CODE)
			throws MyException {
		// 检查权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}
		coursefeedbackMapper.deleteByPrimaryKey(CourseFeedbackID);

		CoursefeedbackExample example = new CoursefeedbackExample();
		com.jy.entiy.content.product.course.CoursefeedbackExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria.andCoursefeedbackidEqualTo(CourseFeedbackID);
		coursefeedbackMapper.deleteByExample(example);

		// 插入数据可操作日志
		String log = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户删除了课程反馈信息，课程反馈信息主键为[" + CourseFeedbackID
				+ "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result updateCourseFeedback(Coursefeedback feedback, AccountInfo accountInfo) {

		Coursefeedback feedback1 = coursefeedbackMapper.selectByPrimaryKey(feedback.getCoursefeedbackid());
		if (feedback1.getAccountid() != accountInfo.getAccount().getAccountid()) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}

		coursefeedbackMapper.updateByPrimaryKeySelective(feedback);

		return Result.build(ResultEnum.SUCCESS);
	}

	/*******************************
	 * 个人课程
	 *
	 * @throws MyException
	 **************************************/

	@Override
	public Result addPersonCourse(Personcourse pc, AccountInfo accountInfo, String AUTHORITY_CODE) throws MyException {

		// 检查权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}

		pc.setCreateby(accountInfo.getAccount().getName());
		pc.setCreatepersonid(accountInfo.getAccount().getAccountid());
		pc.setCreatetime(new Date());
		pc.setCourseprocess(0);
		pc.setIsactive(2);
		personCourseMapper.insertSelective(pc);

		// 插入数据可操作日志
		String log = "ID为[" + accountInfo.getAccount().getAccountid() + "]的管理员添加了个人课程信息，被添加课程用户ID[" + pc.getAccountid()
				+ "],被添加课程ID为[" + pc.getCourseid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {

			e.printStackTrace();
			return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	/*
	 * @Override public Result deletePersonCourse(AccountInfo accountInfo, Long
	 * AccountID, Long CourseID, Long ProductID, String CONTROLLER_CODE) {
	 *
	 * if (!checkDeleteRight(accountInfo, CONTROLLER_CODE)) { return
	 * Result.build(ResultEnum.DELETE_SQL_ERROR); }
	 *
	 *
	 *
	 * personCourseMapper.deleteByPrimaryKey(pc);
	 *
	 * // 插入数据可操作日志 String log = "ID为[" + accountInfo.getAccount().getAccountid() +
	 * "]的管理员删除了个人课程信息，被删除课程的用户ID[" + AccountID + "],被删除课程ID为[" + CourseID + "]";
	 * try { this.dbLog(accountInfo.getAccount().getAccountid(),
	 * accountInfo.getAccount().getName(), log, DB_LOG_TYPE); } catch (MyException
	 * e) {
	 *
	 * e.printStackTrace(); return Result.build(ResultEnum.INSERT_DB_LOG_ERROR); }
	 *
	 * return Result.build(ResultEnum.SUCCESS); }
	 */
	@Override
	public Result service(AccountInfo accountInfo, Long PersonCourseID) throws MyException, ParseException {

		Personcourse personcourse = personCourseMapper.selectByPrimaryKey(PersonCourseID);

		if (personcourse.getIsactive() == 3) {
			personcourse.setIsactive(4);
			int i = personCourseMapper.updateByPrimaryKeySelective(personcourse);

			if (i < 1) {
				return Result.build(ResultEnum.UPDATE_SQL_ERROR);
			}

			Personserviceapplication personserviceapplication = new Personserviceapplication();
			personserviceapplication.setAccountid(accountInfo.getAccount().getAccountid());
			personserviceapplication.setCourseid(PersonCourseID);//因数据库少字段，将能唯一确定一条个人课程数据的PersonCourseID存入
			List<Applicationstatus> applicationStatus = applicationstatusMapper.selectByExample(null);
			for (Applicationstatus applicationstatus2 : applicationStatus) {
				if (applicationstatus2.getCode().equals(Constant.APPLICATION_STATUS_WAIT)) {
					personserviceapplication.setApplicationstatusid(applicationstatus2.getApplicationstatusid());
				}
			}
			personserviceapplication.setServiceapplicationname("过期课程再次激活申请");
			personserviceapplication.setApplicationtime(new Date());
			personserviceapplication.setServiceno(LiuUtils.getServeIdByUUId());

			int j = personserviceapplicationMapper.insertSelective(personserviceapplication);
			if (j < 1) {
				return Result.build(ResultEnum.INSERT_SQL_ERROR);
			}
			log(DB_LOG_TYPE, personserviceapplication, accountInfo, 1, "PersonServiceApplication", null);
		} else if (personcourse.getIsactive() == 2) {
			Course course = courseMapper.selectByPrimaryKey(personcourse.getCourseid());
			personcourse.setIsactive(1);
			long now = new Date().getTime();
			Long temp = course.getValiddays() * 1000L * 24L * 60L * 60L;
			long time = now + temp;
			Date date = new Date(time);
			String strdate = DateUtils.dateTimeToDateString(date);
			strdate = strdate + " 23:59:59";
			Date dateParse = DateUtils.dateParse(strdate,DateUtils.DATE_TIME_PATTERN);
			personcourse.setExpiredate(dateParse);
			int i = personCourseMapper.updateByPrimaryKeySelective(personcourse);
			if (i < 1) {
				return Result.build(ResultEnum.UPDATE_SQL_ERROR);
			}
			log(DB_LOG_TYPE, personcourse, accountInfo, 2, "PersonCourse", personcourse);
		} else {
			return Result.build(ResultEnum.NOT_UPDATE_RIGHTS);
		}
		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result selectPersonCourse(AccountInfo accountInfo, Integer IsActive, Integer page, Integer pageSize,
			Long CourseID) throws Exception {

		// 组装查询条件
		PersoncourseExample example = new PersoncourseExample();
		com.jy.entiy.content.product.course.PersoncourseExample.Criteria criteria = example.createCriteria();

		int count = 0;
		if (IsActive == 3 || IsActive == 4) {
			criteria.andExpiredateLessThan(new Date());
			List<Integer> list = new ArrayList<>();
			list.add(3);
			list.add(4);
			criteria.andIsactiveIn(list);
		} else if (IsActive == 1) {
			//课程状态
			criteria.andIsactiveEqualTo(IsActive);
			criteria.andExpiredateGreaterThanOrEqualTo(new Date());
		} else if(IsActive == 2) {
			//课程状态
			criteria.andIsactiveEqualTo(IsActive);
		}
		if (CourseID != null) {
			criteria.andPersoncourseidEqualTo(CourseID);
		}
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		
		count = personCourseMapper.countByExample(example);

		List<Personcourse> list2 = personCourseMapper.selectByExample(example);// 查询个人课程信息
		List<Personcourse> personcourses = new ArrayList<>();
		for (Personcourse personcourse : list2) {

			// 将已过期但处于激活状态改为未激活
			if (personcourse.getExpiredate() != null && personcourse.getExpiredate().before(new Date())) {
				if (personcourse.getIsactive() == 1) {
					personcourse.setIsactive(3);
					personCourseMapper.updateByPrimaryKeySelective(personcourse);

					// 插入数据可操作日志
					String log = "查询时，自动将已过期但处于激活状态的课程改为未激活，被改课程ID[" + personcourse.getCourseid() + "],所属用户ID["
							+ personcourse.getAccountid() + "]";
					try {
						this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log,
								DB_LOG_TYPE);
					} catch (MyException e) {

						e.printStackTrace();
						return Result.build(ResultEnum.INSERT_DB_LOG_ERROR);
					}

				}
			}

			// 将产品已放入回收站或删除的课程信息去掉
			Productinfo productinfo = productinfoMapper.selectByPrimaryKey(personcourse.getProductid());
			if (productinfo.getIsdelete().equals("Y") || productinfo.getIsauditpassed().equals("N")
					|| productinfo.getRemove().equals("Y")) {
			}else {
				personcourses.add(personcourse);
			}
		}
		Map<Integer, Sectionremembertime> last = new HashMap<>();
		Integer temps =0;
		if (IsActive == 1) {// 计算总进度
			for (Personcourse personcourse : personcourses) {
				CoursechapterExample example2 = new CoursechapterExample();
				com.jy.entiy.content.product.course.CoursechapterExample.Criteria criteria2 = example2.createCriteria();
				criteria2.andCourseidEqualTo(personcourse.getCourseid());
				List<Coursechapter> coursechapters = chapterMapper.selectByExample(example2);
				List<Long> longs = new ArrayList<>();
				for (Coursechapter coursechapter : coursechapters) {
					longs.add(coursechapter.getCharpterid());
				}
				if (longs.size() < 1) {
					continue;
				}
				SectionExample example3 = new SectionExample();
				com.jy.entiy.content.product.course.SectionExample.Criteria criteria3 = example3.createCriteria();
				criteria3.andCharpteridIn(longs);
				List<Section> sections = sectionMapper.selectByExample(example3);
				if (sections.size() < 1) {
					personcourse.setCourseprocess(0);
					continue;
				}
				List<Fileinfo> fileinfos = new ArrayList<>();
				for (Section section : sections) {
					Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(section.getFileid());
					if (fileinfo != null) {
						//视频无视频时长,从阿里云获取视频时长
						if (fileinfo.getType() == 2 && (fileinfo.getVideotime() == null || fileinfo.getVideotime() == 0)){
                            GetVideoInfoResponse.Video video = aliyunOSSClientUtil.getVideoInfo(fileinfo.getFilefullpath()).getVideo();
                            fileinfo.setVideotime(Float.valueOf(video.getDuration() + "").longValue());
                            fileinfoMapper.updateByPrimaryKeySelective(fileinfo);
                        }
						fileinfos.add(fileinfo);
					}
				}


				Integer amount = 0;
				for (Fileinfo fileinfo : fileinfos) {
					if (fileinfo.getVideotime() != null) {
						amount = (int) (amount + fileinfo.getVideotime());
					}

				}

				// 查已看多久
				Integer isSee = 0;
				SectionremembertimeExample example5 = new SectionremembertimeExample();
				com.jy.entiy.content.product.course.SectionremembertimeExample.Criteria criteria5 = example5
						.createCriteria();
				criteria5.andPersoncourseidEqualTo(personcourse.getPersoncourseid());
				example5.setOrderByClause("UpdateTime DESC");
				List<Sectionremembertime> sectionremembertimes = sectionremembertimeMapper.selectByExample(example5);

				if (sectionremembertimes.size() > 0) {
					last.put(temps, sectionremembertimes.get(0));
					temps++;
				}
				for (Sectionremembertime sectionremembertime : sectionremembertimes) {
					if (sectionremembertime.getTime() != null) {
						//未删除的节的已观看时长才算
						for (Section section : sections) {
							if (sectionremembertime.getSectionid().equals(section.getSectionid())) {
								isSee = isSee + sectionremembertime.getTime();
							}
						}
					}
				}
				if (amount == 0) {
					personcourse.setCourseprocess(0);
				} else {
					personcourse.setCourseprocess((Integer) (isSee * 100 / amount));
				}

				personCourseMapper.updateByPrimaryKeySelective(personcourse);
			}
		}

		// 组装入课程信息
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 0 ; i<personcourses.size() ;i++ ) {
			Personcourse personcourse = personcourses.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("personcourse", personcourse);
			Productinfo productinfo = productinfoMapper.selectByPrimaryKey(personcourse.getProductid());
			if (productinfo != null) {
				map.put("productName", productinfo.getProductname());
			}

			Course course = courseMapper.selectByPrimaryKey(personcourse.getCourseid());
			if(course == null) {
				continue;
			}
			map.put("course", course);
			if (course.getFileid() != null) {
				Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(course.getFileid());
				if (fileinfo != null) {
					fileinfo.setFilefullpath(null);
					fileinfo.setFilepath(null);
					map.put("fileinfo", fileinfo);
				}

			}
			if (course.getImage() != null) {
				Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(course.getImage());
				fileinfo.setFilepath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));
				map.put("image", fileinfo);
			}
			// 查询出最近观看的是第几章第几节
			if (last.get(i) != null) {
				Section section = sectionMapper.selectByPrimaryKey(last.get(i).getSectionid());
				if(section != null) {
					// 查第几节
					SectionExample example2 = new SectionExample();
					com.jy.entiy.content.product.course.SectionExample.Criteria criteria2 = example2.createCriteria();
					criteria2.andCharpteridEqualTo(section.getCharpterid());
					example2.setOrderByClause("DisplayOrder");
					List<Section> sections = sectionMapper.selectByExample(example2);
					for (int j = 0; j < sections.size(); j++) {
						if (sections.get(j).getSectionid().equals(section.getSectionid())) {
							map.put("section", j + 1);
						}
					}

					// 查第几章
					Coursechapter coursechapter = chapterMapper.selectByPrimaryKey(section.getCharpterid());
					CoursechapterExample example3 = new CoursechapterExample();
					com.jy.entiy.content.product.course.CoursechapterExample.Criteria criteria3 = example3.createCriteria();
					criteria3.andCourseidEqualTo(coursechapter.getCourseid());
					example3.setOrderByClause("DisplayOrder");
					List<Coursechapter> coursechapters = chapterMapper.selectByExample(example3);
					for (int j = 0; j < coursechapters.size(); j++) {
						if (coursechapters.get(j).getCharpterid().equals(coursechapter.getCharpterid())) {
							map.put("charpterid", j + 1);
						}
					}
					int hour = (int) last.get(i).getTime() / 60 / 60;
					int min = (int) (last.get(i).getTime() - hour * 60 * 60) / 60;
					int s = (int) (last.get(i).getTime() - hour * 60 * 60 - min * 60);
					String hours = "";
					String mins = "";
					String ss = "";
					if (hour < 10) {
						hours = "0" + hour + "";
					} else {
						hours = hour + "";
					}
					if (min < 10) {
						mins = "0" + min + "";
					} else {
						mins = min + "";
					}
					if (s < 10) {
						ss = "0" + s + "";
					} else {
						ss = s + "";
					}
					map.put("time", hours + ":" + mins + ":" + ss);
				}

			}
			list.add(map);
		}
		aliyunOSSClientUtil.closeOSSClient();

		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> list1 = new ArrayList<>();
		if(page != null && pageSize!=null) {
			for(int i = (page-1)*pageSize;i<page*pageSize;i++) {

				if(i >= list.size()) {
					break;
				}
				list1.add(list.get(i));
			}
			map.put("rows", list1);
			map.put("count", list.size());
		}else {
			map.put("rows", list);
			map.put("count", count);
		}





		return Result.succee(map);
	}

	@Override
	public Result deleteHandouts(Long CourseID, AccountInfo accountInfo, Long FileID) throws MyException {

		// 检查权限
		Result result = checkAuthority(accountInfo, AuthorityCode.DELETE_HANDOUTS);
		if (result.getStatus() != 200) {
			return result;
		}
		// 修改数据库数据
		Course course = courseMapper.selectByPrimaryKey(CourseID);

		if (course == null) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}
		if (FileID.equals(course.getFileid())) {
			course.setFileid(null);
		}
		if (FileID.equals(course.getImage())) {
			course.setImage(null);
		}
		int i = courseMapper.updateByPrimaryKey(course);
		if (i < 1) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}

		// 删除文件
		try {
			super.deleteFile(accountInfo, DB_LOG_TYPE, FileID, "Course", course.getCourseid());
		} catch (MyException e1) {
			e1.printStackTrace();
		}

		// 数据库日志
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), "ID为["
					+ accountInfo.getAccount().getAccountid() + "]的用户，删除ID为[ " + course.getCourseid() + "]课程下的讲义",
					DB_LOG_TYPE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Result.build(ResultEnum.SUCCESS);
	}

	@Override
	public Result getHandouts(Long CourseID, AccountInfo accountInfo) throws MyException {
		Result result = checkAuthority(accountInfo, AuthorityCode.DOWN_HANDOUTS);
		if (result.getStatus() != 200) {// 判断权限
			// 无权限，再查询个人课表判断权限
			PersoncourseExample example = new PersoncourseExample();
			com.jy.entiy.content.product.course.PersoncourseExample.Criteria criteria = example.createCriteria();
			criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
			criteria.andCourseidEqualTo(CourseID);
			List<Personcourse> personcourses = personCourseMapper.selectByExample(example);
			if (personcourses.size() < 1) {
				return result;
			}
		}

		Course course = courseMapper.selectByPrimaryKey(CourseID);
		return Result.succee(course);
	}

	@Override
	public Result remember(AccountInfo accountInfo, Sectionremembertime sectionremembertime) throws MyException {
		Personcourse personcourse = personCourseMapper.selectByPrimaryKey(sectionremembertime.getPersoncourseid());
		if (!accountInfo.getAccount().getAccountid().equals(personcourse.getAccountid())) {
			return Result.build(ResultEnum.NOT_UPDATE_RIGHTS);
		}

		SectionremembertimeExample example2 = new SectionremembertimeExample();
		com.jy.entiy.content.product.course.SectionremembertimeExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andPersoncourseidEqualTo(sectionremembertime.getPersoncourseid());
		criteria2.andSectionidEqualTo(sectionremembertime.getSectionid());
		List<Sectionremembertime> sectionremembertimes = sectionremembertimeMapper.selectByExample(example2);
		if (sectionremembertimes.size() > 0) {
			sectionremembertime.setSectionremembertimeid(sectionremembertimes.get(0).getSectionremembertimeid());
		}
		if (sectionremembertime.getSectionremembertimeid() == null) {// 新增
			int i = sectionremembertimeMapper.insertSelective(sectionremembertime);
			if (i < 1) {
				return Result.build(ResultEnum.INSERT_SQL_ERROR);
			}
			log(DB_LOG_TYPE, sectionremembertime, accountInfo, 1, "SectionRememberTime", null);
		} else {// 修改
			Sectionremembertime sectionremembertime2 = sectionremembertimeMapper
					.selectByPrimaryKey(sectionremembertime.getSectionremembertimeid());
			int i = sectionremembertimeMapper.updateByPrimaryKeySelective(sectionremembertime);
			if (i < 1) {
				return Result.build(ResultEnum.UPDATE_SQL_ERROR);
			}
			log(DB_LOG_TYPE, sectionremembertime2, accountInfo, 2, "SectionRememberTime", sectionremembertime);
		}
		return Result.succee();
	}

	@Override
	public Result freeCourse(Long ProductID) {

		// 查询产品绑定课程信息
		ProductbindcousreExample example5 = new ProductbindcousreExample();
		com.jy.entiy.content.product.product.ProductbindcousreExample.Criteria criteria5 = example5.createCriteria();
		criteria5.andProductidEqualTo(ProductID);
		List<Productbindcousre> productbindcousres = productbindcousreMapper.selectByExample(example5);

		// 查询所有产品信息
		List<Course> courses = new ArrayList<>();
		for (Productbindcousre productbindcousre : productbindcousres) {
			courses.add(courseMapper.selectByPrimaryKey(productbindcousre.getCourseid()));
		}
		List<Map<String, Object>> list = new ArrayList<>();
		for (Course course : courses) {
			if(course == null) {
				continue;
			}
			Map<String, Object> map = new HashMap<>();
			map.put("course", course);

			CoursechapterExample example = new CoursechapterExample();
			com.jy.entiy.content.product.course.CoursechapterExample.Criteria criteria = example.createCriteria();
			criteria.andCourseidEqualTo(course.getCourseid());
			example.setOrderByClause("DisplayOrder");
			List<Coursechapter> coursechapters = chapterMapper.selectByExample(example);
			List<Section> sections = new ArrayList<>();
			for (Coursechapter coursechapter : coursechapters) {
				SectionExample example2 = new SectionExample();
				com.jy.entiy.content.product.course.SectionExample.Criteria criteria2 = example2.createCriteria();
				criteria2.andCharpteridEqualTo(coursechapter.getCharpterid());
				criteria2.andIsfreeEqualTo("Y");
				example2.setOrderByClause("DisplayOrder");
				List<Section> sections2 = sectionMapper.selectByExample(example2);
				for (Section section : sections2) {
					if (section.getFileid() != null) {
						Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(section.getFileid());
						if(fileinfo != null && fileinfo.getFilefullpath() != null) {
							section.setFile(super.getBASE64Encoder(fileinfo.getFilefullpath()));
						}

					}
				}
				sections.addAll(sections2);
			}

			map.put("section", sections);
			list.add(map);
		}

		return Result.succee(list);
	}

	@Override
	public Result getHangouts(Long CourseID, AccountInfo accountInfo) throws MyException {
		Result result = checkAuthority(accountInfo, AuthorityCode.DOWN_HANDOUTS);
		if (result.getStatus() != 200) {// 判断权限
			// 无权限，再查询个人课表判断权限
			PersoncourseExample example = new PersoncourseExample();
			com.jy.entiy.content.product.course.PersoncourseExample.Criteria criteria = example.createCriteria();
			criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
			criteria.andCourseidEqualTo(CourseID);
			List<Personcourse> personcourses = personCourseMapper.selectByExample(example);
			if (personcourses.size() < 1) {
				return result;
			}
		}
		Course course = courseMapper.selectByPrimaryKey(CourseID);
		if (course == null) {
			return Result.build(ResultEnum.SELECT_SQL_ERROR);
		}
		Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(course.getFileid());

		return Result.succee(fileinfo);
	}

	@Override
	public Result list(Long CourseID,Long ProductID, AccountInfo accountInfo) throws MyException {
		Result result = checkAuthority(accountInfo, AuthorityCode.COURSE_SELECT);
		int temp = 0;
		PersoncourseExample example4 = new PersoncourseExample();
		com.jy.entiy.content.product.course.PersoncourseExample.Criteria criteria4 = example4.createCriteria();
		criteria4.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria4.andCourseidEqualTo(CourseID);
		if(ProductID != null) {
			criteria4.andProductidEqualTo(ProductID);
		}

		List<Personcourse> personcourses = personCourseMapper.selectByExample(example4);
		if (result.getStatus() != 200) {
			temp = 1;
			if (personcourses.size() < 1) {
				return result;
			}
		}

		Course course = courseMapper.selectByPrimaryKey(CourseID);
		if (course == null) {
			return Result.build(ResultEnum.SELECT_SQL_ERROR);
		}
		Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(course.getFileid());
		course.setFileinfo(fileinfo);
		CoursechapterExample example = new CoursechapterExample();
		com.jy.entiy.content.product.course.CoursechapterExample.Criteria criteria = example.createCriteria();
		criteria.andCourseidEqualTo(CourseID);
		example.setOrderByClause("DisplayOrder");
		List<Coursechapter> coursechapters = chapterMapper.selectByExample(example);
		List<Map<String, Object>> list = new ArrayList<>();
		for (Coursechapter coursechapter : coursechapters) {
//			Map<String, Object> map = new HashMap<>();
//			map.put("coursechapter", coursechapter);
//			map.put("fileinfo", fileinfo);
			SectionExample example2 = new SectionExample();
			com.jy.entiy.content.product.course.SectionExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andCharpteridEqualTo(coursechapter.getCharpterid());
			example2.setOrderByClause("DisplayOrder");
			List<Section> sections = sectionMapper.selectByExample(example2);

			for (Section section : sections) {
				if (section.getFileid() != null) {
					Fileinfo fileinfo2 = fileinfoMapper.selectByPrimaryKey(section.getFileid());
					if (fileinfo2 == null) {
						section.setFileid(null);
						sectionMapper.updateByPrimaryKeySelective(section);
						continue;
					}
					if (fileinfo2.getVideotime()==null) {
						continue;
					}
					section.setFile(fileinfo2.getFilename());
					section.setFilePath(super.getBASE64Encoder(fileinfo2.getFilefullpath()));
					if (temp == 1) {
						SectionremembertimeExample example3 = new SectionremembertimeExample();
						com.jy.entiy.content.product.course.SectionremembertimeExample.Criteria criteria3 = example3
								.createCriteria();
						criteria3.andPersoncourseidEqualTo(personcourses.get(0).getPersoncourseid());
						criteria3.andSectionidEqualTo(section.getSectionid());
						List<Sectionremembertime> sectionremembertimes = sectionremembertimeMapper
								.selectByExample(example3);
						if (sectionremembertimes.size() < 1) {
							section.setJindu("0");
							section.setRememberTime(0);
						} else {
							section.setJindu(
									(sectionremembertimes.get(0).getTime() * 100 / fileinfo2.getVideotime()) + "");
							section.setRememberTime(sectionremembertimes.get(0).getTime());
						}

						section.setTime(fileinfo2.getVideotime());

						int hour = (int) (fileinfo2.getVideotime() / 60L / 60L);
						int min = (int) ((fileinfo2.getVideotime() - hour * 60L * 60L) / 60L);
						int s = (int) (fileinfo2.getVideotime() - hour * 60L * 60L - min * 60L);
						String hours = "";
						String mins = "";
						String ss = "";
						if (hour < 10) {
							hours = "0" + hour + "";
						} else {
							hours = hour + "";
						}
						if (min < 10) {
							mins = "0" + min + "";
						} else {
							mins = min + "";
						}
						if (s < 10) {
							ss = "0" + s + "";
						} else {
							ss = s + "";
						}

						section.setTimes(hours + ":" + mins + ":" + ss);

					}
				}
			}
			coursechapter.setSections(sections);
//			map.put("section", sections);
//			Course course2 = courseMapper.selectByPrimaryKey(coursechapter.getCourseid());
//			if (course2 != null) {
//				map.put("courseName", course2.getCoursetitle());
//			}
//
//			list.add(map);
		}
		course.setCoursechapters(coursechapters);
		return Result.succee(course);
	}

	@Override
	public Result move(Long SectionID, Long CharpterID, Integer type, AccountInfo accountInfo) throws MyException {
		Result result = checkAuthority(accountInfo, AuthorityCode.MOVE_CHAPTER_OR_SECTION);
		if (result.getStatus() != 200) {
			return result;
		}
		if (SectionID != null) {
			Section section = sectionMapper.selectByPrimaryKey(SectionID);
			SectionExample example = new SectionExample();
			com.jy.entiy.content.product.course.SectionExample.Criteria criteria = example.createCriteria();
			criteria.andCharpteridEqualTo(section.getCharpterid());
			example.setOrderByClause("DisplayOrder");
			List<Section> sections = sectionMapper.selectByExample(example);
			for (int i = 0; i < sections.size(); i++) {
				if (sections.get(i).getSectionid().equals(SectionID)) {
					Section section2 = new Section();
					if (type == 1) {
						if (i == 0) {

						} else {
							section2 = sections.get(i - 1);
						}

					} else {
						if (i == sections.size() - 1) {
							section2 = sections.get(i);
						} else {
							section2 = sections.get(i + 1);
						}

					}
					int temp = section.getDisplayorder();
					section.setDisplayorder(section2.getDisplayorder());
					section2.setDisplayorder(temp);
					sectionMapper.updateByPrimaryKeySelective(section2);
					sectionMapper.updateByPrimaryKeySelective(section);
				}
			}
		}
		if (CharpterID != null) {
			Coursechapter chapter = chapterMapper.selectByPrimaryKey(CharpterID);
			CoursechapterExample example = new CoursechapterExample();
			com.jy.entiy.content.product.course.CoursechapterExample.Criteria criteria = example.createCriteria();
			criteria.andCourseidEqualTo(chapter.getCourseid());
			example.setOrderByClause("DisplayOrder");
			List<Coursechapter> chapters = chapterMapper.selectByExample(example);
			for (int i = 0; i < chapters.size(); i++) {
				if (chapters.get(i).getCharpterid().equals(CharpterID)) {
					Coursechapter chapter2 = new Coursechapter();
					if (type == 1) {

						if (i == 0) {
							chapter2 = chapters.get(i);
						} else {
							chapter2 = chapters.get(i - 1);
						}
					} else {
						if (i == chapters.size() - 1) {
							chapter2 = chapters.get(i);
						} else {
							chapter2 = chapters.get(i + 1);
						}

					}
					int temp = chapter.getDisplayorder();
					chapter.setDisplayorder(chapter2.getDisplayorder());
					chapter2.setDisplayorder(temp);
					chapterMapper.updateByPrimaryKeySelective(chapter);
					chapterMapper.updateByPrimaryKeySelective(chapter2);
				}
			}
		}
		return Result.succee();
	}

	@Override
	public Result getSection(Long SectionID, AccountInfo accountInfo) throws MyException {
		Result result = checkAuthority(accountInfo, AuthorityCode.COURSE_SELECT);
		if (result.getStatus() != 200) {
			return result;
		}
		return Result.succee(sectionMapper.selectByPrimaryKey(SectionID));
	}

	@Override
	public Result getCharpter(Long CharpterID, AccountInfo accountInfo) throws MyException {
		Result result = checkAuthority(accountInfo, AuthorityCode.COURSE_SELECT);
		if (result.getStatus() != 200) {
			return result;
		}
		return Result.succee(chapterMapper.selectByPrimaryKey(CharpterID));
	}

	@Override
	public Result noteNumber(AccountInfo accountInfo, Long CourseID) {
		PersoncoursenoteExample example = new PersoncoursenoteExample();
		com.jy.entiy.content.product.course.PersoncoursenoteExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria.andCourseidEqualTo(CourseID);

		return Result.succee(personcoursenoteMapper.countByExample(example));
	}

	@Override
	public Result select(AccountInfo accountInfo) {
		PersoncourseExample example = new PersoncourseExample();
		com.jy.entiy.content.product.course.PersoncourseExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria.andExpiredateIsNotNull();
		List<Personcourse> personcourses = personCourseMapper.selectByExample(example);
		List<Course> courses = new ArrayList<>();
		for (Personcourse personcourse : personcourses) {
			Course course = courseMapper.selectByPrimaryKey(personcourse.getCourseid());
			if (course != null) {
				course.setProductID(personcourse.getProductid());
				courses.add(course);

			}

		}


		return Result.succee(courses);
	}

}
