
package com.ford.apps.findx.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ford.apps.findx.data.dao.UserMapper;
import com.ford.apps.findx.data.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper = null;

	@Test
	public void test01_getById() {
		User user = userMapper.findById(1);
		assertTrue(1 == user.getId());
	}

	@Test
	public void test02_getByName() {
		User user = userMapper.findByUsername("skymarlio82");
		assertTrue("skymarlio82".equals(user.getUsername()));
	}

	@Test
	public void test03_getAll() {
		List<User> users = userMapper.findAll();
		assertTrue(2 == users.size());
	}

	@Test
	public void test04_update() {
		User user = userMapper.findByUsername("test");
		assertTrue("098f6bcd4621d373cade4e832627b4f6".equals(user.getPassword()));
		userMapper.updatePwdByName("test", "password");
		User user1 = userMapper.findByUsername("test");
		assertTrue("password".equals(user1.getPassword()));
	}
}