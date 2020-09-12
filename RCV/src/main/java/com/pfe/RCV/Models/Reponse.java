package com.pfe.RCV.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Document(collection = "reponseQuiz")
public class Reponse {
    @Id
    private String idReponse;

    @DBRef
    private User idUser;
    @DBRef
    private Quiz idQuiz;

    private LocalDateTime date;

    private List<String> reponses;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public Reponse(User idUser, Quiz idQuiz, LocalDateTime date, List<String> reponses) {
        this.idUser = idUser;
        this.idQuiz = idQuiz;
        this.date = date;
        this.reponses = reponses;
    }

    public Reponse() {
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Quiz getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(Quiz idQuiz) {
        this.idQuiz = idQuiz;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<String> getReponses() {
        return reponses;
    }

    public void setReponses(List<String> reponses) {
        this.reponses = reponses;
    }

    @Override
    public String toString() {
        return "Reponse{" +
                "idUser=" + idUser +
                ", idQuiz=" + idQuiz +
                ", date=" + date +
                ", reponses=" + reponses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reponse reponse = (Reponse) o;
        return Objects.equals(idUser, reponse.idUser) &&
                Objects.equals(idQuiz, reponse.idQuiz) &&
                Objects.equals(date, reponse.date) &&
                Objects.equals(reponses, reponse.reponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idQuiz, date, reponses);
    }
}
