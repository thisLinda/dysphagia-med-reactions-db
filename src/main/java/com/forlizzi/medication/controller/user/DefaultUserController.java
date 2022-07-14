package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DefaultUserController implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public int createUser(int user_pk, String pseudo_name, int age, String date_of_eval, String date_of_discharge,
                           String med_dx_icd, String tx_dx_icd) {
        return userService.createUser(user_pk, pseudo_name, age, date_of_eval, date_of_discharge,
                med_dx_icd, tx_dx_icd);
    }

    @Override
    public List<User> getUsers(int userPK) {
        return userService.getUsers(userPK);
    }

    @Override
    public void updateUser(String newPseudoName, int userPK) {
        log.debug("NewPseudoName={},UserPK={}", newPseudoName, userPK);
        userService.updateUser(newPseudoName, userPK);
    }

    @Override
    public void deleteUser(int userPK) {
        log.debug("DeletedUserPK:{}", userPK);
        userService.deleteUser(userPK);
    }

}