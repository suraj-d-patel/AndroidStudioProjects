package com.example.suraj.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by suraj on 29/1/18.
 */

public class Second_Activity extends AppCompatActivity {
        Button btngetmsg;
        EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        btngetmsg=(Button)findViewById(R.id.btngetmsg);
        et=(EditText)findViewById(R.id.et);
        btngetmsg.setOnClickListener((view)->{
            String msgg=et.getText().toString();
            Intent intentmsg=new Intent();
            intentmsg.putExtra("MESSAGES",msgg);
            setResult(200,intentmsg);
            finish();
        });
    }
    public boolean onCreateOptionsMenu(Menu menu2){
        getMenuInflater().inflate(R.menu.menu_main,menu2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitemmm){
        switch (menuitemmm.getItemId()){
            case R.id.share:
            {
                Intent shareintent  = new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                //shareintent.putExtra(Intent.EXTRA_TEXT,"Insert Subject HERE");
                String appyurl="Sharing Successful Text id heeeeeeeee";
                Toast.makeText(this, "Sharing Successful", Toast.LENGTH_SHORT).show();
                shareintent.putExtra(Intent.EXTRA_TEXT,appyurl);
                startActivity(Intent.createChooser(shareintent,"Share via"));
            }
            return true;
            case R.id.setting:
            {
                Intent settingintent= new Intent(this,Settings.class);
                startActivity(settingintent);
            }
            return true;
            default:
               return super.onOptionsItemSelected(menuitemmm);
        }
    }

}
