package com.forlizzi.medication.service;

import com.forlizzi.medication.dao.ReactionDao;
import com.forlizzi.medication.entity.Reaction;
import com.forlizzi.medication.entity.Severity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DefaultReactionService implements ReactionService {

    @Autowired
    private ReactionDao reactionDao;

    @Override
    public List<Reaction> fetchReaction(Severity severity, String reaction) {
        log.info("The fetchReaction method was called with severity={} and reaction={}", severity, reaction);

        return reactionDao.fetchReaction(severity, reaction);
    }

}