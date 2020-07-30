package com.pfe.RCV.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection="cv")
public class CV {
    @Id
    private String id;
    @DBRef
    private User user;
    private DivisionList divisionList;
    private float note;
    private String picture;

    public CV() {
    }

    public CV(String id, User user, DivisionList divisionList, float note, String picture) {
        this.id = id;
        this.user = user;
        this.divisionList = divisionList;
        this.note = note;
        this.picture = picture;
    }

    public CV(User user, DivisionList divisionList, float note, String picture) {
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

    public CV(String id, DivisionList divisionList, float note, String picture) {
        this.id = id;
        this.divisionList = divisionList;
        this.note = note;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DivisionList getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(DivisionList divisionList) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CV cv = (CV) o;
        return Float.compare(cv.note, note) == 0 &&
                Objects.equals(id, cv.id) &&
                Objects.equals(divisionList, cv.divisionList) &&
                Objects.equals(picture, cv.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, divisionList, note, picture);
    }

    @Override
    public String toString() {
        return "CV{" +
                "id='" + id + '\'' +
                ", divisionList=" + divisionList +
                ", note=" + note +
                ", picture='" + picture + '\'' +
                '}';
    }
}
