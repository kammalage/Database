package com.kammalage.database;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shan on 11/9/2015.
 */
public class ListDataAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public ListDataAdapter(Context context, int resource) {

        super(context, resource);
    }

    static class LayoutHandler {

        TextView NAME,PHONE,EMAIL;

    }

    @Override
    public void add(Object object) {

        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null){

            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME = (TextView)row.findViewById(R.id.text_user_name);
            layoutHandler.PHONE = (TextView)row.findViewById(R.id.text_user_phone);
            layoutHandler.EMAIL = (TextView)row.findViewById(R.id.text_user_email);
            row.setTag(layoutHandler);
        }
        else{

            layoutHandler = (LayoutHandler) row.getTag();

        }
        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.PHONE.setText(dataProvider.getPhone());
        layoutHandler.EMAIL.setText(dataProvider.getEmail());

        return row;
    }
}
