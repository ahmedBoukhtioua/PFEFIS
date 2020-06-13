package com.pfe.RCV.Models;

import java.util.Objects;

public class AssociativeExperience {
    private String startDate;
    private String endDate;
    private String association;
    private String post;

    public AssociativeExperience(String startDate, String endDate, String association, String post) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.association = association;
        this.post = post;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "AssociativeExperience{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", association='" + association + '\'' +
                ", post='" + post + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssociativeExperience that = (AssociativeExperience) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(association, that.association) &&
                Objects.equals(post, that.post);
    }

}
