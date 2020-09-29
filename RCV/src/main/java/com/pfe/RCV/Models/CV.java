package com.pfe.RCV.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document(collection="cv")
public class CV implements Serializable {
    @Id
    private String id;
    @DBRef
    private User user;
    private List<String> divisionList;
    private List<String> languesList;
    private float note;
    private String picture;
    private Boolean archived;
    private LocalDateTime date;

    public CV() {
    }


    public CV(User user, List<String> divisionList, float note, String picture) {
        this.user = user;
        this.divisionList = divisionList;
        this.note = note;
        this.picture = picture;
    }

    public CV(User user, float note, String picture) {
        this.user = user;
        this.note = note;
        this.picture = picture;
    }

    public CV(String id, List<String> divisionList, float note, String picture) {
        this.id = id;
        this.divisionList = divisionList;
        this.note = note;
        this.picture = picture;
    }

    public CV(User user, List<String> divisionList, float note, String picture, Boolean archived, LocalDateTime date, List<String> languesList) {
        this.user = user;
        this.divisionList = divisionList;
        this.note = note;
        this.picture = picture;
        this.archived = archived;
        this.date = date;
        this.languesList = languesList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<String> divisionList) {
        this.divisionList = divisionList;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<String> getLanguesList() {
        return languesList;
    }

    public void setLanguesList(List<String> languesList) {
        this.languesList = languesList;
    }
}
