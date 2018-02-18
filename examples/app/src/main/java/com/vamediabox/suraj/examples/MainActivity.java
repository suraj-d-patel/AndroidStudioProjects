package com.vamediabox.suraj.examples;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        Toast toast=Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG);
        toast.show();

        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.customtoast,(ViewGroup)findViewById(R.id.custom_toast_layout));

        Toast toast2=new Toast(getApplicationContext());
        toast2.setDuration(Toast.LENGTH_LONG);
        toast2.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast2.setView(layout);
        toast.show();
    }


    }


