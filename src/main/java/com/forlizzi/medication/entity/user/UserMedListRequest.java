package com.forlizzi.medication.entity.user;

import lombok.Data;

@Data
public class UserMedListRequest {
    private String user;
    private String brandName;
}