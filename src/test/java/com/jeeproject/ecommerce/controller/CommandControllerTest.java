package com.jeeproject.ecommerce.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeeproject.ecommerce.model.Command;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CommandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private String urlBase = "/command/";

    @Test
    void getAllCommands() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(urlBase))
                .andExpect(status().isOk());
    }

    @Test
    void getCommandByCommandCode() {
    }

    @Test
    void addCommand() throws Exception {

        Command mockCommand = new Command();

        List<Product> mockProductList = mockCommand.getProductList();

        mockProductList.add(new Product("chargeur","fakeUrlImg",15L,4,"fakeProductCode"));
        mockProductList.add(new Product("chargeur","fakeUrlImg",15L,4,"fakeProductCode"));
        mockProductList.add(new Product("chargeur","fakeUrlImg",15L,4,"fakeProductCode"));

        mockCommand.setProductList(mockProductList);

        mockCommand.setCommandDate("XX-XX-XXXX");
        mockCommand.setUserCode("FakeUserCode");
        mockCommand.setProductList((mockProductList));
        mockCommand.setDeliveryAddress("58 Boulevard DEsGranges");


        mockMvc.perform(MockMvcRequestBuilders.post(urlBase)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockCommand)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateCommand() {
    }

    @Test
    void deleteCommand() {
    }
}