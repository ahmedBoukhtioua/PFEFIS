package com.pfe.RCV.Models;

import java.io.Serializable;
import java.util.List;

public class test implements Serializable {

    private String user;
    private List<String> skills;
    private List<String> langue;

    public test() {
    }

    public test(String user, List<String> skills, List<String> langue) {
        this.user = user;
        this.skills = skills;
        this.langue = langue;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getLangue() {
        return langue;
    }

    public void setLangue(List<String> langue) {
        this.langue = langue;
    }
}
