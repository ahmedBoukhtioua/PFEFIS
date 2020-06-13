package com.pfe.RCV.Models;

import java.util.Objects;

public class Language {
    private String name;
    private String level;

    public Language(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(name, language.name) &&
                Objects.equals(level, language.level);
    }

    @Override
    public String toString() {
        return "language{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
