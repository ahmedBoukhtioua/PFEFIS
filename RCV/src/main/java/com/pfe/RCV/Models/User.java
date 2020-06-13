package com.pfe.RCV.Models;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(collection = "users")
public class User {


    @Id
    private String  id;
    private String FName;
    private String photo;
    @Email
    private String  email;
    private String adress;
    private Date birthDate;
    private  boolean enabled;
    /*
    private CV cv;
    private List<Quiz> quizList;
    private List<JobOffer> jobOfferList;
    private Role
    */
    @UniqueElements
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

    public User(String FName, String photo, @Email String email, String adress, Date birthDate, boolean enabled, @UniqueElements String eNumber, String password, Set<Role> roles) {
        this.FName = FName;
        this.photo = photo;
        this.email = email;
        this.adress = adress;
        this.birthDate = birthDate;
        this.enabled = enabled;
        this.eNumber = eNumber;
        this.password = password;
        this.roles = roles;
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
                Objects.equals(eNumber, user.eNumber) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FName, photo, email, adress, birthDate, enabled, eNumber, password, roles);
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
                ", eNumber='" + eNumber + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}