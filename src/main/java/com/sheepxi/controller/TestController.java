package com.sheepxi.controller;

import com.sheepxi.datasource.DBIdentifier;
import com.sheepxi.service.TestService;
import com.sheepxi.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 喜🐑
 * @create: 2018-12-05 11:36
 */
@Api(value = "测试")
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/listAllUser.do")
    @ApiImplicitParam(name = "projectCode",value = "项目code",dataType = "String",paramType = "query")
    public ResponseBean listAllUser(@RequestParam(value = "projectCode")String projectCode){
        DBIdentifier.setProjectCode(projectCode);
        return ResponseBean.success(testService.selectAll());
    }
}
