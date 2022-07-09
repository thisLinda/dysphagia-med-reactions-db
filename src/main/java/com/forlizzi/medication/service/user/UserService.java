package com.forlizzi.medication.service.user;

import com.forlizzi.medication.entity.user.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    User getUser(String user);

    @Transactional
    User createUser(User user);

    User createUser(String pseudoName);

    void updateUser(String pseudoName);

    void deleteUser(String pseudoName);

    List<User> fetchUsers(User pseudoName);
}
