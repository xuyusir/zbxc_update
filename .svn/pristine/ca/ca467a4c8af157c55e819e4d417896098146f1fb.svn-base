package com.jy.service.system.select;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jy.common.result.Result;
import com.jy.dao.system.select.AreaMapper;
import com.jy.service.base.BaseService;

/**
 * 
 * @ClassName:  AreaServiceImpl   
 * @Description:中国地区服务实现类
 * @author: cheng fei
 * @date:   2018-09-12 15:23
 */

@Service
public class AreaServiceImpl extends BaseService implements AreaService{
	
	@Resource
	private AreaMapper areaMapper;

	@Override
	public Result getSelect(String code) {
		return Result.succee(areaMapper.getSelect(code));
	}

}
