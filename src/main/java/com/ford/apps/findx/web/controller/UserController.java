
package com.ford.apps.findx.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ford.apps.findx.common.constant.AppConstant;
import com.ford.apps.findx.domain.service.AuthService;
import com.ford.apps.findx.util.ResponseUtil;

@Controller
public class UserController {

	@Autowired
	private AuthService authService = null;

	@GetMapping(value="/user/default/loginform")
	public String loginForm() {
		return AppConstant.USER_LOGIN_FORM_PAGE;
	}

	@GetMapping(value="/user/login")
	@ResponseBody
	public Object login() {
		return ResponseUtil.fail("402", "Credential authentication required.");
	}

	@GetMapping(value="/user/unauthorized")
	@ResponseBody
	public Object unauthorized() {
		return ResponseUtil.fail("403", "Unauthorized and forbidden.");
	}

	@GetMapping(value="/authorization/callback")
	public void authorizationCodeCallback(@RequestParam("code") String code,
		HttpServletRequest request, HttpServletResponse response) {
		authService.loginAsOAuth2(code, request, response);
	}

	@GetMapping(value="/user/default/logout")
	public String logout(@RequestParam(value="err", required=false) Integer err, Model model) {
		if (err != null && err.intValue() == 1) {
			model.addAttribute("message", "User not existed");
		}
		return AppConstant.USER_LOGOUT_END_PAGE;
	}

	@GetMapping(value="/system/dashboard")
	public String redirectSystemDashboard() {
		return AppConstant.GLOBAL_SYSTEM_INFO_PAGE;
	}
}