package com.jy.quartz;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.jy.common.utils.DateUtils;
import com.jy.dao.content.articleManage.ArticleinfoMapper;
import com.jy.entiy.content.articleManage.Articleinfo;

/**
 * 过期文章自动回收
 * 
 * @author chenye 2018-11-29
 */
public class ArticleQuartz {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private ArticleinfoMapper articleinfoMapper;

	public void execute() throws ParseException {
		logger.info("自动回收过期文章开始执行....");
		List<Articleinfo> overList = getOverdueArticle();
		if (overList != null && overList.size() != 0) {
			for (Articleinfo articleinfo : overList) {
				if (articleinfo != null) {
					articleinfo.setIsdelete("Y");
					int i = articleinfoMapper.updateByPrimaryKeySelective(articleinfo);
					if (i < 1) {
						logger.error("回收文章:[ " + articleinfo.getArticletitle() + " ]失败!");
					} else {
						logger.info("系统自动回收了文章:[  " + articleinfo.getArticletitle() + "  ]");
					}
				}

			}
			logger.info("自动回收过期文章结束!");
		}

	}

	/**
	 * 检测过期文章
	 * 
	 * @return
	 * @throws ParseException
	 */
	private List<Articleinfo> getOverdueArticle() throws ParseException {
		String nowDate = DateUtils.dateFormat(new Date(), DateUtils.DATE_PATTERN);
		return articleinfoMapper.getOverdueArticleList(nowDate);

	}

}
