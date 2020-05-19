
package com.ford.apps.findx.data.entity;

import java.util.List;

public class User {

	private Long id = 0L;
	private String username = null;
	private String password = null;
	private List<Authority> authorities = null;

	public User() {

	}

	@Override
	public String toString() {
		return "User#{id=" + id + ",username=" + username + ",password=" + password + ",authorities=" + authorities + "}";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
}