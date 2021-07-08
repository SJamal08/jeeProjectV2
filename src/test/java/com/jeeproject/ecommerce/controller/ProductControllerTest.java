package com.jeeproject.ecommerce.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeeproject.ecommerce.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private String urlBase = "/product/";

    @Test
    void getAllProducts() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(urlBase))
                .andExpect(status().isOk());
    }

    @Test
    void getProductByProductCode() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(urlBase+"find/pr-ed895676-5822-43af-8408-a805aa9f2005"))
                .andExpect(status().isOk());
    }

    @Test
    void addProduct() throws Exception {

        Product mockProduct = new Product();

        mockProduct.setPrice(15L);
        mockProduct.setRating(4);
        mockProduct.setTitle("Chargeur iphone 6 d'occasion");
        mockProduct.setImageUrl("Fake url image");

        mockMvc.perform(MockMvcRequestBuilders.post(urlBase)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockProduct)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateProduct() throws Exception {

        Product mockProduct = new Product();

        mockProduct.setPrice(15L);
        mockProduct.setRating(4);
        mockProduct.setTitle("Chargeur iphone 6 neuf");
        mockProduct.setImageUrl("Fake url image");
        mockProduct.setProductCode("pr-74746039-3508-4490-aeac-02d2749bd1d1");
        mockProduct.setIdProduct(16L);

        mockMvc.perform(MockMvcRequestBuilders.put(urlBase+"update/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockProduct)))
                .andExpect(status().isOk());


    }

    @Test
    void deleteProduct() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete(urlBase+"delete/pr-74746039-3508-4490-aeac-02d2749bd1d1")).andExpect(status().isOk());

    }
}