package com.myprojects.smartcity.society.main.service;

import com.myprojects.smartcity.society.user.data_model.User;

import rx.Observable;

/**
 * Created by marco on 17/08/16.
 */

public interface CloudMessagingService {

    Observable<String> readToken(User user);

    void setToken(User user);

}
