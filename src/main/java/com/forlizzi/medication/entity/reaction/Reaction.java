// ToDo: ? need to remove

package com.forlizzi.medication.entity.reaction;

import lombok.*;

import java.util.Comparator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reaction implements Comparable<Reaction> {
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

//    @JsonIgnore
//    public String getReactionPK() {
//        return reactionPK;
//    }
}