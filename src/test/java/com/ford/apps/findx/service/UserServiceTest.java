
package com.ford.apps.findx.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ford.apps.findx.data.entity.User;
import com.ford.apps.findx.domain.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

	@Autowired
	private UserService userService = null;

	@Test
	public void test01_getById() {
		User user = userService.getUserById(1);
		assertTrue(1 == user.getId());
	}

	@Test
	public void test02_getByName() {
		User user = userService.getUserByName("skymarlio82");
		assertTrue("skymarlio82".equals(user.getUsername()));
	}

	@Test
	public void test03_getAll() {
		List<User> users = userService.getAllUsers();
		assertTrue(2 == users.size());
	}

	@Test
	public void test04_uptPwd() {
		userService.updatePassword("test", "password");
		User user1 = userService.getUserById(2);
		assertTrue("password".equals(user1.getPassword()));
	}
}