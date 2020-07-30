package com.pfe.RCV.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "jobOffer")
public class JobOffer {
    @Id
    private String id;
    private  String projectName;
    private String  projectDescription;
    private Date   startDate;
    private Date endDate;
    @DBRef
    private List<User> listCandidat;
    @DBRef
    private User manager;
    private boolean valide;
    private boolean archive;


    public JobOffer() {
    }

    public JobOffer(String id, String projectName, String projectDescription, Date startDate, Date endDate, List<User> listCandidat, User manager, boolean valide, boolean archive) {
        this.id = id;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.listCandidat = listCandidat;
        this.manager = manager;
        this.valide = valide;
        this.archive = archive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<User> getListCandidat() {
        return listCandidat;
    }

    public void setListCandidat(List<User> listCandidat) {
        this.listCandidat = listCandidat;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobOffer jobOffer = (JobOffer) o;
        return valide == jobOffer.valide &&
                archive == jobOffer.archive &&
                Objects.equals(projectName, jobOffer.projectName) &&
                Objects.equals(projectDescription, jobOffer.projectDescription) &&
                Objects.equals(startDate, jobOffer.startDate) &&
                Objects.equals(endDate, jobOffer.endDate) &&
                Objects.equals(listCandidat, jobOffer.listCandidat) &&
                Objects.equals(manager, jobOffer.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, projectDescription, startDate, endDate, listCandidat, manager, valide, archive);
    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", listCandidat=" + listCandidat +
                ", manager=" + manager +
                ", valide=" + valide +
                ", archive=" + archive +
                '}';
    }
}
