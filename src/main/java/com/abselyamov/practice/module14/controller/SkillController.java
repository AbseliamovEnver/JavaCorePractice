package com.abselyamov.practice.module14.controller;

import com.abselyamov.practice.module14.model.Skill;
import com.abselyamov.practice.module14.repository.JavaIOSkillRepositoryImpl;
import com.abselyamov.practice.module14.repository.SkillRepository;

import java.util.Set;

public class SkillController {
    SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();

    public void add(String skillName) {
        Skill skill = new Skill(0, skillName);
        skillRepository.add(skill);
    }

    public String getById(long id) {
        Skill skill = skillRepository.getById(id);
        if (skill != null)
            return "Skill with id \'" + id + "\' have value \'" + skill.getSkillName() + "\'.";
        return "Skill with id \'" + id + "\' not found.";
    }

    public String getByName(String name) {
        Skill skill = skillRepository.getByName(name);
        if (skill != null)
            return "Skill with name \'" + skill.getSkillName() + "\' have id \'" + skill.getId() + "\'.";
        return "Skill with name \'" + name + "\' not found.";
    }

    public Set<Skill> getListSkills() {
        Set<Skill> skills = skillRepository.getAll();
        if (skills != null) {
            for (Skill skill : skills)
                System.out.println(skill.getId() + "\t" + skill.getSkillName());
            return skills;
        } else System.out.println("List skills is empty.");
        return null;
    }

    public void delete(Long id) {
        Skill skill = skillRepository.delete(id);
        if (skill != null)
            System.out.println("Skill with id \'" + skill.getId() + "\' and value \'" + skill.getSkillName() + "\' was delete.");
        else
            System.out.println("Skill with id \'" + id + "\' not found.");
    }
}
