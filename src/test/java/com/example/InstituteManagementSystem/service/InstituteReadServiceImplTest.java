package com.example.InstituteManagementSystem.service;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.domain.Institute;
import com.example.InstituteManagementSystem.domain.InstituteRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class InstituteReadServiceImplTest {
    @Mock
    private InstituteRepository instituteRepository;

    @Mock
    private InstituteReadService instituteService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getInstitute() {

        Institute institute = new Institute();
        institute.setId(1L);
        institute.setName("Test Name");
        institute.setCode("Test Code");
        institute.setAddress1("Test Address1");
        institute.setAddress2("Test Address2");
        institute.setPhoneNo("Test PhoneNo");
        institute.setPinCode("Test PinCode");

        // Call the service method
        InstituteData result = instituteService.getInstitute(1L);
        when(instituteRepository.findById(anyLong())).thenReturn(Optional.of(institute));


        // Verify that the repository method was called with the correct parameter
        // (optional, but useful for ensuring that the correct interactions are happening)
        // Mockito.verify(instituteRepository).findById(instituteId);

        // Verify that the result matches the expected data
        assertEquals("Test Name", result.getName());
        assertEquals("Test Code", result.getCode());
        assertEquals("Test Address1", result.getAddress1());
    }
}