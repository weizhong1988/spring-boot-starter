package com.weiz.controller.api;

import com.weiz.config.ApiVersion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/{version}/user/")
@RestController
@ApiVersion(2)
public class UserV2Controller {

    @GetMapping("/newtest")
    public String newtest() {
        return "user v2 newtest";
    }
}
