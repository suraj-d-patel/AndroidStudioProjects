package com.example.suraj.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        Button btn;
        EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener((view)->{
            startAlert();
        });
    }

    public void startAlert(){
        et=(EditText)findViewById(R.id.et);
        int i=Integer.parseInt(et.getText().toString());
        Intent intent=new Intent(this,MyBroadcastReciever.class);
        PendingIntent pi=PendingIntent.getBroadcast(this,234324243,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pi);
        Toast.makeText(this, "Alarm set in "+i+"seconds", Toast.LENGTH_LONG).show();
    }




}
