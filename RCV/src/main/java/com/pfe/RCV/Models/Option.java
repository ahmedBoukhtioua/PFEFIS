package com.pfe.RCV.Models;

import java.util.Objects;

public class Option {

    private String optionName;
    private Boolean correct;

    public Option(String optionName, Boolean correct) {
        this.optionName = optionName;
        this.correct = correct;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionName='" + optionName + '\'' +
                ", correct=" + correct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Objects.equals(optionName, option.optionName) &&
                Objects.equals(correct, option.correct);
    }

}


