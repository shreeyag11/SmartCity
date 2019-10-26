package com.myprojects.head.societymanager.global.database;

import com.myprojects.head.societymanager.global.data_model.Chat;
import com.myprojects.head.societymanager.global.data_model.Message;

import rx.Observable;

/**
 * Created by marco on 08/08/16.
 */

public interface GlobalDatabase {

    Observable<Chat> observeOldMessages(String key);

    Observable<Message> observeNewMessages(String key);

    Observable<Chat> observeChat();

    void sendMessage(Message message);

}

