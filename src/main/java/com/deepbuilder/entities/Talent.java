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
    public int talentStrengthRequirement;
    public int talentFortitudeRequirement;
    public int talentAgilityRequirement;
    public int talentWillpowerRequirement;
    public int talentCharismaRequirement;
    public int talentFrostdrawRequirement;
    public int talentGalebreatheRequirement;
    public int talentShadowcastRequirement;
    public int talentBloodrendRequirement;
    public int talentIronsingRequirement;

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

    public int getTalentStrengthRequirement() {
        return talentStrengthRequirement;
    }

    public void setTalentStrengthRequirement(int talentStrengthRequirement) {
        this.talentStrengthRequirement = talentStrengthRequirement;
    }

    public int getTalentFortitudeRequirement() {
        return talentFortitudeRequirement;
    }

    public void setTalentFortitudeRequirement(int talentFortitudeRequirement) {
        this.talentFortitudeRequirement = talentFortitudeRequirement;
    }

    public int getTalentAgilityRequirement() {
        return talentAgilityRequirement;
    }

    public void setTalentAgilityRequirement(int talentAgilityRequirement) {
        this.talentAgilityRequirement = talentAgilityRequirement;
    }

    public int getTalentWillpowerRequirement() {
        return talentWillpowerRequirement;
    }

    public void setTalentWillpowerRequirement(int talentWillpowerRequirement) {
        this.talentWillpowerRequirement = talentWillpowerRequirement;
    }

    public int getTalentCharismaRequirement() {
        return talentCharismaRequirement;
    }

    public void setTalentCharismaRequirement(int talentCharismaRequirement) {
        this.talentCharismaRequirement = talentCharismaRequirement;
    }

    public int getTalentFrostdrawRequirement() {
        return talentFrostdrawRequirement;
    }

    public void setTalentFrostdrawRequirement(int talentFrostdrawRequirement) {
        this.talentFrostdrawRequirement = talentFrostdrawRequirement;
    }

    public int getTalentGalebreatheRequirement() {
        return talentGalebreatheRequirement;
    }

    public void setTalentGalebreatheRequirement(int talentGalebreatheRequirement) {
        this.talentGalebreatheRequirement = talentGalebreatheRequirement;
    }

    public int getTalentShadowcastRequirement() {
        return talentShadowcastRequirement;
    }

    public void setTalentShadowcastRequirement(int talentShadowcastRequirement) {
        this.talentShadowcastRequirement = talentShadowcastRequirement;
    }

    public int getTalentBloodrendRequirement() {
        return talentBloodrendRequirement;
    }

    public void setTalentBloodrendRequirement(int talentBloodrendRequirement) {
        this.talentBloodrendRequirement = talentBloodrendRequirement;
    }

    public int getTalentIronsingRequirement() {
        return talentIronsingRequirement;
    }

    public void setTalentIronsingRequirement(int talentIronsingRequirement) {
        this.talentIronsingRequirement = talentIronsingRequirement;
    }
}
