
package com.ford.apps.findx.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JasyptUtilTests {

	@Test
	public void test01_decyptDevSecret() {
		assertTrue("637bef1188d35e99e60587c3e1bc84a630cfb198"
			.equals(JasyptUtil.decyptPwd("EbfYkitulv73I2p0mXI50JMXoaxZTKJ7",
				"WoJq9PfJNIl0TEPhTtuvYa34D3o6D2KekPHF80SiGz86rmAoElkdoP2ZTZYufL727ksVJovU9TU=")));
	}

	@Test
	public void test02_decyptStgSecret() {
		assertTrue("d4966da1d5526d8d56b436b2ab30d0b6fc7ed736"
			.equals(JasyptUtil.decyptPwd("EbfYkitulv73I2p0mXI50JMXoaxZTKJ7",
				"QLkx83lqXCnpT1zgp8miYO0lBgTLjHwu8ibhVuXB62cnnvbVf3CAMaW6FoR9yTcIYDvn6H5QjpI=")));
	}

	@Test
	public void test03_En_De_DevSecret() {
		String enc = JasyptUtil.encryptPwd("EbfYkitulv73I2p0mXI50JMXoaxZTKJ7",
			"637bef1188d35e99e60587c3e1bc84a630cfb198");
		assertTrue("637bef1188d35e99e60587c3e1bc84a630cfb198"
			.equals(JasyptUtil.decyptPwd("EbfYkitulv73I2p0mXI50JMXoaxZTKJ7", enc)));
	}
}