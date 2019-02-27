package com.jy.controller.system.select;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.service.system.select.AreaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName:  AreaController   
 * @Description:中国地区接口
 * @author: cheng fei
 * @date:   2018-09-12 15:12
 */

@Controller
@RequestMapping("/system/area")
@Api(tags = "system.select.AreaController", description = "系统-下拉列表-中国地区模块")
public class AreaController extends BaseController{
	
	@Resource
	private AreaService areaService;
	
	@ApiOperation(value ="查询中国地区" ,httpMethod = "GET", produces="application/json")
	@RequestMapping(value = "/select",method = RequestMethod.GET)
	@ResponseBody
	public Result getSelectProvince(
			@ApiParam(value = "地区code",required = false) @RequestParam(required = false, defaultValue = "100000") String code
			) {
		return areaService.getSelect(code);
	}
}
