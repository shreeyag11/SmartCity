package com.myprojects.smartcity.society;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemberBillMainActivity extends AppCompatActivity {

    Button btnproceed;
    EditText Re_enterFlatNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_bill_activity_main);
        btnproceed = (Button)findViewById(R.id.btnFlatNext);
        Re_enterFlatNo =(EditText)findViewById(R.id.etRe_enterFlatNo);



        btnproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((Re_enterFlatNo).getText().toString().isEmpty())
                { Toast.makeText(getApplicationContext(),"Please Enter Valid Flat No. Without Spaces to Proceed.", Toast.LENGTH_LONG).show();
                }
                else if((Re_enterFlatNo).getText().toString().contains(" "))
                { Toast.makeText(getApplicationContext(),"Please Enter Valid Flat No. Without Spaces to Proceed.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String s=Re_enterFlatNo.getText().toString();
                    Bundle basket=new Bundle();
                    basket.putString("Sagar",s);

                    Intent i=new Intent(MemberBillMainActivity.this,MemberWebViewBill.class);
                    i.putExtras(basket);
                    startActivity(i);
                    Toast.makeText(MemberBillMainActivity.this, "Loading Data...Please Wait ! ", Toast.LENGTH_LONG).show();
                    MemberBillMainActivity.this.finish();
                }
            }
        });

    }
}
