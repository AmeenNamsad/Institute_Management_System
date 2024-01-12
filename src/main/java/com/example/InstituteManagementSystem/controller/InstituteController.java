package com.example.InstituteManagementSystem.controller;

import com.example.InstituteManagementSystem.data.InstituteData;
import com.example.InstituteManagementSystem.service.InstituteReadService;
import com.example.InstituteManagementSystem.service.InstituteWriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/institute")
public class InstituteController {

    private final InstituteWriteService instituteWriteService;
    private final InstituteReadService instituteReadService;

    @Autowired
    public InstituteController(final InstituteWriteService instituteWriteService, final InstituteReadService instituteReadService) {
        this.instituteWriteService = instituteWriteService;
        this.instituteReadService = instituteReadService;
    }

    @PostMapping("/register")
    @Operation(summary = "Register Institute", description = "Register institute along with details",
            requestBody = @RequestBody(required = true, content = @Content(schema = @Schema(implementation = InstituteControllerSwagger.PostRegisterRequest.class))),
            responses = @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InstituteControllerSwagger.PostRegisterResponse.class))))
    public ResponseEntity<InstituteData> register(@RequestBody InstituteData instituteData) {
        return ResponseEntity.ok(instituteWriteService.register(instituteData));
    }

    @GetMapping("{id}")
    @Operation(summary = "Fetch Institute", description = "Get Institute details",
            responses = @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InstituteControllerSwagger.GetInstituteResponse.class))))
    public ResponseEntity<InstituteData> getInstitute(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(instituteReadService.getInstitute(id));
    }

    @PutMapping("{id}")
    @Operation(summary = "Modify Institute", description = "Modify institute",
            requestBody = @RequestBody(required = true, content = @Content(schema = @Schema(implementation = InstituteControllerSwagger.modifyInstituteRequest.class))),
            responses = @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InstituteControllerSwagger.modifyInstituteResponse.class))))
    public ResponseEntity<InstituteData> modifyInstitute(@PathVariable(value = "id") Long id, @RequestBody InstituteData instituteData) {
        return ResponseEntity.ok(instituteWriteService.modify(instituteData, id));
    }

}
