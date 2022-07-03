package com.forlizzi.medication.service.user;

import com.forlizzi.medication.dao.user.UserMedListDao;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.entity.user.UserMedList;
import com.forlizzi.medication.entity.user.UserMedListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserMedListService implements UserMedListService{

    @Autowired
    private UserMedListDao userMedListDao;

    @Transactional
    @Override
    public UserMedList createUserMedList(UserMedListRequest userMedListRequest) {
        User user = userMedListDao.fetchUser(userMedListRequest.getUser());

        return null;
    }
}
