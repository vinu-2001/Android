package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name,date,email;
    DBHelper DB;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        DB = new DBHelper(this);
        name = new ArrayList<>();
        date = new ArrayList<>();
        email = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        myAdapter = new MyAdapter(this,name,date,email);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }
    private void displaydata(){
        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Entry Exists!!!", Toast.LENGTH_LONG).show();
            return;
        }else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                date.add(cursor.getString(1));
                email.add(cursor.getString(2));
            }
        }
    }
}