package com.pfe.RCV.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.*;

@Document(collection = "users")
public class User {

    @Id
    private String  id;
    private String FName;
    private String photo;

    @UniqueElements
    private String  email;

    private String adress;
    private Date birthDate;
    private  boolean enabled;

    private CV cv;
    @DBRef
    private List<JobOffer> jobOfferList;


    private List<Quiz> quizList;

    private String eNumber;
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();


    public User() {
    }

    public User(@Email String email, @UniqueElements String eNumber, String password) {
        this.email = email;
        this.eNumber = eNumber;
        this.password = password;
    }

    public User(String FName, @Email String email, List<JobOffer> jobOfferList, @UniqueElements String eNumber, Set<Role> roles) {
        this.FName = FName;
        this.email = email;
        this.jobOfferList = jobOfferList;
        this.eNumber = eNumber;
        this.roles = roles;
    }

    public User(String FName, @Email String email, String adress, Date birthDate, boolean enabled, CV cv, Set<Role> roles) {
        this.FName = FName;
        this.email = email;
        this.adress = adress;
        this.birthDate = birthDate;
        this.enabled = enabled;
        this.cv = cv;
        this.roles = roles;
    }

    public User(String id, String FName, String photo, @Email String email, String adress, Date birthDate, boolean enabled, CV cv, List<JobOffer> jobOfferList, List<Quiz> quizList, @UniqueElements String eNumber, String password, Set<Role> roles) {
        this.id = id;
        this.FName = FName;
        this.photo = photo;
        this.email = email;
        this.adress = adress;
        this.birthDate = birthDate;
        this.enabled = enabled;
        this.cv = cv;
        this.jobOfferList = jobOfferList;
        this.quizList = quizList;
        this.eNumber = eNumber;
        this.password = password;
        this.roles = roles;
    }

    public User(String FName, @Email String email, String adress, Date birthDate, String password) {
        this.FName = FName;
        this.email = email;
        this.adress = adress;
        this.birthDate = birthDate;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public List<JobOffer> getJobOfferList() {
        return jobOfferList;
    }

    public void setJobOfferList(List<JobOffer> jobOfferList) {
        this.jobOfferList = jobOfferList;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                Objects.equals(id, user.id) &&
                Objects.equals(FName, user.FName) &&
                Objects.equals(photo, user.photo) &&
                Objects.equals(email, user.email) &&
                Objects.equals(adress, user.adress) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(cv, user.cv) &&
                Objects.equals(jobOfferList, user.jobOfferList) &&
                Objects.equals(quizList, user.quizList) &&
                Objects.equals(eNumber, user.eNumber) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FName, photo, email, adress, birthDate, enabled, cv, jobOfferList, quizList, eNumber, password, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", FName='" + FName + '\'' +
                ", photo='" + photo + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", birthDate=" + birthDate +
                ", enabled=" + enabled +
                ", cv=" + cv +
                ", jobOfferList=" + jobOfferList +
                ", quizList=" + quizList +
                ", eNumber='" + eNumber + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
