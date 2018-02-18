package com.example.suraj.login.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.suraj.login.R;

/**
 * Created by suraj on 12/2/18.
 */

public class RegisterActivity extends AppCompatActivity {
    EditText name,email,password;
    Button regbtnlogin,regbtn;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getSupportActionBar().hide();

        name=(EditText)findViewById(R.id.regetname);
        email=(EditText) findViewById(R.id.regetemail);
        password=(EditText) findViewById(R.id.regetpass);
        regbtn=(Button)findViewById(R.id.regbtn);
        regbtnlogin=(Button)findViewById(R.id.regbtnlogin);

        String iname=name.getText().toString().trim();
        String iemail=email.getText().toString().trim();

        regbtnlogin.setOnClickListener((v)->{
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        });
        regbtn.setOnClickListener((V)->{
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        });
        

    }
}
