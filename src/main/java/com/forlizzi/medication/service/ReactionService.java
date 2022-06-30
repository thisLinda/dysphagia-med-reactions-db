package com.forlizzi.medication.service;

import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.Severity;

import java.util.List;

public interface ReactionService {

    /*
     * @param severity
     * @param reaction
     * @return
     */
    List<Reaction> fetchReaction(Severity severity, String reaction);
}
