package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.Medication;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.entity.user.UserMedList;

import java.util.Optional;

public interface UserMedListDao {

    Optional<User> fetchUser(Long userPK);

    Optional<Medication> fetchMedication(Long medPK);

    UserMedList saveUserMedList(User user, Medication medication);

}