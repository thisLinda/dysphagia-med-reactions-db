package com.forlizzi.medication.service.user;

import com.forlizzi.medication.dao.user.UserMedListDao;
import com.forlizzi.medication.entity.user.Medication;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.entity.user.UserMedList;
import com.forlizzi.medication.entity.user.UserMedListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class DefaultUserMedListService implements UserMedListService{

    @Autowired
    private UserMedListDao userMedListDao;

    @Transactional
    @Override
    public UserMedList createUserMedList(UserMedListRequest userMedListRequest) {
        User pseudoName = getUser(userMedListRequest);
        Medication brandName = getMedication(userMedListRequest);

        return userMedListDao.saveUserMedList(pseudoName, brandName);
    }

    protected User getUser(UserMedListRequest userMedListRequest) {
        return userMedListDao
                .fetchUser(userMedListRequest.getUser())
                .orElseThrow(()
                -> new NoSuchElementException("User with pseudoName="
                        + userMedListRequest.getUser() + " was not found"));
        }

    protected Medication getMedication(UserMedListRequest userMedListRequest) {
        return userMedListDao
                .fetchMedication(userMedListRequest.getMedication())
                .orElseThrow(()
                -> new NoSuchElementException("User with brandName="
                        + userMedListRequest.getMedication() + " was not found"));
    }

}