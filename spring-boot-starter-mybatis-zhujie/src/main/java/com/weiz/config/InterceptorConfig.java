package com.weiz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.weiz.controller.interceptor.OneInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Resource
	private OneInterceptor myInterceptor1;

	//@Resource
	//private TwoInterceptor myInterceptor2;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//添加要拦截的url               1                         拦截的路径                         排除的路径
		registry.addInterceptor(myInterceptor1).addPathPatterns("/th/**").excludePathPatterns("/th/postform");
		//添加要拦截的url               2
		//registry.addInterceptor(myInterceptor2).addPathPatterns("/th/**").excludePathPatterns("/admin/login");
	}
}