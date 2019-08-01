package com.example.android.loginandregistration;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper openHelper;//
    SQLiteDatabase db;
    Button  registration,login;
    EditText txtfname, txtlname, txtpassword, txtemail, txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper = new DatabaseHelper(this);
        registration = findViewById(R.id.registration);
        txtfname = findViewById(R.id.txtfname);
        txtlname = findViewById(R.id.txtlname);
        txtpassword = findViewById(R.id.txtpassword);
        txtemail = findViewById(R.id.txtemail);
        txtphone = findViewById(R.id.txtphone);
        login = findViewById(R.id.login);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db=openHelper.getWritableDatabase();
                String fname =txtfname.getText().toString();
                String lname =txtlname.getText().toString();
                String password =txtpassword.getText().toString();
                String email=txtemail.getText().toString();
                String phone =txtphone.getText().toString();
                insertdata(fname, lname, password, email, phone);
                Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();




            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((MainActivity.this), login.class);
                startActivity(intent);
            }
        });

    }
    public void insertdata(String fname, String lname, String password, String email, String phone ){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, fname);
        contentValues.put(DatabaseHelper.COL_3, lname);
        contentValues.put(DatabaseHelper.COL_4, password);
        contentValues.put(DatabaseHelper.COL_5, email);
        contentValues.put(DatabaseHelper.COL_6, phone);
        long ID = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

    }
}
