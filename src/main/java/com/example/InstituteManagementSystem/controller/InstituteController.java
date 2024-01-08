package com.example.InstituteManagementSystem.controller;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.service.InstituteReadService;
import com.example.InstituteManagementSystem.service.InstituteWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/institute")
public class InstituteController {

    private InstituteWriteService instituteWriteService;
    private InstituteReadService instituteReadService;

    @Autowired
    public InstituteController(InstituteWriteService instituteWriteService, InstituteReadService instituteReadService) {
        this.instituteWriteService = instituteWriteService;
        this.instituteReadService = instituteReadService;
    }

    @PostMapping("/register")
    public ResponseEntity<InstituteData> register(@RequestBody InstituteData instituteData) {
        return ResponseEntity.ok(instituteWriteService.register(instituteData));
    }

    @GetMapping("{id}")
    public ResponseEntity<InstituteData> getInstitute(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(instituteReadService.getInstitute(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<InstituteData> modifyInstitute(@PathVariable(value = "id") Long id, @RequestBody InstituteData instituteData) {
        return ResponseEntity.ok(instituteWriteService.modify(instituteData, id));
    }

}
