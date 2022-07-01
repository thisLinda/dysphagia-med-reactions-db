package com.forlizzi.medication.controller;

import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.ReactionSeverity;
import com.forlizzi.medication.service.ReactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DefaultReactionController implements ReactionController {

    @Autowired
    private ReactionService reactionService;

    @Override
    public List<Reaction> fetchReactions(ReactionSeverity severity, String reaction) {
//        log.info("severity={}, reaction={}", severity, reaction);
        log.debug("severity={}, reaction={}", severity, reaction);
        return reactionService.fetchReactions(severity, reaction);
    }

}