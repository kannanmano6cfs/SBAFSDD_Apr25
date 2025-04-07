package com.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Demo1ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	 @LocalServerPort
	   private int port;
	
	@Test
	void tesGetDemo() throws Exception {
		String str=restTemplate.getForObject("http://localhost:"+port+"/demo", String.class);
		System.out.println(str+port);
		Assertions.assertEquals("OK", str);
		
	}
}
