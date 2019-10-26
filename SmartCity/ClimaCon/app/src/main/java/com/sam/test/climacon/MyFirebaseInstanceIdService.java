package com.sam.test.climacon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by sagar on 9/19/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    public  String uniquekey = new String();
private static final String REG_TOKEN ="REG_TOKEN";
    @Override
    public void onTokenRefresh() {
                String recent_token = FirebaseInstanceId.getInstance().getToken();
        uniquekey= (getText(Log.d(REG_TOKEN,recent_token)).toString());
        Toast.makeText(this,"Your Unique Id Is : "+uniquekey,Toast.LENGTH_LONG).show();

    }
}
