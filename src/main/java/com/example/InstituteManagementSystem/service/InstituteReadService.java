package com.example.InstituteManagementSystem.service;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.domain.Institute;

import java.util.Optional;

public interface InstituteReadService {

    InstituteData getInstitute(Long id);
}
