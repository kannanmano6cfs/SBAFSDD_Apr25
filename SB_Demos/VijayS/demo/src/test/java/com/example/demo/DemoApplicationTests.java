package com.example.demo;

import com.example.demo.model.customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class DemoApplicationTests {
	@Autowired
	private ObjectMapper objectMapper;


	@Autowired
	MockMvc mockMvc;

	@Test
	void test1() throws Exception {
		mockMvc.perform(get("/cusdetails")).andExpect(status().isOk());
	}

	@Test
	void test2() throws Exception {
		customer cus = new customer();
		cus.setBookcount("1");
		cus.setBookdescription("test");
		cus.setBookprice("10");
		cus.setCustomername("surya");


		mockMvc.perform(post("/addcustomer")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(cus)))
				.andExpect(status().isOk());
	}
}
