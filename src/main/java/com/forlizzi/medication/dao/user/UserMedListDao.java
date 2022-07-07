package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import com.forlizzi.medication.entity.user.Medication;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.entity.user.UserMedList;

import java.util.List;
import java.util.Optional;

public interface UserMedListDao {

    Optional<User> fetchUser(String pseudoName);

    Optional<Medication> fetchMedication(String brandName);

//    List<Medication> fetchAllMedications();

    UserMedList saveUserMedList(User pseudoName, Medication brandName);

}