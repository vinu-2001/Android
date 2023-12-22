package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,date,email;
    Button insert;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.username);
        date=findViewById(R.id.birthdate);
        email=findViewById(R.id.email);
        insert =findViewById(R.id.submit);
        DB = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameTXT = name.getText().toString();
                String dateTXT = date.getText().toString();
                String emailTXT = email.getText().toString();
                Boolean checkinsertdata = DB.insertuserdata(nameTXT,dateTXT,emailTXT);
                if(checkinsertdata==true){
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "New Entry not Inserted!!!", Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(MainActivity.this,UserList.class));

            }
        });

    }
}