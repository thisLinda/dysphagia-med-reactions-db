package com.forlizzi.medication.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {
    private int reactionId;
    private String severity;
    private String reaction;

}