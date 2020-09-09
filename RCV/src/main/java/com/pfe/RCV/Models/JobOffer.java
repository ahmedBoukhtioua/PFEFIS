package com.pfe.RCV.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "jobOffer")
public class JobOffer {
    @Id
    private String idJobOffer;
    private  String projectName;
    private String  projectDescription;
    private LocalDateTime addDate;
    private Date   startDate;
    private Date endDate;
    @DBRef
    private List<User> listCandidat;
    @DBRef
    private User manager;
    private boolean valide;


    public JobOffer() {
    }

    public JobOffer(String idJobOffer, String projectName, String projectDescription, Date startDate, Date endDate, List<User> listCandidat, User manager, boolean valide) {
        this.idJobOffer = idJobOffer;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.listCandidat = listCandidat;
        this.manager = manager;
        this.valide = valide;
    }

    public JobOffer(String idJobOffer, String projectName, String projectDescription, Date startDate, Date endDate , LocalDateTime addDate) {
        this.idJobOffer = idJobOffer;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.addDate = addDate;
    }

    public String getIdJobOffer() {
        return idJobOffer;
    }

    public void setIdJobOffer(String idJobOffer) {
        this.idJobOffer = idJobOffer;
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


    public LocalDateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobOffer jobOffer = (JobOffer) o;
        return valide == jobOffer.valide &&
                Objects.equals(idJobOffer, jobOffer.idJobOffer) &&
                Objects.equals(projectName, jobOffer.projectName) &&
                Objects.equals(projectDescription, jobOffer.projectDescription) &&
                Objects.equals(addDate, jobOffer.addDate) &&
                Objects.equals(startDate, jobOffer.startDate) &&
                Objects.equals(endDate, jobOffer.endDate) &&
                Objects.equals(listCandidat, jobOffer.listCandidat) &&
                Objects.equals(manager, jobOffer.manager);
    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "id='" + idJobOffer + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", addDate=" + addDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", listCandidat=" + listCandidat +
                ", manager=" + manager +
                ", valide=" + valide +
                '}';
    }
}
