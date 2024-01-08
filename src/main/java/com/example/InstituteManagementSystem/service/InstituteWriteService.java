package com.example.InstituteManagementSystem.service;

import com.example.InstituteManagementSystem.data.InstituteData;

public interface InstituteWriteService {

    InstituteData register(InstituteData institute);

    InstituteData modify(InstituteData instituteData, Long id);
}
