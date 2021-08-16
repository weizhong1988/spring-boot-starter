package com.weiz.controller;

import com.weiz.entity.User;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created with Intellij IDEA.
 *
 * @Author: Gabriel
 * @Date: 2018-10-23
 * @Description:
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

	@RequestMapping("/check")
	public String check(@RequestBody @Valid User user, BindingResult result){
		return user.getName()+" 检测完毕！没有问题";
	}

	@RequestMapping("/query")
	public String query(@Range(min = 1, max = 9, message = "年级只能从1-9")
							@RequestParam(name = "grade", required = true) int grade,
						@Min(value = 1, message = "班级最小只能1")
						@Max(value = 99, message = "班级最大只能99")
						@RequestParam(name = "classroom", required = true) int classroom){

		System.out.println(grade + "," + classroom);
		return grade + "," + classroom;
	}
}