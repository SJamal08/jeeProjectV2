package com.jeeproject.ecommerce.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeeproject.ecommerce.model.User;
import com.jeeproject.ecommerce.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserService userService;

    private String urlBase = "/user/";

    @Test
    void getAllUsers() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(urlBase)).andExpect(status().isOk());

    }

    @Test
    void getUserByUserCode() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(urlBase+"find/280501f5-9176-4ed8-a58c-c0065c772dec")).andExpect(status().isOk());
    }

    @Test
    void addUser() throws Exception {
        User mockUser = new User("Jamal", "jams@gmail.com", "000321234" , "FakePassword" , "58 Boulevard DEsGranges");

        mockMvc.perform(MockMvcRequestBuilders.post(urlBase)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockUser)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateEmployee() throws Exception {

        User mockUser = new User();

        mockUser.setUserCode("aa0ad472-7f1d-4aac-bc81-aab64be6c29d");

        mockMvc.perform(MockMvcRequestBuilders.put(urlBase+"update/").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(mockUser))).andExpect(status().isOk());
    }

    @Test
    void deleteUser() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete(urlBase+"delete/aa0ad472-7f1d-4aac-bc81-aab64be6c29d")).andExpect(status().isOk());
    }
}