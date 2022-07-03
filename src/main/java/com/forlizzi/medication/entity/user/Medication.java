package com.forlizzi.medication.entity.user;

import lombok.Data;

@Data
public class Medication {
    private Long medPK;
    private String brandName;
    private boolean hasReaction;
}

//med_pk int NOT NULL AUTO_INCREMENT,
//        brand_name varchar(40) NOT NULL,
//        has_reaction boolean,
//        PRIMARY KEY (med_pk)