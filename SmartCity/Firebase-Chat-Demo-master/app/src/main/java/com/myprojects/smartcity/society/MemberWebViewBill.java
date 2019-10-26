package com.myprojects.smartcity.society;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;


public class MemberWebViewBill extends AppCompatActivity {
    private Context mContext;
    public String flat;
    EditText Re_enterFlatNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.member_bill_activity_web_view);
        Re_enterFlatNo =(EditText)findViewById(R.id.etRe_enterFlatNo);
        Bundle b=getIntent().getExtras();
        flat=b.getString("Sagar");

        String url = "http://www.societymanager.sammeyinc.com/product/"+flat;
        mContext = this.getApplicationContext();

        WebView vbill = (WebView) findViewById(R.id.web);
        vbill.setWebViewClient(new WebViewClient());
        vbill.getSettings().setJavaScriptEnabled(true);
        vbill.getSettings().setAppCacheEnabled(true);
      //  vbill.getSettings().setAppCachePath(mContext.getCacheDir().getPath());
        vbill.loadUrl(url);


    }
}
