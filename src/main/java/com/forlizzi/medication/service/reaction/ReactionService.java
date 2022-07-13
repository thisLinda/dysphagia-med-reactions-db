package com.forlizzi.medication.service.reaction;

import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import java.util.List;

public interface ReactionService {

    /*
     * @param severity
     * @param reaction
     * @return
     */
    List<Reaction> fetchReactions(ReactionSeverity severity, String reaction);

}
