package com.abselyamov.practice.module14.repository;

import com.abselyamov.practice.module14.model.Skill;

import java.util.Set;

public interface SkillRepository extends GenericRepository<Skill, Long>{

    Set<Skill> getData();
}
