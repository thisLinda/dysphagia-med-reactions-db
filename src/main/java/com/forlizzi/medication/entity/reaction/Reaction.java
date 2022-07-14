package com.forlizzi.medication.entity.reaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.Comparator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reaction implements Comparable<Reaction> {
    private int reactionPK;
    private ReactionSeverity severity;
    private String reaction;

    @Override
    public int compareTo(Reaction that) {
        // @formatter:off
        return Comparator
                .comparing(Reaction::getSeverity)
                .thenComparing(Reaction::getReaction)
                .compare(this, that);
        // @formatter:on
    }

    @JsonIgnore
    public int getReactionPK() {
        return reactionPK;
    }

}