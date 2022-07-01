package com.forlizzi.medication.dao;

import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.ReactionSeverity;

import java.util.List;


public interface ReactionDao {

    List<Reaction> fetchReactions(ReactionSeverity severity, String reaction);
}