package com.example.InstituteManagementSystem.service;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.domain.Institute;
import com.example.InstituteManagementSystem.domain.InstituteRepository;
import com.example.InstituteManagementSystem.exception.InstituteException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InstituteReadServiceImpl implements InstituteReadService {

    private InstituteRepository instituteRepository;

    @Autowired
    public InstituteReadServiceImpl(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteData getInstitute(Long id) {
        InstituteData instituteData = new InstituteData();
        Institute institute = instituteRepository.findById(id)
                .orElseThrow(() -> new InstituteException("intitute.not.found", "Institute Not Found with identifier " + id, id));
        BeanUtils.copyProperties(institute, instituteData);
        return instituteData;
    }
}
