package com.example.InstituteManagementSystem.domain;


import javax.persistence.*;

@Entity
@Table(name = "institute", uniqueConstraints = {@UniqueConstraint(columnNames = {"code"}, name = "code_unique")})
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Column
    private String address1;

    @Column
    private String address2;

    @Column
    private String pinCode;

    @Column
    private String phoneNo;

    public Institute(String name, String code, String address1, String address2, String pinCode, String phoneNo) {
        this.name = name;
        this.code = code;
        this.address1 = address1;
        this.address2 = address2;
        this.pinCode = pinCode;
        this.phoneNo = phoneNo;
    }

    public Institute() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
