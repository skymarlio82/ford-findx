
package com.ford.apps.findx.web.vo;

public class AccessTokenVo {

    private String access_token = null;
    private String token_type = null;
    private String scope = null;

    public AccessTokenVo() {

    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}