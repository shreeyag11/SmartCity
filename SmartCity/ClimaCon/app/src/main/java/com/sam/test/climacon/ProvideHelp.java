package com.sam.test.climacon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by sagar on 9/21/2017.
 */
public class ProvideHelp extends Fragment {

    EditText editTextName, editTextAddress,editTextPhone;
    Button submit;
    DatabaseReference generalDatabase;
    ListView listViewdata;
    List<Data> datalist;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {


        View rootView = inflater.inflate(R.layout.providehelp, container, false);
        super.onCreate(savedInstanceState);
        generalDatabase = FirebaseDatabase.getInstance().getReference("Data");
        editTextAddress=(EditText)rootView.findViewById(R.id.editTextAddress);
        datalist = new ArrayList<>();

        editTextName = (EditText)rootView.findViewById(R.id.editTextName);
        editTextPhone = (EditText)rootView.findViewById(R.id.editTextPhone);
        listViewdata=(ListView)rootView.findViewById(R.id.listViewData);
        submit = (Button)rootView.findViewById(R.id.button2);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();  //Calling addData on click
            }
        });

        return rootView;


    }



    @Override
    public void onStart() {
        super.onStart();
        generalDatabase .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                datalist.clear();
                for(DataSnapshot publicSnapshot : dataSnapshot.getChildren()){
                    Data data = publicSnapshot.getValue(Data.class);
                    datalist.add(data);
                }

              //  RetrivedList adapter =new RetrivedList(MainActivity.this,datalist);
             //   listViewdata.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addData()
    {
        String name =editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        if (!TextUtils.isEmpty(name)){

            String id = generalDatabase.push().getKey();
            Data data = new Data(id,name,address,phone);
            generalDatabase.child(id).setValue(data);
    Toast.makeText(this.getContext(),"Data Added Successfully.", Toast.LENGTH_SHORT).show();


        }else
        {
            Toast.makeText(this.getContext(),"Enter Valid Name", Toast.LENGTH_SHORT).show();

        }
    }


}


