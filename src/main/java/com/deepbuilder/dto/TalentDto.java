package com.deepbuilder.dto;

import com.deepbuilder.entities.Talent;

import java.util.HashMap;
import java.util.Map;

public class TalentDto {
    private Long id;
    private String name;
    private String description;
    private Map<String, Integer> requirements;

    public TalentDto(Talent talent) {
        this.id = talent.getTalentId();
        this.name = talent.getTalentName();
        this.description = talent.getTalentDesc();
        this.requirements = mapRequirements(talent);
    }

    //helper method to map requirements instead of doing it in my constructor
    public Map<String, Integer> mapRequirements(Talent talent){
        if(talent.talentStrengthRequirement > 0){
            requirements.put("strength", talent.talentStrengthRequirement);
        }
        if(talent.talentFortitudeRequirement > 0){
            requirements.put("fortitude", talent.talentFortitudeRequirement);
        }
        if(talent.talentAgilityRequirement > 0){
            requirements.put("agility", talent.talentAgilityRequirement);
        }
        if(talent.talentWillpowerRequirement > 0){
            requirements.put("willpower", talent.talentWillpowerRequirement);
        }
        if(talent.talentCharismaRequirement > 0){
            requirements.put("charisma", talent.talentCharismaRequirement);
        }
        if(talent.talentFrostdrawRequirement > 0){
            requirements.put("frostdraw", talent.talentFrostdrawRequirement);
        }
        if(talent.talentGalebreatheRequirement > 0){
            requirements.put("galebreathe", talent.talentGalebreatheRequirement);
        }
        if(talent.talentShadowcastRequirement > 0){
            requirements.put("shadowcast", talent.talentShadowcastRequirement);
        }
        if(talent.talentBloodrendRequirement > 0){
            requirements.put("bloodrend", talent.talentBloodrendRequirement);
        }
        if(talent.talentIronsingRequirement > 0){
            requirements.put("ironsing", talent.talentIronsingRequirement);
        }
        return requirements;
    }


    public static TalentDto from(Talent talent){
        return new TalentDto(talent);
    }

    public Map<String, Integer> getRequirements() {
        return requirements;
    }

    public void setRequirements(Map<String, Integer> requirements) {
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
