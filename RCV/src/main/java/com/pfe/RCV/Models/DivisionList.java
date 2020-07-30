package com.pfe.RCV.Models;
import java.util.List;

public class DivisionList {

   private List<Skills> skillsList;
   private List<Degree> degreeList;
   private List<Experience> experienceList;
   private List<Language> languageList;
   private List<AssociativeExperience> associativeExperienceList;
   private List<String> interestList;

    public DivisionList() {
    }


    public DivisionList(List<Skills> skillsList, List<Degree> degreeList, List<Experience> experienceList, List<Language> languageList, List<AssociativeExperience> associativeExperienceList, List<String> interestList) {
        this.skillsList = skillsList;
        this.degreeList = degreeList;
        this.experienceList = experienceList;
        this.languageList = languageList;
        this.associativeExperienceList = associativeExperienceList;
        this.interestList = interestList;
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public List<Degree> getDegreeList() {
        return degreeList;
    }

    public void setDegreeList(List<Degree> degreeList) {
        this.degreeList = degreeList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }


    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public List<AssociativeExperience> getAssociativeExperienceList() {
        return associativeExperienceList;
    }

    public void setAssociativeExperienceList(List<AssociativeExperience> associativeExperienceList) {
        this.associativeExperienceList = associativeExperienceList;
    }

    public List<String> getInterestList() {
        return interestList;
    }

    public void setInterestList(List<String> interestList) {
        this.interestList = interestList;
    }

}
