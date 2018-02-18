package com.example.suraj.login.activities;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.suraj.login.R;
import com.example.suraj.login.helper.DatabaseHelper;

/**
 * Created by suraj on 12/2/18.
 */

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    Button btnLogin,btnLinkToRegister;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=(EditText)findViewById(R.id.loginemail);
        password=(EditText)findViewById(R.id.loginpass);
        btnLogin=(Button)findViewById(R.id.loginbtn);
        btnLinkToRegister=(Button)findViewById(R.id.loginregbtn);
        getSupportActionBar().hide();

        btnLogin.setOnClickListener((v)->{

            Intent intent=new Intent(this,UserActivity.class);
            startActivity(intent);
        });

        btnLinkToRegister.setOnClickListener((v)->{
            Intent intent=new Intent(this,RegisterActivity.class);
            startActivity(intent);
        });


    }
}
