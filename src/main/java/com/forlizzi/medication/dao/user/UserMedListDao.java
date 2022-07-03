package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.User;

public interface UserMedListDao {

    User fetchUser(String user);
}
