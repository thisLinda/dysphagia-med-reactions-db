package com.forlizzi.medication.service;

import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.ReactionSeverity;

import java.util.List;

public interface ReactionService {

    /*
     * @param severity
     * @param reaction
     * @return
     */
    List<Reaction> fetchReactions(ReactionSeverity severity, String reaction);
}
