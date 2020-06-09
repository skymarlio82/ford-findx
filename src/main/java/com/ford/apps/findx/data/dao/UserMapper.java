
package com.ford.apps.findx.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ford.apps.findx.data.entity.User;

@Mapper
public interface UserMapper {

    User findByUsername(String username);

    User findById(long id);

    List<User> findAll();

    void updatePwdByName(String username, String password);
}