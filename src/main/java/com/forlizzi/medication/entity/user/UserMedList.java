package com.forlizzi.medication.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserMedList {
    private Long userMedPK;

    @NotNull
    @Length(max = 30)
//    could put @Pattern(regexp = "[A-Z0-9_]") (each character is cap or number or underscore)
//    "[\\w\\s]* (word, space, includes underscore
    private User user;

    @NotNull
    @Length(max = 30)
    private Medication brandName;

    @JsonIgnore
    public Long getUserMedPK() {
        return userMedPK;
    }
}

//public class UserMedListRequest {
//    private String user;
//    private String brandName;
//}