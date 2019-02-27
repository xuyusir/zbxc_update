package com.jy.service.content.product;

import java.text.ParseException;
import java.util.Map;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.product.course.Course;
import com.jy.entiy.content.product.course.Coursechapter;
import com.jy.entiy.content.product.course.Coursefeedback;
import com.jy.entiy.content.product.course.Personcourse;
import com.jy.entiy.content.product.course.Personcoursenote;
import com.jy.entiy.content.product.course.Section;
import com.jy.entiy.content.product.course.Sectionremembertime;

/**
 * 课程信息业务逻辑层接口
 * @author Administrator
 *
 */
public interface CourseService {

	/**
	 * 查询课程信息
	 * @param prodictId
	 * @return
	 * @throws MyException
	 */
	public Result getCourse(Map<String,Object> param,AccountInfo accountInfo) throws MyException;

	/**
	 * 查询免费试看课程信息
	 * @param CourseID
	 * @return
	 */
	public Result freeCourse(Long ProductID);

	/**
	 * 查询课程章目信息
	 * @param param
	 * @return
	 */
	public Result getCourseCharpter(Long CourseID);

	/**
	 * 查询课程章目信息
	 * @return
	 * @throws MyException
	 */
	public Result getCharpter(Long CharpterID,AccountInfo accountInfo) throws MyException;

	/**
	 * 根据章目Id获取课程章节信息
	 * @param Integer
	 * @return
	 * @throws MyException
	 */
	public Result getCourseSection(Long CharpterID,AccountInfo accountInfo) throws MyException;

	/**
	 * 查询课程章节信息
	 * @param SectionID
	 * @param accountInfo
	 * @return
	 * @throws MyException
	 */
	public Result getSection(Long SectionID,AccountInfo accountInfo) throws MyException;

	/**
	 * 添加课程信息
	 * @param param
	 * @param account
	 * @return
	 * @throws MyException
	 */
	public Result addCourse(Map<String,Object> param,AccountInfo account) throws MyException;

	/**
	 * 添加课程章目信息
	 * @param param
	 * @param account
	 * @return
	 * @throws MyException
	 */
	public Result addCourseCharpter(Map<String,Object> param,AccountInfo account ) throws MyException;

	/**
	 * 添加章节信息
	 * @param param
	 * @param account
	 * @return
	 */
	public Result addSection(Map<String,Object> param,AccountInfo account) throws MyException ;

	/**
	 * 删除课程信息
	 * @param info
	 * @param CourseIDs
	 * @param CourseCodes
	 * @return
	 * @throws MyException
	 */
	public Result deleteCourse(AccountInfo info,String CourseID) throws MyException;

	/**
	 * 删除章目信息
	 * @param info
	 * @param CourseIDs
	 * @param CourseCodes
	 * @param CharpterIDs
	 * @return
	 * @throws MyException
	 */
	public Result deleteCourseCharpter(AccountInfo info,Long CharpterID ) throws MyException;

	/**
	 * 删除章节信息
	 * @param info
	 * @param SectionIDs
	 * @param CharpterIDs
	 * @param SectionCodes
	 * @return
	 * @throws MyException
	 */
	public Result deleteSection(AccountInfo info,Long SectionID) throws MyException;

	/**
	 * 修改课程信息
	 * @param info
	 * @param course
	 * @return
	 */
	public Result updateCourse(AccountInfo info,Course course ) throws MyException;

	/**
	 * 修改课程章目信息
	 * @param chapter
	 * @return
	 * @throws MyException
	 */
	public Result updateChapter(AccountInfo info,Coursechapter chapter) throws MyException;

	/**
	 * 修改课程章节信息
	 * @param info
	 * @param section
	 * @return
	 */
	public Result updateSection(AccountInfo info,Section section )  throws MyException ;

	/**
	 * 添加笔记
	 * @param note
	 * @return
	 * @throws MyException
	 */
	public Result addPersonCourseNote(Personcoursenote note) throws MyException;

	/**
	 * 删除笔记
	 * @param accountInfo
	 * @param CourseNoteID
	 * @return
	 */
	public Result deletePersonCourseNote(AccountInfo accountInfo,Long CourseNoteID);

