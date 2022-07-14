package com.forlizzi.medication.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserMedList {
    private int userMedsListPK;
    private User user;
    private Medication medication;

    @JsonIgnore
    public int getUserMedsListPK() {
        return userMedsListPK;
    }

}