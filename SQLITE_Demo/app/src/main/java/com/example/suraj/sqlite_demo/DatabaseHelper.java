package com.example.suraj.sqlite_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLInput;

/**
 * Created by suraj on 7/2/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Students DataBase";
    public static final String TABLE_NAME="STUDENTS";
    public static final String COL1="ID";
    public static final String COL2="FIRST_NAME";
    public static final String COL3="LAST_NAME";
    public static final String COL4="MARKS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,LAST_NAME TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        Log.d("SURAJ","TABLE DROPPED");
        onCreate(db);
    }
    public boolean insertData(String firstname,String lastname,String marks){
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        //contentValues.put(COL1,firstname);
        contentValues.put(COL2,firstname);
        contentValues.put(COL3,lastname);
        contentValues.put(COL4,marks);
        long result=database.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
        return false;
        }
        else{
            return true;
        }

    }
}
