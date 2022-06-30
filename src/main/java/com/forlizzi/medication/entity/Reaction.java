package com.forlizzi.medication.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {
    private ReactionSeverity severity;
    private String reaction;

    public String getReactionPK() {
        return reactionPK;
    }
}