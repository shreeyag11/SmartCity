package com.myprojects.smartcity.society.global.view;

import android.support.v7.widget.RecyclerView;

import com.myprojects.smartcity.society.global.data_model.Message;
import com.myprojects.smartcity.society.user.data_model.User;

/**
 * Created by marco on 08/08/16.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private final MessageView messageView;

    public MessageViewHolder(MessageView messageView) {
        super(messageView);
        this.messageView = messageView;
    }

    public void bind(User user, Message message) {
        messageView.display(user, message);
    }
}
