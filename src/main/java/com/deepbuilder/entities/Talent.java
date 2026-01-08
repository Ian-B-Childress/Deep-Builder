package com.deepbuilder.entities;

import jakarta.persistence.*;

import java.util.EnumMap;
import java.util.Map;
import com.deepbuilder.entities.Stat.StatType;

@Entity
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "talent_id")
    public Long talentId;
    @Column(name = "talent_name")
    public String talentName;
    public String talentDesc;

    @ElementCollection
    @CollectionTable(name = "talent_requirement", joinColumns = @JoinColumn(name = "talent_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "stat")
    @Column(name = "value")
    private Map<StatType, Integer> requirements;

    public Talent() {
        this.requirements = new EnumMap<>(StatType.class);
    }


    public Map<StatType, Integer> getRequirements() {
        return requirements;
    }

    public void setRequirements(StatType stat, int value) {
        requirements.put(stat, value);
    }

    public Long getTalentId() {
        return talentId;
    }

    public void setTalentId(Long talentId) {
        this.talentId = talentId;
    }

    public String getTalentName() {
        return talentName;
    }

    public void setTalentName(String talentName) {
        this.talentName = talentName;
    }

    public String getTalentDesc() {
        return talentDesc;
    }

    public void setTalentDesc(String talentDesc) {
        this.talentDesc = talentDesc;
    }

}
