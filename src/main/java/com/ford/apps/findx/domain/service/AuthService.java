
package com.ford.apps.findx.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ford.apps.findx.common.constant.AppConstant;
import com.ford.apps.findx.data.entity.User;
import com.ford.apps.findx.util.SimpleMd5PasswordEncoder;
import com.ford.apps.findx.web.vo.AccessTokenVo;
import com.ford.apps.findx.web.vo.UserInfoVo;

@Service
public class AuthService {

    @Value("${github-client-secret}")
    private String GITHUB_FORD_FINDX_CLIENT_SECRET = null;

    @Autowired
    private UserService userService = null;

    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Transactional
    public void loginAsOAuth2(String code, HttpServletRequest request, HttpServletResponse response) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<MediaType> accepts = new ArrayList<>();
        accepts.add(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(accepts);
        HttpEntity<String> req = new HttpEntity<>(headers);
        String url1 = AppConstant.LOGIN_OAUTH_TOKEN_HEAD_PART
            + "?client_id=" + AppConstant.GITHUB_FORD_FINDX_CLIENT_ID
            + "&client_secret=" + GITHUB_FORD_FINDX_CLIENT_SECRET
            + "&code=" + code;
        ResponseEntity<AccessTokenVo> res1 = restTemplate.postForEntity(url1, req, AccessTokenVo.class);
        AccessTokenVo atvo = res1.getBody();
        headers.set("Authorization", "token " + atvo.getAccess_token());
        String url2 = AppConstant.API_USER_INFO_HEAD_PART + "?access_token=" + atvo.getAccess_token();
        ResponseEntity<HashMap> res2 = restTemplate.getForEntity(url2, HashMap.class);
        HashMap<String, String> info = res2.getBody();
        UserInfoVo userInfo = new UserInfoVo(info.get("login"), info.get("avatar_url"),
            info.get("name"), info.get("email"), atvo.getAccess_token());
        User user = userService.getUserByName(userInfo.getLoginId());
        if (user == null) {
            response.setHeader("Location", request.getContextPath() + "/user/default/logout?err=1");
            response.setStatus(302);
            return;
        }
        userService.updatePassword(userInfo.getLoginId(),
            (new SimpleMd5PasswordEncoder()).encode(userInfo.getLoginId()));
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(new UsernamePasswordToken(userInfo.getLoginId(), userInfo.getLoginId()));
        } catch (UnknownAccountException uae) {
            uae.printStackTrace();
        } catch (LockedAccountException lae) {
            lae.printStackTrace();
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
        }
        currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        userInfo.setLocalToken(session.getId().toString());
        session.setAttribute(AppConstant.USER_CONFIG, userInfo);
        response.setHeader("Location", request.getContextPath() + "/system/dashboard?token=" + session.getId());
        response.setStatus(302);
    }
}