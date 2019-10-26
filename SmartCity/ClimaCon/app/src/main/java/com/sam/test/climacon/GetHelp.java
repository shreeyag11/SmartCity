package com.sam.test.climacon;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

public class GetHelp extends Fragment {
    EditText editTextName, editTextAddress;
    Button submit;
    Button retrive;     //part2
    DatabaseReference generalDatabase;
    ListView listViewdata;
    List<Data> datalist;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.gethelp, container, false);
        super.onCreate(savedInstanceState);
        generalDatabase = FirebaseDatabase.getInstance().getReference("Data");
        datalist = new ArrayList<>();
        listViewdata=(ListView)rootView.findViewById(R.id.listViewData);

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
Activity activity =getActivity();
                RetrivedList adapter =new RetrivedList(activity,datalist);
                listViewdata.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




}


