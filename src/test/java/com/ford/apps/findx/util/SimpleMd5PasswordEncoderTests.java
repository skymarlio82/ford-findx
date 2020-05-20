
package com.ford.apps.findx.util;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleMd5PasswordEncoderTests {

	@Test
	public void test01_md5_skymarlio82() {
		SimpleMd5PasswordEncoder encoder = new SimpleMd5PasswordEncoder();
		assertTrue(encoder.matches("skymarlio82", "1713b22df240e72c083acb34aa05e537"));
	}

	@Test
	public void test02_md5_test() {
		SimpleMd5PasswordEncoder encoder = new SimpleMd5PasswordEncoder();
		assertTrue(encoder.matches("test", "098f6bcd4621d373cade4e832627b4f6"));
	}
}