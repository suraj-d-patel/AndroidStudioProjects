package com.vamediabox.suraj.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by suraj on 18/1/18.
 */

public class WelcomeActivity extends AppCompatActivity {
    TextView txt ;
    public void onCreate(Bundle saved){

                super.onCreate(saved);
        setContentView(R.layout.welcome);
        txt= (TextView)findViewById(R.id.welcome);

        Intent intent=getIntent();
        String user=intent.getStringExtra("fullnamepassed");
        String email=intent.getStringExtra("emailpassed");
        String phone=intent.getStringExtra("phonepassed");
        String password=intent.getStringExtra("passwordpassed");
        String address=intent.getStringExtra("addresspassed");
        String gender=intent.getStringExtra("spinnerpassed");

        txt.append(" "+gender+ user+"."+"\n"+"\n");
        txt.append("Your Email ID is " + email+"."+"\n"+"\n");
        txt.append("Its Confidential, Your password is " + password+"."+"\n"+"\n");
        txt.append("We will be contacting you on "+phone+"."+"\n"+"\n");
        txt.append("Your Address is "+"\n"+address+"."+"\n"+"\n");
        txt.append("Thanks!!!");

    }
}
