package com.example.android.loginandregistration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="register";
    public static final String  COL_1="ID";
    public static final String  COL_2="FName";
    public static final String  COL_3="LastName";
    public static final String  COL_4="Password";
    public static final String  COL_5="Email";
    public static final String  COL_6="Phone";
     public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE " + TABLE_NAME+ " (FName Text, LastName TEXT, Password TEXT, Email TEXT, Phone TEXT) ");//We can auto increment a field value by using AUTOINCREMENT keyword when creating a table with specific column name to auto increment.


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);  //Drop older table if exists
        onCreate(db);

    }
}
