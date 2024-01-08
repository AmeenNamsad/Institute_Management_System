package com.example.InstituteManagementSystem.service;


import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.domain.Institute;
import com.example.InstituteManagementSystem.domain.InstituteRepository;
import com.example.InstituteManagementSystem.exception.InstituteException;
import com.example.InstituteManagementSystem.serialization.InstituteDataValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

@Service
public class InstituteWriteServiceImpl implements InstituteWriteService {

    private InstituteRepository instituteRepository;
    private InstituteDataValidator instituteDataValidator;

    @Autowired
    public InstituteWriteServiceImpl(InstituteRepository instituteRepository, InstituteDataValidator instituteDataValidator) {
        this.instituteRepository = instituteRepository;
        this.instituteDataValidator = instituteDataValidator;
    }

    @Override
    public InstituteData register(InstituteData instituteData) {

        instituteDataValidator.validateForCreate(instituteData);
        Institute institute = new Institute();
        BeanUtils.copyProperties(instituteData, institute);
        try {
            instituteRepository.save(institute);
            instituteData.setId(institute.getId());
        } catch (final JpaSystemException | DataIntegrityViolationException dve) {
            handleDataIntegrityIssues(instituteData, dve.getMostSpecificCause());
        }
        return instituteData;
    }


    @Override
    public InstituteData modify(InstituteData instituteData, Long id) {

        Institute institute = instituteRepository.findById(id).get();
        if (instituteData.getName() != null && !instituteData.getName().trim().isEmpty() && !instituteData.getName().equals(institute.getName())) {
            institute.setName(instituteData.getName());
        }
        if (instituteData.getCode() != null && !instituteData.getCode().trim().isEmpty() && !instituteData.getCode().equals(institute.getCode())) {
            institute.setCode(instituteData.getCode());
        }
        if (instituteData.getAddress1() != null && !instituteData.getAddress1().trim().isEmpty() && !instituteData.getAddress1().equals(institute.getAddress1())) {
            institute.setAddress1(instituteData.getAddress1());
        }
        if (instituteData.getAddress2() != null && !instituteData.getAddress2().trim().isEmpty() && !instituteData.getAddress2().equals(institute.getAddress2())) {
            institute.setAddress2(instituteData.getAddress2());
        }
        if (instituteData.getPinCode() != null && !instituteData.getPinCode().trim().isEmpty() && !instituteData.getPinCode().equals(institute.getPinCode())) {
            institute.setPinCode(instituteData.getPinCode());
        }
        if (instituteData.getPhoneNo() != null && !instituteData.getPhoneNo().trim().isEmpty() && !instituteData.getPhoneNo().equals(institute.getPhoneNo())) {
            institute.setPhoneNo(instituteData.getPhoneNo());
        }
        try {
            instituteRepository.saveAndFlush(institute);
        } catch (final JpaSystemException | DataIntegrityViolationException dve) {
            handleDataIntegrityIssues(instituteData, dve.getMostSpecificCause());
            instituteData.setId(institute.getId());
        }
        BeanUtils.copyProperties(institute, instituteData);
        return instituteData;
    }

    private void handleDataIntegrityIssues(InstituteData instituteData, Throwable realCause) {

        if (realCause.getMessage().contains("code")) {
            if (instituteData.getCode() != null) {
                throw new InstituteException("error.msg.client.duplicate.code",
                        "Institute with code" + instituteData.getCode() + " already exists");
            }
        }
    }
}
