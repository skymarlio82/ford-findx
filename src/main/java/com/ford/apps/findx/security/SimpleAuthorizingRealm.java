
package com.ford.apps.findx.security;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.ford.apps.findx.data.entity.User;
import com.ford.apps.findx.domain.service.UserService;
import com.ford.apps.findx.util.SimpleMd5PasswordEncoder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService = null;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		String password = new String(upToken.getPassword());
		if (StringUtils.isEmpty(username)) {
			throw new AccountException("Username required.");
		}
		if (StringUtils.isEmpty(password)) {
			throw new AccountException("Password required.");
		}
		User user = userService.getUserByName(username);
		if (user == null) {
			throw new UnknownAccountException("User (" + username + ") not existed.");
		}
		SimpleMd5PasswordEncoder encoder = new SimpleMd5PasswordEncoder();
		if (!encoder.matches(password, user.getPassword())) {
			throw new UnknownAccountException("Username (" + username + ") and its password not matched.");
		}
		return new SimpleAuthenticationInfo(user, password, getName());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException("PrincipalCollection method argument required.");
		}
		User user = (User) getAvailablePrincipal(principals);
		Set<String> permissions = new HashSet<String>();
		Set<String> roles = user.getAuthorities().stream().map(a -> a.getName()).collect(Collectors.toSet());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roles);
		info.setStringPermissions(permissions);
		return info;
	}
}