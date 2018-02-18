package com.example.suraj.dummy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText rname,remail,rpass;
    Button rbtnreg,rbtnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rname=(EditText)findViewById(R.id.rname);
        remail=(EditText)findViewById(R.id.remail);
        rpass=(EditText)findViewById(R.id.rpass);
        rbtnreg=(Button)findViewById(R.id.rbtnreg);
        rbtnlogin=(Button)findViewById(R.id.rbtnlogin);

        rbtnreg.setOnClickListener((v)->{
            String passedname=rname.getText().toString();
            String passedemail=remail.getText().toString();
            String passedpassword=rpass.getText().toString();

            Log.d("SURAJ ","going to pass username "+passedname+" and email "+passedemail+
                    " and password "+passedpassword);

        });



    }
}
