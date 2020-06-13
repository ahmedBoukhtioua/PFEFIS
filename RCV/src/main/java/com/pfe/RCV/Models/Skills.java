package com.pfe.RCV.Models;

import java.util.Objects;

public class Skills {
    private SkillsType type;
    private String  techno;

    public Skills(SkillsType type, String techno) {
        this.type = type;
        this.techno = techno;
    }

    public SkillsType getType() {
        return type;
    }

    public void setType(SkillsType type) {
        this.type = type;
    }

    public String getTechno() {
        return techno;
    }

    public void setTechno(String techno) {
        this.techno = techno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skills skills = (Skills) o;
        return type == skills.type &&
                Objects.equals(techno, skills.techno);
    }

    @Override
    public String toString() {
        return "Skills{" +
                "type=" + type +
                ", techno='" + techno + '\'' +
                '}';
    }
}
