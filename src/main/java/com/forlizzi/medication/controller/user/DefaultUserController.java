package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DefaultUserController implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public int createUser(int user_pk, String pseudo_name, int age, String date_of_eval, String date_of_discharge,
                           String med_dx_icd, String tx_dx_icd) {
//        log.debug("User={}", user);
        return userService.createUser(user_pk, pseudo_name, age, date_of_eval, date_of_discharge,
                med_dx_icd, tx_dx_icd);
    }

    @Override
    public void updateUser(String newPseudoName, String oldPseudoName, int userPK) {
        log.debug("OldPseudoName={}, NewPseudoName={}, UserPK={}", newPseudoName, oldPseudoName, userPK);
        userService.updateUser(newPseudoName, oldPseudoName, userPK);
    }

    @Override
    public void updateUser(String newPseudoName, String oldPseudoName, Long userPK) {

    }

    @Override
    public void deleteUser(String pseudoName) {
        log.debug("DeletedUserPseudoName:{}", pseudoName);
        userService.deleteUser(pseudoName);
    }

//    @Override
//    public User getUser(String pseudoName) {
//        log.debug("PseudoName={}", pseudoName);
//        return userService.getUser(pseudoName);
//    }

}
