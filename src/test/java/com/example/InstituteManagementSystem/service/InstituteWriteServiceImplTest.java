package com.example.InstituteManagementSystem.service;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.domain.Institute;
import com.example.InstituteManagementSystem.domain.InstituteRepository;
import com.example.InstituteManagementSystem.exception.InstituteException;
import com.example.InstituteManagementSystem.serialization.InstituteDataValidator;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class InstituteWriteServiceImplTest {

    @InjectMocks
    private InstituteWriteServiceImpl instituteWriteService;

    @InjectMocks
    private InstituteDataValidator instituteDataValidator;


    @Mock
    private InstituteDataValidator instituteDataValidatorMock;

    @Mock
    private InstituteRepository instituteRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register() {
        InstituteData institute = new InstituteData();
        institute.setId(1L);
        institute.setName("Test Name");
        institute.setCode("Test Code");
        institute.setAddress1("Test Address1");
        institute.setAddress2("Test Address2");
        institute.setPhoneNo("Test PhoneNo");
        institute.setPinCode("Test PinCode");
        InstituteData result=instituteWriteService.register(institute);
        assertEquals(1L, result.getId());
        assertEquals("Test Name", result.getName());
        assertEquals("Test Code", result.getCode());
        assertEquals("Test Address1", result.getAddress1());
        assertEquals("Test Address2", result.getAddress2());
        assertEquals("Test PhoneNo", result.getPhoneNo());
        assertEquals("Test PinCode", result.getPinCode());
        verify(instituteRepository, times(1)).save(any(Institute.class));
    }

    @Test
    void modify() {

        InstituteData institute = new InstituteData();
        institute.setName("Test Name");
        institute.setCode("Test Code");
        institute.setAddress1("Test Address1");
        institute.setAddress2("Test Address2");
        institute.setPhoneNo("Test PhoneNo");
        institute.setPinCode("Test PinCode");

        Institute instituteClass = new Institute();
        instituteClass.setId(1L);
        instituteClass.setName("Test Name");
        instituteClass.setCode("Test Code");
        instituteClass.setAddress1("Test Address1");
        instituteClass.setAddress2("Test Address2");
        instituteClass.setPhoneNo("Test PhoneNo");
        instituteClass.setPinCode("Test PinCode");
        when(instituteRepository.findById(anyLong())).thenReturn(Optional.of(instituteClass));
        InstituteData result=instituteWriteService.modify(institute,1L);
        assertEquals(1L, result.getId());
        assertEquals("Test Name", result.getName());
        assertEquals("Test Code", result.getCode());
        assertEquals("Test Address1", result.getAddress1());
        assertEquals("Test Address2", result.getAddress2());
        assertEquals("Test PhoneNo", result.getPhoneNo());
        assertEquals("Test PinCode", result.getPinCode());
        verify(instituteRepository, times(1)).saveAndFlush(any(Institute.class));
    }

    @Test
    void saveInstituteDetails_Exception() {
        InstituteData instituteData = new InstituteData();
        instituteData.setName("Test Name");instituteData.setCode("Test Code");
        instituteData.setAddress1("Test Address1");
        instituteData.setAddress2("Test Address2");
        instituteData.setPhoneNo("Test PhoneNo");
        instituteData.setPinCode("Test PinCode");
        instituteData.setName(null);InstituteException exception = assertThrows(InstituteException.class,
                () -> instituteDataValidator.validateForCreate(instituteData));
        assertEquals("Name is mandatory!", exception.getMessage());
        verify(instituteRepository, never()).save(any(Institute.class));
    }
}