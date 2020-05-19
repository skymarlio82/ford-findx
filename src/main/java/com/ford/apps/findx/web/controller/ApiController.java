
package com.ford.apps.findx.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ford.apps.findx.data.entity.LocationPoint;
import com.ford.apps.findx.data.entity.User;
import com.ford.apps.findx.domain.service.AuthService;
import com.ford.apps.findx.domain.service.BaiduMapService;
import com.ford.apps.findx.domain.service.UserService;
import com.ford.apps.findx.util.ResponseUtil;

@Controller
public class ApiController {

	@Autowired
	private UserService userService = null;

	@Autowired
	private AuthService authService = null;

	@Autowired
	private BaiduMapService baiduMapService = null;

	@RequiresRoles(value={"ADMIN","USER"}, logical=Logical.OR)
	@GetMapping(value="/api/logout/user")
	@ResponseBody
	public Object apiOfLogoutUser() {
		authService.logout();
		return ResponseUtil.ok("200", "User logout success.");
	}

	@RequiresRoles(value={"ADMIN","USER"}, logical=Logical.OR)
	@GetMapping(value="/api/user/{id}")
	@ResponseBody
	public Object apiOfGetUserById(@PathVariable(required=true, name="id") long id) {
		User user = userService.getUserById(id);
		return ResponseUtil.ok("200", "Success.", user);
	}

	@RequiresRoles("USER")
	@GetMapping(value="/api/users/all")
	@ResponseBody
	public Object apiOfGetAllUsers() {
		List<User> userList = userService.getAllUsers();
		return ResponseUtil.ok("200", "Success.", userList);
	}

	@RequiresRoles(value={"ADMIN","USER"}, logical=Logical.OR)
	@GetMapping("/api/map/search")
	@ResponseBody
	public Object apiOfSearchOnMap(@RequestParam(required=true, name="lat") String lat,
		@RequestParam(required=true, name="lng") String lng) {
		List<LocationPoint> list = baiduMapService.searchOnPurpose(lat, lng);
		return ResponseUtil.ok("200", "Success.", list);
	}

	@RequiresRoles("ADMIN")
	@GetMapping("/api/map/tops")
	@ResponseBody
	public Object apiOfFetchTops() {
		List<LocationPoint> list = baiduMapService.getTops();
		return ResponseUtil.ok("200", "Success.", list);
	}
}