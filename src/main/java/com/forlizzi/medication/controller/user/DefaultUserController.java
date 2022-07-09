package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.service.reaction.ReactionService;
import com.forlizzi.medication.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@Slf4j
public class DefaultUserController implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public User createUser(User user) {
        log.debug("User={}", user);
        return userService.createUser(user);
    }

    @Override
    public void updateUser(String pseudoName) {
        log.debug("Update User={}", pseudoName);
        userService.updateUser(pseudoName);
    }

    @Override
    public void deleteUser(String pseudoName) {
        log.debug("deleteUser:{}", pseudoName);
        userService.deleteUser(pseudoName);
    }

    @Override
    public User getUser(String pseudoName) {
        log.debug("pseudoName={}", pseudoName);
        return userService.getUser(pseudoName);
    }

    @Autowired
    private ReactionService reactionService;

}
