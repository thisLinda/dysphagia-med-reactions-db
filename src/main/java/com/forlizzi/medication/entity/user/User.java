package com.forlizzi.medication.entity.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long userPK;
    private String pseudoName;
    private int age;
    private String dateOfEval;
    private String dateOfDischarge;
    private String medDxIcd;
    private String txDxIcd;
}

//user_pk int NOT NULL AUTO_INCREMENT,
//        pseudo_name varchar(40) NOT NULL,
//        age int NOT NULL,
//        date_of_eval varchar(40) NOT NULL,
//        date_of_discharge varchar(40),
//        med_dx_icd varchar(40) NOT NULL,
//        tx_dx_icd varchar(40) NOT NULL,
//        PRIMARY KEY (user_pk)
//        );
