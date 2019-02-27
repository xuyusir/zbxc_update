package com.jy.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.JsonUtils;

/**
 * @ClassName:  GlobalExceptionHandler   
 * @Description:异常统一处理类  
 * @author: cheng fei
 * @date:   2018-07-31 09:26
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {

	private Logger logger = Logger.getLogger(this.getClass());
	@Override
	public ModelAndView resolveException(HttpServletRequest request , HttpServletResponse response, Object obj, Exception e) {
		response.setStatus(200);
		String data = "";
		if (e instanceof MyException) {
			MyException myException = (MyException) e;
			logger.error(myException.getMsg());
			e.printStackTrace();
			Result result = Result.build(myException.getResultEnum());
			result.setStatus(200);
			data = JsonUtils.objectToJson(result);
		}else {
			logger.error(ResultEnum.UNDEFINED_ERROR.getMsg());
			e.printStackTrace();
			Result result = Result.build(ResultEnum.UNDEFINED_ERROR);
			result.setStatus(200);
			data = JsonUtils.objectToJson(result);
		}
		
		try {
			response.getWriter().println(data);
		} catch (IOException e1) {
			logger.error("向页面返回数据错误");
			e1.printStackTrace();
		}
		
		return null;
	}

}
