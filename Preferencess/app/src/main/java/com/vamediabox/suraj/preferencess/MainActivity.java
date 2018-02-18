package com.vamediabox.suraj.preferencess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button storeinfo, showinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storeinfo = (Button) findViewById(R.id.storeinformation);
        showinfo = (Button) findViewById(R.id.showinformation);
        textView = (TextView) findViewById(R.id.txtPrefs);

        View.OnClickListener listener = new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.storeinformation:
                    {
                        Intent intent = new Intent(MainActivity.this, PrefsActivity.class);
                        startActivity(intent);
                    }
                        break;
                    case R.id.showinformation:
                        displaySharedPreferences();
                        break;
                    default: break;
                }
            }

        };

        storeinfo.setOnClickListener(listener);
        showinfo.setOnClickListener(listener);
    }

    public void displaySharedPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = prefs.getString("username", "Default NickName");
        String passw = prefs.getString("password", "Default Password");
        boolean checkBox = prefs.getBoolean("checkBox", false);
        String listPrefs = prefs.getString("listpref", "Default list prefs");

        StringBuilder builder = new StringBuilder();
        builder.append("Username: " + username + "\n");
        builder.append("Password: " + passw + "\n");
        builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
        builder.append("List preference: " + listPrefs);
        textView.setText(builder.toString());
    }
}