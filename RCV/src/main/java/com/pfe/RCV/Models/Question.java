package com.pfe.RCV.Models;

import java.util.List;
import java.util.Objects;

public class Question {

    private String question;
    private List<Option> optionList;


    public Question(String question, List<Option> optionList) {
        this.question = question;
        this.optionList = optionList;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) &&
                Objects.equals(optionList, question1.optionList);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", optionList=" + optionList +
                '}';
    }
}
