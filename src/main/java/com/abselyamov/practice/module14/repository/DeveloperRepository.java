package com.abselyamov.practice.module14.repository;

import com.abselyamov.practice.module14.model.Developer;
import com.abselyamov.practice.module14.model.Skill;

public interface DeveloperRepository extends GenericRepository<Developer, Long> {

    void update(Developer developer, Long id);

    Developer getByName(String name);

    boolean addSkillDeveloper(Developer developer, Skill skill);
}
