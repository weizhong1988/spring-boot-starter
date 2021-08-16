package com.weiz.controller.api;

import com.weiz.config.ApiVersion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/{version}/user")
@RestController
@ApiVersion()
public class UserV1Controller {

    @GetMapping("/test")
    public String test() {
        return "user v1 test";
    }

    @GetMapping("/extend")
    public String extendTest() {
        return "user v1 extend";
    }
}