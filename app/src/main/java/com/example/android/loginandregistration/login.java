package com.example.android.loginandregistration;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {


    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button btnlogin;
    EditText logemail, logpassword;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        btnlogin = findViewById(R.id.btnlogin);
        logemail = findViewById(R.id.logemail);
        logpassword = findViewById(R.id.logpassword);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = logemail.getText().toString();
                String pass = logpassword.getText().toString();
                cursor = db.rawQuery("SELECT * FROM "+ DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_5+ "=? AND " + DatabaseHelper.COL_4+ "=?", new String[]{email, pass});
                if (cursor!=null) {
                    if (cursor.getCount() > 0) {
                         cursor.moveToNext();
                       Toast.makeText(getApplicationContext(), "login successfull", Toast.LENGTH_LONG).show();


                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


    }
}
