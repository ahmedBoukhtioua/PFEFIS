package com.pfe.RCV.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

public class SignupRequest {
    private  String eNumber ;
    private  String password ;
    private String email ;
    private String fName;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    private String adress;
    private Date birthDate;
    private Set<String> role ;

    public SignupRequest(String eNumber, String password, String email) {
        eNumber = eNumber;
        this.password = password;
        this.email = email;
    }

    public SignupRequest(String password, String email, String fName, String adress, Date birthDate) {
        this.password = password;
        this.email = email;
        this.fName = fName;
        this.adress = adress;
        this.birthDate = birthDate;
    }

    public SignupRequest() {
    }

    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    public Set<String> getRoles() {
        return role;
    }

    public void setRoles(Set<String> roles) {
        this.role = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
