package com.weiz.controller;

import com.weiz.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created with Intellij IDEA.
 *
 * @Author: Gabriel
 * @Date: 2018-10-23
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/check")
	public String check(@Valid User user){
		return "检测完毕！没有问题";
	}
}