package com.vamediabox.suraj.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by suraj on 18/1/18.
 */

public class ForgotActivity extends AppCompatActivity {
    TextView msg;
    EditText editemail;
    Button btnsubmit;
    int flag=0;//error
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.forgot);
        editemail=(EditText)findViewById(R.id.editemail);
        msg = (TextView)findViewById(R.id.msg);
        //textemail = (TextView)findViewById(R.id.txtemail);
        btnsubmit=(Button)findViewById(R.id.btnsubmit);







        btnsubmit.setOnClickListener((view)->{
            if(editemail.getText().toString().equals("")){
                editemail.setError("Enter valid EMail Address");
                flag=0;
            }
            else if(!editemail.getText().toString().trim().matches(emailPattern)){

                    Toast.makeText(this, "Please Enter valid EMail ID", Toast.LENGTH_LONG).show();
                    flag=0;
            }
            else{
                flag=1;
            }

            if(flag==1){
                msg.setText("Check your Email ID for Recovery.");
                Toast.makeText(this, "Check your Email ID for Recovery..", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

