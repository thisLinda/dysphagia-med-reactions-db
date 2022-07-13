package com.forlizzi.medication.service.user;

import com.forlizzi.medication.entity.user.User;

import java.util.List;

public interface UserService {

    int createUser(int user_pk, String pseudo_name, int age, String date_of_eval, String date_of_discharge,
                    String med_dx_icd, String tx_dx_icd);

    List<User> getUsers(int userPK);

    void updateUser(String newPseudoName, int userPK);

    void deleteUser(int userPK);

}