package com.example.suraj.extendedsplogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by suraj on 12/2/18.
 */

public class UserActivity extends AppCompatActivity {
    TextView utxtwelcome,utxtname,utxtemail;
    Button ubtnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_user);

        SharedPreferences prefs= getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);
        SharedPreferences.Editor editor= prefs.edit();
        editor.putInt("spflag",4);
        editor.commit();

        utxtemail=(TextView)findViewById(R.id.utxtemail);
        utxtname=(TextView)findViewById(R.id.utxtname);
        utxtwelcome=(TextView)findViewById(R.id.utxtwelcome);
        ubtnlogout=(Button)findViewById(R.id.ubtnlogout);

        ubtnlogout.setOnClickListener((v)->{

            editor.putInt("spflag",1); //denotes you are logout
            editor.commit();




            Intent intent= new Intent(UserActivity.this,LoginActivity.class);
            startActivity(intent);
        });

    }
}
