package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.User;

import java.util.List;

public interface UserDao {

    int createUser(int user_pk, String pseudo_name, int age, String date_of_eval, String date_of_discharge,
                    String med_dx_icd, String tx_dx_icd);

//    User saveUser(String pseudoName);

    List<User> getUser(int user_pk);

    void updateUser(String newPseudoName, String oldPseudoName, int userPK);

    void deleteUser(int userPK);

}
