package com.example.InstituteManagementSystem.service;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.domain.Institute;
import com.example.InstituteManagementSystem.domain.InstituteRepository;
import com.example.InstituteManagementSystem.exception.InstituteException;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InstituteReadServiceImplTest {
    @Mock
    private InstituteRepository instituteRepository;

    @InjectMocks
    private InstituteReadServiceImpl instituteService;

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

        when(instituteRepository.findById(anyLong())).thenReturn(Optional.of(institute));
        InstituteData result = instituteService.getInstitute(1L);
        assertEquals("Test Name", result.getName());
        assertEquals("Test Code", result.getCode());
        assertEquals("Test Address1", result.getAddress1());
        assertEquals("Test Address1", result.getAddress1());
        assertEquals("Test Address1", result.getAddress1());
        assertEquals("Test Address1", result.getAddress1());
        verify(instituteRepository, times(1)).findById(any(Long.class));
        verifyNoMoreInteractions(instituteRepository);
    }

    @Test
    void getInstituteDetails_Exception() {
        InstituteException exception = assertThrows(InstituteException.class,
                () -> instituteService.getInstitute(1L));
        assertEquals("Institute Not Found with identifier 1", exception.getMessage());
        verify(instituteRepository, never()).saveAndFlush(any(Institute.class));
    }
}