package com.forlizzi.medication.entity.user;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserMedListRequest {
    @NotNull
    @Length(max = 30)
//    could put @Pattern(regexp = "[A-Z0-9_]") (each character is cap or number or underscore)
//    "[\\w\\s]* (word, space, includes underscore
    private Long user;

    @NotNull
    @Length(max = 30)
    private Long medication;

}