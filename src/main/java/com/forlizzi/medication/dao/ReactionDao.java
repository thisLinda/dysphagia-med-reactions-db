package com.forlizzi.medication.dao;

import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.Severity;

import java.util.List;


public interface ReactionDao {

    /**
     * @param severity
     * @param reaction
     * @return
     */
    List<Reaction> fetchReaction(Severity severity, String reaction);
}
