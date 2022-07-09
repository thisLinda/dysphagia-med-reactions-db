package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.User;

public interface UserDao {


    User getUser(String user);

    User saveUser(String pseudoName);

    void updateUser(String pseudoName);

    void deleteUser(String pseudoName);

    User createUser(User user);
}
