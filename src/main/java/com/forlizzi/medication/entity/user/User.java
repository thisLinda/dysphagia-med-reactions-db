package com.forlizzi.medication.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    public Long getUserPK() {
        return userPK;
    }

}
