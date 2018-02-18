package com.example.suraj.databasecrud;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText etmail, etpass;
    Button btn;
    DatabaseHelper helper;
    //helper= new DatabaseHelper(getApplicationContext());
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        etmail = (EditText) findViewById(R.id.loginemail);
        etpass = (EditText) findViewById(R.id.loginpass);
        btn = (Button) findViewById(R.id.loginbtn);
        btn.setOnClickListener((View v) -> {

            String logincheck = etmail.getText().toString();
            String passcheck = etpass.getText().toString();
            Log.d("SURAJ","Parameter passed is login:"+logincheck+" and pass:"+passcheck);





            helper=new DatabaseHelper(this);

            String checkbnt=helper.checkdata(logincheck,passcheck);
            if(checkbnt=="NOT FOUND"){
                Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            }
            else{
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            }
           Log.d("SURAJ","gone through checkdata method comes in login "+checkbnt);
//           if(db.checkdata(editemail.getText().toString(),editpass.getText().toString())){
//
//               Toast.makeText(this," credentials correct",Toast.LENGTH_LONG).show();
//           }
//           else{
//
//               Toast.makeText(this," credentials incorrect",Toast.LENGTH_LONG).show();
//           }
        });
    }
}