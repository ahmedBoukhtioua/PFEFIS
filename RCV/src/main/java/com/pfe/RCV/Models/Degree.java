package com.pfe.RCV.Models;

import java.util.Date;
import java.util.Objects;

public class Degree {
    private String type;
    private String speciality;
    private Date date;
    private String university;
    private String country;

    public Degree(String type, String speciality, Date date, String university, String country) {
        this.type = type;
        this.speciality = speciality;
        this.date = date;
        this.university = university;
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "type='" + type + '\'' +
                ", speciality='" + speciality + '\'' +
                ", date=" + date +
                ", university='" + university + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Degree degree = (Degree) o;
        return Objects.equals(type, degree.type) &&
                Objects.equals(speciality, degree.speciality) &&
                Objects.equals(date, degree.date) &&
                Objects.equals(university, degree.university) &&
                Objects.equals(country, degree.country);
    }

}
