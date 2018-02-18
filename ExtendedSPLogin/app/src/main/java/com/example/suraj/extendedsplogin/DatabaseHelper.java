package com.example.suraj.extendedsplogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by suraj on 13/2/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME="STUDENTS";
    public static final String DATABASE_NAME="DATABASE_1";
    public static final String COL_1="ID";
    public static final String COL_2="FULL_NAME";
    public static final String COL_3="EMAIL_ID";
    public static final String COL_4="PASSWORD";
    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null,1);
    }
    String query_onCreate="create table "+TABLE_NAME+"("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_2+" TEXT,"+COL_3+" TEXT,"+COL_4+" TEXT)";
    String query_onUpgrade="drop table if exists "+TABLE_NAME;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query_onCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(query_onUpgrade);
    }

    public Boolean insertDATA(String name,String email,String pass){
        SQLiteDatabase dbb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,pass);
        long result=dbb.insert(TABLE_NAME,null,contentValues);
        dbb.close();

        if(result==-1){
            Log.d("SURAJ","result==-1 and false will be returned");
            return false;
        }else {
            Log.d("SURAJ","result== positive and true will be returned");
            return true;
        }
    }

    public String checkData(String logincheck,String passcheck){
        SQLiteDatabase helper=this.getReadableDatabase();
        Log.d("SURAJ","logincheck= "+logincheck+" passcheck= "+passcheck);
        String query_check = "select EMAIL_ID, PASSWORD from " + TABLE_NAME + " where EMAIL_ID = '" + logincheck + "' AND PASSWORD = '" + passcheck + "'";
        Cursor res=helper.rawQuery(query_check,null);

        String a,b;
        b="NOT FOUND";
        if(res.moveToFirst()){
            do{
                a=res.getString(0);
                if(a.equals(logincheck)){
                    b=res.getString(1);
                    break;
                }else{
                    b="NOT FOUND";
                }
            }while(res.moveToNext());
        }
        helper.close();
        return b;
    }
}
