package com.jy.controller.system.health;

import com.jy.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description : 健康检查Controller
 * @Author : cheng fei
 * @Date : 2018/12/20 17:57
 */
@Controller
@Api(tags = "com.jy.controller.system.health", description = "系统-健康检查")
public class HealthController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "健康检查接口", httpMethod = "GET", produces = "application/json")
    public Result health(){
        return  Result.succee();
    }
}
