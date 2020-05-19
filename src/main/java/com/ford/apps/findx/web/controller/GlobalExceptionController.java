
package com.ford.apps.findx.web.controller;

import org.apache.shiro.authz.UnauthorizedException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ford.apps.findx.util.ResponseUtil;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseBody
	public Object handleUnauthorizedException(Exception ex) {
		return ResponseUtil.fail("401", ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handleException(Exception ex) {
		return ResponseUtil.fail("500", ex.getMessage());
	}
}