package com.deepbuilder.dto;

import com.deepbuilder.entities.Stat;
import com.deepbuilder.entities.Talent;

import com.deepbuilder.entities.Stat.StatType;
import java.util.HashMap;
import java.util.Map;

public class TalentDto {
    private Long id;
    private String name;
    private String description;
    private Map<StatType, Integer> requirements;

    public TalentDto(Talent talent) {
        this.id = talent.getTalentId();
        this.name = talent.getTalentName();
        this.description = talent.getTalentDesc();
        this.requirements = talent.getRequirements();
    }



    public static TalentDto from(Talent talent){
        return new TalentDto(talent);
    }

    public Map<StatType, Integer> getRequirements() {
        return requirements;
    }

    public void setRequirements(Map<StatType, Integer> requirements) {
        this.requirements = requirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
