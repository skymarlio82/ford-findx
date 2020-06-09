
package com.ford.apps.findx.web.vo;

public class UserInfoVo {

    private String loginId = null;
    private String avatarUrl = null;
    private String userName = null;
    private String userEmail = null;
    private String accessToken = null;
    private String localToken = null;

    public UserInfoVo() {

    }

    public UserInfoVo(String loginId, String avatarUrl, String userName, String userEmail, String accessToken) {
        this.loginId = loginId;
        this.avatarUrl = avatarUrl;
        this.userName = userName;
        this.userEmail = userEmail;
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "UserInfoVo#{loginId=" + loginId + ",avatarUrl=" + avatarUrl + ",userName=" + userName
            + ",userEmail=" + userEmail + ",accessToken=" + accessToken + ",localToken=" + localToken + "}";
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getLocalToken() {
        return localToken;
    }

    public void setLocalToken(String localToken) {
        this.localToken = localToken;
    }
}