
package com.ford.apps.findx.common.constant;

public class AppConstant {

	// ==== DEV setting for GitHub OAuth2 in Testing Environment ====
	public final static String GITHUB_FORD_FINDX_CLIENT_ID = "4d211460686aae6ab414";
	public final static String GITHUB_FORD_FINDX_REDIRECT_URI = "http://localhost:8080/ford-findx/authorization/callback";

	// ==== STG setting for GitHub OAuth2 in Testing Environment ====
//	public final static String GITHUB_FORD_FINDX_CLIENT_ID = "17c2fcd07dc49ce2fac1";
//	public final static String GITHUB_FORD_FINDX_REDIRECT_URI = "https://www.skymarlio.com/ford-findx/authorization/callback";

	public final static String LOGIN_OAUTH_TOKEN_HEAD_PART = "https://github.com/login/oauth/access_token";
	public final static String API_USER_INFO_HEAD_PART = "https://api.github.com/user";
	public final static String BAIDU_MAP_SEARCH_API_HEAD_PART = "http://api.map.baidu.com/place/v2/search";
	public final static String BAIDU_MAP_SEARCH_RADIUS = "5000";

	public final static String USER_CONFIG = "USER_CONFIG";

	public final static String USER_LOGIN_FORM_PAGE = "USER_LOGIN_FORM_PAGE";
	public final static String USER_LOGOUT_END_PAGE = "USER_LOGOUT_END_PAGE";
	public final static String GLOBAL_SYSTEM_INFO_PAGE = "GLOBAL_SYSTEM_INFO_PAGE";
}