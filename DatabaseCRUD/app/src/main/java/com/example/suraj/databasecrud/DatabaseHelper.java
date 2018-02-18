package com.example.suraj.databasecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by suraj on 8/2/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="STUDENTS.db";
    public static final String TABLE_NAME="STUDENTS";
    public static final String ID="ID";
    public static final String FULL_NAME="NAME";
    public static final String EMAIL="EMAIL_ID";
    public static final String PHONE="PHONE";
    public static final String ADDRESS="ADDRESS";
    public static final String PASSWORD="PASSWORD";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+FULL_NAME+" TEXT,"+EMAIL+" TEXT,"+PHONE+" NUMBER,"+ADDRESS+" TEXT,"+PASSWORD+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fullname,String email,String phone,String address,String password){
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(FULL_NAME,fullname);
        contentValues.put(EMAIL,email);
        contentValues.put(PHONE,phone);
        contentValues.put(ADDRESS,address);
        contentValues.put(PASSWORD,password);

        long result=database.insert(TABLE_NAME,null,contentValues);
        database.close();
        if(result==-1){
            return false;
        }
        else return true;
    }

    public Cursor viewData(){
        SQLiteDatabase database= this.getWritableDatabase();
        Cursor res= database.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    //String logincheck=email.getText().toString();
    public String checkdata(String logincheck,String passcheck) {
        Log.d("SURAJ", "just entered checkdata in databasehelper");
        SQLiteDatabase database = this.getReadableDatabase();
        //Cursor ress= database.rawQuery("select PASSWORD from "+TABLE_NAME+" where EMAIL="+logincheck,null);
        String query = "select EMAIL_ID, PASSWORD from " + TABLE_NAME + " where EMAIL_ID = '" + logincheck + "' AND PASSWORD = '" + passcheck + "'";
        Log.d("SURAJ", "QUERY CORRECt");
        Cursor res = database.rawQuery(query, null);

        String a, b;

        b = "NOT FOUND";
        Log.d("SURAJ", "Going to check condition");
        if (res.moveToFirst()) {
            do {
                a = res.getString(0);

                if (a.equals(logincheck)) {
                    b = res.getString(1);
                    break;
                } else {
                    b = "NOT FOUND";
                }
            } while (res.moveToNext());
        }
        return b;

    }
}

































//        if(res.getCount()==0){
//            Log.d("SURAJ","getcount=0"); //error
//            return false;
//
//        }
//        else if(res.getCount()==1){
//            Log.d("SURAJ","getcount=1");
//            return true;
//        }
//        else{
//
//            Log.d("SURAJ","getcount=kuch bhi");
//        }
//        return false;
