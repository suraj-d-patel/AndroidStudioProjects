package com.example.suraj.extendedsplogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText rname,remail,rpass;
    Button rbtnreg,rbtnlogin;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rname=(EditText)findViewById(R.id.rname);
        remail=(EditText)findViewById(R.id.remail);
        rpass=(EditText)findViewById(R.id.rpass);
        rbtnreg=(Button)findViewById(R.id.rbtnreg);
        rbtnlogin=(Button)findViewById(R.id.rbtnlogin);

        db=new DatabaseHelper(this);

        rbtnlogin.setOnClickListener((v)->{
            Intent intent= new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
        });

        rbtnreg.setOnClickListener((v)->{
            String nametext=rname.getText().toString().trim();
            String emailtext=remail.getText().toString().trim();
            String passtext=rpass.getText().toString();
            Log.d("SURAJ","name = "+nametext+" email= "+emailtext+" password= "+passtext);
            //SharedPreference Storing
            SharedPreferences prefs= getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);
            SharedPreferences.Editor editor=prefs.edit();
            editor.putString("spname",nametext);
            editor.putString("spemail",emailtext);
            editor.putString("sppass",passtext);
            editor.putInt("spflag",2);
            editor.commit();

            boolean sign=db.insertDATA(nametext,emailtext,passtext);
            if(sign){
                Toast.makeText(this, "Successfully SignedUp", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
