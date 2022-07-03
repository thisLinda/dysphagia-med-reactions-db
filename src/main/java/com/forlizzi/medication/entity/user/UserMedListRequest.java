package com.forlizzi.medication.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserMedListRequest {
    private Long userPK;
    private Long medPK;

    @NotNull
    @Length(max = 30)
//    could put @Pattern(regexp = "[A-Z0-9_]") (each character is cap or number or underscore)
//    "[\\w\\s]* (word, space, includes underscore
    private String pseudoName;

    @NotNull
    @Length(max = 30)
    private String brandName;

//    Do I separately ignore medPK?
    @JsonIgnore
    public Long getUserMedPK() {
        return userPK;
    }
}