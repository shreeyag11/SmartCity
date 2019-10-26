package com.sam.test.climacon;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sagar on 9/20/2017.
 */

public class RetrivedList extends ArrayAdapter <Data> {
    private Activity context;
    private List <Data> publicList;
    public RetrivedList(Activity context, List<Data> publicList){
        super(context,R.layout.listview,publicList);
        this.context=context;
        this.publicList=publicList;



    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listview,null,true);
        TextView tview4 = (TextView)listViewItem.findViewById(R.id.textView4);
        SpannableString con1 = new SpannableString(tview4.getText());
        con1.setSpan(new UnderlineSpan(), 0, con1.length(), 0);
        tview4.setText(con1);
        TextView tv6 = (TextView)listViewItem.findViewById(R.id.textView6);
        SpannableString content1 = new SpannableString(tv6.getText());
        content1.setSpan(new UnderlineSpan(), 0, content1.length(), 0);
        tv6.setText(content1);
        TextView tv7 = (TextView)listViewItem.findViewById(R.id.textView7);
        SpannableString content2 = new SpannableString(tv7.getText());
        content2.setSpan(new UnderlineSpan(), 0, content2.length(), 0);
        tv7.setText(content2);
        TextView textViewName = (TextView)listViewItem.findViewById(R.id.textViewName);
        TextView textViewAddress = (TextView)listViewItem.findViewById(R.id.textViewAddress);
        TextView textViewPhone = (TextView)listViewItem.findViewById(R.id.textViewPhone);
        Data data = publicList.get(position);

        textViewName.setText(data.getName());
        textViewAddress.setText(data.getAddress());
        textViewPhone.setText(data.getPhone());
        return listViewItem;
    }
}
