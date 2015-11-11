package com.kammalage.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        listView = (ListView) findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        cursor = userDbHelper.getInformation(sqLiteDatabase);
        if(cursor.moveToFirst()){
            do{
                String name,phone,email;
                name = cursor.getString(0);
                phone = cursor.getString(1);
                email = cursor.getString(2);

                DataProvider dataProvider= new DataProvider(name,phone,email);
                listDataAdapter.add(dataProvider);

            }while(cursor.moveToNext());
        }
    }
}
