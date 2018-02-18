package com.example.suraj.extendedsplogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by suraj on 12/2/18.
 */

public class SplashActivity extends AppCompatActivity{
    private int SPLASH_TIME_OUT=2000;          //2 seconds

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {

            SharedPreferences prefs=getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);
            String uname=prefs.getString("spname",null);
            String email=prefs.getString("spemail",null);
            String epass=prefs.getString("sppass",null);
            int flag= prefs.getInt("spflag",0);

            //1==logout

            if(uname!=null && email!=null && epass!=null && flag==3){
                Intent intent=new Intent(SplashActivity.this,UserActivity.class);
                startActivity(intent);
            }else if(flag==2||flag==0||flag==1){
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
            }
            else if(flag==3||flag==4){
                Intent intent=new Intent(SplashActivity.this,UserActivity.class);
                startActivity(intent);
            }

            finish();
        },SPLASH_TIME_OUT);
    }
}
