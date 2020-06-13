package com.pfe.RCV.payload.response;

import java.util.List;

public class JwtResponse {
    private  String token ;
    private  String type ="Bearer";
    private String id ;
    private String eNumber ;
    private String email ;
    private List<String>roles ;

    public JwtResponse(String token, String type, String id, String eNumber, String email, List<String> roles) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.eNumber = eNumber;
        this.email = email;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;

    }

    public JwtResponse(String token, String id, String eNumber, String email, List<String> roles) {
        this.token = token;
        this.id = id;
        this.eNumber = eNumber;
        this.email = email;
        this.roles = roles;
    }
}
