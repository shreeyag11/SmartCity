package com.myprojects.smartcity.society.main.service;

import com.myprojects.smartcity.society.main.database.CloudMessagingDatabase;
import com.myprojects.smartcity.society.user.data_model.User;

import rx.Observable;

/**
 * Created by marco on 17/08/16.
 */

public class FirebaseCloudMessagingService implements CloudMessagingService {

    private CloudMessagingDatabase messagingDatabase;

    public FirebaseCloudMessagingService(CloudMessagingDatabase messagingDatabase) {
        this.messagingDatabase = messagingDatabase;
    }

    @Override
    public Observable<String> readToken(User user) {
        return messagingDatabase.readToken(user);
    }

    @Override
    public void setToken(User user) {
        messagingDatabase.setToken(user);
    }
}