	/**
	 * 修改笔记
	 * @param note
	 * @return
	 */
	public Result updatePersonCourseNote(Personcoursenote note);

	/**
	 * 查询笔记信息
	 * @param note
	 * @return
	 */
	public Result getPersonCourseNote(Personcoursenote note);

	/**
	 * 增加反馈信息
	 * @return
	 */
	public Result addCourseFeedback(AccountInfo accountInfo,Coursefeedback feedbake,String flag);


	/**
	 * 查询课程反馈信息
	 * @param accountInfo
	 * @param feedbake
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public Result getCourseFeedback(Map<String, Object> param);

	/**
	 * 删除课程信息
	 * @param CourseFeedbackID
	 * @param accountInfo
	 * @return
	 * @throws MyException
	 */
	public Result deleteCourseFeedback(Long CourseFeedbackID,AccountInfo accountInfo,String CONTROLLER_CODE) throws MyException;

	/**
	 * 反馈信息修改
	 * @param feedback
	 * @param accountInfo
	 * @return
	 */
	public Result updateCourseFeedback(Coursefeedback feedback,AccountInfo accountInfo);

	/**
	 * 添加个人课程
	 * @param pc
	 * @param accountInfo
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException
	 */
	public Result addPersonCourse(Personcourse pc,AccountInfo accountInfo,String CONTROLLER_CODE) throws MyException;

	/**
	 * 删除个人课程信息
	 * @param accountInfo
	 * @param AccountID
	 * @param CourseID
	 * @param CONTROLLER_CODE
	 * @return
	 */
	//public Result deletePersonCourse(AccountInfo accountInfo,Long AccountID,Long CourseID,Long ProductID,String CONTROLLER_CODE);

	/**
	 * 申请激活课程服务
	 * @param accountInfo
	 * @param Remark
	 * @param CourseProcess
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException
	 * @throws ParseException 
	 */
	public Result service(AccountInfo accountInfo,Long PersonCourseID) throws MyException, ParseException;

	/**
	 * 查询个人课程信息
	 * @param accountInfo
	 * @param param
	 * @param CONTROLLER_CODE
	 * @return
	 */
	public Result selectPersonCourse(AccountInfo accountInfo,Integer IsActive,Integer pageNumber,Integer pageCount,Long CourseID) throws Exception;


	/**
	 * 删除讲义
	 * @param CourseID
	 * @param accountInfo
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException
	 */
	public Result deleteHandouts(Long CourseID,AccountInfo accountInfo,Long FileID) throws MyException;

	/**
	 * 获取讲义下载地址
	 * @param CourseID
	 * @param accountInfo
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException
	 */
	public Result getHandouts(Long CourseID,AccountInfo accountInfo) throws MyException;

	/**
	 * 回显讲义信息
	 * @return
	 * @throws MyException
	 */
	public Result getHangouts(Long CourseID,AccountInfo accountInfo) throws MyException;

	/**
	 * 记忆播放时间增加修改
	 * @param accountInfo
	 * @param sectionremembertime
	 * @return
	 * @throws MyException
	 */
	public Result remember(AccountInfo accountInfo,Sectionremembertime sectionremembertime) throws MyException;

	/**
	 * 查询课程所有章节列表
	 * @param CourseID
	 * @param accountInfo
	 * @return
	 * @throws MyException
	 */
	public Result list(Long CourseID,Long ProductID,AccountInfo accountInfo) throws MyException;

	/**
	 * 章目/章节，上移/下移
	 * @param SectionID
	 * @param CharpterID
	 * @param type
	 * @param accountInfo
	 * @return
	 * @throws MyException
	 */
	public Result move(Long SectionID,Long CharpterID,Integer type,AccountInfo accountInfo) throws MyException;

	/**
	 * 查询课程笔记数量
	 * @param accountInfo
	 * @param CourseID
	 * @return
	 */
	public Result noteNumber(AccountInfo accountInfo, Long CourseID);

	/**
	 * 查个人课表
	 * @return
	 */
	public Result select(AccountInfo accountInfo);
}
