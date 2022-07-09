package com.forlizzi.medication.service.user;

import com.forlizzi.medication.dao.user.UserDao;
import com.forlizzi.medication.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String user) {
        return userDao.getUser(user);
                // .orElseThrow(() -> new NoSuchElementException("User was not found"));
    }

    @Override
    public User createUser(String pseudoName) {

    }

    @Override
    public void updateUser(String pseudoName) {

    }

    @Override
    public void deleteUser(String pseudoName) {

    }

    @Override
    public List<User> fetchUsers(User pseudoName) {
        return null;
    }

//    void deleteUser(String pseudoName);
//    @Autowired
//    private DeleteUserDao deleteUserDao;
//
//    @Transactional
//    @Override
//    public List<User> deleteUser(@Valid DeleteUser deleteUser) {
//        String first_Name = deleteUser.getPseudoName();
//        return deleteUserDao.saveUser(pseudoName);
//    }

}
