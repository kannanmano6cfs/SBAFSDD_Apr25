package com.learning.exproductservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.exproductservice.Model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ExProductServiceApplicationTests {


//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private stubRepository repo;

    @Autowired
    MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        mockMvc.perform(get("/api/products")).andExpect(status().isOk());
    }

    @Test
    void test2() throws Exception {
        Product product = new Product();
        product.setPrdname("Samsung_M33");
        product.setPrddescription("Samsung M33 mobile device");
        product.setPrdprice("35000");
        product.setPrdcount("10");

        mockMvc.perform(post("/api/addproduct1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk());
    }
//        long ct = restTemplate.getForObject("/api/count", Long.class);
//        Assertions.assertEquals(ct,1);



}
