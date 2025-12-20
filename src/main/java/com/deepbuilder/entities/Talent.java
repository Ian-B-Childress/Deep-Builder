package com.deepbuilder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long talentId;
    public String talentName;
    public String talentDesc;
    public Long talentStrengthRequirement;
    public Long talentFortitudeRequirement;
    public Long talentAgilityRequirement;
    public Long talentWillpowerRequirement;
    public Long talentCharismaRequirement;
    public Long talentFrostdrawRequirement;
    public Long talentGalebreatheRequirement;
    public Long talentShadowcastRequirement;
    public Long talentBloodrendRequirement;
    public Long talentIronsingRequirement;

    public Talent() {
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

    public Long getTalentStrengthRequirement() {
        return talentStrengthRequirement;
    }

    public void setTalentStrengthRequirement(Long talentStrengthRequirement) {
        this.talentStrengthRequirement = talentStrengthRequirement;
    }

    public Long getTalentFortitudeRequirement() {
        return talentFortitudeRequirement;
    }

    public void setTalentFortitudeRequirement(Long talentFortitudeRequirement) {
        this.talentFortitudeRequirement = talentFortitudeRequirement;
    }

    public Long getTalentAgilityRequirement() {
        return talentAgilityRequirement;
    }

    public void setTalentAgilityRequirement(Long talentAgilityRequirement) {
        this.talentAgilityRequirement = talentAgilityRequirement;
    }

    public Long getTalentWillpowerRequirement() {
        return talentWillpowerRequirement;
    }

    public void setTalentWillpowerRequirement(Long talentWillpowerRequirement) {
        this.talentWillpowerRequirement = talentWillpowerRequirement;
    }

    public Long getTalentCharismaRequirement() {
        return talentCharismaRequirement;
    }

    public void setTalentCharismaRequirement(Long talentCharismaRequirement) {
        this.talentCharismaRequirement = talentCharismaRequirement;
    }

    public Long getTalentFrostdrawRequirement() {
        return talentFrostdrawRequirement;
    }

    public void setTalentFrostdrawRequirement(Long talentFrostdrawRequirement) {
        this.talentFrostdrawRequirement = talentFrostdrawRequirement;
    }

    public Long getTalentGalebreatheRequirement() {
        return talentGalebreatheRequirement;
    }

    public void setTalentGalebreatheRequirement(Long talentGalebreatheRequirement) {
        this.talentGalebreatheRequirement = talentGalebreatheRequirement;
    }

    public Long getTalentShadowcastRequirement() {
        return talentShadowcastRequirement;
    }

    public void setTalentShadowcastRequirement(Long talentShadowcastRequirement) {
        this.talentShadowcastRequirement = talentShadowcastRequirement;
    }

    public Long getTalentBloodrendRequirement() {
        return talentBloodrendRequirement;
    }

    public void setTalentBloodrendRequirement(Long talentBloodrendRequirement) {
        this.talentBloodrendRequirement = talentBloodrendRequirement;
    }

    public Long getTalentIronsingRequirement() {
        return talentIronsingRequirement;
    }

    public void setTalentIronsingRequirement(Long talentIronsingRequirement) {
        this.talentIronsingRequirement = talentIronsingRequirement;
    }
}
