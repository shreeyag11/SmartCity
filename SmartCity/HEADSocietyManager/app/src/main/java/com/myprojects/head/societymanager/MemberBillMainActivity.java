package com.myprojects.head.societymanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemberBillMainActivity extends AppCompatActivity {

   public Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_bill_activity_main);
        String url = "http://www.societymanager.sammeyinc.com/wp-admin/";
        mContext = this.getApplicationContext();

        WebView vbill = (WebView) findViewById(R.id.wvHeadBill);
        vbill.setWebViewClient(new WebViewClient());
        vbill.getSettings().setJavaScriptEnabled(true);
        vbill.getSettings().setAppCacheEnabled(true);
        //  vbill.getSettings().setAppCachePath(mContext.getCacheDir().getPath());
        vbill.loadUrl(url);
        Toast.makeText(this, "Loading Data... Please Wait !", Toast.LENGTH_LONG).show();

    }

}
