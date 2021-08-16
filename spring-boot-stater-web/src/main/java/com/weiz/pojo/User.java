package com.weiz.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * Created with Intellij IDEA.
 *
 * @Author: Gabriel
 * @Date: 2018-10-23
 * @Description:
 */
public class User {
	@NotBlank(message = "name不允许为空")
	@Length(min = 2,max = 10,message = "你的长度不对劲呀")
	private String name;
	@NotNull(message = "进入未成年人入内！")
	@Min(18)
	private int age;
	@NotBlank(message = "拒绝黑户")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}