
package com.ford.apps.findx.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ford.apps.findx.common.constant.AppConstant;
import com.ford.apps.findx.data.entity.LocationPoint;
import com.ford.apps.findx.data.entity.User;
import com.ford.apps.findx.domain.service.AuthService;
import com.ford.apps.findx.domain.service.BaiduMapService;
import com.ford.apps.findx.domain.service.UserService;
import com.ford.apps.findx.util.ResponseUtil;
import com.ford.apps.findx.web.vo.UserInfoVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "API RESTful Services")
@Controller
public class ApiController {

    @Autowired
    private UserService userService = null;

    @Autowired
    private AuthService authService = null;

    @Autowired
    private BaiduMapService baiduMapService = null;

    @Autowired
    private HttpSession session = null;

    @ApiOperation(value = "User try to logout", nickname = "Findx")
    @RequiresRoles(value = {"ADMIN", "USER"}, logical = Logical.OR)
    @GetMapping(value = "/api/logout/user")
    @ResponseBody
    public Object apiOfLogoutUser() {
        authService.logout();
        return ResponseUtil.ok("200", "User logout success.");
    }

    @ApiOperation(value = "Get user by id", nickname = "Findx")
    @RequiresRoles(value = {"ADMIN", "USER"}, logical = Logical.OR)
    @GetMapping(value = "/api/user/{id}")
    @ResponseBody
    public Object apiOfGetUserById(@ApiParam(value = "userId, i.e., (1)", required = true)
                                   @PathVariable(required = true, name = "id") long id) {
        User user = userService.getUserById(id);
        return ResponseUtil.ok("200", "Success.", user);
    }

    @ApiOperation(value = "Get all users", nickname = "Findx")
    @RequiresRoles("USER")
    @GetMapping(value = "/api/users/all")
    @ResponseBody
    public Object apiOfGetAllUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseUtil.ok("200", "Success.", userList);
    }

    @ApiOperation(value = "Search on Baidu Map for 中石化$福特", nickname = "Findx")
    @RequiresRoles(value = {"ADMIN", "USER"}, logical = Logical.OR)
    @GetMapping("/api/map/search")
    @ResponseBody
    public Object apiOfSearchOnMap(@ApiParam(value = "the latitude, i.e., 39.915", required = true)
                                   @RequestParam(required = true, name = "lat") String lat,
                                   @ApiParam(value = "the longitude, i.e., 116.404", required = true)
                                   @RequestParam(required = true, name = "lng") String lng) {
        UserInfoVo userInfo = (UserInfoVo) session.getAttribute(AppConstant.USER_CONFIG);
        List<LocationPoint> list = baiduMapService.searchOnPurpose(lat, lng, "中石化$福特", userInfo.getLoginId());
        return ResponseUtil.ok("200", "Success.", list);
    }

    @ApiOperation(value = "Analysis most popular site (中石化$福特)", nickname = "Findx")
    @RequiresRoles("ADMIN")
    @GetMapping("/api/map/tops")
    @ResponseBody
    public Object apiOfFetchTops() {
        List<LocationPoint> list = baiduMapService.getTops();
        return ResponseUtil.ok("200", "Success.", list);
    }
}