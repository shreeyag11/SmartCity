package com.myprojects.smartcity.society.conversation;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.myprojects.smartcity.society.BaseActivity;
import com.myprojects.smartcity.society.Dependencies;
import com.myprojects.smartcity.society.R;
import com.myprojects.smartcity.society.conversation.presenter.ConversationPresenter;
import com.myprojects.smartcity.society.conversation.view.ConversationDisplayer;
import com.myprojects.smartcity.society.conversation.view.ConversationView;
import com.myprojects.smartcity.society.navigation.AndroidNavigator;


/**
 * Created by marco on 29/07/16.
 */

public class ConversationActivity extends BaseActivity {

    private ConversationPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ConversationDisplayer conversationDisplayer = (ConversationView) findViewById(R.id.conversationView);
        presenter = new ConversationPresenter(
                Dependencies.INSTANCE.getLoginService(),
                Dependencies.INSTANCE.getConversationService(),
                conversationDisplayer,
                Dependencies.INSTANCE.getUserService(),
                getIntent().getStringExtra("sender"),
                getIntent().getStringExtra("destination"),
                new AndroidNavigator(this)
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.startPresenting();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopPresenting();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
