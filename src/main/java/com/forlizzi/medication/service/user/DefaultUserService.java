package com.forlizzi.medication.service.user;

import com.forlizzi.medication.dao.user.UserDao;
import com.forlizzi.medication.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public int createUser(int user_pk, String pseudo_name, int age, String date_of_eval, String date_of_discharge, String med_dx_icd, String tx_dx_icd) {
        int user = userDao.createUser(user_pk, pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd,
                tx_dx_icd);
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers(int userPK) {
        List<User> users = userDao.getUsers(userPK);

        if(users.isEmpty()) {
            String msg = String.format("No users found with userPK=%s", userPK);
            throw new NoSuchElementException(msg);
        }
        return users;
    }

    @Override
    public void updateUser(String newPseudoName, int userPK) {
        userDao.updateUser(newPseudoName, userPK);
    }

    @Override
    public void deleteUser(int userPK) {
    }

}