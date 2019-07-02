package com.abselyamov.practice.module14.model;

public class Skill implements Comparable<Skill>{
    private int id;
    private String skillName;

    public Skill(int id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Skill o) {
        return this.id - o.getId();
    }
}
