package com.myprojects.head.societymanager.main.service;

import com.myprojects.head.societymanager.user.data_model.User;

import rx.Observable;

/**
 * Created by marco on 17/08/16.
 */

public interface CloudMessagingService {

    Observable<String> readToken(User user);

    void setToken(User user);

}
