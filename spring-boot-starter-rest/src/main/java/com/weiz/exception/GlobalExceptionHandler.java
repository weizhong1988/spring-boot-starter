package com.weiz.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weiz.utils.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.weiz.utils.JSONResult;

@ControllerAdvice
public class GlobalExceptionHandler  {

	public static final String ERROR_VIEW = "error";

	Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, 
    		HttpServletResponse response, Exception e) throws Exception {
    	
    	//e.printStackTrace();
		// 记录日志
		logger.error(ExceptionUtils.getMessage(e));
    	// 是否ajax请求
    	if (isAjax(reqest)) {
    		return JSONResult.errorException(e.getMessage());
    	} else {
    		ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
    	}
    }
	
	/**
	 * 
	 * @Title: GlobalExceptionHandler.java
	 * @Package com.weiz.exception
	 * @Description: 判断是否是ajax请求
	 * Copyright: Copyright (c) 2017
	 * 
	 * @author weiz
	 * @date 2017年12月3日 下午1:40:39
	 * @version V1.0
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With")) );
	}
}
