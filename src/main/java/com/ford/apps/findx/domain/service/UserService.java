
package com.ford.apps.findx.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ford.apps.findx.data.dao.UserMapper;
import com.ford.apps.findx.data.entity.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper = null;

	@Transactional(readOnly=true)
	public User getUserByName(String userName) {
		return userMapper.findByUsername(userName);
	}

	@Transactional(readOnly=true)
    public User getUserById(long id) {
        return userMapper.findById(id);
    }

	@Transactional(readOnly=true)
	public List<User> getAllUsers() {
		return userMapper.findAll();
	}

	@Transactional
	public void updatePassword(String username, String password) {
		userMapper.updatePwdByName(username, password);
	}
}