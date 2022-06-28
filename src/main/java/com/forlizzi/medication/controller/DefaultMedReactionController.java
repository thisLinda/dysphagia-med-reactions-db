package com.forlizzi.medication.controller;

import com.forlizzi.medication.entity.Reaction;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefaultMedReactionController implements MedReactionController{
    @Override
    public List<Reaction> fetchReaction(String severity, String reaction) {
        return null;
    }

}