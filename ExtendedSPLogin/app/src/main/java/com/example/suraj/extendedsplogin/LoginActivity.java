package com.example.suraj.extendedsplogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by suraj on 12/2/18.
 */

public class LoginActivity extends AppCompatActivity {
    EditText lemail,lpass;
    String TAG="SURAJ";
    Button lbtnlogin,lbtnsignup;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lemail=(EditText)findViewById(R.id.lemail);
        lpass=(EditText)findViewById(R.id.lpass);
        lbtnlogin=(Button)findViewById(R.id.lbtnlogin);
        lbtnsignup=(Button)findViewById(R.id.lbtnsignup);

        helper=new DatabaseHelper(this);


        SharedPreferences prefs= getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);//0 indicates MODE_PRivate
        SharedPreferences.Editor editor=prefs.edit();

        lbtnlogin.setOnClickListener((v)->{
            String logincheck=lemail.getText().toString();
            String passcheck=lpass.getText().toString();
           String checking= helper.checkData(logincheck,passcheck);
           if(checking=="NOT FOUND"){
               Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
           }
           else{
               Toast.makeText(this, "Successfully Logined", Toast.LENGTH_SHORT).show();

               editor.putInt("spflag",3);

               Intent intent= new Intent(LoginActivity.this,UserActivity.class);
               startActivity(intent);
           }
        });
        String username=prefs.getString("spname",null);
        String email=prefs.getString("spemail",null);
        String password=prefs.getString("sppass",null);

        lbtnsignup.setOnClickListener((v)->{

            Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        });
            editor.commit();
            lemail.setText(email);


    }
}
