package com.forlizzi.medication.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class User {
    private int userPK;
    private String pseudoName;
    private int age;
    private String dateOfEval;
    private String dateOfDischarge;
    private String medDxIcd;
    private String txDxIcd;

    @JsonIgnore
    public int getUserPK() {
        return userPK;
    }

}