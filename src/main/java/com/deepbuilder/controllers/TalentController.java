package com.deepbuilder.controllers;

import com.deepbuilder.services.TalentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/talents")
public class TalentController {
    private final TalentService talentService;

    public TalentController(TalentService talentService) {
        this.talentService = talentService;
    }
}
