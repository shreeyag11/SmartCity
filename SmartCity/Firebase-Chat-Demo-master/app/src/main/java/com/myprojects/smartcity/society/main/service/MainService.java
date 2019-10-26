package com.myprojects.smartcity.society.main.service;

import com.myprojects.smartcity.society.user.data_model.User;

/**
 * Created by marco on 16/08/16.
 */

public interface MainService {

    String getLoginProvider() throws Exception;

    void initLastSeen(User user);

    void logout();

}
