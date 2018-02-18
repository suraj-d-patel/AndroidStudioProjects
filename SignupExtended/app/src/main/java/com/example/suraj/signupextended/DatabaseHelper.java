package com.example.suraj.signupextended;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by suraj on 7/2/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Students Database";
    public static final String TABLE_NAME="STUDENTS";
    public static final String COL1="ID";
    public static final String COL2="FULL_NAME";
    public static final String COL3="EMAIL";
    public static final String COL4="PHONE";
    public static final String COL5="ADDRESS";
    public static final String COL6="PASSWORD";
    public static final String COL7="GENDER";

    public DatabaseHelper(Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME +"("+COL1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL2+" TEXT,"+COL3+" TEXT,"+COL4+" NUMBER,"+COL5+" TEXT,"+COL6+" TEXT,"+COL7+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String fullname,String email,String phone,String address,String password,String gender){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2,fullname);
        contentValues.put(COL3,email);
        contentValues.put(COL4,phone);
        contentValues.put(COL5,address);
        contentValues.put(COL6,password);
        contentValues.put(COL7,gender);

        long result =database.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }



}
