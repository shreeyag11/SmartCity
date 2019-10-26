package com.myprojects.head.societymanager.main.service;

import com.myprojects.head.societymanager.user.data_model.User;

/**
 * Created by marco on 16/08/16.
 */

public interface MainService {

    String getLoginProvider() throws Exception;

    void initLastSeen(User user);

    void logout();

}
