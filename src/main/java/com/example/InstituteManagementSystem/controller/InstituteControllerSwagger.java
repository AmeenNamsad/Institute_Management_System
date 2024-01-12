package com.example.InstituteManagementSystem.controller;

import io.swagger.v3.oas.annotations.media.Schema;

public class InstituteControllerSwagger {


    private InstituteControllerSwagger() {
    }

    @Schema(description = "PostRegisterRequest")
    public static final class PostRegisterRequest {

        private PostRegisterRequest() {
        }

        @Schema(example = "Test Institute")
        private String name;

        @Schema(example = "1")
        private String code;

        @Schema(example = "Bengalure")
        private String address1;

        @Schema(example = "karnataka")
        private String address2;

        @Schema(example = "560068")
        private String pinCode;

        @Schema(example = "+919995559995")
        private String phoneNo;
    }

    @Schema(description = "PostRegisterResponse")
    public static final class PostRegisterResponse {

        private PostRegisterResponse() {
        }

        @Schema(example = "1")
        private Long id;

        @Schema(example = "Test Institute")
        private String name;

        @Schema(example = "1")
        private String code;

        @Schema(example = "Bengalure")
        private String address1;

        @Schema(example = "karnataka")
        private String address2;

        @Schema(example = "560068")
        private String pinCode;

        @Schema(example = "+919995559995")
        private String phoneNo;
    }


    @Schema(description = "modifyInstituteRequest")
    public static final class modifyInstituteRequest {

        private modifyInstituteRequest() {
        }

        @Schema(example = "Test Institute")
        private String name;

        @Schema(example = "1")
        private String code;

        @Schema(example = "Bengalure")
        private String address1;

        @Schema(example = "karnataka")
        private String address2;

        @Schema(example = "560068")
        private String pinCode;

        @Schema(example = "+919995559995")
        private String phoneNo;
    }

    @Schema(description = "modifyInstituteResponse")
    public static final class modifyInstituteResponse {

        private modifyInstituteResponse() {
        }

        @Schema(example = "1")
        private Long id;

        @Schema(example = "Test Institute")
        private String name;

        @Schema(example = "1")
        private String code;

        @Schema(example = "Bengalure")
        private String address1;

        @Schema(example = "karnataka")
        private String address2;

        @Schema(example = "560068")
        private String pinCode;

        @Schema(example = "+919995559995")
        private String phoneNo;
    }

    @Schema(description = "GetInstituteResponse")
    public static final class GetInstituteResponse {

        private GetInstituteResponse() {
        }

        @Schema(example = "1")
        private Long id;

        @Schema(example = "Test Institute")
        private String name;

        @Schema(example = "1")
        private String code;

        @Schema(example = "Bengalure")
        private String address1;

        @Schema(example = "karnataka")
        private String address2;

        @Schema(example = "560068")
        private String pinCode;

        @Schema(example = "+919995559995")
        private String phoneNo;
    }
}