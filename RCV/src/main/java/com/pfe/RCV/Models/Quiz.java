package com.pfe.RCV.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pfe.RCV.payload.response.JwtResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "quiz")
public class Quiz {
    @Id
    private String idQuiz;

    @DBRef
    private User idRh;

    private String quizName;
    private LocalDateTime date;
    private Boolean visible;


    private List<Question> questionsList;


    public Quiz(String idQuiz, User idRh, String quizName, LocalDateTime date, Boolean visible, List<Question> questionsList) {
        this.idQuiz = idQuiz;
        this.idRh = idRh;
        this.quizName = quizName;
        this.date = date;
        this.visible = visible;
        this.questionsList = questionsList;
    }

    public String getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(String idQuiz) {
        this.idQuiz = idQuiz;
    }

    public User getIdRh() {
        return idRh;
    }

    public void setIdRh(User idRh) {
        this.idRh = idRh;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public List<Question> getQuestions() {
        return questionsList;
    }

    public void setQuestions(List<Question> questionsList) {
        this.questionsList = questionsList;
    }



    @Override
    public String toString() {
        return "Quiz{" +
                "idQuiz=" + idQuiz +
                ", idRh=" + idRh +
                ", quizName='" + quizName + '\'' +
                ", date=" + date +
                ", visible=" + visible +
                ", questions=" + questionsList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(idQuiz, quiz.idQuiz) &&
                Objects.equals(idRh, quiz.idRh) &&
                Objects.equals(quizName, quiz.quizName) &&
                Objects.equals(date, quiz.date) &&
                Objects.equals(visible, quiz.visible) &&
                Objects.equals(questionsList, quiz.questionsList) ;
    }

}
