package com.sam.test.climacon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PucData extends AppCompatActivity {
    EditText editTextValue1, editTextValue2,editTextValue3,editTextValue4,editTextPucNumber,editTextDate,editTextVehicleNo;
    Button submit;

    DatabaseReference PucDatabase;
       List<Data> Pucdatalist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puc_data);
        PucDatabase = FirebaseDatabase.getInstance().getReference("PUCData");
        editTextValue1=(EditText)findViewById(R.id.editTextValue1);
        Pucdatalist = new ArrayList<>();
        editTextValue2=(EditText)findViewById(R.id.editTextValue2);
        editTextValue3=(EditText)findViewById(R.id.editTextValue3);
        editTextValue4=(EditText)findViewById(R.id.editTextValue4);
        editTextPucNumber=(EditText)findViewById(R.id.editTextPucNumber);
        editTextDate=(EditText)findViewById(R.id.editTextDate);
        editTextVehicleNo=(EditText)findViewById(R.id.editTextVehicleNo);
        submit = (Button)findViewById(R.id.SubmitBtn);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();  //Calling addData on click
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        PucDatabase .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Pucdatalist.clear();
                for(DataSnapshot publicSnapshot : dataSnapshot.getChildren()){
                    DataPucServer data = publicSnapshot.getValue(DataPucServer.class);
                   // Pucdatalist.add(data);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addData()
    {
        String vehicleNo =editTextVehicleNo.getText().toString().trim();
        String pucnumber = editTextPucNumber.getText().toString().trim();
        String val1 = editTextValue1.getText().toString().trim();
        String val2 = editTextValue2.getText().toString().trim();
        String val3 = editTextValue3.getText().toString().trim();
        String val4 = editTextValue4.getText().toString().trim();
        String date = editTextDate.getText().toString().trim();
        if (!TextUtils.isEmpty(vehicleNo)){



                                    String id = PucDatabase.push().getKey();
                                    DataPucServer datapuc = new DataPucServer(id,val1,val2,val3,val4,vehicleNo,date,pucnumber);
                                    PucDatabase.child(id).setValue(datapuc);
                                    Toast.makeText(this, "Data Added Successfully.", Toast.LENGTH_SHORT).show();


        }else
        {
            Toast.makeText(this,"Enter Valid Name", Toast.LENGTH_SHORT).show();

        }
    }
}


