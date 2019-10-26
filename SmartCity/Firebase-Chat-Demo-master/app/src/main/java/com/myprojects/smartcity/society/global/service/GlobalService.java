package com.myprojects.smartcity.society.global.service;

import com.myprojects.smartcity.society.database.DatabaseResult;
import com.myprojects.smartcity.society.global.data_model.Chat;
import com.myprojects.smartcity.society.global.data_model.Message;

import rx.Observable;

/**
 * Created by marco on 08/08/16.
 */

public interface GlobalService {

    Observable<Chat> getOldMessages(String key);

    Observable<Message> getNewMessages(String key);

    Observable<DatabaseResult<Chat>> getChat();

    void sendMessage(Message message);

}
