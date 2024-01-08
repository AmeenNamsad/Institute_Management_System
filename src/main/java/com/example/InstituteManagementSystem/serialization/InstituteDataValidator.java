package com.example.InstituteManagementSystem.serialization;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.exception.InstituteException;
import org.springframework.stereotype.Component;

@Component
public class InstituteDataValidator {

    public void validateForCreate(InstituteData instituteData) {

        if (instituteData.getName() == null || instituteData.getName().trim().isEmpty()) {
            throw new InstituteException("error.name.mandatory", "Name is mandatory!", "name");
        }
        if (instituteData.getCode() == null || instituteData.getCode().trim().isEmpty()) {
            throw new InstituteException("error.code.mandatory", "Code is mandatory!", "code");
        }
    }
}
