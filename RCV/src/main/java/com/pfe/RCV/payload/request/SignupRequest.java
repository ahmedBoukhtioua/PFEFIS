package com.pfe.RCV.payload.request;

import java.util.Set;

public class SignupRequest {
    private  String eNumber ;
    private  String password ;
    private String email ;
    private Set<String> role ;
    public SignupRequest(String eNumber, String password, String email) {
        eNumber = eNumber;
        this.password = password;
        this.email = email;
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

}
