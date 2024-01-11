package com.example.InstituteManagementSystem.controller;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.domain.InstituteRepository;
import com.example.InstituteManagementSystem.service.InstituteReadService;
import com.example.InstituteManagementSystem.service.InstituteWriteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.Mockito.when;


@WebMvcTest
class InstituteControllerTest {

    @MockBean
    private InstituteWriteService instituteWriteService;
    @MockBean
    private InstituteReadService instituteReadService;
    @MockBean
    private InstituteRepository instituteRepository;
    @InjectMocks
    private InstituteController instituteController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void register() throws Exception {
        InstituteData instituteData = new InstituteData();
        instituteData.setName("Test Name");
        instituteData.setCode("Test Code");
        instituteData.setAddress1("Test Address1");
        instituteData.setAddress2("Test Address2");
        instituteData.setPhoneNo("Test PhoneNo");
        instituteData.setPinCode("Test PinCode");

       mockMvc.perform(MockMvcRequestBuilders.post("/institute/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instituteData)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    @Test
    void getInstitute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/institute/{id}",1L))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }
    @Test
    public void should_Return404_When_InstituteNotFound() throws Exception {

        when(instituteReadService.getInstitute(1L)).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/institut/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void update() throws Exception {
        InstituteData instituteData = new InstituteData();
        instituteData.setName("Test Name");
        instituteData.setCode("Test Code");
        instituteData.setAddress1("Test Address1");
        instituteData.setAddress2("Test Address2");
        instituteData.setPhoneNo("Test PhoneNo");
        instituteData.setPinCode("Test PinCode");

        mockMvc.perform(MockMvcRequestBuilders.put("/institute/{id}",1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instituteData)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }
}