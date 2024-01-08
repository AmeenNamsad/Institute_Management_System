package com.example.InstituteManagementSystem.service;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.domain.InstituteRepository;
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
    public InstituteData getInstitute(Long id){
        InstituteData instituteData = new InstituteData();
        BeanUtils.copyProperties(instituteRepository.findById(id).get(),instituteData);
        return instituteData;
    }
}
