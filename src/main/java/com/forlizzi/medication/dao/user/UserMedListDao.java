package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.Medication;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.entity.user.UserMedList;

import java.util.Optional;

public interface UserMedListDao {

    Optional<User> fetchUser(Long userPK, String pseudoName);

    Optional<Medication> fetchBrandName(Long medPK, String brandName);

    UserMedList saveUserMedList(User user, Medication brandName );

}