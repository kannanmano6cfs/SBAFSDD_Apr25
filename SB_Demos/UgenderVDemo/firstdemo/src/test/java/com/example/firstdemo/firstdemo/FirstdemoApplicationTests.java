package com.example.firstdemo.firstdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class FirstdemoApplicationTests {


	@Autowired
	repotest repot;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void contextLoads() throws Exception {
		model mod= new model();
		mod.setName("fss");
		mod.setUserName("testfss");
		mockMvc.perform(post("/test/addDemoone")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(mod)))
				.andExpect(status().isOk());
	}

}
