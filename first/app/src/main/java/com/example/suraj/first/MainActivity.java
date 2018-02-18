package com.example.suraj.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnshareapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnshareapp=(Button)findViewById(R.id.btnshareapp);
        btnshareapp.setOnClickListener((view)->{
            Intent shareIntent= new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Insert Subject HERE");
            String app_url="http://knowtohackandroid.blogspot.com";
            shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
            startActivity(Intent.createChooser(shareIntent,"Share via"));
        });

    }
}
