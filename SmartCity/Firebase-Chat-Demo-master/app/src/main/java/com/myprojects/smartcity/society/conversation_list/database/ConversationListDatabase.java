package com.myprojects.smartcity.society.conversation_list.database;

import com.myprojects.smartcity.society.user.data_model.User;

import java.util.List;

import rx.Observable;

/**
 * Created by marco on 29/07/16.
 */

public interface ConversationListDatabase {

    Observable<List<String>> observeConversationsFor(User user);

}
