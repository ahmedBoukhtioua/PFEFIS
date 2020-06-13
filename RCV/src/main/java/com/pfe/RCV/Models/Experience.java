package com.pfe.RCV.Models;

import java.util.Date;
import java.util.Objects;

public class Experience {

    private Date startDate;
    private Date endDate;
    private String company;
    private String projectName;
    private String projectDescription;
    private String techno;
    private Type type;
    private String projectLink;

    public Experience(Date startDate, Date endDate, String company, String projectName, String projectDescription, String techno, Type type, String projectLink) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.techno = techno;
        this.type = type;
        this.projectLink = projectLink;

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getTechno() {
        return techno;
    }

    public void setTechno(String techno) {
        this.techno = techno;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(company, that.company) &&
                Objects.equals(projectName, that.projectName) &&
                Objects.equals(projectDescription, that.projectDescription) &&
                Objects.equals(techno, that.techno) &&
                type == that.type &&
                Objects.equals(projectLink, that.projectLink);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", company='" + company + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", techno='" + techno + '\'' +
                ", type=" + type +
                ", projectLink='" + projectLink + '\'' +
                '}';
    }
}
