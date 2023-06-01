package com.example.test_easy_bot;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestEasyBotApplication.class)
@AutoConfigureMockMvc
@Transactional
class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void createProduct_Returns_201() throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("type", "PC");
        jo.put("serialNumber", "123");
        jo.put("manufacturer", "Manufacturer A");
        jo.put("price", 10000);
        jo.put("amount", 20);
        jo.put("pcFormFactor", "Desktop");
        mvc.perform(MockMvcRequestBuilders.post("/product/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jo.toString()))
                .andExpect(status().isCreated());
    }

    @Test
    void changeProduct_Returns_200() throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("id", 1);
        jo.put("type", "PC");
        jo.put("serialNumber", "123");
        jo.put("manufacturer", "Manufacturer A");
        jo.put("price", 10000);
        jo.put("amount", 20);
        jo.put("pcFormFactor", "Desktop");
        mvc.perform(MockMvcRequestBuilders.post("/product/change")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jo.toString()))
                .andExpect(status().isOk());

    }

    @Test
    void getAllProducts_Returns_200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    void getProduct_Returns_200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void deleteProduct_Returns_200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/product/{id}", 1))
                .andExpect(status().isOk());
    }
}
