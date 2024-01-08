package com.example.InstituteManagementSystem.controller;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.domain.Institute;
import com.example.InstituteManagementSystem.domain.InstituteRepository;
import com.example.InstituteManagementSystem.service.InstituteReadService;
import com.example.InstituteManagementSystem.service.InstituteWriteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class InstituteControllerTest {

    @Mock
    private InstituteWriteService instituteWriteService;
    @Mock
    private InstituteReadService instituteReadService;
    @Mock
    private InstituteRepository instituteRepository;

    @InjectMocks
    private InstituteController instituteController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register() throws Exception {
        InstituteData instituteData = new InstituteData();
        instituteData.setName("Test Name");
        instituteData.setCode("Test Code");
        instituteData.setAddress1("Test Address1");
        instituteData.setAddress2("Test Address2");
        instituteData.setPhoneNo("Test PhoneNo");
        instituteData.setPinCode("Test PinCode");

        when(instituteWriteService.register(any(InstituteData.class))).thenReturn(instituteData);
        mockMvc.perform(MockMvcRequestBuilders.post("/institute/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instituteData)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test Name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("Test Code"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address1").value("Test Address1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address2").value("Test Address2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pinCode").value("Test PinCode"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNo").value("Test PhoneNo"));
    }

    @Test
    void getInstitute() throws Exception {
        InstituteData instituteData = new InstituteData();
        instituteData.setId(1L);
        instituteData.setName("Test Name");
        instituteData.setCode("Test Code");
        instituteData.setAddress1("Test Address1");
        instituteData.setAddress2("Test Address2");
        instituteData.setPhoneNo("Test PhoneNo");
        instituteData.setPinCode("Test PinCode");

        Institute institute = new Institute();
        institute.setId(1L);
        institute.setName("Test Name");
        institute.setCode("Test Code");
        institute.setAddress1("Test Address1");
        institute.setAddress2("Test Address2");
        institute.setPhoneNo("Test PhoneNo");
        institute.setPinCode("Test PinCode");

        when(instituteRepository.findById(any(Long.class))).thenReturn(Optional.of(institute));
        when(instituteReadService.getInstitute(any(Long.class))).thenReturn(instituteData);
        mockMvc.perform(MockMvcRequestBuilders.get("/institute/{id}",1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test Name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("Test Code"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address1").value("Test Address1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address2").value("Test Address2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pinCode").value("Test PinCode"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNo").value("Test PhoneNo"));
    }
//
//    @Test
//    void modifyInstitute() {
//    }
}