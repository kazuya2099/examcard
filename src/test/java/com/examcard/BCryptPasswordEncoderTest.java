package com.examcard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BCryptPasswordEncoderTest {

	@Test
	public void encode() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashString = encoder.encode("password");
		System.out.println(hashString);
	}
}
