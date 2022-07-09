package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.User;

public interface UserDao {

    User createUser(String pseudoName);

    User getUser(String user);

    User saveUser(String pseudoName);

    void updateUser(String newPseudoName, String oldPseudoName, Long userPK);

    void deleteUser(Long userPK);

}
