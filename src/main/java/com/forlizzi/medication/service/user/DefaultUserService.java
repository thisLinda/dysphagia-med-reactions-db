package com.forlizzi.medication.service.user;

import com.forlizzi.medication.dao.user.UserDao;
import com.forlizzi.medication.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String pseudoName) {
        return null;
    }

    @Override
    @Transactional
    public int createUser(int user_pk, String pseudo_name, int age, String date_of_eval, String date_of_discharge,
                           String med_dx_icd, String tx_dx_icd) {
        int user = userDao.createUser(user_pk, pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd,
                tx_dx_icd);
        return user;
    }

//    @Override
//    public User getUser(String pseudoName) {
//        return userDao.getUser(pseudoName);
//        // .orElseThrow(() -> new NoSuchElementException("User was not found"));
//    }

    @Override
    public void updateUser(String newPseudoName, String oldPseudoName, int userPK) {
    }

    @Override
    public void deleteUser(String pseudoName) {
    }

//    @Override
//    public List<User> fetchUsers(User pseudoName) {
//        return null;
//    }

}
